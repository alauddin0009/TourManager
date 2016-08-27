package theateam.com.tourmanager.Weather;

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
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import theateam.com.tourmanager.GeoData.Constants;
import theateam.com.tourmanager.GeoData.FetchAddressIntentService;
import theateam.com.tourmanager.JsonPersing.PlacesResponse;
import theateam.com.tourmanager.LogInActivity;
import theateam.com.tourmanager.ProfileHomeActivity;
import theateam.com.tourmanager.R;
import theateam.com.tourmanager.Weather.Autocomplete.SuggestionAdapter;

public class MyWeather extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks
        , GoogleApiClient.OnConnectionFailedListener, LocationListener  {
        GoogleApiClient googleApiClient;
        LocationRequest locationRequest;
        TextView lattitudeTv; Place place;

        Location latlong;  Double myLattitude, myLongitude ;

        AddressResultReceiver resultreceiver;
        String Address;String markerInterest="all";
        ArrayList<PlacesResponse.Result> results ;
private static final LatLngBounds BOUNDS_MOUNTAIN_VIEW = new LatLngBounds(
        new LatLng(37.398160, -122.180831), new LatLng(37.430610, -121.972090));
private static final int REQUEST_SELECT_PLACE = 1000;

        LatLng latLng; boolean flag;
    WeatherServiceAPI weatherServiceAPI;
    WeatherResponse weatherResponse;
    AutoCompleteTextView weatherAutoComplete;


    String City = "Narsingdi";
    String Country = "Bangladesh";
    WeatherResponse.CurrentObservation currentObservation;
    String temperature;
    Double tempC;
    Double tempF;
    List<WeatherResponse.Forecast> forecastClass;

    // All View References Here

    TextView weatherTv,windspeedTV,pressureTv,humidityTv,tempTv,feelslikeTv,WeathercityNametv;
    ListView wealtherListView; ImageView searchImg;


    // View References End here

    // All Json Variable here
    // cloudy or sun
    String weather ;
    Double windKph;
    String pressuremb;
    String relativeHumidity;
    private String feelslikeC;


    // Jason variable end here


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_weather);
        initialize();
        networkLibraryPopulate();
        //loadDatas(City,Country);


        // Copy and Paste
        Toolbar toolbar = (Toolbar) findViewById(R.id.Weathertoolbar);
        setSupportActionBar(toolbar);
       /* ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setTitle("");
*/

        // Making google Api client
       try
       {
           googleApiClient = new GoogleApiClient.Builder(this)
                   .addApi(LocationServices.API)
                   .addConnectionCallbacks(this)
                   .addOnConnectionFailedListener(this)
                   .build();
       }catch (Exception e)
       {
           Log.e("Weather Exception ", e.toString());
       }

        // Making a object to send on The IntentService so that IntentSevice Can send Result to this Class
        resultreceiver = new AddressResultReceiver(new Handler());

        weatherAutoComplete = (AutoCompleteTextView) findViewById(R.id.weatherAutoComplete);
        weatherAutoComplete.setAdapter(new SuggestionAdapter(this,weatherAutoComplete.getText().toString()));
        weatherAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = weatherAutoComplete.getText().toString();
                weatherAutoComplete.setText("");
                weatherAutoComplete.setVisibility(View.GONE);
                String[] split = s.split(",");
                loadDatas(split[0].trim(),split[split.length-1].trim());

                Log.e("City",split[0].trim() );
                Log.e("Country", split[split.length-1].trim());
                WeathercityNametv.setVisibility(View.VISIBLE);
                searchImg.setVisibility(View.VISIBLE);
                WeathercityNametv.setText(s);
            }
        });
    }

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
            MyWeather.this.finish();
        }
        else if(id == R.id.myHome)
        {
            startActivity(new Intent(this,ProfileHomeActivity.class));
            MyWeather.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStart() {
        super.onStart();
        try{

            googleApiClient.connect();
        }catch (Exception e)
        {
            Log.e("Weather Error ", e.toString());
        }
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
                .setInterval(1000*60*10);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);

    }

    public void startIntentService()
    {
        Intent intent = new Intent(this,FetchAddressIntentService.class);
        intent.putExtra(Constants.WEATHER_NEARBY,"weather");
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
        Toast.makeText(MyWeather.this, "Check your network conection", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLocationChanged(Location location) {

        if (location==null)
        {
            Toast.makeText(this,"Check your network connection",Toast.LENGTH_LONG).show();
        }
        latlong= location;
        myLattitude=latlong.getLatitude();

        myLongitude=latlong.getLongitude();
        Log.e("Latlong : ",myLattitude+", "+myLongitude);
        startIntentService();

     /*   lattitudeTv.setText(location.getLatitude()+"");
        longitudeTv.setText(location.getLongitude()+"");*/


    }



    public class AddressResultReceiver extends ResultReceiver
    {
        public AddressResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            Address = resultData.getString(Constants.RESULT_DATA_KEY);
            String[] split = Address.split(",");

            loadDatas(split[0].trim(),split[split.length-1].trim());
            WeathercityNametv.setText(split[0].trim());

            /*weatherTv.setVisibility(View.VISIBLE);
            windspeedTV.setVisibility(View.VISIBLE);
            pressureTv.setVisibility(View.VISIBLE);
            humidityTv.setVisibility(View.VISIBLE);
            tempTv.setVisibility(View.VISIBLE);
            feelslikeTv.setVisibility(View.VISIBLE);*/

            Log.e("MyAddress", Address);

            if(flag)
            {
               // myJsonGooglePlaces.LoadData("restaurant",false);
                flag=false;
            }
            if (resultCode == Constants.SUCCESS_RESULT) {
                Log.e("onReceiveResult","onReceiveResult");
            }


        }
    }
    // Start a Class






    public void initialize()
    {
        weatherTv=(TextView) findViewById(R.id.weatherTv);
        windspeedTV=(TextView) findViewById(R.id.windspeedTV);
        pressureTv=(TextView) findViewById(R.id.pressureTv);
        humidityTv=(TextView) findViewById(R.id.humidityTv);
        tempTv=(TextView) findViewById(R.id.tempTv);
        feelslikeTv= (TextView) findViewById(R.id.feelslikeTv);
        wealtherListView= (ListView) findViewById(R.id.wealtherListView);
        weatherAutoComplete= (AutoCompleteTextView) findViewById(R.id.weatherAutoComplete);
        WeathercityNametv= (TextView) findViewById(R.id.WeathercityNametv);
        searchImg= (ImageView) findViewById(R.id.searchImg);
    }


    private void loadDatas(String SelectedCity,String SelectedCountry) {

     /*   try
        {*/


        String webadd = "api/c01608ec8b245e24/conditions/forecast10day/q/" + SelectedCountry + "/" + SelectedCity + ".json";
        Log.e("Check Narsingdi", webadd);
        //String webadd = "api/c01608ec8b245e24/geolookup/conditions/forecast10day/q/Bangladesh/Dhaka.json";
        Call<WeatherResponse> weatherResponseCall = weatherServiceAPI.getWeather(webadd);
        Log.e("Check Narsingdi 2", "agdom bagdom");

        weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                Log.e("Check Narsingdi 3", "agdom bagdom");
                weatherResponse = response.body();
                WeatherResponse.CurrentObservation observation=weatherResponse.getCurrentObservation();
                tempC=observation.getTempC();
                tempTv.setText(tempC.intValue()+"℃");
                Log.e("temp", "Temp Celcius: "+tempC);
                // tempF=observation.getTempF();
                Log.e("temp", "tempf: "+tempF);
                relativeHumidity=observation.getRelativeHumidity();
                humidityTv.setText(relativeHumidity);
                Log.e("relativeHumidity", relativeHumidity);
                String windDir=observation.getWindDir();
                Log.e("windDir", "windDir "+windDir);
                Double windMph=observation.getWindMph();
                Log.e("windMph", "windMph "+windMph);
                windKph=observation.getWindKph();
                windspeedTV.setText(windKph+"");
                Log.e("windKph", "windKph "+windKph);
                pressuremb=observation.getPressureMb();
                pressureTv.setText(pressuremb+" kpa");
                Log.e("pressureIn", "pressureIn "+pressuremb);
                Log.e("Weather ", observation.getWeather());
                weather = observation.getWeather();
                weatherTv.setText(weather);

                String visibilityMi=observation.getVisibilityMi();
                Log.e("visibilityMi", "visibilityMi "+visibilityMi);
                String visibilityKm=observation.getVisibilityKm();
                Log.e("visibilityKm", "visibilityKm "+visibilityKm);

                feelslikeC = observation.getFeelslikeC();
                feelslikeTv.setText("( feelslike "+feelslikeC+"℃ )");
                Log.e("Feelslike : ", feelslikeC);

                weatherTv.setVisibility(View.VISIBLE);
                windspeedTV.setVisibility(View.VISIBLE);
                pressureTv.setVisibility(View.VISIBLE);
                humidityTv.setVisibility(View.VISIBLE);
                tempTv.setVisibility(View.VISIBLE);
                feelslikeTv.setVisibility(View.VISIBLE);


                final List<WeatherResponse.Forecast.Simpleforecast.Forecastday_> forecastday =
                        weatherResponse.getForecast().getSimpleforecast().getForecastday();

                for (int i=0;i<forecastday.size();i++)
                {
                    WeatherResponse.Forecast.Simpleforecast.Forecastday_.Date date = forecastday.get(i).getDate();
                    Log.e("Date : ", String.valueOf(date.getDay()+"/"+date.getMonth()));
                    Log.e("TempHigh : ", String.valueOf(forecastday.get(i).getHigh().getCelsius()));
                    Log.e("TempLow : ", String.valueOf(forecastday.get(i).getLow().getCelsius()));
                }


                Log.e("temp", "onResponse: " + tempC);



                wealtherListView.setAdapter(new MyWeatherAdapter(MyWeather.this,getLayoutInflater(),forecastday));


                // End of posting to UI

            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Toast.makeText(MyWeather.this, "Check Your Network Connection.", Toast.LENGTH_SHORT).show();

            }
        });

        /*}catch (Exception e)
        {
            Toast.makeText(MyWeather.this,"No data found ", Toast.LENGTH_LONG);
        }*/
    }

    private void networkLibraryPopulate() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(WeatherConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        weatherServiceAPI = retrofit.create(WeatherServiceAPI.class);


    }

    public void search(View view) {

        WeathercityNametv.setVisibility(View.GONE);
        weatherAutoComplete.setVisibility(View.VISIBLE);
        searchImg.setVisibility(View.GONE);

    }
}













