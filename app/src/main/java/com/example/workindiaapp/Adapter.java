package com.example.workindiaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<Product> products;

    public Adapter( List<Product> products){
        //this.inflater = LayoutInflater.from(ctx);
        this.products = products;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // bind the data
        holder.productName.setText(products.get(position).getName());
        holder.productPrice.setText(products.get(position).getPrice());
        if(products.get(position).getExtra() != "null" ) {
            holder.productExtra.setText(products.get(position).getExtra());
        }
        //Picasso.get().load(products.get(position).getCoverImage()).into(holder.productCoverImage);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{
        TextView productName,productPrice,productExtra;
        //ImageView productCoverImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.name);
            productPrice = itemView.findViewById(R.id.price);
            productExtra = itemView.findViewById(R.id.extra);
            //productCoverImage = itemView.findViewById(R.id.coverImage);

            // handle onClick

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(v.getContext(), "Do Something With this Click", Toast.LENGTH_SHORT).show();
//                }
//            });
        }
    }
}
