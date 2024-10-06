package com.example.ecomm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ecomm.Api.ApiClient;
import com.example.ecomm.Api.ServiceApi;
import com.example.ecomm.Model.Products_Model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    RecyclerView Recy_category;
    GridLayoutManager layoutManager;
    RecylerApadterProduct apadterProduct;
    ProgressBar progress;

    Button btn_products;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        Recy_category = view.findViewById(R.id.Recy_category);
        progress = view.findViewById(R.id.progress);
        GetProducts();
        return view;
    }

    public void GetProducts()
    {
        ServiceApi api = ApiClient.getClient().create(ServiceApi.class);
        Call<Products_Model> call = api.getProducts();

        call.enqueue(new Callback<Products_Model>() {
            @Override
            public void onResponse(Call<Products_Model> call, Response<Products_Model> response) {

                if(response.isSuccessful())
                {
                    progress.setVisibility(View.GONE);
                    layoutManager = new GridLayoutManager(getContext(),2);
                    apadterProduct = new RecylerApadterProduct(getContext(),response.body().getProducts());

                    Recy_category.setLayoutManager(layoutManager);
                    Recy_category.setAdapter(apadterProduct);
                    Recy_category.setHasFixedSize(false);

                    Log.e("TAG", "Suucessfully api hit " );
                    for(int i = 0; i<response.body().getProducts().size(); i++)
                    {
                        Log.e("TAG", "Brand Name: "+response.body().getProducts().get(i).getBrand() );
                    }

                }
            }
            @Override
            public void onFailure(Call<Products_Model> call, Throwable t) {

            }
        });
    }

}