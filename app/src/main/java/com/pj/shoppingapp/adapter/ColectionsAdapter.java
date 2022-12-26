package com.pj.shoppingapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pj.shoppingapp.ProductDetails;
import com.pj.shoppingapp.R;
import com.pj.shoppingapp.model.Colections;

import java.util.ArrayList;

public class ColectionsAdapter extends RecyclerView.Adapter<ColectionsAdapter.ColectionViewHolder> {


    Context context;
    ArrayList<Colections> colections;


    public ColectionsAdapter(Context context, ArrayList<Colections> colections) {
        this.context = context;
        this.colections = colections;

    }

    @NonNull
    @Override
    public ColectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.colection_row_items, parent, false);
        return new ColectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColectionViewHolder holder, final int position) {

        Glide.with(context).load(colections.get(position).getUrlImage()).into(holder.image);
        holder.name.setText(colections.get(position).getName());
        holder.price.setText(colections.get(position).getPrice());
//        holder.description.setText(colections.get(position).getDescription());

        //Glide.with(context).load(colections.get(position).getUrlImage()).into((ImageView) holder.itemView);


        holder.itemView.setOnClickListener((view)->{
            Intent i=new Intent(context, ProductDetails.class);
            i.putExtra("name",colections.get(position).getName());
            i.putExtra("price",colections.get(position).getPrice());
            i.putExtra("rating",colections.get(position).getRating());
            i.putExtra("image", colections.get(position).getUrlImage());
            i.putExtra("description", colections.get(position).getDescription());



            context.startActivity(i);
        });

    }

    @Override
    public int getItemCount() {
        return colections.size();
    }

    public static class ColectionViewHolder extends  RecyclerView.ViewHolder{
        TextView name,price,description;
        ImageView image;

        public ColectionViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.categoryImage);
            name = itemView.findViewById(R.id.nameSneaker);
            price = itemView.findViewById(R.id.priceSneaker);
            description = itemView.findViewById(R.id.descriptionView);




        }
    }
}
