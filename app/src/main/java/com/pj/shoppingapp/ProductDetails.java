package com.pj.shoppingapp;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {
    TextView productName, productPrice, productRating;
    ImageView backButton,img ,bg;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent i = getIntent();

        String name = i.getStringExtra("name");
        String price = i.getStringExtra("price");
        String rating = i.getStringExtra("rating");
        Integer image = i.getIntExtra("image",R.drawable.b1);


        productName = findViewById(R.id.prod_name);
        productPrice = findViewById(R.id.price);
        productRating = findViewById(R.id.rating);
        backButton = findViewById(R.id.backButton);
        img = findViewById(R.id.big_image);



        productName.setText(name);
        productPrice.setText(price);
        productRating.setText(rating);
        img.setImageResource(image);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductDetails.this, HomeActivity.class);
                startActivity(i);
            }
        });
    }
}