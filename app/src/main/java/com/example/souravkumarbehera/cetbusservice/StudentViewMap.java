package com.example.souravkumarbehera.cetbusservice;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class StudentViewMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng driverLocation,userLocation;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        intent=getIntent();
        RelativeLayout mapLayout=(RelativeLayout)findViewById(R.id.mapRelative);
        mapLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                driverLocation = new LatLng(intent.getDoubleExtra("Driver Latitude",0), intent.getDoubleExtra("Driver Longitude", 0));
                userLocation = new LatLng(intent.getDoubleExtra("User Latitude",0), intent.getDoubleExtra("User Longitude", 0));


                ArrayList<Marker> markers= new ArrayList<>();
                markers.add(mMap.addMarker(new MarkerOptions().position(driverLocation).title("Driver Location")));
                markers.add(mMap.addMarker(new MarkerOptions().position(userLocation).title("Your Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))));
                // Add a marker in Sydney and move the camera
                LatLngBounds.Builder builder= new LatLngBounds.Builder();
                for(Marker marker : markers){
                    builder.include(marker.getPosition());
                }
                LatLngBounds bounds = builder.build();

                int padding=60;

                CameraUpdate cu= CameraUpdateFactory.newLatLngBounds(bounds, padding);
                //mMap.animateCamera(cu);
                //CameraUpdateFactory.newLatLngZoom(driverLocation,15);
                try {
                    Thread.sleep(2000);
                }
                catch (Exception e){

                }

                mMap.animateCamera(cu);
            }
        });
    }

    public void navigate(View view){

        Intent directionIntent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?saddr="+ intent.getDoubleExtra("User Latitude",0) + ","+ intent.getDoubleExtra("User Longitude",0)+ "&daddr="+  intent.getDoubleExtra("Driver Latitude",0) + ","+ intent.getDoubleExtra("Driver Longitude",0)));
        startActivity(directionIntent);
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


    }
}
