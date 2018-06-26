package com.example.souravkumarbehera.cetbusservice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GeneralRoute3 extends AppCompatActivity {
    int count=0,r=0;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    ImageView cat1;
    ImageView cat2;
    TextView detailHeader,BusNo1,BusNo2;
    String nowTime,firstTime="9:30",secondTime="14:10", thirdTime="16:45";
    Date now,firsttime,secondtime,thirdtime;
    Button get,mapButton1,mapButton2;
    RelativeLayout innerRelative;
    Firebase mRef;
    Firebase myFirebase,child1,child2;
    LocationManager locationManager;
    LocationListener locationListener;
    Double userLat, userLng, driverLat, driverLng;
    String dLatitude,dLongitude;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER,0,0,locationListener);
            }
        }
    }

    public void mapButton1Clicked(View view){
        //Toast.makeText(GeneralRoute1.this, "working", Toast.LENGTH_SHORT).show();

        if(BusNo1.getText().toString().equals("Bus No: 1")){

            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","1");
            //startActivity(i);


            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/1/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/1/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo1.getText().toString().equals("Bus No: 2")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","2");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/2/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/2/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo1.getText().toString().equals("Bus No: 3")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","3");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/3/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/3/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo1.getText().toString().equals("Bus No: 4")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","4");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/4/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/4/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo1.getText().toString().equals("Bus No: 5")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","5");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/5/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/5/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo1.getText().toString().equals("Bus No: 6")){
            //Toast.makeText(GeneralRoute1.this, "nested working", Toast.LENGTH_SHORT).show();
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","6");
            //startActivity(i);

            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/6/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/6/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo1.getText().toString().equals("Bus No: 7")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","7");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/7/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/7/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo1.getText().toString().equals("Bus No: 8")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","8");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/8/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/8/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo1.getText().toString().equals("Bus No: 9")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","9");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/9/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/9/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo1.getText().toString().equals("Bus No: 10")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","10");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/10/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/10/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo1.getText().toString().equals("Bus No: 11")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","11");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/11/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/11/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo1.getText().toString().equals("Bus No: 12")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","12");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/12/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/12/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo1.getText().toString().equals("Bus No: 13")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","13");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/13/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/13/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo1.getText().toString().equals("Bus No: 14")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","14");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/14/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/14/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo1.getText().toString().equals("Bus No: 15")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","15");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/15/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/15/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else
            Toast.makeText(GeneralRoute3.this, "Error", Toast.LENGTH_SHORT).show();

    }
    public void mapButton2Clicked(View view){
        if(BusNo2.getText().toString().equals("Bus No: 1")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","1");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/1/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/1/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo2.getText().toString().equals("Bus No: 2")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","2");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/2/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/2/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo2.getText().toString().equals("Bus No: 3")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","3");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/3/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/3/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo2.getText().toString().equals("Bus No: 4")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","4");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/4/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/4/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo2.getText().toString().equals("Bus No: 5")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","5");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/5/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/5/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo2.getText().toString().equals("Bus No: 6")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","6");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/6/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/6/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo2.getText().toString().equals("Bus No: 7")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","7");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/7/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/7/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo2.getText().toString().equals("Bus No: 8")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","8");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/8/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/8/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo2.getText().toString().equals("Bus No: 9")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","9");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/9/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/9/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo2.getText().toString().equals("Bus No: 10")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","10");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/10/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/10/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo2.getText().toString().equals("Bus No: 11")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","11");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/11/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/11/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo2.getText().toString().equals("Bus No: 12")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","12");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/12/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/12/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo2.getText().toString().equals("Bus No: 13")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","13");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/13/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/13/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo2.getText().toString().equals("Bus No: 14")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","14");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/14/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/14/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else if(BusNo2.getText().toString().equals("Bus No: 15")){
            //Intent i= new Intent(GeneralRoute1.this, Map1.class);
            //i.putExtra("BusNo","15");
            //startActivity(i);
            Toast.makeText(GeneralRoute3.this, "Map Loading...", Toast.LENGTH_SHORT).show();

            Firebase child1 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/15/Location/Latitude");
            child1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot Ref1dataSnapshot) {
                    Firebase child2 = new Firebase("https://cet-bus-services.firebaseio.com/Driver Bus No/15/Location/Longitude");
                    child2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot Ref2dataSnapshot) {
                            if(Ref1dataSnapshot!=null || Ref2dataSnapshot!=null){
                                dLatitude= Ref1dataSnapshot.getValue(String.class);
                                dLongitude= Ref2dataSnapshot.getValue(String.class);

                                if(!dLatitude.equals("") || !dLongitude.equals("")) {
                                    //Toast.makeText(GeneralRoute1.this, dLatitude + " " + dLongitude, Toast.LENGTH_SHORT).show();
                                    driverLat= Double.parseDouble(dLatitude);
                                    driverLng= Double.parseDouble(dLongitude);
                                    locationManager=(LocationManager)GeneralRoute3.this.getSystemService(Context.LOCATION_SERVICE);
                                    if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

                                        Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        //Log.d("saswat", "pass1");
                                        if(lastKnownLocation != null){
                                            //Log.d("saswat", "pass2");
                                            Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                                            updateMap(lastKnownLocation,intent);
                                            intent.putExtra("Driver Latitude",driverLat );
                                            intent.putExtra("Driver Longitude", driverLng);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(GeneralRoute3.this, "Error getting location", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(GeneralRoute3.this, "Driver is offline", Toast.LENGTH_SHORT).show();

                                }

                            }
                            else{
                                Toast.makeText(GeneralRoute3.this,"Driver location not found", Toast.LENGTH_SHORT).show();
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
        else
            Toast.makeText(GeneralRoute3.this, "Error", Toast.LENGTH_SHORT).show();
    }
    private Date parseDate(String date) {

        try {
            return simpleDateFormat.parse(date);
        } catch (java.text.ParseException e) {
            return new Date(0);
        }
    }
    public void imageClicked(View view)
    {

        count++;
        if(count%2!=0) {
            cat1.animate()
                    .translationXBy(-500f)
                    .translationYBy(-500f)
                    .scaleX(0.5f)
                    .scaleY(0.5f)
                    .setDuration(1000);

            cat2.animate().alphaBy(1).setDuration(1000);
            //cat2.animate().alpha(1f).setDuration(2000);


        }
        else{
            cat1.setTranslationX(-1000f);
            cat1.setTranslationY(-1000f);
            cat1.animate()
                    .translationXBy(1000f)
                    .translationYBy(1000f)
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(1000);
            cat2.animate().alpha(0).setDuration(1000);
        }
    }
    public void getClicked(View view){
        get.setVisibility(view.INVISIBLE);
        innerRelative.setAlpha(1f);
        calendar= Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("HH:mm");
        //nowTime = simpleDateFormat.format(calendar.getTime());
        //Toast.makeText(this, nowTime , Toast.LENGTH_SHORT).show();
        int hour= calendar.get(Calendar.HOUR_OF_DAY);
        int min= calendar.get(Calendar.MINUTE);
        String hourString=Integer.toString(hour);
        String minString=Integer.toString(min);
        Toast.makeText(this,  hourString + ":" + minString, Toast.LENGTH_SHORT ).show();
        now = parseDate(hour + ":" + min);
        firsttime=parseDate(firstTime);
        secondtime=parseDate(secondTime);
        thirdtime=parseDate(thirdTime);
        if(now.before(firsttime) || now.after(thirdtime)){
            detailHeader.setText("9:30 Leaving Cuttack to Barmunda to CET");
            r=1;
        }
        else if(now.before(secondtime) && now.after(firsttime)){
            detailHeader.setText("14:10 Leaving CET to Barmunda to Cuttack");
            r=2;
        }
        else if (now.before(thirdtime) && now.after(secondtime)){
            detailHeader.setText("16:45 Leaving CET to Barmunda to Cuttack");
            r=3;
        }
        if(r==1){
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Three/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    BusNo2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Three/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    BusNo1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if(r==2){
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Three/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    BusNo2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Three/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    BusNo1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if(r==3){
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Three/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    BusNo2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Three/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    BusNo1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else
            Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show();
    }
    public void updateMap(Location location, Intent intent){
        //Toast.makeText(GeneralRoute1.this, "Location got", Toast.LENGTH_SHORT).show();
        //Toast.makeText(GeneralRoute1.this, Double.toString(location.getLatitude()), Toast.LENGTH_SHORT).show();
        //Toast.makeText(GeneralRoute1.this, Double.toString(location.getLongitude()), Toast.LENGTH_SHORT).show();

        intent.putExtra("User Latitude",location.getLatitude());
        intent.putExtra("User Longitude", location.getLongitude());

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_route3);
        cat1=(ImageView)findViewById(R.id.route3);
        cat2=(ImageView)findViewById(R.id.map3);
        detailHeader=(TextView)findViewById(R.id.detailHeader);
        get= (Button)findViewById(R.id.get);
        innerRelative=(RelativeLayout)findViewById(R.id.innerRelative);

        BusNo1=(TextView)findViewById(R.id.BusNo1);
        BusNo2=(TextView)findViewById(R.id.BusNo2);
        mapButton1=(Button)findViewById(R.id.mapButton1);
        mapButton2=(Button)findViewById(R.id.mapButton2);

        mRef.setAndroidContext(getApplicationContext());
        child1.setAndroidContext(getApplicationContext());
        child2.setAndroidContext(getApplicationContext());
        locationManager=(LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        locationListener= new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.i("Location User", location.toString());
                //LatLng driverLocation = new LatLng(location.getLatitude(), location.getLongitude());
                Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                updateMap(location,intent);

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

        if(ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},1);
        }
        else{
            locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER,0,0,locationListener);



            Location lastKnownLocation = getLastKnownLocation();//locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            //LatLng userLocation = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            if(lastKnownLocation!=null){
                Intent intent= new Intent(getApplicationContext(), StudentViewMap.class);
                updateMap(lastKnownLocation,intent);
            }

        }
    }
    private Location getLastKnownLocation() {
        locationManager = (LocationManager)getApplicationContext().getSystemService(LOCATION_SERVICE);
        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        if(Build.VERSION.SDK_INT >=23 || ContextCompat.checkSelfPermission(GeneralRoute3.this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {

            for (String provider : providers) {
                Location l = locationManager.getLastKnownLocation(provider);

                if (l == null) {
                    continue;
                }
                if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                    // Found best last known location: %s", l);
                    bestLocation = l;
                }
            }
        }
        return bestLocation;
    }
}
