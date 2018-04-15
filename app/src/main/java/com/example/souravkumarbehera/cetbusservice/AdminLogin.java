package com.example.souravkumarbehera.cetbusservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

   

public class AdminLogin extends AppCompatActivity {
    Button login;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        login=(Button)findViewById(R.id.login);
        username =(EditText)findViewById(R.id.userName);
        password =(EditText)findViewById(R.id.password);


    }

    public void forgetPasswordClicked(View view){
        Intent i=new Intent(AdminLogin.this, ForgetPassword.class);
        startActivity(i);
    }
    public void loginClicked(View view) {
        String un, pw;
        un = username.getText().toString();
        pw = password.getText().toString();
        int count = 0;
        if (un.equals("skbisoi@cetb") && pw.equals("cetb1234")) {
            Intent next = new Intent(AdminLogin.this, AdminPage.class);
            startActivity(next);
            password.setText("");
        }
        else{
            count++;
            Toast.makeText(getApplicationContext(),"wrong username or password", Toast.LENGTH_SHORT).show();
            if(count>=5){
                Intent back =new Intent(AdminLogin.this, MainActivity.class);
                startActivity(back);
            }
        }
    }
}
