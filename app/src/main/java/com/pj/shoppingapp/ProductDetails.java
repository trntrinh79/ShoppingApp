package com.pj.shoppingapp;

import static java.lang.Integer.BYTES;
import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pj.shoppingapp.model.Cart;
import com.pj.shoppingapp.model.Colections;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductDetails extends AppCompatActivity {
    TextView productName, productPrice, productRating, descriptionView;
    ImageView backButton,img;
    LottieAnimationView lottieAnimationViewaddtocart,like;
    String size="29",name,price,rating,image,description,account;


    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent i = getIntent();

        name = i.getStringExtra("name");
        price = i.getStringExtra("price");
        rating = i.getStringExtra("rating");
        image = i.getStringExtra("image");
        description = i.getStringExtra("description");
        account = i.getStringExtra("Account");

        like = findViewById(R.id.like);
        productName = findViewById(R.id.prod_name);
        productPrice = findViewById(R.id.price);
        productRating = findViewById(R.id.rating);
        backButton = findViewById(R.id.backButton);
        img = findViewById(R.id.big_image);
        lottieAnimationViewaddtocart = findViewById(R.id.addtocart);
        descriptionView = findViewById(R.id.descriptionView);



        productName.setText(name);
        productPrice.setText(price);
        productRating.setText(rating);
        descriptionView.setText(description);

        Glide.with(this).load(image).into(img);




//

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductDetails.this, HomeActivity.class);
                startActivity(i);
            }
        });
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                like.playAnimation();
                Toast.makeText(ProductDetails.this, "Thanks for Like", Toast.LENGTH_SHORT).show();
            }
        });

        lottieAnimationViewaddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lottieAnimationViewaddtocart.playAnimation();
                databaseReference = FirebaseDatabase.getInstance().getReference("Cart");
                Cart cart = new Cart(account,name,price,image,size);
                databaseReference.push().setValue(cart);
            }
        });



    }

    public void onClickSizeButton(View view) {
        Button b = (Button) view;
        size = b.getText().toString();

    }

}