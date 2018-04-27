package com.example.souravkumarbehera.cetbusservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Driver15Page extends AppCompatActivity {

    public void goOnlineClicked(View view){
        Toast.makeText(this, "Map Loading...", Toast.LENGTH_SHORT).show();
        Intent goMap= new Intent(Driver15Page.this, Driver15Map.class);
        startActivity(goMap);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver15_page);
    }
}
