package com.example.ecomm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.logging.LogRecord;

public class DashbordActivity extends AppCompatActivity {
    LinearLayout card_icon;
    LinearLayout Account_icon;
    LinearLayout categories_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(Color.parseColor("#C80303"));

        //Navigation BAr
        getWindow().setNavigationBarColor(Color.parseColor("#C80303"));


        card_icon=findViewById(R.id.card_icon);
        Account_icon=findViewById(R.id.Account_icon);
        categories_icon=findViewById(R.id.categories_icon);

        LoadFragment(new HomeFragment());

        findViewById(R.id.Home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadFragment(new HomeFragment());
                Log.e("TAG", "onClick: Home" );

            }
        });

        card_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadFragment(new CardFragment());
                Log.e("TAG", "onClick: Cart Fragement" );
            }
        });
        Account_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadFragment(new ProfileFragment());
                Log.e("TAG", "onClick: Profile Fragement" );
            }
        });
        categories_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadFragment(new CategoryFragment());
                Log.d("TAG", "onClick: CategoryFragment");
                System.out.println("CategoryFragment");
            }
        });





    }

        //loadfragement method
        public void LoadFragment(Fragment fragment)
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame,fragment);
            fragmentTransaction.commit();
        }
}