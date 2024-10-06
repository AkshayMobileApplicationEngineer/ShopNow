package com.example.ecomm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecomm.Model.Products_Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecylerApadterProduct extends RecyclerView.Adapter<RecylerApadterProduct.viewHolder> {
    Context context;
    List<Products_Model.Product> slist;


    public  RecylerApadterProduct(Context context,List<Products_Model.Product> mlist){
        this.context= context;
        this.slist = mlist;
    }

    @NonNull
    @Override
    public RecylerApadterProduct.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  =  LayoutInflater.from(context).inflate(R.layout.product_row,parent,false);
        viewHolder viewHolder= new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerApadterProduct.viewHolder holder, int position) {

        holder.product_stack.setText("Stock: "+slist.get(holder.getAdapterPosition()).getStock().toString());
        holder.Product_Price.setText("₹"+slist.get(holder.getAdapterPosition()).getPrice().toString());
        holder.product_name_mobile.setText(slist.get(holder.getAdapterPosition()).getBrand().toString());
        holder.discount.setText(slist.get(holder.getAdapterPosition()).getDiscountPercentage().toString()+"%");

        Glide.with(context).load(slist.get(holder.getAdapterPosition()).getThumbnail()).into(holder.Product_imag);

        holder.btn_maincard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,ProductDetails.class);

                intent.putExtra("titleName",slist.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("BrandName",slist.get(holder.getAdapterPosition()).getBrand());
                intent.putExtra("price",slist.get(holder.getAdapterPosition()).getPrice().toString());
                intent.putExtra("Stock",slist.get(holder.getAdapterPosition()).getStock().toString());
                intent.putExtra("Discount",slist.get(holder.getAdapterPosition()).getDiscountPercentage().toString());
                intent.putExtra("Rating",slist.get(holder.getAdapterPosition()).getRating().toString());
                intent.putExtra("Description",slist.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("Thumbnail",slist.get(holder.getAdapterPosition()).getThumbnail());

                List<String> imagelist = slist.get(holder.getAdapterPosition()).getImages();
                intent.putExtra("imglist",(Serializable) imagelist);



                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return slist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView Product_imag;
        TextView product_stack, Product_Price,product_name_mobile,discount;
        LinearLayout btn_maincard;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            Product_imag= itemView.findViewById(R.id.product_imag);

            product_stack=itemView.findViewById(R.id.product_stack);
            Product_Price=itemView.findViewById(R.id.product_price);
            product_name_mobile=itemView.findViewById(R.id.product_name_mobile);
            discount=itemView.findViewById(R.id.product_discount);
            btn_maincard=itemView.findViewById(R.id.btn_maincard);

        }
    }
}
