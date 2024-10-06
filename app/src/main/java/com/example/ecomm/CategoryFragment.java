package com.example.ecomm;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ecomm.SliderImage.RecycleAdapterCategoriesProduct;
import com.example.ecomm.SliderImage.RecyclerAdapterCategroies;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {

    RecyclerView recyclerView_item_Image;
    RecyclerView recycle_item_product;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        recyclerView_item_Image=view.findViewById(R.id.Recycle_brand);
        recycle_item_product=view.findViewById(R.id.recycle_item_product);

        getrecyclerconcept();
        getlistconcept();//vertical concept
        return  view;
    }

    RecyclerAdapterCategroies imageItem;
    ImageView imageView;
    public void getrecyclerconcept(){

        String imagelist[] = {"https://th.bing.com/th/id/R.65a4137376936ae9be364a44431c9348?rik=0STdQSU%2b2wHJeg&riu=http%3a%2f%2fwww.learningcomputer.com%2fblog%2fwp-content%2fuploads%2f2016%2f11%2fCell-Phone-Plans-topic-page-graphic.png&ehk=gkxu1Dk7B1f91j369HRMYQapfTwy7hxrk%2ftwAM80wcY%3d&risl=&pid=ImgRaw&r=0",
        "https://th.bing.com/th/id/OIP.0Jo05CBaTQeI8XWMREVptwHaHa?rs=1&pid=ImgDetMain",
                "https://th.bing.com/th/id/OIP.NDOdMC_KsCMy-cpI6kRK5wHaEW?rs=1&pid=ImgDetMain"
        ,"https://www.lawcrossing.com/images/articleimages/40-Books-Every-Attorney-Should-Read.jpg"};
        String items[] = {"Mobile","Laptop","Car","Book"};

        imageItem=new RecyclerAdapterCategroies(getContext(),imagelist,items);
        recyclerView_item_Image.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView_item_Image.setAdapter(imageItem);
    }

    RecycleAdapterCategoriesProduct productItem;


    ImageView item_picture;
    TextView product_name;
    TextView product_price;
    TextView product_discount;

    public void getlistconcept(){

        productItem=new RecycleAdapterCategoriesProduct(getContext(),item_picture,product_name,product_price,product_discount);
        recycle_item_product.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false));
        recycle_item_product.setAdapter(productItem);


    }
}