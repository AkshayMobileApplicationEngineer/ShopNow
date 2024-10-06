package com.example.ecomm;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.skydoves.elasticviews.ElasticButton;
import com.skydoves.elasticviews.ElasticImageView;

import java.net.URLEncoder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardFragment extends Fragment {
    TextView saved_msg_01;


    ElasticButton GoBack;
    TextView total_product_buy;
    TextView minus_decrements;
    TextView number_sysmbols;
    TextView plus_increments;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CardFragment newInstance(String param1, String param2) {
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cart, container, false);


        minus_decrements=view.findViewById(R.id.minus_decrements);
        number_sysmbols=view.findViewById(R.id.number_sysmbols);
        plus_increments=view.findViewById(R.id.plus_increments);





        minus_decrements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(number_sysmbols.getText().toString());
                if(count>1){
                    number_sysmbols.setText(""+((count)-1));

                }
            }
        });
        plus_increments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(number_sysmbols.getText().toString());
                if(count>1){
                    number_sysmbols.setText(""+((count)+1));
                }
            }
        });
        GoBack= view.findViewById(R.id.btn_back_01);
        GoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(),DashbordActivity.class);
                startActivity(intent);
                Log.d("TAG", "onClick: Come Back to DashBoard");
            }
        });

        saved_msg_01=view.findViewById(R.id.saved_msg_01);
        saved_msg_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    PackageManager packageManager = getActivity().getPackageManager();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    String url = "https://api.whatsapp.com/send?phone="+ "+918987918309" +"&text=" + URLEncoder.encode("Hello", "UTF-8");
                    i.setPackage("com.whatsapp");
                    i.setData(Uri.parse(url));
                    if (i.resolveActivity(packageManager) != null) {
                        startActivity(i);
                    }else {
                        Toast.makeText(getActivity(), "No Whatsapp Number", Toast.LENGTH_SHORT).show();
                    }
                } catch(Exception e) {
                    Log.e("ERROR WHATSAPP",e.toString());
                    Toast.makeText(getActivity(), "Not Found Whatsapp app.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        total_product_buy=view.findViewById(R.id.total_product_buy);
        getbtnclick();
        return  view;
    }


    public void getbtnclick(){
        total_product_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(),BuyNow.class);
                startActivity(intent);
                Log.e("TAG", "onClick: Proced option are clicked now" );
            }
        });
    }


}