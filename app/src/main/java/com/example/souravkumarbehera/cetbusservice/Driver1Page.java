package com.example.souravkumarbehera.cetbusservice;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Driver1Page extends AppCompatActivity {

    public void goOnlineClicked(View view){
        ProgressDialog pd= new ProgressDialog(Driver1Page.this);

        pd.setMessage("Map Loading...");
        pd.show();
        pd.setCancelable(true);
        Toast.makeText(this, "Map Loading...", Toast.LENGTH_SHORT).show();
        Intent goMap= new Intent(Driver1Page.this, Driver1Map.class);

        pd.cancel();
        startActivity(goMap);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver1_page);
    }
}