/*
package theateam.com.tourmanager.Weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import theateam.com.tourmanager.R;
import theateam.com.tourmanager.Weather.Autocomplete.SuggestionAdapter;

public class MyWeather extends AppCompatActivity {
    WeatherServiceAPI weatherServiceAPI;
    WeatherResponse weatherResponse;
    AutoCompleteTextView weatherAutoComplete;


    String City = "Narsingdi";
    String Country = "Bangladesh";
    WeatherResponse.CurrentObservation currentObservation;
    String temperature;
    int tempC;
    int tempF;
    List<WeatherResponse.Forecast> forecastClass;

    // All View References Here

    TextView weatherTv,windspeedTV,pressureTv,humidityTv,tempTv,feelslikeTv,WeathercityNametv;
    ListView wealtherListView; ImageView searchImg;


    // View References End here

    // All Json Variable here
    // cloudy or sun
     String weather ;
    Integer windKph;
   String pressuremb;
    String relativeHumidity;
    private String feelslikeC;


    // Jason variable end here


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_weather);
        initialize();
        networkLibraryPopulate();
        loadDatas(City,Country);

         weatherAutoComplete = (AutoCompleteTextView) findViewById(R.id.weatherAutoComplete);
        weatherAutoComplete.setAdapter(new SuggestionAdapter(this,weatherAutoComplete.getText().toString()));
        weatherAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = weatherAutoComplete.getText().toString();
                weatherAutoComplete.setText("");
                weatherAutoComplete.setVisibility(View.GONE);
                String[] split = s.split(",");
                Log.e("City",split[0].trim() );
                Log.e("Country", split[split.length-1].trim());
                loadDatas(split[0].trim(),split[split.length-1].trim());
                WeathercityNametv.setVisibility(View.VISIBLE);
                searchImg.setVisibility(View.VISIBLE);
                WeathercityNametv.setText(s);
            }
        });
    }


    public void initialize()
    {
        weatherTv=(TextView) findViewById(R.id.weatherTv);
        windspeedTV=(TextView) findViewById(R.id.windspeedTV);
        pressureTv=(TextView) findViewById(R.id.pressureTv);
        humidityTv=(TextView) findViewById(R.id.humidityTv);
        tempTv=(TextView) findViewById(R.id.tempTv);
        feelslikeTv= (TextView) findViewById(R.id.feelslikeTv);
        wealtherListView= (ListView) findViewById(R.id.wealtherListView);
        weatherAutoComplete= (AutoCompleteTextView) findViewById(R.id.weatherAutoComplete);
        WeathercityNametv= (TextView) findViewById(R.id.WeathercityNametv);
        searchImg= (ImageView) findViewById(R.id.searchImg);
    }


    private void loadDatas(String SelectedCity,String SelectedCountry) {


        String webadd = "api/c01608ec8b245e24/conditions/forecast10day/q/" + SelectedCountry + "/" + SelectedCity + ".json";
        Log.e("Check Narsingdi", webadd);
        //String webadd = "api/c01608ec8b245e24/geolookup/conditions/forecast10day/q/Bangladesh/Dhaka.json";
        Call<WeatherResponse> weatherResponseCall = weatherServiceAPI.getWeather(webadd);
        Log.e("Check Narsingdi 2", "agdom bagdom");

        weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                Log.e("Check Narsingdi 3", "agdom bagdom");
                weatherResponse = response.body();
                WeatherResponse.CurrentObservation observation=weatherResponse.getCurrentObservation();
                tempC=observation.getTempC();
                tempTv.setText(tempC+"℃");
                Log.e("temp", "Temp Celcius: "+tempC);
               // tempF=observation.getTempF();
                Log.e("temp", "tempf: "+tempF);
                relativeHumidity=observation.getRelativeHumidity();
                humidityTv.setText(relativeHumidity);
                Log.e("relativeHumidity", relativeHumidity);
                String windDir=observation.getWindDir();
                Log.e("windDir", "windDir "+windDir);
                Integer windMph=observation.getWindMph();
                Log.e("windMph", "windMph "+windMph);
                 windKph=observation.getWindKph();
                windspeedTV.setText(windKph+"");
                Log.e("windKph", "windKph "+windKph);
                pressuremb=observation.getPressureMb();
                pressureTv.setText(pressuremb+" kpa");
                Log.e("pressureIn", "pressureIn "+pressuremb);
                Log.e("Weather ", observation.getWeather());
                weather = observation.getWeather();
                weatherTv.setText(weather);

                String visibilityMi=observation.getVisibilityMi();
                Log.e("visibilityMi", "visibilityMi "+visibilityMi);
                String visibilityKm=observation.getVisibilityKm();
                Log.e("visibilityKm", "visibilityKm "+visibilityKm);

                  feelslikeC = observation.getFeelslikeC();
                feelslikeTv.setText("( feelslike "+feelslikeC+"℃ )");
                 Log.e("Feelslike : ", feelslikeC);


                final List<WeatherResponse.Forecast.Simpleforecast.Forecastday_> forecastday =
                        weatherResponse.getForecast().getSimpleforecast().getForecastday();

                for (int i=0;i<forecastday.size();i++)
                {
                     WeatherResponse.Forecast.Simpleforecast.Forecastday_.Date date = forecastday.get(i).getDate();
                    Log.e("Date : ", String.valueOf(date.getDay()+"/"+date.getMonth()));
                    Log.e("TempHigh : ", String.valueOf(forecastday.get(i).getHigh().getCelsius()));
                    Log.e("TempLow : ", String.valueOf(forecastday.get(i).getLow().getCelsius()));
                }


                Log.e("temp", "onResponse: " + tempC);
               // Toast.makeText(MyWeather.this, "temp" + tempC, Toast.LENGTH_SHORT).show();


                // Posting to UI from here
     */
/*           weather = observation.getWeather();
                weatherTv.setText(weather);
                windspeedTV.setText(windKph+"");
                pressureTv.setText(pressuremb+" kpa");
                humidityTv.setText(relativeHumidity);
                tempTv.setText(tempC+"℃");
                feelslikeTv.setText("( feelslike "+feelslikeC+"℃ )");*//*



                wealtherListView.setAdapter(new MyWeatherAdapter(MyWeather.this,getLayoutInflater(),forecastday));


                // End of posting to UI

            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Toast.makeText(MyWeather.this, "Check Your Network Connection.", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void networkLibraryPopulate() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(WeatherConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        weatherServiceAPI = retrofit.create(WeatherServiceAPI.class);


    }

    public void search(View view) {

        WeathercityNametv.setVisibility(View.GONE);
        weatherAutoComplete.setVisibility(View.VISIBLE);
        searchImg.setVisibility(View.GONE);

    }
}*/
