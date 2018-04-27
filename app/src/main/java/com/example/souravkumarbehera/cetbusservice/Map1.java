package com.example.souravkumarbehera.cetbusservice;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map1 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LocationManager locationManager;
    LocationListener locationListener;
    Firebase myFirebase;
    Button showBusNo;
    String latitude,longitude,verti, hori;
    Double lat, lng;
    Marker busLoc,current;
    TextView status;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(Map1.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER,0,0,locationListener);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        showBusNo=(Button)findViewById(R.id.showBusNo);
        status=(TextView)findViewById(R.id.status);
        myFirebase.setAndroidContext(this);
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

        String s = getIntent().getStringExtra("BusNo");
        showBusNo.setText(s);
        locationManager=(LocationManager)this.getSystemService(Context.LOCATION_SERVICE);

        if(s.equals("1")){
            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/1/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/1/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            latitude= Ref1dataSnapshot.getValue(String.class);
                            longitude= Ref2dataSnapshot.getValue(String.class);

                            if(!latitude.equals("") || !longitude.equals("")) {
                                Toast.makeText(Map1.this, latitude + " " + longitude, Toast.LENGTH_SHORT).show();

                                status.setText("ONLINE");

                                lat=Double.parseDouble(latitude);
                                lng=Double.parseDouble(longitude);

                                LatLng busLocation = new LatLng(lat,lng);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                                /*
                                locationListener= new LocationListener() {
                                    @Override
                                    public void onLocationChanged(Location location) {
                                        Log.i("Location User", location.toString());
                                        LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                        mMap.clear();
                                        //current.remove();
                                        current = mMap.addMarker(new MarkerOptions().position(driverLocation).title("Current Location"));
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation,16));

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
                                };*/
                            }
                            else{
                                Toast.makeText(Map1.this, "Driver is offline", Toast.LENGTH_SHORT).show();
                                status.setText("OFFLINE");
                                LatLng busLocation = new LatLng(20.2764562,85.7736074);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Last Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                            }


                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if(s.equals("2")){
            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/2/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/2/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            latitude= Ref1dataSnapshot.getValue(String.class);
                            longitude= Ref2dataSnapshot.getValue(String.class);

                            if(!latitude.equals("") || !longitude.equals("")) {
                                Toast.makeText(Map1.this, latitude + " " + longitude, Toast.LENGTH_SHORT).show();

                                status.setText("ONLINE");

                                lat=Double.parseDouble(latitude);
                                lng=Double.parseDouble(longitude);

                                LatLng busLocation = new LatLng(lat,lng);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                                /*
                                locationListener= new LocationListener() {
                                    @Override
                                    public void onLocationChanged(Location location) {
                                        Log.i("Location User", location.toString());
                                        LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                        mMap.clear();
                                        //current.remove();
                                        current = mMap.addMarker(new MarkerOptions().position(driverLocation).title("Current Location"));
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation,16));

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
                                };*/
                            }
                            else{
                                Toast.makeText(Map1.this, "Driver is offline", Toast.LENGTH_SHORT).show();
                                status.setText("OFFLINE");
                                LatLng busLocation = new LatLng(20.2764562,85.7736074);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Last Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                            }


                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if(s.equals("3")){
            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/3/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/3/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            latitude= Ref1dataSnapshot.getValue(String.class);
                            longitude= Ref2dataSnapshot.getValue(String.class);

                            if(!latitude.equals("") || !longitude.equals("")) {
                                Toast.makeText(Map1.this, latitude + " " + longitude, Toast.LENGTH_SHORT).show();

                                status.setText("ONLINE");

                                lat=Double.parseDouble(latitude);
                                lng=Double.parseDouble(longitude);

                                LatLng busLocation = new LatLng(lat,lng);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                                /*
                                locationListener= new LocationListener() {
                                    @Override
                                    public void onLocationChanged(Location location) {
                                        Log.i("Location User", location.toString());
                                        LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                        mMap.clear();
                                        //current.remove();
                                        current = mMap.addMarker(new MarkerOptions().position(driverLocation).title("Current Location"));
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation,16));

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
                                };*/
                            }
                            else{
                                Toast.makeText(Map1.this, "Driver is offline", Toast.LENGTH_SHORT).show();
                                status.setText("OFFLINE");
                                LatLng busLocation = new LatLng(20.2764562,85.7736074);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Last Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                            }


                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if(s.equals("4")){
            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/4/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/4/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            latitude= Ref1dataSnapshot.getValue(String.class);
                            longitude= Ref2dataSnapshot.getValue(String.class);

                            if(!latitude.equals("") || !longitude.equals("")) {
                                Toast.makeText(Map1.this, latitude + " " + longitude, Toast.LENGTH_SHORT).show();

                                status.setText("ONLINE");

                                lat=Double.parseDouble(latitude);
                                lng=Double.parseDouble(longitude);

                                LatLng busLocation = new LatLng(lat,lng);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                                /*
                                locationListener= new LocationListener() {
                                    @Override
                                    public void onLocationChanged(Location location) {
                                        Log.i("Location User", location.toString());
                                        LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                        mMap.clear();
                                        //current.remove();
                                        current = mMap.addMarker(new MarkerOptions().position(driverLocation).title("Current Location"));
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation,16));

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
                                };*/
                            }
                            else{
                                Toast.makeText(Map1.this, "Driver is offline", Toast.LENGTH_SHORT).show();
                                status.setText("OFFLINE");
                                LatLng busLocation = new LatLng(20.2764562,85.7736074);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Last Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                            }


                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if(s.equals("5")){
            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/5/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/5/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            latitude= Ref1dataSnapshot.getValue(String.class);
                            longitude= Ref2dataSnapshot.getValue(String.class);

                            if(!latitude.equals("") || !longitude.equals("")) {
                                Toast.makeText(Map1.this, latitude + " " + longitude, Toast.LENGTH_SHORT).show();

                                status.setText("ONLINE");

                                lat=Double.parseDouble(latitude);
                                lng=Double.parseDouble(longitude);

                                LatLng busLocation = new LatLng(lat,lng);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                                /*
                                locationListener= new LocationListener() {
                                    @Override
                                    public void onLocationChanged(Location location) {
                                        Log.i("Location User", location.toString());
                                        LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                        mMap.clear();
                                        //current.remove();
                                        current = mMap.addMarker(new MarkerOptions().position(driverLocation).title("Current Location"));
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation,16));

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
                                };*/
                            }
                            else{
                                Toast.makeText(Map1.this, "Driver is offline", Toast.LENGTH_SHORT).show();
                                status.setText("OFFLINE");
                                LatLng busLocation = new LatLng(20.2764562,85.7736074);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Last Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                            }


                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if(s.equals("6")){
            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/6/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/6/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            latitude= Ref1dataSnapshot.getValue(String.class);
                            longitude= Ref2dataSnapshot.getValue(String.class);

                            if(!latitude.equals("") || !longitude.equals("")) {
                                Toast.makeText(Map1.this, latitude + " " + longitude, Toast.LENGTH_SHORT).show();

                                status.setText("ONLINE");

                                lat=Double.parseDouble(latitude);
                                lng=Double.parseDouble(longitude);

                                LatLng busLocation = new LatLng(lat,lng);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                                /*
                                locationListener= new LocationListener() {
                                    @Override
                                    public void onLocationChanged(Location location) {
                                        Log.i("Location User", location.toString());
                                        LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                        mMap.clear();
                                        //current.remove();
                                        current = mMap.addMarker(new MarkerOptions().position(driverLocation).title("Current Location"));
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation,16));

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
                                };*/
                            }
                            else{
                                Toast.makeText(Map1.this, "Driver is offline", Toast.LENGTH_SHORT).show();
                                status.setText("OFFLINE");
                                LatLng busLocation = new LatLng(20.2764562,85.7736074);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Last Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                            }


                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if(s.equals("7")){
            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/7/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/7/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            latitude= Ref1dataSnapshot.getValue(String.class);
                            longitude= Ref2dataSnapshot.getValue(String.class);

                            if(!latitude.equals("") || !longitude.equals("")) {
                                Toast.makeText(Map1.this, latitude + " " + longitude, Toast.LENGTH_SHORT).show();

                                status.setText("ONLINE");

                                lat=Double.parseDouble(latitude);
                                lng=Double.parseDouble(longitude);

                                LatLng busLocation = new LatLng(lat,lng);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                                /*
                                locationListener= new LocationListener() {
                                    @Override
                                    public void onLocationChanged(Location location) {
                                        Log.i("Location User", location.toString());
                                        LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                        mMap.clear();
                                        //current.remove();
                                        current = mMap.addMarker(new MarkerOptions().position(driverLocation).title("Current Location"));
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation,16));

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
                                };*/
                            }
                            else{
                                Toast.makeText(Map1.this, "Driver is offline", Toast.LENGTH_SHORT).show();
                                status.setText("OFFLINE");
                                LatLng busLocation = new LatLng(20.2764562,85.7736074);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Last Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                            }


                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if(s.equals("8")){
            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/8/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/8/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            latitude= Ref1dataSnapshot.getValue(String.class);
                            longitude= Ref2dataSnapshot.getValue(String.class);

                            if(!latitude.equals("") || !longitude.equals("")) {
                                Toast.makeText(Map1.this, latitude + " " + longitude, Toast.LENGTH_SHORT).show();

                                status.setText("ONLINE");

                                lat=Double.parseDouble(latitude);
                                lng=Double.parseDouble(longitude);

                                LatLng busLocation = new LatLng(lat,lng);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                                /*
                                locationListener= new LocationListener() {
                                    @Override
                                    public void onLocationChanged(Location location) {
                                        Log.i("Location User", location.toString());
                                        LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                        mMap.clear();
                                        //current.remove();
                                        current = mMap.addMarker(new MarkerOptions().position(driverLocation).title("Current Location"));
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation,16));

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
                                };*/
                            }
                            else{
                                Toast.makeText(Map1.this, "Driver is offline", Toast.LENGTH_SHORT).show();
                                status.setText("OFFLINE");
                                LatLng busLocation = new LatLng(20.2764562,85.7736074);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Last Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                            }


                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if(s.equals("9")){
            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/9/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/9/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            latitude= Ref1dataSnapshot.getValue(String.class);
                            longitude= Ref2dataSnapshot.getValue(String.class);

                            if(!latitude.equals("") || !longitude.equals("")) {
                                Toast.makeText(Map1.this, latitude + " " + longitude, Toast.LENGTH_SHORT).show();

                                status.setText("ONLINE");

                                lat=Double.parseDouble(latitude);
                                lng=Double.parseDouble(longitude);

                                LatLng busLocation = new LatLng(lat,lng);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                                /*
                                locationListener= new LocationListener() {
                                    @Override
                                    public void onLocationChanged(Location location) {
                                        Log.i("Location User", location.toString());
                                        LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                        mMap.clear();
                                        //current.remove();
                                        current = mMap.addMarker(new MarkerOptions().position(driverLocation).title("Current Location"));
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation,16));

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
                                };*/
                            }
                            else{
                                Toast.makeText(Map1.this, "Driver is offline", Toast.LENGTH_SHORT).show();
                                status.setText("OFFLINE");
                                LatLng busLocation = new LatLng(20.2764562,85.7736074);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Last Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                            }


                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if(s.equals("10")){
            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/10/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/10/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            latitude= Ref1dataSnapshot.getValue(String.class);
                            longitude= Ref2dataSnapshot.getValue(String.class);

                            if(!latitude.equals("") || !longitude.equals("")) {
                                Toast.makeText(Map1.this, latitude + " " + longitude, Toast.LENGTH_SHORT).show();

                                status.setText("ONLINE");

                                lat=Double.parseDouble(latitude);
                                lng=Double.parseDouble(longitude);

                                LatLng busLocation = new LatLng(lat,lng);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                                /*
                                locationListener= new LocationListener() {
                                    @Override
                                    public void onLocationChanged(Location location) {
                                        Log.i("Location User", location.toString());
                                        LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                        mMap.clear();
                                        //current.remove();
                                        current = mMap.addMarker(new MarkerOptions().position(driverLocation).title("Current Location"));
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation,16));

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
                                };*/
                            }
                            else{
                                Toast.makeText(Map1.this, "Driver is offline", Toast.LENGTH_SHORT).show();
                                status.setText("OFFLINE");
                                LatLng busLocation = new LatLng(20.2764562,85.7736074);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Last Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                            }


                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if(s.equals("11")){
            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/11/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/11/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            latitude= Ref1dataSnapshot.getValue(String.class);
                            longitude= Ref2dataSnapshot.getValue(String.class);

                            if(!latitude.equals("") || !longitude.equals("")) {
                                Toast.makeText(Map1.this, latitude + " " + longitude, Toast.LENGTH_SHORT).show();

                                status.setText("ONLINE");

                                lat=Double.parseDouble(latitude);
                                lng=Double.parseDouble(longitude);

                                LatLng busLocation = new LatLng(lat,lng);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                                /*
                                locationListener= new LocationListener() {
                                    @Override
                                    public void onLocationChanged(Location location) {
                                        Log.i("Location User", location.toString());
                                        LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                        mMap.clear();
                                        //current.remove();
                                        current = mMap.addMarker(new MarkerOptions().position(driverLocation).title("Current Location"));
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation,16));

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
                                };*/
                            }
                            else{
                                Toast.makeText(Map1.this, "Driver is offline", Toast.LENGTH_SHORT).show();
                                status.setText("OFFLINE");
                                LatLng busLocation = new LatLng(20.2764562,85.7736074);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Last Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                            }


                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if(s.equals("12")){
            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/12/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/12/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            latitude= Ref1dataSnapshot.getValue(String.class);
                            longitude= Ref2dataSnapshot.getValue(String.class);

                            if(!latitude.equals("") || !longitude.equals("")) {
                                Toast.makeText(Map1.this, latitude + " " + longitude, Toast.LENGTH_SHORT).show();

                                status.setText("ONLINE");

                                lat=Double.parseDouble(latitude);
                                lng=Double.parseDouble(longitude);

                                LatLng busLocation = new LatLng(lat,lng);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                                /*
                                locationListener= new LocationListener() {
                                    @Override
                                    public void onLocationChanged(Location location) {
                                        Log.i("Location User", location.toString());
                                        LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                        mMap.clear();
                                        //current.remove();
                                        current = mMap.addMarker(new MarkerOptions().position(driverLocation).title("Current Location"));
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation,16));

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
                                };*/
                            }
                            else{
                                Toast.makeText(Map1.this, "Driver is offline", Toast.LENGTH_SHORT).show();
                                status.setText("OFFLINE");
                                LatLng busLocation = new LatLng(20.2764562,85.7736074);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Last Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                            }


                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if(s.equals("13")){
            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/13/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/13/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            latitude= Ref1dataSnapshot.getValue(String.class);
                            longitude= Ref2dataSnapshot.getValue(String.class);

                            if(!latitude.equals("") || !longitude.equals("")) {
                                Toast.makeText(Map1.this, latitude + " " + longitude, Toast.LENGTH_SHORT).show();

                                status.setText("ONLINE");

                                lat=Double.parseDouble(latitude);
                                lng=Double.parseDouble(longitude);

                                LatLng busLocation = new LatLng(lat,lng);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                                /*
                                locationListener= new LocationListener() {
                                    @Override
                                    public void onLocationChanged(Location location) {
                                        Log.i("Location User", location.toString());
                                        LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                        mMap.clear();
                                        //current.remove();
                                        current = mMap.addMarker(new MarkerOptions().position(driverLocation).title("Current Location"));
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation,16));

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
                                };*/
                            }
                            else{
                                Toast.makeText(Map1.this, "Driver is offline", Toast.LENGTH_SHORT).show();
                                status.setText("OFFLINE");
                                LatLng busLocation = new LatLng(20.2764562,85.7736074);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Last Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                            }


                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if(s.equals("14")){
            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/14/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/14/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            latitude= Ref1dataSnapshot.getValue(String.class);
                            longitude= Ref2dataSnapshot.getValue(String.class);

                            if(!latitude.equals("") || !longitude.equals("")) {
                                Toast.makeText(Map1.this, latitude + " " + longitude, Toast.LENGTH_SHORT).show();

                                status.setText("ONLINE");

                                lat=Double.parseDouble(latitude);
                                lng=Double.parseDouble(longitude);

                                LatLng busLocation = new LatLng(lat,lng);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                                /*
                                locationListener= new LocationListener() {
                                    @Override
                                    public void onLocationChanged(Location location) {
                                        Log.i("Location User", location.toString());
                                        LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                        mMap.clear();
                                        //current.remove();
                                        current = mMap.addMarker(new MarkerOptions().position(driverLocation).title("Current Location"));
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation,16));

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
                                };*/
                            }
                            else{
                                Toast.makeText(Map1.this, "Driver is offline", Toast.LENGTH_SHORT).show();
                                status.setText("OFFLINE");
                                LatLng busLocation = new LatLng(20.2764562,85.7736074);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Last Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                            }


                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if(s.equals("15")){
            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/15/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/15/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            latitude= Ref1dataSnapshot.getValue(String.class);
                            longitude= Ref2dataSnapshot.getValue(String.class);

                            if(!latitude.equals("") || !longitude.equals("")) {
                                Toast.makeText(Map1.this, latitude + " " + longitude, Toast.LENGTH_SHORT).show();

                                status.setText("ONLINE");

                                lat=Double.parseDouble(latitude);
                                lng=Double.parseDouble(longitude);

                                LatLng busLocation = new LatLng(lat,lng);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                                /*
                                locationListener= new LocationListener() {
                                    @Override
                                    public void onLocationChanged(Location location) {
                                        Log.i("Location User", location.toString());
                                        LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                        mMap.clear();
                                        //current.remove();
                                        current = mMap.addMarker(new MarkerOptions().position(driverLocation).title("Current Location"));
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation,16));

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
                                };*/
                            }
                            else{
                                Toast.makeText(Map1.this, "Driver is offline", Toast.LENGTH_SHORT).show();
                                status.setText("OFFLINE");
                                LatLng busLocation = new LatLng(20.2764562,85.7736074);

                                busLoc= mMap.addMarker(new MarkerOptions().position(busLocation).title("Last Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                            }


                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else {
            Toast.makeText(Map1.this, "Error" ,Toast.LENGTH_SHORT).show();
        }
        /*
        if(!latitude.equals(null) && !longitude.equals(null)) {
            Toast.makeText(Map1.this, latitude + longitude ,Toast.LENGTH_SHORT).show();

            lat = Double.parseDouble(latitude);
            lng = Double.parseDouble(longitude);
            LatLng busLocation = new LatLng(lat, lng);
            mMap.clear();
            mMap.addMarker(new MarkerOptions().position(busLocation).title("Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(busLocation, 16));

        }
        else {
            Toast.makeText(Map1.this, "The Driver is offline", Toast.LENGTH_SHORT).show();
        }
        */
        //Toast.makeText(Map1.this, latitude + longitude ,Toast.LENGTH_SHORT).show();
        //LatLng busLocation = new LatLng(20.278881,85.7955214);
        //mMap.clear();
        //mMap.addMarker(new MarkerOptions().position(busLocation).title("Bus Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(busLocation, 16));
        Toast.makeText(Map1.this, s, Toast.LENGTH_SHORT).show();
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        locationManager=(LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        locationListener= new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.i("Location User", location.toString());
                LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.clear();
                mMap.addMarker(new MarkerOptions().position(driverLocation).title("Updating Location"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(driverLocation, 16));

                /*
                myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/1/Location");
                Firebase childRef1= myFirebase.child("Latitude");
                childRef1.setValue(location.getLatitude());
                Firebase childRef2= myFirebase.child("Longitude");
                childRef2.setValue(location.getLongitude());*/

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

        if(ContextCompat.checkSelfPermission(Map1.this, android.Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},1);
        }
        else{
            locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER,0,0,locationListener);

            Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            mMap.clear();
            LatLng userLocation = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            mMap.addMarker(new MarkerOptions().position(userLocation).title("Current Location")).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation,16));


        }

    }
}
