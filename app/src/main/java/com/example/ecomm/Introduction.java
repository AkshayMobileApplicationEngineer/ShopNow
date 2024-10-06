package com.example.ecomm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ecomm.Adapter.ImagePagerAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class  Introduction extends AppCompatActivity {
    Button getStart;
    ViewPager viewPager;
    LinearLayout dotsLayout;
    ImagePagerAdapter myPagerAdapter;
    private int currentPage=0;
    private  int [] images={R.drawable.idf,R.drawable.remove, R.drawable.shop};
    private  String [] Messages={"Sell your farm fresh products directly to consumers, cutting out the middleman and reducing emissions of the global supply chain. ","Our team of delivery drivers will make sure your orders are picked up on time and promptly delivered to your customers.","We love the earth and know you do too! Join us in reducing our local carbon footprint one order at a time. "};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        getSupportActionBar().hide();

        getStart=findViewById(R.id.GetStarted);
        viewPager=findViewById(R.id.pagerViewer);
        dotsLayout=findViewById(R.id.dotsLayout);

        getStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),login.class);
                startActivity(intent);
            }
        });

       // viewPager = findViewById(R.id.viewPager);
       // dotsLayout = findViewById(R.id.dotsLayout);
       // btn_start = findViewById(R.id.btn_start);

        myPagerAdapter = new ImagePagerAdapter(this, images, Messages);
        viewPager.setAdapter(myPagerAdapter);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.parseColor("#FEB941"));
            getWindow().setNavigationBarColor(Color.parseColor("#FFFFFF"));
        }

        addDotsIndicator(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                addDotsIndicator(position);
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        addDotsIndicator(1);
        // Auto-scroll the ViewPager
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentPage == images.length) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
                handler.postDelayed(this, 2000); // Set the time interval for auto-scrolling
            }
        }, 2000); // Set the initial delay



    }

    private void addDotsIndicator(int position) {
        ImageView[] dots = new ImageView[images.length];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.ic_dot_inactive));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(8, 0, 8, 0);
            dotsLayout.addView(dots[i], params);
        }

        if (dots.length > 0) {
            dots[position].setImageDrawable(getResources().getDrawable(R.drawable.ic_dot_active));
        }
    }

    String agree = "";




}