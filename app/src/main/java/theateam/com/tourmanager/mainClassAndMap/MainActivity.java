package theateam.com.tourmanager.mainClassAndMap;


// https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=23.7842676%2C90.369294&radius=5000&types=restaurant&key=AIzaSyB3PpqkyKKcYOiEw1XjQ2BsjF6zB_x8peI
// https://developers.google.com/places/supported_types

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import theateam.com.tourmanager.GeoData.Constants;
import theateam.com.tourmanager.GeoData.FetchAddressIntentService;
import theateam.com.tourmanager.JsonPersing.Constantsty;
import theateam.com.tourmanager.JsonPersing.PlacesResponse;
import theateam.com.tourmanager.JsonPersing.PlacesServiceApi;
import theateam.com.tourmanager.LogInActivity;
import theateam.com.tourmanager.ProfileHomeActivity;
import theateam.com.tourmanager.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.ConnectionCallbacks
        , GoogleApiClient.OnConnectionFailedListener, LocationListener  {
    GoogleApiClient googleApiClient;
    LocationRequest locationRequest;
    TextView lattitudeTv; Place place;

    Location latlong;  Double myLattitude, myLongitude ;

    AddressResultReceiver resultreceiver;
    String Address;String markerInterest="all";
    MyJsonGooglePlaces  myJsonGooglePlaces;
    ArrayList<PlacesResponse.Result> results ;
    private static final LatLngBounds BOUNDS_MOUNTAIN_VIEW = new LatLngBounds(
            new LatLng(37.398160, -122.180831), new LatLng(37.430610, -121.972090));
    private static final int REQUEST_SELECT_PLACE = 1000;

    LatLng latLng; boolean flag;

    Place Myplace;

    // Views Refernce
    TextView searchTv,AddressTV,cityNametv;
    Button atmBtn, currentLocationMapButton,hospitalBtn,restaurentBtn,bankBtn,
            policeBtn,shoppingMallBtn, nearbyplacesMapButton;

    ListView listView;
    // Views reference End


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initilize();  // initilizing all vies



        // Setting our custom toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myJsonGooglePlaces=new MyJsonGooglePlaces();

        myJsonGooglePlaces.networkLibraryPopulate();



        // Making google Api client
        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        // Making a object to send on The IntentService so that IntentSevice Can send Result to this Class
        resultreceiver = new AddressResultReceiver(new Handler());


        /*PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Myplace = place ;
                userSerchedMap();
                Log.e("Error", "Place: " + place.getName());
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.e("Error", "An error occurred: " + status);
            }
        });*/
        flag= true;
        atmBtn.setOnClickListener(this);
        currentLocationMapButton.setOnClickListener(this);
        hospitalBtn.setOnClickListener(this);
        restaurentBtn.setOnClickListener(this);
        bankBtn.setOnClickListener(this);
        policeBtn.setOnClickListener(this);
        shoppingMallBtn.setOnClickListener(this);
        nearbyplacesMapButton.setOnClickListener(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(MainActivity.this,MapsActivity.class);
                in.putExtra(Constants.LATTITUDE,results.get(i).getGeometry().getLocation().getLat());
                in.putExtra(Constants.LONGITUDE,results.get(i).getGeometry().getLocation().getLng());
                in.putExtra(Constants.MY_LOCATION,results.get(i).getName());
                in.putExtra(Constants.ALL_OR_SINGLE_PLACE,false);
                startActivity(in);


            }
        });







    }




    public void initilize()
    {
      /*  searchTv = (TextView) findViewById(R.id.searchTv);
        lattitudeTv= (TextView) findViewById(R.id.lattitudeTv);
        longitudeTv= (TextView) findViewById(R.id.longitudeTv);*/
        AddressTV= (TextView) findViewById(R.id.AddressTV);
        listView= (ListView) findViewById(R.id.listView);
        cityNametv = (TextView) findViewById(R.id.cityNametv);

        atmBtn= (Button) findViewById(R.id.atmBtn);
        currentLocationMapButton= (Button) findViewById(R.id.currentLocationMapButton);
        hospitalBtn= (Button) findViewById(R.id.hospitalBtn);
        restaurentBtn= (Button) findViewById(R.id.restaurentBtn);
        bankBtn= (Button) findViewById(R.id.bankBtn);
        policeBtn= (Button) findViewById(R.id.policeBtn);
        shoppingMallBtn= (Button) findViewById(R.id.shoppingMallBtn);
        nearbyplacesMapButton= (Button) findViewById(R.id.nearbyplacesMapButton);

        // addressType = (TextView) findViewById(R.id.addressType);



    }






    @Override
    protected void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    protected void onPause() {
        googleApiClient.disconnect();
        super.onPause();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(1000*60);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);

    }

    public void startIntentService()
    {
        Intent intent = new Intent(this,FetchAddressIntentService.class);
        intent.putExtra(Constants.WEATHER_NEARBY,"nearby");
        intent.putExtra(Constants.RECEIVER,resultreceiver);
        intent.putExtra(Constants.MY_LOCATION,latlong);  // sending the LAt and Long
        Log.e("Start Service ", " Start service");
        startService(intent);

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        latlong= location;
        myLattitude=latlong.getLatitude();

        myLongitude=latlong.getLongitude();
        Log.e("Latlong : ",myLattitude+", "+myLongitude);
        startIntentService();

     /*   lattitudeTv.setText(location.getLatitude()+"");
        longitudeTv.setText(location.getLongitude()+"");*/


    }



