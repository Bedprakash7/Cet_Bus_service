package com.example.souravkumarbehera.cetbusservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void studentClicked(View v) {
        Intent Student1 = new Intent(MainActivity.this, ListOfGeneralBuses.class);
        startActivity(Student1);

    }
    public void adminClicked(View v)
    {
        Intent admin1 = new Intent(MainActivity.this, AdminLogin.class);
        startActivity(admin1);
    }
}
