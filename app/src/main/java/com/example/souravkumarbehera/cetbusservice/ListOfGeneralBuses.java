package com.example.souravkumarbehera.cetbusservice;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListOfGeneralBuses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_general_buses);

        ListView GeneralBusesListView= (ListView)findViewById(R.id.GeneralBusesListView);


        final ArrayList<String> gBuses= new ArrayList<String>();

        gBuses.add("Route 1");
        gBuses.add("Route 2");
        gBuses.add("Route 3");
        gBuses.add("Route 4");
        gBuses.add("Route 5");
        gBuses.add("Route 6");

        ArrayAdapter<String> myArrayAdapter= new ArrayAdapter<String>(ListOfGeneralBuses.this, android.R.layout.simple_list_item_1, gBuses);

        GeneralBusesListView.setAdapter(myArrayAdapter);

        GeneralBusesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(gBuses.get(i)=="Route 1"){
                    Intent r1= new Intent(ListOfGeneralBuses.this, GeneralRoute1.class);
                    startActivity(r1);
                }
                else if(gBuses.get(i)=="Route 2"){
                    Intent r2= new Intent(ListOfGeneralBuses.this, GeneralRoute2.class);
                    startActivity(r2);
                }
                else if(gBuses.get(i)=="Route 3"){
                    Intent r3= new Intent(ListOfGeneralBuses.this, GeneralRoute3.class);
                    startActivity(r3);
                }
                else if(gBuses.get(i)=="Route 4"){
                    Intent r4= new Intent(ListOfGeneralBuses.this, GeneralRoute4.class);
                    startActivity(r4);
                }
                else if(gBuses.get(i)=="Route 5"){
                    Intent r5= new Intent(ListOfGeneralBuses.this, GeneralRoute5.class);
                    startActivity(r5);
                }
                else {
                    Intent r6= new Intent(ListOfGeneralBuses.this, GeneralRoute6.class);
                    startActivity(r6);
                }
            }
        });
    }
}
