//package com.pj.shoppingapp;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.widget.StaggeredGridLayoutManager;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.WindowManager;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.bumptech.glide.Glide;
//import com.google.firebase.database.DatabaseReference;
//import com.pj.shoppingapp.adapter.CartAdapter;
//import com.pj.shoppingapp.model.Cart;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AddToCart extends AppCompatActivity {
//    TextView productName, productPrice;
//    ImageView backButton,img;
//    RecyclerView addtocartrecycler;
//    AddToCart addToCart;
//    List<Cart> cart;
//    DatabaseReference databaseReference;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_to_cart);
//
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        addtocartrecycler=findViewById(R.id.addtocartrecycler);
//
//
//
//
//
//
//
//
//
//
//
//        Intent i = getIntent();
//
//
//        String image = i.getStringExtra("image");
//        String name = i.getStringExtra("name");
//        String price = i.getStringExtra("price");
//
////        productName = findViewById(R.id.prod_name);
////        productPrice = findViewById(R.id.price);
////        img = findViewById(R.id.big_image);
////        backButton = findViewById(R.id.backButton);
//        productName.setText(name);
//        productPrice.setText(price);
//        Glide.with(this).load(image).into(img);
//
//
//        setCartRecycler((ArrayList<AddToCart>) );
//
//
//
//    }
//    private void setCartRecycler(ArrayList<AddToCart> dataList) {
//        StaggeredGridLayoutManager staggeredGridLayoutManager= new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        addtocartrecycler.setLayoutManager(staggeredGridLayoutManager);
////
//    }
//}