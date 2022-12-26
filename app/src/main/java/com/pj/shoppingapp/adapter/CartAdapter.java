//package com.pj.shoppingapp.adapter;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.firebase.database.core.Context;
//import com.pj.shoppingapp.AddToCart;
//import com.pj.shoppingapp.R;
//import com.pj.shoppingapp.model.Cart;
//
//import java.util.ArrayList;
//
//public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
//
//    Context context;
//    ArrayList<Cart> cart;
//
//
//
//    public CartAdapter(Context context,ArrayList<Cart> cart){
//        this.context = context;
//        this.cart= cart;
//    }
//    @NonNull
//    @Override
//    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.colection_row_items, parent, false);
//        return new CartViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return cart.size();
//    }
//
//    public static class CartViewHolder extends RecyclerView.ViewHolder {
//        TextView name,price;
//        ImageView image;
//
//        public CartViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            image = itemView.findViewById(R.id.categoryImage);
//            name = itemView.findViewById(R.id.nameSneaker);
//            price = itemView.findViewById(R.id.priceSneaker);
//
//
//
//
//
//        }
//    }
//}