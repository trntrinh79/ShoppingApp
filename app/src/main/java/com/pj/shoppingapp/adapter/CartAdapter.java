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
import com.pj.shoppingapp.CartActivity;
import com.pj.shoppingapp.ProductDetails;
import com.pj.shoppingapp.R;
import com.pj.shoppingapp.model.Cart;
import com.pj.shoppingapp.model.Colections;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ColectionViewHolder> {


    Context context;
    ArrayList<Cart> carts;

    public CartAdapter(Context context, ArrayList<Cart> carts) {
        this.context = context;
        this.carts = carts;
    }

    @NonNull
    @Override
    public ColectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.incart_item, parent, false);
        return new ColectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColectionViewHolder holder,final int position) {

        Glide.with(context).load(carts.get(position).getImageUrl()).into(holder.image);
        holder.name.setText(carts.get(position).getName());
        holder.price.setText(carts.get(position).getPrice().toString());
        holder.size.setText(carts.get(position).getSize());
        holder.unit.setText(carts.get(position).getUnit());



//        holder.itemView.setOnClickListener((view)->{
//                Intent i = new Intent(context, CartActivity.class);
//                i.putExtra("name",carts.get(position).getName());
//                context.startActivity(i);
//            });


    }

    @Override
    public int getItemCount() {
        return carts.size();
    }

    public static class ColectionViewHolder extends  RecyclerView.ViewHolder{
        TextView name,price,size,unit;
        ImageView image;

        public ColectionViewHolder(@NonNull View itemView) {
            super(itemView);
            unit = itemView.findViewById(R.id.prod_unit);
            image = itemView.findViewById(R.id.itemImage);
            name = itemView.findViewById(R.id.nameSneakerCart);
            price = itemView.findViewById(R.id.priceSneakerCart);
            size = itemView.findViewById(R.id.sizeSneakerCart);
        }
    }


}
