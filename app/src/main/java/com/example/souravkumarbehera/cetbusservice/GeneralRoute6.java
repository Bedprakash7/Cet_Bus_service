package com.example.souravkumarbehera.cetbusservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GeneralRoute6 extends AppCompatActivity {

    int count=0;
    ImageView cat1;
    ImageView cat2;
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
        setContentView(R.layout.activity_general_route6);
        cat1=(ImageView)findViewById(R.id.route6);
        cat2=(ImageView)findViewById(R.id.map6);
    }
}
