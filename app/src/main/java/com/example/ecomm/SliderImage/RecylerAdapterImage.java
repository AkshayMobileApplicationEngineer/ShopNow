package com.example.ecomm.SliderImage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecomm.R;

import java.util.List;

public class RecylerAdapterImage extends RecyclerView.Adapter<RecylerAdapterImage.ViewHolder> {


    Context context;
    List<String> imgList;
    public RecylerAdapterImage( Context context, List<String> Images){
        this.context= context;
        this.imgList = Images;
    }


    @NonNull
    @Override
    public RecylerAdapterImage.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  =  LayoutInflater.from(context).inflate(R.layout.imagesilder,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerAdapterImage.ViewHolder holder, int position) {
        Glide.with(context).load(imgList.get(holder.getAdapterPosition()).toString()).into(holder.ImageLoder);
    }

    @Override
    public int getItemCount() {
        return imgList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ImageLoder;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ImageLoder=itemView.findViewById(R.id.simageRes);
        }
    }
}
