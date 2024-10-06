package com.example.ecomm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {
    TextView Signup;
    TextView ForgetPassword, PassMSq;
    EditText Username, Password;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(Color.parseColor("#FEB941"));

        Signup = findViewById(R.id.signupaccount);
        Login = findViewById(R.id.BtnLogin);
        ForgetPassword = findViewById(R.id.forgetpassword);
        Username = findViewById(R.id.username_input);
        Password = findViewById(R.id.password_input);
        PassMSq = findViewById(R.id.pass_msg);

        ForgetPassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgetPassword.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             /* if(validation()){*/
                  Intent intent = new Intent(getApplicationContext(), DashbordActivity.class);
                  startActivity(intent);
              //}

                Log.e("TAG", "onClick: You are login Now Right Now" );
                Log.e("TAG", "Username: " + Username.getText().toString());
                Log.e("TAG", "Password: " + Password.getText().toString());
            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUP.class);
                startActivity(intent);
            }
        });



    }
    /*public boolean validation() {
        if(Username.getText().toString().trim().isEmpty() && Password.getText().toString().trim().isEmpty() ){
            PassMSq.setText("Username and Password must be required");
            return false;
        }
        if (Username.getText().toString().trim().isEmpty()) {
            PassMSq.setText("Username must be required");
            return false;
        }
        if (Password.getText().toString().trim().isEmpty()){
            PassMSq.setText("Password must be required");
            return false;
        }
        return true;
    }*/


}