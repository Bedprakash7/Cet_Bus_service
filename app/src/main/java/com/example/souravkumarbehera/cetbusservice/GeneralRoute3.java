package com.example.souravkumarbehera.cetbusservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GeneralRoute3 extends AppCompatActivity {
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    TextView detailHeader;
    String nowTime,firstTime="9:30",secondTime="14:10", thirdTime="16:45";
    Date now,firsttime,secondtime,thirdtime;
    int count=0;
    ImageView cat1;
    ImageView cat2;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_route3);
        cat1=(ImageView)findViewById(R.id.route3);
        cat2=(ImageView)findViewById(R.id.map3);
        detailHeader=(TextView)findViewById(R.id.detailHeader);
        calendar= Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("HH:MM");
        //nowTime = simpleDateFormat.format(calendar.getTime());
        int hour= calendar.get(Calendar.HOUR);
        int min= calendar.get(Calendar.MINUTE);
        now = parseDate(hour + ":" + min);
        firsttime=parseDate(firstTime);
        secondtime=parseDate(secondTime);
        thirdtime=parseDate(thirdTime);

        if(firsttime.before(now) && thirdtime.after(now)){
            detailHeader.setText("9:30 Leaving Barmunda to Cuttack");
        }
        else if(secondtime.before(now) && firsttime.after(now)){
            detailHeader.setText("14:10 Leaving Barmunda to Cuttack");
        }
        else{
            detailHeader.setText("16:45 Leaving Barmunda to Cuttack");
        }
    }
}
