package com.example.souravkumarbehera.cetbusservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AdminDatabase extends AppCompatActivity {
    TextView Time,route1Bus1, route1Bus2, route2Bus1, route2Bus2, route3Bus1, route3Bus2, route4Bus1, route4Bus2, route5Bus1, route5Bus2, route6Bus1, route6Bus2;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String nowTime,firstTime="9:30",secondTime="14:10", thirdTime="16:45";
    Date now,firsttime,secondtime,thirdtime;
    Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_database);
        route1Bus1=(TextView)findViewById(R.id.route1Bus1);
        route1Bus2=(TextView)findViewById(R.id.route1Bus2);
        route2Bus1=(TextView)findViewById(R.id.route2Bus1);
        route2Bus2=(TextView)findViewById(R.id.route2Bus2);
        route3Bus1=(TextView)findViewById(R.id.route3Bus1);
        route3Bus2=(TextView)findViewById(R.id.route3Bus2);
        route4Bus1=(TextView)findViewById(R.id.route4Bus1);
        route4Bus2=(TextView)findViewById(R.id.route4Bus2);
        route5Bus1=(TextView)findViewById(R.id.route5Bus1);
        route5Bus2=(TextView)findViewById(R.id.route5Bus2);
        route6Bus1=(TextView)findViewById(R.id.route6Bus1);
        route6Bus2=(TextView)findViewById(R.id.route6Bus2);
        Time = (TextView)findViewById(R.id.Time);

        calendar= Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("HH:mm");
        int hour= calendar.get(Calendar.HOUR_OF_DAY);
        int min= calendar.get(Calendar.MINUTE);
        String hourString=Integer.toString(hour);
        String minString=Integer.toString(min);
        now = parseDate(hour + ":" + min);
        firsttime=parseDate(firstTime);
        secondtime=parseDate(secondTime);
        thirdtime=parseDate(thirdTime);
        if(now.compareTo(firsttime)<=0 || now.compareTo(thirdtime)>0){
            Time.setText("09 : 30");
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route One/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route1Bus1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route One/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route1Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mRef = new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Two/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route2Bus1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Two/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route2Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mRef = new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Three/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route3Bus1.setText("Bus No: " + myChildText);
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
                    route3Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mRef = new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Four/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route4Bus1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Four/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route4Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mRef = new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Five/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route5Bus1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Five/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route5Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mRef = new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Six/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route6Bus1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Six/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route6Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if(now.compareTo(secondtime)<=0 && now.compareTo(firsttime)>0){

            Time.setText("14 : 10");
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route One/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route1Bus1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route One/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route1Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Two/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route2Bus1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Two/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route2Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Three/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route3Bus1.setText("Bus No: " + myChildText);
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
                    route3Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Four/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route4Bus1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Four/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route4Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Five/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route5Bus1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Five/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route5Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Six/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route6Bus1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Six/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route6Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else if (now.compareTo(thirdtime)<=0 && now.compareTo(secondtime)>0){

            Time.setText("16 : 45");
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route One/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route1Bus1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route One/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route1Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Two/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route2Bus1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Two/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route2Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Three/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route3Bus1.setText("Bus No: " + myChildText);
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
                    route3Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Four/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route4Bus1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Four/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route4Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Five/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route5Bus1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Five/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route5Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Six/Bus One");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route6Bus1.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Six/Bus Two");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String myChildText= dataSnapshot.getValue(String.class);
                    route6Bus2.setText("Bus No: " + myChildText);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
    }
    private Date parseDate(String date) {

        try {
            return simpleDateFormat.parse(date);
        } catch (java.text.ParseException e) {
            return new Date(0);
            //Toast.makeText(GeneralRoute1.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}
