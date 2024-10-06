package com.example.ecomm;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import com.skydoves.elasticviews.ElasticButton;
import com.skydoves.elasticviews.ElasticImageView;

import java.net.URLEncoder;

public class BuyNow extends AppCompatActivity {
   ElasticButton btn_back;
   TextView saved_msg_02;
   ElasticImageView img_change_Delivey_Adress_info,img_change_personal_info;
   ElasticImageView img_change_Contact_info;

   Dialog dialog;
   EditText edit_adress,text_city_input,text_state_input,text_pin_input;
   EditText txt_first_name,txt_Middle_Name,txt_last_Name;
   EditText txt_email,txt_mobile;
   ElasticButton btn_saved,btn_saved_01,btn_saved_02;
   TextView text_address_value,text_city_value,text_pinCode,text_state_value;
   TextView text_Mobile_value,text_Email_value;

   TextView text_Name_value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buynow);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(Color.parseColor("#FEB941"));
        getWindow().setNavigationBarColor(Color.parseColor("#ffffff"));


        //Initization
        btn_back=findViewById(R.id.btn_back);
        img_change_Delivey_Adress_info=findViewById(R.id.img_change_Delivey_Adress_info);
        img_change_personal_info=findViewById(R.id.img_change_personal_info);
        img_change_Contact_info=findViewById(R.id.img_change_Contact_info);


        /**********************************************************************/
        text_address_value=findViewById(R.id.text_address_value);
        text_city_value=findViewById(R.id.text_city_value);
        text_pinCode=findViewById(R.id.text_pinCode);
        text_state_value=findViewById(R.id.text_state_value);

        /*********************************************************************************/
        text_Name_value=findViewById(R.id.text_Name_value);
        /*********************************************************************************/
        text_Mobile_value=findViewById(R.id.text_Mobile_value);
        text_Email_value=findViewById(R.id.text_Email_value);

        saved_msg_02=findViewById(R.id.saved_msg_02);


            //***********************      DIALOG   *****************************************
        img_change_Delivey_Adress_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog = new Dialog(BuyNow.this);
                dialog.setContentView(R.layout.dialog_edit_address);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
                dialog.getWindow().getAttributes().windowAnimations = R.style.Theme_Ecomm;
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);


                edit_adress=dialog.findViewById(R.id.edit_adress);
                text_city_input=dialog.findViewById(R.id.text_city_input);
                text_state_input=dialog.findViewById(R.id.text_state_input);
                text_pin_input=dialog.findViewById(R.id.text_pin_input);

                btn_saved = dialog.findViewById(R.id.btn_saved);

                btn_saved.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(BuyNow.this, "Btn _ hit now", Toast.LENGTH_SHORT).show();
                        text_address_value.setText(edit_adress.getText().toString());
                        text_city_value.setText(text_city_input.getText().toString());
                        text_pinCode.setText(text_pin_input.getText());
                        text_state_value.setText(text_state_input.getText().toString());
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });


        /********************************img_change_personal_info*********************************/

        img_change_personal_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog1= new Dialog(BuyNow.this);
                dialog.setContentView(R.layout.dialog_change_file);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
                dialog.getWindow().getAttributes().windowAnimations = R.style.Theme_Ecomm;
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);


                txt_first_name=dialog1.findViewById(R.id.txt_first_name);
                txt_Middle_Name=dialog1.findViewById(R.id.txt_Middle_Name);
                txt_last_Name=dialog1.findViewById(R.id.txt_last_Name);

                btn_saved_01=dialog.findViewById(R.id.btn_saved_01);

                btn_saved_01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        text_Name_value.setText(txt_first_name.getText().toString()+" "+txt_Middle_Name.getText().toString()+" "+txt_last_Name.getText().toString());
                        dialog1.dismiss();
                    }

                });
                dialog1.show();
            }
        });
        /**********************************************************************/

        img_change_Contact_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog1=new Dialog(BuyNow.this);
                dialog1.setContentView(R.layout.dialog_contact_information);
                dialog1.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
                dialog1.getWindow().getAttributes().windowAnimations = R.style.Theme_Ecomm;
                dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                txt_email=dialog1.findViewById(R.id.txt_email);
                txt_mobile=dialog1.findViewById(R.id.txt_mobile);

                btn_saved_02=dialog1.findViewById(R.id.btn_saved_02);

                btn_saved_02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        text_Mobile_value.setText(txt_mobile.getText().toString());
                        text_Email_value.setText(txt_email.getText().toString());
                        dialog1.dismiss();
                    }
                });
                dialog1.show();

            }
        });

        //***************************************************************


        //Back Button
        //********************************************************************************************
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                Log.e("TAG", "onClick: Comeback to pervious Activity" );
            }
        });
        //***********************************************************************************************



        //************************************************** go to make payments activity  ********************************************

        findViewById(R.id.proceed_to_payment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), Amount_payment.class);
                startActivity(intent);
                Log.e("TAG", "onClick: Proceed to payment option " );
            }
        });

        saved_msg_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    PackageManager packageManager = getApplicationContext().getPackageManager();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    String url = "https://api.whatsapp.com/send?phone="+ "+918987918309" +"&text=" + URLEncoder.encode("HEllo", "UTF-8");
                    i.setPackage("com.whatsapp");
                    i.setData(Uri.parse(url));
                    if (i.resolveActivity(packageManager) != null) {
                        startActivity(i);
                    }else {
                        Toast.makeText(getApplicationContext(), "No Whatsapp Number", Toast.LENGTH_SHORT).show();
                    }
                } catch(Exception e) {
                    Log.e("ERROR WHATSAPP",e.toString());
                    Toast.makeText(getApplicationContext(), "Noy Found Whatsapp app.", Toast.LENGTH_SHORT).show();

                }
            }


        });



    }
}