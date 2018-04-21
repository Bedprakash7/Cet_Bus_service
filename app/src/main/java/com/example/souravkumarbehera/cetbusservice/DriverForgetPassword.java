package com.example.souravkumarbehera.cetbusservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DriverForgetPassword extends AppCompatActivity {

    EditText firstAns, secondAns,userNameET;
    Button getPassword;
    TextView UAndP;
    public void getClicked(View view){
        String ansOne,ansTwo,un;
        ansOne=firstAns.getText().toString();
        ansTwo=secondAns.getText().toString();
        un=userNameET.getText().toString();
        if(ansOne.equals("Sonu") && ansTwo.equals("Rony")){
            if(un.equals("Bus1@cetb")) {
                UAndP.setText("cetb@1");
            }
            else if(un.equals("Bus2@cetb")) {
                UAndP.setText("cetb@2");
            }
            else if(un.equals("Bus3@cetb")) {
                UAndP.setText("cetb@3");
            }
            else if(un.equals("Bus4@cetb")) {
                UAndP.setText("cetb@4");
            }
            else if(un.equals("Bus5@cetb")) {
                UAndP.setText("cetb@5");
            }
            else if(un.equals("Bus6@cetb")) {
                UAndP.setText("cetb@6");
            }
            else if(un.equals("Bus7@cetb")) {
                UAndP.setText("cetb@7");
            }
            else if(un.equals("Bus8@cetb")) {
                UAndP.setText("cetb@8");
            }
            else if(un.equals("Bus9@cetb")) {
                UAndP.setText("cetb@9");
            }
            else if(un.equals("Bus10@cetb")) {
                UAndP.setText("cetb@10");
            }
            else if(un.equals("Bus11@cetb")) {
                UAndP.setText("cetb@11");
            }
            else if(un.equals("Bus12@cetb")) {
                UAndP.setText("cetb@12");
            }
            else if(un.equals("Bus13@cetb")) {
                UAndP.setText("cetb@13");
            }
            else if(un.equals("Bus14@cetb")) {
                UAndP.setText("cetb@14");
            }
            else if(un.equals("Bus15@cetb")) {
                UAndP.setText("cetb@15");
            }
            else
                Toast.makeText(this,"Wrong username", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(DriverForgetPassword.this,"Wrong Answer",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_forget_password);
        firstAns=(EditText)findViewById(R.id.firstAns);
        secondAns=(EditText)findViewById(R.id.secondAns);
        getPassword=(Button)findViewById(R.id.getPassword);
        UAndP=(TextView)findViewById(R.id.UAndP);
        userNameET=(EditText)findViewById(R.id.userNameET);
    }
}
