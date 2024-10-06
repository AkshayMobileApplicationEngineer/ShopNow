package com.example.ecomm.SliderImage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecomm.R;

public class RecyclerAdapterCategroies extends RecyclerView.Adapter<RecyclerAdapterCategroies.ViewHolder> {


    Context context;
    ImageView imageView;
    String images[] = null;
    String items[] = null;
    public RecyclerAdapterCategroies(Context context,String images[], String items[] ) {
        this.context = context;
        this.images = images;
        this.items = items;

    }

    @NonNull
    @Override
    public RecyclerAdapterCategroies.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_categories,parent,false);
        return new RecyclerAdapterCategroies.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterCategroies.ViewHolder holder, int position) {
        /*coding */

        Glide.with(context).load(images[holder.getAdapterPosition()]).into(holder.imageView);
        holder.textView.setText(items[holder.getAdapterPosition()]);

    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.item_brand_image);
            textView=itemView.findViewById(R.id.logoName);

        }
    }
}
