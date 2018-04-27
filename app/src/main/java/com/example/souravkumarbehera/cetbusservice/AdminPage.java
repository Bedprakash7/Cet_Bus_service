package com.example.souravkumarbehera.cetbusservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class AdminPage extends AppCompatActivity {

    String timeString="Select timing first", routeString="Select route first";
    TextView showBuses;
    EditText busOneET,busTwoET;
    Button firstTime, secondTime, thirdTime, busOneAdd, busTwoAdd, reset, routeOne, routeTwo, routeThree, routeFour, routeFive, routeSix;
    Firebase myFirebase;

    public void showDBClicked(View view){
        Intent db= new Intent(AdminPage.this, AdminDatabase.class);
        startActivity(db);
    }

    public void firstTimeClicked (View view){
        secondTime.setVisibility(View.INVISIBLE);
        thirdTime.setVisibility(View.INVISIBLE);
        timeString="first";
    }
    public void secondTimeClicked (View view){
        firstTime.setVisibility(View.INVISIBLE);
        thirdTime.setVisibility(View.INVISIBLE);
        timeString="second";
    }
    public void thirdTimeClicked (View view){
        secondTime.setVisibility(View.INVISIBLE);
        firstTime.setVisibility(View.INVISIBLE);
        timeString="third";
    }
    public void resetClicked (View view){
        firstTime.setVisibility(View.VISIBLE);
        secondTime.setVisibility(View.VISIBLE);
        thirdTime.setVisibility(View.VISIBLE);
        routeOne.setVisibility(View.VISIBLE);
        routeTwo.setVisibility(View.VISIBLE);
        routeThree.setVisibility(View.VISIBLE);
        routeFour.setVisibility(View.VISIBLE);
        routeFive.setVisibility(View.VISIBLE);
        routeSix.setVisibility(View.VISIBLE);
        timeString="Select timing first";
        routeString="Select route first";
    }
    public void routeOneClicked (View view){
        routeTwo.setVisibility(View.INVISIBLE);
        routeThree.setVisibility(View.INVISIBLE);
        routeFour.setVisibility(View.INVISIBLE);
        routeFive.setVisibility(View.INVISIBLE);
        routeSix.setVisibility(View.INVISIBLE);
        routeString="first";
    }
    public void routeTwoClicked (View view){
        routeOne.setVisibility(View.INVISIBLE);
        routeThree.setVisibility(View.INVISIBLE);
        routeFour.setVisibility(View.INVISIBLE);
        routeFive.setVisibility(View.INVISIBLE);
        routeSix.setVisibility(View.INVISIBLE);
        routeString="second";
    }
    public void routeThreeClicked (View view){
        routeOne.setVisibility(View.INVISIBLE);
        routeTwo.setVisibility(View.INVISIBLE);
        routeFour.setVisibility(View.INVISIBLE);
        routeFive.setVisibility(View.INVISIBLE);
        routeSix.setVisibility(View.INVISIBLE);
        routeString="third";
    }
    public void routeFourClicked (View view){
        routeOne.setVisibility(View.INVISIBLE);
        routeTwo.setVisibility(View.INVISIBLE);
        routeThree.setVisibility(View.INVISIBLE);
        routeFive.setVisibility(View.INVISIBLE);
        routeSix.setVisibility(View.INVISIBLE);
        routeString="fourth";
    }
    public void routeFiveClicked (View view){
        routeOne.setVisibility(View.INVISIBLE);
        routeTwo.setVisibility(View.INVISIBLE);
        routeThree.setVisibility(View.INVISIBLE);
        routeFour.setVisibility(View.INVISIBLE);
        routeSix.setVisibility(View.INVISIBLE);
        routeString="fifth";
    }
    public void routeSixClicked (View view){
        routeOne.setVisibility(View.INVISIBLE);
        routeTwo.setVisibility(View.INVISIBLE);
        routeThree.setVisibility(View.INVISIBLE);
        routeFour.setVisibility(View.INVISIBLE);
        routeFive.setVisibility(View.INVISIBLE);
        routeString="sixth";
    }

    public void firstBusAddClicked (View view){
        String busOneNumber;
        if(timeString!="Select timing first" && routeString!="Select route first"){
            Toast.makeText(AdminPage.this,"Time: " + timeString + "& Route: " + routeString,Toast.LENGTH_SHORT).show();
            if(!busOneET.getText().toString().equals("")) {
                busOneNumber = busOneET.getText().toString();
                if(timeString.equals("first")){
                    if(routeString.equals("first")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route One");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }
                    else if(routeString.equals("second")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Two");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }
                    else if(routeString.equals("third")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Three");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }
                    else if(routeString.equals("fourth")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Four");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }
                    else if(routeString.equals("fifth")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Five");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }
                    else{
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Six");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }
                }
                else if(timeString.equals("second")){
                    if(routeString.equals("first")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route One");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }
                    else if(routeString.equals("second")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Two");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }
                    else if(routeString.equals("third")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Three");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }
                    else if(routeString.equals("fourth")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Four");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }
                    else if(routeString.equals("fifth")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Five");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }
                    else{
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Six");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }
                }
                else{
                    if(routeString.equals("first")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route One");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }
                    else if(routeString.equals("second")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Two");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }
                    else if(routeString.equals("third")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Three");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }
                    else if(routeString.equals("fourth")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Four");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }
                    else if(routeString.equals("fifth")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Five");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }
                    else{
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Six");
                        Firebase childRef= myFirebase.child("Bus One");
                        childRef.setValue(busOneNumber);
                    }

                }
            }
            else{

                Toast.makeText(AdminPage.this,"Enter bus number",Toast.LENGTH_SHORT).show();
            }
            /*if(timeString.equals("first")){
                if(routeString.equals("first")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route One");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("second")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Two");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("third")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Three");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("fourth")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Four");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("fifth")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Five");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else{
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Six");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
            }
            else if(timeString.equals("second")){
                if(routeString.equals("first")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route One");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("second")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Two");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("third")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Three");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("fourth")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Four");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("fifth")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Five");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else{
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Six");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
            }
            else{
                if(routeString.equals("first")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route One");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("second")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Two");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("third")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Three");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("fourth")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Four");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("fifth")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Five");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else{
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Six");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }

            }*/
        }
        else{
            Toast.makeText(AdminPage.this,timeString + " &\n" + routeString ,Toast.LENGTH_SHORT).show();
            resetClicked(view);
        }

    }
    public void secondBusAddClicked(View view){
        if(timeString!="Select timing first" && routeString!="Select route first"){
            Toast.makeText(AdminPage.this,"Time: " + timeString + "& Route: " + routeString,Toast.LENGTH_SHORT).show();
            if(!busOneET.getText().toString().equals("")) {
                String busTwoNumber = busTwoET.getText().toString();
                if(timeString.equals("first")){
                    if(routeString.equals("first")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route One");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);

                    }
                    else if(routeString.equals("second")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Two");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);

                    }
                    else if(routeString.equals("third")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Three");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);

                    }
                    else if(routeString.equals("fourth")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Four");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);

                    }
                    else if(routeString.equals("fifth")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Five");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);

                    }
                    else{
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Six");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);

                    }
                }
                else if(timeString.equals("second")){
                    if(routeString.equals("first")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route One");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);

                    }
                    else if(routeString.equals("second")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Two");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);

                    }
                    else if(routeString.equals("third")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Three");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);

                    }
                    else if(routeString.equals("fourth")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Four");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);

                    }
                    else if(routeString.equals("fifth")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Five");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);

                    }
                    else{
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Six");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);

                    }
                }
                else{
                    if(routeString.equals("first")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route One");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);

                    }
                    else if(routeString.equals("second")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Two");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);

                    }
                    else if(routeString.equals("third")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Three");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);

                    }
                    else if(routeString.equals("fourth")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Four");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);

                    }
                    else if(routeString.equals("fifth")){
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Five");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);
                    }
                    else{
                        myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Six");
                        Firebase childRef= myFirebase.child("Bus Two");
                        childRef.setValue(busTwoNumber);
                    }

                }
            }
            else{
                Toast.makeText(AdminPage.this,"Enter bus number",Toast.LENGTH_SHORT).show();
            }
           /*
            if(timeString.equals("first")){
                if(routeString.equals("first")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route One");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("second")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Two");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("third")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Three");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("fourth")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Four");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("fifth")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Five");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else{
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Six");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
            }
            else if(timeString.equals("second")){
                if(routeString.equals("first")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route One");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("second")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Two");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("third")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Three");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("fourth")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Four");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("fifth")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Five");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else{
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Six");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
            }
            else{
                if(routeString.equals("first")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route One");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("second")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Two");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("third")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Three");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("fourth")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Four");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else if(routeString.equals("fifth")){
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Five");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }
                else{
                    myFirebase= new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Six");
                    myFirebase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String showBusNumber=dataSnapshot.getValue(String.class);
                            showBuses.append(showBusNumber);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showBuses.append("Error");
                        }
                    });
                }

            }*/
        }
        else{
            Toast.makeText(AdminPage.this,timeString + " &\n" + routeString ,Toast.LENGTH_SHORT).show();
            resetClicked(view);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        reset = (Button)findViewById(R.id.reset);
        firstTime = (Button)findViewById(R.id.firstTime);
        secondTime = (Button)findViewById(R.id.secondTime);
        thirdTime = (Button)findViewById(R.id.thirdTime);
        routeOne = (Button)findViewById(R.id.routeOne);
        routeTwo = (Button)findViewById(R.id.routeTwo);
        routeThree = (Button)findViewById(R.id.routeThree);
        routeFour = (Button)findViewById(R.id.routeFour);
        routeFive = (Button)findViewById(R.id.routeFive);
        routeSix = (Button)findViewById(R.id.routeSix);
        //showBuses = (TextView)findViewById(R.id.showBuses);
        busOneET= (EditText)findViewById(R.id.busOneET);
        busTwoET= (EditText)findViewById(R.id.busTwoET);
        busOneAdd =(Button)findViewById(R.id.busOneAdd);
        busTwoAdd= (Button)findViewById(R.id.busTwoAdd);

        Firebase.setAndroidContext(this);



    }
}
