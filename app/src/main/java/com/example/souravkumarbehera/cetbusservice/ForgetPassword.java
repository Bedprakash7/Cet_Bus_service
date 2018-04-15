package com.example.souravkumarbehera.cetbusservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgetPassword extends AppCompatActivity {

    EditText firstAns, secondAns;
    Button getPassword;
    TextView UAndP;
    public void getClicked(View view){
        String ansOne,ansTwo;
        ansOne=firstAns.getText().toString();
        ansTwo=secondAns.getText().toString();
        if(ansOne.equals("Sonu") && ansTwo.equals("Rony")){
            UAndP.setText("skbisoi@cetb\ncetb1234");
        }
        else{
            Toast.makeText(ForgetPassword.this,"Wrong Answer",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        firstAns=(EditText)findViewById(R.id.firstAns);
        secondAns=(EditText)findViewById(R.id.secondAns);
        getPassword=(Button)findViewById(R.id.getPassword);
        UAndP=(TextView)findViewById(R.id.UAndP);
    }
}
