package com.example.souravkumarbehera.cetbusservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GeneralRoute1 extends AppCompatActivity {
    int count=0,r=0;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    ImageView cat1;
    ImageView cat2;
    TextView detailHeader,BusNo1,BusNo2;
    String nowTime,firstTime="9:30",secondTime="14:10", thirdTime="16:45";
    Date now,firsttime,secondtime,thirdtime;
    Button get;
    RelativeLayout innerRelative;
    Firebase mRef;

    //ListView BusNos;

    private Date parseDate(String date) {

        try {
            return simpleDateFormat.parse(date);
        } catch (java.text.ParseException e) {
            return new Date(0);
            //Toast.makeText(GeneralRoute1.this, "Error", Toast.LENGTH_SHORT).show();
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
                    .setDuration(5000);

            cat2.animate().alphaBy(1).setDuration(5000);
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
                    .setDuration(5000);
            cat2.animate().alpha(0).setDuration(5000);
        }
    }
    public void getClicked(View view){
        get.setVisibility(view.INVISIBLE);
        innerRelative.setAlpha(1f);
        calendar= Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("HH:mm");
        //nowTime = simpleDateFormat.getTimeInstance(DateFormat.AM_PM_FIELD).format(calendar.getTime());
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
        if(now.compareTo(firsttime)<=0 || now.compareTo(thirdtime)>0){
            detailHeader.setText("9:30 Leaving Barmunda to Rajmahal");
            r=1;
        }
        else if(now.compareTo(secondtime)<=0 && now.compareTo(firsttime)>0){
            detailHeader.setText("14:10 Leaving Barmunda to Rajmahal");
            r=2;
        }
        else if (now.compareTo(thirdtime)<=0 && now.compareTo(secondtime)>0){
            detailHeader.setText("16:45 Leaving Barmunda to Rajmahal");
            r=3;
        }
        //final ArrayList<String> listOfBuses= new ArrayList<String>();
        //ArrayAdapter<String> myArrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listOfBuses);
        //BusNos.setAdapter(myArrayAdapter);
        if(r==1){
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route One/Bus One");
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
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route One/Bus Two");
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
            /*mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String values=dataSnapshot.getValue(String.class);
                    listOfBuses.add(values);
                    BusNo1.setText(values);


                    Log.i("Sourav", values);
                    Toast.makeText(GeneralRoute1.this, values , Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            */
            //String show1=listOfBuses.get(0);
            //String show2=listOfBuses.get(1);
            //Log.i("bus1",listOfBuses.get(0));

            //Log.i("bus2", listOfBuses.get(1));
            //BusNo1.setText(show1);
            //BusNo2.setText(show2);
        }
        else if(r==2){
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route One/Bus One");
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
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route One/Bus Two");
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
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route One/Bus One");
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
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route One/Bus Two");
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_route1);



        cat1=(ImageView)findViewById(R.id.route1);
        cat2=(ImageView)findViewById(R.id.map1);
        detailHeader=(TextView)findViewById(R.id.detailHeader);
        get= (Button)findViewById(R.id.get);
        innerRelative=(RelativeLayout)findViewById(R.id.innerRelative);
        //BusNos=(ListView)findViewById(R.id.BusNos);
        BusNo1=(TextView)findViewById(R.id.BusNo1);
        BusNo2=(TextView)findViewById(R.id.BusNo2);

        mRef.setAndroidContext(getApplicationContext());

        /*calendar= Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("HH:MM");
        nowTime = simpleDateFormat.format(calendar.getTime());
        Toast.makeText(this, nowTime , Toast.LENGTH_SHORT).show();
        int hour= calendar.get(Calendar.HOUR);
        int min= calendar.get(Calendar.MINUTE);
        now = parseDate(hour + ":" + min);
        firsttime=parseDate(firstTime);
        secondtime=parseDate(secondTime);
        thirdtime=parseDate(thirdTime);
        */

        /*Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //TextView tdate = (TextView) findViewById(R.id.date);
                                long date = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("HH:MM");
                                String dateString = sdf.format(date);

                                //tdate.setText(dateString);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();
        */
        //Toast.makeText(GeneralRoute1.this, dateString , Toast.LENGTH_SHORT).show();
        //long date1= (Long)getTime(firsttime);

        /*if(now.before(firsttime) || now.after(thirdtime)){
            detailHeader.setText("9:30 Leaving Barmunda to Rajmaahal");
        }
        else if(now.before(secondtime) && now.after(firsttime)){
            detailHeader.setText("14:10 Leaving Barmunda to Rajmahal");
        }
        else if (now.before(thirdtime) && now.after(secondtime)){
            detailHeader.setText("16:45 Leaving Barmunda to Rajmahal");
        }
        */

    }
}
