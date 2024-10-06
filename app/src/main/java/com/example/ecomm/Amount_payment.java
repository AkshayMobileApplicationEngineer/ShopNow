package com.example.ecomm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.skydoves.elasticviews.ElasticButton;

import java.util.Timer;
import java.util.TimerTask;

public class Amount_payment extends AppCompatActivity {
    ElasticButton btn_payment_01;

    TextView paynow1;
    TextView paynow_2;
    TextView paynow_3;
    TextView digita_balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount_payment);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(Color.parseColor("#FEB941"));

        btn_payment_01=findViewById(R.id.btn_payment_01);
        digita_balance=findViewById(R.id.digita_balance);
        paynow1=findViewById(R.id.paynow1);
        paynow_2=findViewById(R.id.paynow_2);
        paynow_3=findViewById(R.id.paynow_3);

        //*************************************** Back Activity Page Buy Now *************************

        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                Log.e("TAG", "onClick:Back Activity Page Buy Now "  );
            }
        });
        digita_balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Amount_payment.this, "BTn clicked", Toast.LENGTH_SHORT).show();
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.phonepe.app");
                if (intent != null) {
                    // We found the activity now start the activity
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }

            }
        });
        paynow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.instagram.android");
                if (intent != null) {
                    // We found the activity now start the activity
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
        paynow_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                if (intent != null) {
                    // We found the activity now start the activity
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });

        paynow_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=getPackageManager().getLaunchIntentForPackage("com.snapchat.android");
              intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              startActivity(intent);
            }
        });

        //*************************** finish code ***************************************************
        btn_payment_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog= new Dialog(Amount_payment.this);
                dialog.setContentView(R.layout.dialog_paymet_sucessful);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
                dialog.getWindow().getAttributes().windowAnimations = R.style.Theme_Ecomm;
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                ElasticButton btn_ok= dialog.findViewById(R.id.btn_ok);

                btn_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(getApplicationContext(), DashbordActivity.class);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
                dialog.show();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(getApplicationContext(),DashbordActivity.class);
                        startActivity(intent);
                    }
                },5000);
            }
        });


    }
}