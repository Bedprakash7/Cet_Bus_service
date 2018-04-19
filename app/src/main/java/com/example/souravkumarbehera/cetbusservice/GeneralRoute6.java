package com.example.souravkumarbehera.cetbusservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import java.util.Locale;

public class GeneralRoute6 extends AppCompatActivity {

    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    TextView detailHeader,BusNo1,BusNo2;
    String nowTime,firstTime="9:30",secondTime="14:10", thirdTime="16:45";
    Date now,firsttime,secondtime,thirdtime;
    int count=0,r=0;
    ImageView cat1;
    ImageView cat2;
    Button get;
    RelativeLayout innerRelative;
    Firebase mRef;
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
            detailHeader.setText("9:30 Leaving Kalinga Studio to Barmunda");
            r=1;
        }
        else if(now.before(secondtime) && now.after(firsttime)){
            detailHeader.setText("14:10 Leaving Kalinga Studio to Barmunda");
            r=2;
        }
        else if (now.before(thirdtime) && now.after(secondtime)){
            detailHeader.setText("16:45 Leaving Kalinga Studio to Barmunda");
            r=3;
        }
        if(r==1){
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Six/Bus One");
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
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/First Timing/Route Six/Bus Two");
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
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Six/Bus One");
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
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Second Timing/Route Six/Bus Two");
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
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Six/Bus One");
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
            mRef = new Firebase("https://cet-bus-services.firebaseio.com/Third Timing/Route Six/Bus Two");
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
        setContentView(R.layout.activity_general_route6);
        cat1=(ImageView)findViewById(R.id.route6);
        cat2=(ImageView)findViewById(R.id.map6);
        detailHeader=(TextView)findViewById(R.id.detailHeader);
        get= (Button)findViewById(R.id.get);
        innerRelative=(RelativeLayout)findViewById(R.id.innerRelative);
        BusNo1=(TextView)findViewById(R.id.BusNo1);
        BusNo2=(TextView)findViewById(R.id.BusNo2);

        mRef.setAndroidContext(getApplicationContext());
        /*calendar= Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("HH:MM", Locale.getDefault());
        nowTime = simpleDateFormat.format(calendar.getTime());
        int hour= calendar.get(Calendar.HOUR);
        int min= calendar.get(Calendar.MINUTE);
        now = parseDate(hour + ":" + min);
        firsttime=parseDate(firstTime);
        secondtime=parseDate(secondTime);
        thirdtime=parseDate(thirdTime);

        Toast.makeText(this, nowTime , Toast.LENGTH_SHORT).show();
        if(now.before(firsttime) && now.after(thirdtime)){
            detailHeader.setText("9:30 Leaving Kalinga Studio to Barmunda");
        }
        else if(now.before(secondtime) && now.after(firsttime)){
            detailHeader.setText("14:10 Leaving Kalinga Studio to Barmunda");
        }
        else if (now.before(thirdtime) && now.after(secondtime)){
            detailHeader.setText("16:45 Leaving Kalinga Studio to Barmunda");
        }
        */
    }
}
