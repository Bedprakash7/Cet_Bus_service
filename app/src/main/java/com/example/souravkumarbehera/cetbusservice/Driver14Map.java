package com.example.souravkumarbehera.cetbusservice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;

import com.firebase.client.Firebase;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Driver14Map extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LocationManager locationManager;
    LocationListener locationListener;
    Firebase myFirebase;

    public void goOfflineClicked(View view){
        Intent prev =new Intent(Driver14Map.this, Driver14Page.class);
        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/14/Location");
        Firebase childRef1= myFirebase.child("Latitude");
        childRef1.setValue("");
        Firebase childRef2= myFirebase.child("Longitude");
        childRef2.setValue("");
        startActivity(prev);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/14/Location");
        Firebase childRef1= myFirebase.child("Latitude");
        childRef1.setValue("");
        Firebase childRef2= myFirebase.child("Longitude");
        childRef2.setValue("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/14/Location");
        Firebase childRef1= myFirebase.child("Latitude");
        childRef1.setValue("");
        Firebase childRef2= myFirebase.child("Longitude");
        childRef2.setValue("");
    }



    @Override
    protected void onStop() {
        super.onStop();
        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/14/Location");
        Firebase childRef1= myFirebase.child("Latitude");
        childRef1.setValue("");
        Firebase childRef2= myFirebase.child("Longitude");
        childRef2.setValue("");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(Driver14Map.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER,0,0,locationListener);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver14_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Firebase.setAndroidContext(this);
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
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        locationManager=(LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        locationListener= new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.i("Location of Driver 14", location.toString());
                LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.clear();
                mMap.addMarker(new MarkerOptions().position(driverLocation).title("Updating Location"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation,16));

                myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/14/Location");
                Firebase childRef1= myFirebase.child("Latitude");
                childRef1.setValue(location.getLatitude());
                Firebase childRef2= myFirebase.child("Longitude");
                childRef2.setValue(location.getLongitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        //if(Build.VERSION.SDK_INT<23){
        //  locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER,0,0,locationListener);
        //}
        //else{
        if(ContextCompat.checkSelfPermission(Driver14Map.this, android.Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},1);
        }
        else{
            locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER,0,0,locationListener);

            Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            mMap.clear();
            LatLng driverLocation = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            mMap.addMarker(new MarkerOptions().position(driverLocation).title("Last Location"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation,16));

            myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/14/Location");
            Firebase childRef1= myFirebase.child("Latitude");
            childRef1.setValue(lastKnownLocation.getLatitude());
            Firebase childRef2= myFirebase.child("Longitude");
            childRef2.setValue(lastKnownLocation.getLongitude());
        }
    }
}