/*    public void map(View view) {
        Intent in = new Intent(this, MapsActivity.class);
        in.putExtra(Constants.LATTITUDE,latlong.getLatitude());
        in.putExtra(Constants.LONGITUDE,latlong.getLongitude());
        startActivity(in);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_home,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            startActivity(new Intent(this,LogInActivity.class));
            MainActivity.this.finish();
        }
        else if(id == R.id.myHome)
        {
            startActivity(new Intent(this,ProfileHomeActivity.class));
            MainActivity.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }


    public void restaurent(View view) {
        myJsonGooglePlaces.LoadData("restaurant",true);
        // String str = results.get(0).getName() + results.get(0).getVicinity();
       /* if(str!= null)
        {
            Toast.makeText(MainActivity.this,str, Toast.LENGTH_LONG).show();
            addressType.setText(str);

        }
*/
    }

    public void search(View view) {
        try {
            Intent intent = new PlaceAutocomplete.IntentBuilder
                    (PlaceAutocomplete.MODE_OVERLAY)
                    .build(MainActivity.this);
            startActivityForResult(intent, REQUEST_SELECT_PLACE);
        } catch (GooglePlayServicesRepairableException |
                GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View view) {
        Log.e("True false ki gisena","Gisena kerree");
        int id = view.getId();

        switch (id)
        {

            case R.id.atmBtn : markerInterest = "atm";
                Log.e("MarkerTest", markerInterest);myJsonGooglePlaces.LoadData("atm",true); break;
            case R.id.bankBtn:markerInterest = "bank";myJsonGooglePlaces.LoadData("bank",true);break;
            case R.id.hospitalBtn:markerInterest = "hospital";myJsonGooglePlaces.LoadData("hospital",true);break;
            case R.id.policeBtn:markerInterest = "police";myJsonGooglePlaces.LoadData("police",true);break;
            case R.id.restaurentBtn:markerInterest = "restaurant";myJsonGooglePlaces.LoadData("restaurant",true);break;
            case R.id.shoppingMallBtn:markerInterest = "shopping_mall";myJsonGooglePlaces.LoadData("shopping_mall",true);break;
            case R.id.currentLocationMapButton :
                Intent in = new Intent(this, MapsActivity.class);
                in.putExtra(Constants.MY_LOCATION,Address);
                Log.e("Current Location geseni",Address);
                in.putExtra(Constants.ALL_OR_SINGLE_PLACE,false);//Sending False If we just need to show the Current location only

                // Dynamic start
                in.putExtra(Constants.LATTITUDE,latlong.getLatitude());
                in.putExtra(Constants.LONGITUDE,latlong.getLongitude());
                // Dynamic End

                // Analog start
               /* in.putExtra(Constants.LATTITUDE,23.7842676);
                in.putExtra(Constants.LONGITUDE,90.369294);*/
                // Analog End

                startActivity(in);
                //finish();
                break;

            case R.id.nearbyplacesMapButton :
                Intent allplaceMapIntent = new Intent(this, MapsActivity.class);
                allplaceMapIntent.putExtra(Constants.MARKER_INTEREST,markerInterest);
                allplaceMapIntent.putExtra(Constants.MY_LOCATION,Address);
                allplaceMapIntent.putExtra(Constants.ALL_OR_SINGLE_PLACE,true); // Sending true if we need All places Nearby

                // dynamic
                allplaceMapIntent.putExtra(Constants.LATTITUDE,latlong.getLatitude());
                allplaceMapIntent.putExtra(Constants.LONGITUDE,latlong.getLongitude());
               // dynamic end

                // Analog start
               /* allplaceMapIntent.putExtra(Constants.LATTITUDE,23.7842676);
                allplaceMapIntent.putExtra(Constants.LONGITUDE,90.369294);*/
                // Analog End

                double placesLattitude[] = new double[results.size()];
                double placesLongitude[] = new double[results.size()];
                Log.e("Places Lattitude size ", placesLattitude.length+"");
                String placesName[]=new String[results.size()];
                for(int i=0;i <placesLattitude.length;i++)
                {
                    placesLattitude[i] = results.get(i).getGeometry().getLocation().getLat();
                    placesLongitude[i] = results.get(i).getGeometry().getLocation().getLng();
                    placesName[i]= results.get(i).getName();

                }
                allplaceMapIntent.putExtra(Constants.PLACES_NAME,placesName);
                allplaceMapIntent.putExtra(Constants.PLACES_LATTITUDE,placesLattitude);
                Log.e("Places Lattitude size 2", placesLattitude.length+"");
                allplaceMapIntent.putExtra(Constants.PLACES_LONGITUDE,placesLongitude);
                //allplaceMapIntent.putParcelableArrayListExtra(Constants.PLACES_ARRAYLSIT,results);
                startActivity(allplaceMapIntent);
               // finish();
                break ;


        }

    }



    public class AddressResultReceiver extends ResultReceiver
    {
        public AddressResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            Address = resultData.getString(Constants.RESULT_DATA_KEY);
            AddressTV.setText(Address +"");
            if(flag)
            {
                myJsonGooglePlaces.LoadData("restaurant",false);
                flag=false;
            }
            if (resultCode == Constants.SUCCESS_RESULT) {
                Log.e("onReceiveResult","onReceiveResult");
            }


        }
    }
    // Start a Class



    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_SELECT_PLACE) {
            if (resultCode == RESULT_OK) {
                place = PlaceAutocomplete.getPlace(this, data);
                final Locale locale = place.getLocale();
              //  final String country = locale.getCountry();
             //   Log.e("Test Country", locale.getCountry());

                Intent in = new Intent(this, MapsActivity.class);
                in.putExtra(Constants.MY_LOCATION,place.getName());
                Log.e("Current Location geseni",place.getName()+"");

                in.putExtra(Constants.ALL_OR_SINGLE_PLACE,false);//Sending False If we just need to show the Current location only
                in.putExtra(Constants.LATTITUDE,place.getLatLng().latitude);
                in.putExtra(Constants.LONGITUDE,place.getLatLng().longitude);
                startActivity(in);
                finish();

                //cityNametv.setText(place.getName());
                // Log.e("Toi call hoisost kere", place.getViewport().toString());
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                Toast.makeText(MainActivity.this,status.toString(), Toast.LENGTH_LONG).show();
            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }




    class MyJsonGooglePlaces {
        Retrofit retrofit;
        PlacesServiceApi placesServiceApi;
        PlacesResponse placesResponse;
        String typeName;


        public MyJsonGooglePlaces() {

        }

        public void networkLibraryPopulate()
        {
            retrofit= new Retrofit.Builder().baseUrl(Constantsty.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            placesServiceApi = retrofit.create(PlacesServiceApi.class);

        }

        public void LoadData(String type, final boolean toogle)
        {   String url = null;
            // if Toogle is true than Serch for Types Else General
            if(toogle)
            {

               // url = "maps/api/place/nearbysearch/json?location="+myLattitude+","+myLongitude+"&radius=2000&types="+type+"&key=AIzaSyB3PpqkyKKcYOiEw1XjQ2BsjF6zB_x8peI";
                url = "maps/api/place/nearbysearch/json?location=23.7842676,90.369294&radius=2000&types="+type+"&key=AIzaSyB3PpqkyKKcYOiEw1XjQ2BsjF6zB_x8peI";
                //https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=23.7842676,90.369294&radius=500&type=restaurant&key=AIzaSyB3PpqkyKKcYOiEw1XjQ2BsjF6zB_x8peI

            }
            else
            {
                if(type.equals("police") || type.equals("shopping_mall"))
                {

                    url = "maps/api/place/nearbysearch/json?location=23.7842676,90.369294&radius=5000&key=AIzaSyB3PpqkyKKcYOiEw1XjQ2BsjF6zB_x8peI";
                    //url = "maps/api/place/nearbysearch/json?location="+myLattitude+","+myLongitude+"&radius=5000&key=AIzaSyB3PpqkyKKcYOiEw1XjQ2BsjF6zB_x8peI";
                }
                else {
                    url = "maps/api/place/nearbysearch/json?location=23.7842676,90.369294&radius=1500&key=AIzaSyB3PpqkyKKcYOiEw1XjQ2BsjF6zB_x8peI";
                    //url = "maps/api/place/nearbysearch/json?location=" + myLattitude + "," + myLongitude + "&radius=1500&key=AIzaSyB3PpqkyKKcYOiEw1XjQ2BsjF6zB_x8peI";
                }
            }

            Call<PlacesResponse> placesResponseCall = placesServiceApi.getPlaces(url);

            placesResponseCall.enqueue(new Callback<PlacesResponse>() {
                @Override
                public void onResponse(Call<PlacesResponse> call, Response<PlacesResponse> response) {
                    placesResponse = response.body();
                    results = placesResponse.getResults();
                    //typeName = "Restaurent Name : "+results.get(0).getName()+" Address : "+results.get(0).getVicinity();

                    listView.setAdapter(new MyAdapter(MainActivity.this,getLayoutInflater(),results,toogle));

                    // TextView addressType = (TextView)findViewById(R.id.addressType);
                    // addressType.setText(typeName);
                }

                @Override
                public void onFailure(Call<PlacesResponse> call, Throwable t) {

                    Toast.makeText(MainActivity.this,"Failure", Toast.LENGTH_LONG).show();

                }
            });


        }

    }









}
