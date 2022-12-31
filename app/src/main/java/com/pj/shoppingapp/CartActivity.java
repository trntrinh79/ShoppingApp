package com.pj.shoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pj.shoppingapp.adapter.CartAdapter;
import com.pj.shoppingapp.adapter.ColectionsAdapter;
import com.pj.shoppingapp.model.Cart;
import com.pj.shoppingapp.model.Colections;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    ArrayList<Cart> cartList;
    CartAdapter cartAdapter;
    DatabaseReference databaseReference;
    String account ;
    RecyclerView cartRecyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartList = new ArrayList<Cart>();
        account = getIntent().getStringExtra("Account");
        cartRecyclerView = findViewById(R.id.rcvCart);
        databaseReference = FirebaseDatabase.getInstance().getReference("Cart");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()){
                    Cart cart = data.getValue(Cart.class);
                    cartList.add(cart);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        //cartList.add( new Cart("Nike Air Jordan 1 Mid GS ‘Noble Red’","255$","https://sneakerdaily.vn/wp-content/uploads/2022/12/giay-nike-air-jordan-1-mid-gs-noble-red-554725-066.jpg.webp","30"));
        setCartRecycler((ArrayList<Cart>) cartList);


    }

    private void setCartRecycler(ArrayList<Cart> dataList) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        cartRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        cartAdapter = new CartAdapter(this, dataList);
        cartRecyclerView.setAdapter(cartAdapter);
    }
}