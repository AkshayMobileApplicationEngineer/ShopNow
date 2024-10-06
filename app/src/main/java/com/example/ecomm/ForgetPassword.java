package com.example.ecomm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.icu.number.IntegerWidth;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPassword extends AppCompatActivity {
  Button Createe;
  EditText OTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(Color.parseColor("#C80303"));

        getWindow().setNavigationBarColor(Color.parseColor("#ffe0e0"));
        OTP=findViewById(R.id.OTPpaste);

        Createe = findViewById(R.id.SetPassword);
        Createe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", "OTP: "+OTP.getText().toString() );
                if(OTP.getText().toString().isEmpty()){
                    return;
                }
                  else {
                      Intent intent = new Intent(ForgetPassword.this,NewPassword.class);
                      startActivity(intent);

                }
            }
        });

    }
}