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
import android.widget.Toast;

public class NewPassword extends AppCompatActivity {
            Button Loghere;
            TextView AlertMsg;
            EditText NewPass,ConformPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(Color.parseColor("#FEB941"));
        NewPass=findViewById(R.id.password_paste);
        ConformPass=findViewById(R.id.confirm_password);
        AlertMsg= findViewById(R.id.pass_msg);



        Loghere=findViewById(R.id.btnLoginNow);
        Loghere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", "Password: "+NewPass.getText().toString() );
                Log.e("TAG", "Confirm Password : "+ConformPass.getText().toString() );

               if(passwardVarification()){
                   Intent intent =new Intent(NewPassword.this,login.class);
                   startActivity(intent);
               }
            }
        });

    }
    public boolean passwardVarification(){
        if(NewPass.getText().toString().isEmpty() && ConformPass.getText().toString().isEmpty()){
            AlertMsg.setText("Fill the field");
            return  false;
        }


        if (NewPass.getText().toString().isEmpty()){
            AlertMsg.setText("Enter the New Password");
            return false;
        }
        if (ConformPass.getText().toString().isEmpty()){
            AlertMsg.setText("Please Enter the Re-Password");
            return  false;
        }

        if(!NewPass.getText().toString().equals(ConformPass.getText().toString())){
            AlertMsg.setText("The Password Does not match");
            return false;
        }
        return true;
    }
}