package com.example.souravkumarbehera.cetbusservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentPage extends AppCompatActivity {

    public void generalClicked(View view){
        Intent i= new Intent(StudentPage.this, ListOfGeneralBuses.class);
        startActivity(i);

    }

    public void specialClicked(View view){


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_page);

    }
}
