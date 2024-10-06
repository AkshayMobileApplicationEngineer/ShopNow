package com.example.ecomm.SliderImage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecomm.ProductDetails;
import com.example.ecomm.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecycleAdapterCategoriesProduct extends RecyclerView.Adapter<RecycleAdapterCategoriesProduct.ViewHolder>{

    Context context;
    ImageView item_picture;
    TextView product_name;
    TextView product_price;
    TextView product_discount;
    public RecycleAdapterCategoriesProduct(Context context,ImageView item_picture, TextView product_name, TextView product_price,TextView product_discount) {


        this.context = context;
        this.item_picture = item_picture;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_discount = product_discount;
    }

    @NonNull
    @Override
    public RecycleAdapterCategoriesProduct.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_categories_item,parent,false);
        return new RecycleAdapterCategoriesProduct.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapterCategoriesProduct.ViewHolder holder, int position) {    /*Coding */
        
        holder.relativeLayoutitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "welcome", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(context, ProductDetails.class);
                intent.putExtra("titleName","fgjffh");
                intent.putExtra("BrandName","gfgffgffv");
                intent.putExtra("price","5656");
                intent.putExtra("Stock","566566");
                intent.putExtra("Discount","34");
                intent.putExtra("Rating","6");
                intent.putExtra("Description","45454 56656hg gyghjgvgygjh gjgj gughj");
                intent.putExtra("Thumbnail","hsdhahs");

                List<String> imagelist = new ArrayList<>();
                intent.putExtra("imglist",(Serializable) imagelist);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 24;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item_picture;
        TextView product_name;
        TextView product_price;
        TextView product_discount;
        RelativeLayout relativeLayoutitem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_picture=itemView.findViewById(R.id.item_picture);
            product_name=itemView.findViewById(R.id.product_name);
            product_price=itemView.findViewById(R.id.product_price);
            product_discount=itemView.findViewById(R.id.product_discount);

            relativeLayoutitem=itemView.findViewById(R.id.item);
        }
    }

}
