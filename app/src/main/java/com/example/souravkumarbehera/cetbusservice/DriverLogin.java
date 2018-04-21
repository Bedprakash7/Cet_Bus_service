package com.example.souravkumarbehera.cetbusservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DriverLogin extends AppCompatActivity {

    Button login;
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);
        login=(Button)findViewById(R.id.login);
        username =(EditText)findViewById(R.id.userName);
        password =(EditText)findViewById(R.id.password);
    }
    public void forgetPasswordClicked(View view){
        Intent i=new Intent(DriverLogin.this, DriverForgetPassword.class);
        startActivity(i);
    }
    public void loginClicked(View view) {
        String un, pw;
        un = username.getText().toString();
        pw = password.getText().toString();
        int count = 0;
        if (un.equals("Bus1@cetb") && pw.equals("cetb@1")) {
            Toast.makeText(DriverLogin.this, "Bus 1 Driver", Toast.LENGTH_SHORT).show();
            Intent next = new Intent(DriverLogin.this, Driver1Page.class);
            startActivity(next);
            password.setText("");
        }
        else if (un.equals("Bus2@cetb") && pw.equals("cetb@2")) {
            Toast.makeText(DriverLogin.this, "Bus 2 Driver", Toast.LENGTH_SHORT).show();
            Intent next = new Intent(DriverLogin.this, Driver2Page.class);
            startActivity(next);
            password.setText("");
        }
        else if (un.equals("Bus3@cetb") && pw.equals("cetb@3")) {
            Toast.makeText(DriverLogin.this, "Bus 3 Driver", Toast.LENGTH_SHORT).show();
            Intent next = new Intent(DriverLogin.this, Driver3Page.class);
            startActivity(next);
            password.setText("");
        }
        else if (un.equals("Bus4@cetb") && pw.equals("cetb@4")) {
            Toast.makeText(DriverLogin.this, "Bus 4 Driver", Toast.LENGTH_SHORT).show();
            Intent next = new Intent(DriverLogin.this, Driver4Page.class);
            startActivity(next);
            password.setText("");
        }
        else if (un.equals("Bus5@cetb") && pw.equals("cetb@5")) {
            Toast.makeText(DriverLogin.this, "Bus 5 Driver", Toast.LENGTH_SHORT).show();
            Intent next = new Intent(DriverLogin.this, Driver5Page.class);
            startActivity(next);
            password.setText("");
        }
        else if (un.equals("Bus6@cetb") && pw.equals("cetb@6")) {
            Toast.makeText(DriverLogin.this, "Bus 6 Driver", Toast.LENGTH_SHORT).show();
            Intent next = new Intent(DriverLogin.this, Driver6Page.class);
            startActivity(next);
            password.setText("");
        }
        else if (un.equals("Bus7@cetb") && pw.equals("cetb@7")) {
            Toast.makeText(DriverLogin.this, "Bus 7 Driver", Toast.LENGTH_SHORT).show();
            Intent next = new Intent(DriverLogin.this, Driver7Page.class);
            startActivity(next);
            password.setText("");
        }
        else if (un.equals("Bus8@cetb") && pw.equals("cetb@8")) {
            Toast.makeText(DriverLogin.this, "Bus 8 Driver", Toast.LENGTH_SHORT).show();
            Intent next = new Intent(DriverLogin.this, Driver8Page.class);
            startActivity(next);
            password.setText("");
        }
        else if (un.equals("Bus9@cetb") && pw.equals("cetb@9")) {
            Toast.makeText(DriverLogin.this, "Bus 9 Driver", Toast.LENGTH_SHORT).show();
            Intent next = new Intent(DriverLogin.this, Driver9Page.class);
            startActivity(next);
            password.setText("");
        }
        else if (un.equals("Bus10@cetb") && pw.equals("cetb@10")) {
            Toast.makeText(DriverLogin.this, "Bus 10 Driver", Toast.LENGTH_SHORT).show();
            Intent next = new Intent(DriverLogin.this, Driver10Page.class);
            startActivity(next);
            password.setText("");
        }
        else if (un.equals("Bus11@cetb") && pw.equals("cetb@11")) {
            Toast.makeText(DriverLogin.this, "Bus 11 Driver", Toast.LENGTH_SHORT).show();
            Intent next = new Intent(DriverLogin.this, Driver11Page.class);
            startActivity(next);
            password.setText("");
        }
        else if (un.equals("Bus12@cetb") && pw.equals("cetb@12")) {
            Toast.makeText(DriverLogin.this, "Bus 12 Driver", Toast.LENGTH_SHORT).show();
            Intent next = new Intent(DriverLogin.this, Driver12Page.class);
            startActivity(next);
            password.setText("");
        }
        else if (un.equals("Bus13@cetb") && pw.equals("cetb@13")) {
            Toast.makeText(DriverLogin.this, "Bus 13 Driver", Toast.LENGTH_SHORT).show();
            Intent next = new Intent(DriverLogin.this, Driver13Page.class);
            startActivity(next);
            password.setText("");
        }
        else if (un.equals("Bus14@cetb") && pw.equals("cetb@14")) {
            Toast.makeText(DriverLogin.this, "Bus 14 Driver", Toast.LENGTH_SHORT).show();
            Intent next = new Intent(DriverLogin.this, Driver14Page.class);
            startActivity(next);
            password.setText("");
        }
        else if (un.equals("Bus15cetb") && pw.equals("cetb@15")) {
            Toast.makeText(DriverLogin.this, "Bus 15 Driver", Toast.LENGTH_SHORT).show();
            Intent next = new Intent(DriverLogin.this, Driver15Page.class);
            startActivity(next);
            password.setText("");
        }
        else{
            count++;
            Toast.makeText(getApplicationContext(),"wrong username or password", Toast.LENGTH_SHORT).show();
            if(count==5){
                Intent back =new Intent(DriverLogin.this, MainActivity.class);
                startActivity(back);
            }
        }
    }
}
