package com.example.ecomm.Api;


import com.example.ecomm.Model.Products_Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET("products")
    Call<Products_Model> getProducts();

}
