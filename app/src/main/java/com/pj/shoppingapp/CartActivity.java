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
    //String account = getIntent().getStringExtra("Account").toString();
    RecyclerView cartRecyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartList = new ArrayList<Cart>();
        cartRecyclerView = findViewById(R.id.rcvCart);
        databaseReference = FirebaseDatabase.getInstance().getReference("Cart");
        databaseReference.child("0").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if (task.isSuccessful()){

                    if (task.getResult().exists()){

                        Toast.makeText(CartActivity.this,"Successfully Read",Toast.LENGTH_SHORT).show();
                        DataSnapshot dataSnapshot = task.getResult();
//                        String name = String.valueOf(dataSnapshot.child("name").getValue());
//                        String price = String.valueOf(dataSnapshot.child("price").getValue());
//                        String size = String.valueOf(dataSnapshot.child("size").getValue());
//                        String imgURL = String.valueOf(dataSnapshot.child("imageUrl").getValue());
                        for(DataSnapshot data : dataSnapshot.getChildren()){
                            Cart cart = data.getValue(Cart.class);
                            cartList.add(cart);
                        }


                    }else {

                        Toast.makeText(CartActivity.this,"User Doesn't Exist",Toast.LENGTH_SHORT).show();

                    }


                }else {

                    Toast.makeText(CartActivity.this,"Failed to read",Toast.LENGTH_SHORT).show();
                }

            }
        });
        setCartRecycler((ArrayList<Cart>) cartList);


    }

    private void setCartRecycler(ArrayList<Cart> dataList) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        cartRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        cartAdapter = new CartAdapter(this, dataList);
        cartRecyclerView.setAdapter(cartAdapter);
    }
}