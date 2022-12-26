package com.pj.shoppingapp;

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

public class ProductDetails extends AppCompatActivity {
    TextView productName, productPrice, productRating, descriptionView;
    ImageView backButton,img;
    LottieAnimationView lottieAnimationViewaddtocart,like;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent i = getIntent();

        String name = i.getStringExtra("name");
        String price = i.getStringExtra("price");
        String rating = i.getStringExtra("rating");
        String image = i.getStringExtra("image");
        String description = i.getStringExtra("description");

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
            }
        });
    }
}