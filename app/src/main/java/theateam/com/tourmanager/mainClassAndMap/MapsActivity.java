package theateam.com.tourmanager.mainClassAndMap;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import theateam.com.tourmanager.GeoData.Constants;
import theateam.com.tourmanager.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    Double lattitude, longitude;


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        lattitude = getIntent().getDoubleExtra(Constants.LATTITUDE, 0.0);
        longitude = getIntent().getDoubleExtra(Constants.LONGITUDE, 0.0);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);





    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        lattitude = getIntent().getDoubleExtra(Constants.LATTITUDE,1.0);
        longitude = getIntent().getDoubleExtra(Constants.LONGITUDE,1.0);
        mMap = googleMap;
        String currentLocation = getIntent().getStringExtra(Constants.MY_LOCATION);
        Log.e("Current Location ", currentLocation+"");

        LatLng currentplace = new LatLng(lattitude, longitude);


        if(!getIntent().getBooleanExtra(Constants.ALL_OR_SINGLE_PLACE,true))
        {

            // Add a marker in Sydney and move the camera

            mMap.addMarker(new MarkerOptions().position(currentplace).title(currentLocation + ""));

            // mMap.addMarker(new MarkerOptions().position(prince).title("Marker in Prince"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentplace,12));
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);
        }
        else
        {


            double[] lattitudeArray= getIntent().getDoubleArrayExtra(Constants.PLACES_LATTITUDE);
            Log.e("Places Lattitude Maps", lattitudeArray.length+"");
            double[] LongitudeeArray= getIntent().getDoubleArrayExtra(Constants.PLACES_LONGITUDE);
            Log.e("Places Lattitude Maps 2", lattitudeArray.length+"");
            String[] placesname = getIntent().getStringArrayExtra(Constants.PLACES_NAME);
            mMap.addMarker(new MarkerOptions().position(currentplace).title(currentLocation+""));
            for(int i=0;i<lattitudeArray.length;i++)
            {

                Marker marker = mMap.addMarker(new MarkerOptions().position(new LatLng(lattitudeArray[i], LongitudeeArray[i])).title("" + placesname[i]));
                /*.alpha(0.7f)*/
                setmarker(marker,getIntent().getStringExtra(Constants.MARKER_INTEREST));
                Log.e("Marker ", getIntent().getStringExtra(Constants.MARKER_INTEREST));

            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentplace,14));

            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);
        }


       /* mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng pirerbag = new LatLng(lattitude, longitude);
        LatLng prince = new LatLng(23.798552, 90.353914);
        mMap.addMarker(new MarkerOptions().position(pirerbag).title("Marker in Pirerbag"));
       // mMap.addMarker(new MarkerOptions().position(prince).title("Marker in Prince"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pirerbag,10));

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);*/

    }

    public void search(View view) {
        onBackPressed();
    }

    private Bitmap getMarkerBitmapFromView(@DrawableRes int resId) {

        View customMarkerView = ((LayoutInflater) getSystemService(this.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.view_custom_marker, null);
        ImageView markerImageView = (ImageView) customMarkerView.findViewById(R.id.profile_image);
        markerImageView.setImageResource(resId);
        customMarkerView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        customMarkerView.layout(0, 0, customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight());
        customMarkerView.buildDrawingCache();
        Bitmap returnedBitmap = Bitmap.createBitmap(customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN);
        Drawable drawable = customMarkerView.getBackground();
        if (drawable != null)
            drawable.draw(canvas);
        customMarkerView.draw(canvas);
        return returnedBitmap;
    }

    public void setmarker(Marker marker1, String marker) {
        switch (marker)
        {
            case "atm": marker1.setIcon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.drawable.atm1)));break ;
            case "hospital": marker1.setIcon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.drawable.hospital)));break ;
            case "bank": marker1.setIcon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.drawable.bank)));break ;
            case "police": marker1.setIcon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.drawable.police)));break ;
            case "restaurant": marker1.setIcon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.drawable.restaurent)));break ;
            case "shopping_mall": marker1.setIcon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.drawable.shopping)));break ;
            case "all": marker1.setIcon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.drawable.location)));break ;

        }
    }

    public void Showlist(View view) {
        onBackPressed();
    }
}
