package com.example.ecomm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class SignUP extends AppCompatActivity {

    EditText FullName,MobileNumber,EmailID,Username,Password;
    TextView PassMas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(Color.parseColor("#FEB941"));

        FullName= findViewById(R.id.name_input);
        PassMas=findViewById(R.id.pass_msg);
        MobileNumber=findViewById(R.id.mobile_input);
        EmailID=findViewById(R.id.email_input);
        Username=findViewById(R.id.username_input);
        Password=findViewById(R.id.password_input);

        findViewById(R.id.BtnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (signupform()){
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Intent intent  = new Intent(SignUP.this, login.class);
                            startActivity(intent);
                            finish();
                        }
                    },3000);
                }
            }
        });

        findViewById(R.id.BtnLoginhere).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUP.this,login.class);
                startActivity(intent);
            }
        });


    }
    public boolean signupform(){
        if(FullName.getText().toString().isEmpty() && MobileNumber.getText().toString().isEmpty()){
            PassMas.setText("All field are must be required");
            return false;
        }
        if(FullName.getText().toString().isEmpty()){
         PassMas.setText("FullName Must be Required");
         return false;

        }
        if(MobileNumber.getText().toString().isEmpty()){
            PassMas.setText("Mobile Number Must be Required");
            return false;
        }

        if(EmailID.getText().toString().isEmpty()){
            PassMas.setText("Email id Must be Required");
        }

        if(Username.getText().toString().isEmpty()){
            PassMas.setText("Username Must be Required");
            return false;

        }
        if(Password.getText().toString().isEmpty()){
            PassMas.setText("Password Must be Required");
            return false;
        }
        return true;
    }
}