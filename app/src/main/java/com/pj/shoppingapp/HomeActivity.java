package com.pj.shoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pj.shoppingapp.adapter.ColectionsAdapter;
import com.pj.shoppingapp.model.Colections;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    RecyclerView colectionsRecyclerView;
    ColectionsAdapter colectionsAdapter;
    List<Colections> colectionsList = new ArrayList<>();

    DatabaseReference databaseReference;
    EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        search = findViewById(R.id.etSearch);
        colectionsRecyclerView=findViewById(R.id.colectionsRecycler);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                colectionsAdapter.getFilter().filter(editable);
            }
        });







        //add Colection
        colectionsList.add(new Colections(1,"https://sneakerdaily.vn/wp-content/uploads/2020/11/air-jordan-1-high-dark-mocha-555088-105-1.png.webp","Air Jordan 1 Dark Mocha High OG","115$","4.5","This OG AJ1 employs a new twist on a familiar colour scheme: dark mocha."));
        colectionsList.add(new Colections(2,"https://sneakerdaily.vn/wp-content/uploads/2022/12/giay-nike-air-jordan-1-mid-gs-noble-red-554725-066.jpg.webp","Nike Air Jordan 1 Mid GS ‘Noble Red’","255$","5.0","Inspired by 2018's 'Bred Toe,' the Air Jordan 1 Mid GS 'Noble Red' is a grade-school shoe with a familiar mix of colors."));
        colectionsList.add(new Colections(3,"https://sneakerdaily.vn/wp-content/uploads/2022/12/giay-nike-undefeated-x-air-force-1-low-sp-dunk-vs-af1-dm8462-400.jpg.webp","Nike Undefeated x Air Force 1 Low","96$","4.0","Introduced in 1982, the Air Force 1 redefined basketball footwear from the hardwood to the tarmac."));
        colectionsList.add(new Colections(4,"https://sneakerdaily.vn/wp-content/uploads/2022/09/Thiet-ke-chua-co-ten-2022-09-28T125111.296.jpg.webp","Nike Air Force 1 Shadow","100$","4.5","The Nike Air Force 1 Shadow puts a playful twist on a classic b-ball design.Using a layered approach, doubling the branding and exaggerating the midsole, it highlights AF-1 DNA with a bold, new look."));
        colectionsList.add(new Colections(5,"https://sneakerdaily.vn/wp-content/uploads/2021/07/giay-nam-air-jordan-4-retro-white-oreo-ct8527-100-1.jpg.webp","Air Jordan 4 Retro ‘White Oreo’","200$","4.5","The Air Jordan 4 Retro 'White Oreo' features a design theme that recalls the original 'Oreo' AJ4 from 1999."));
        colectionsList.add(new Colections(5,"https://sneakerdaily.vn/wp-content/uploads/2022/08/Thiet-ke-chua-co-ten-7-1.jpg.webp","Nike Air Jordan 1 Retro High OG ‘Taxi’","250$","5.0","The Air Jordan 1 Retro High OG Yellow Toe brings back the distinct color blocking as well as the sneaker´s high silhouette."));

        databaseReference  = FirebaseDatabase.getInstance().getReference("Items");
        databaseReference.setValue(colectionsList).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Failure",Toast.LENGTH_SHORT).show();
            }
        });



        setColectionsRecycler((ArrayList<Colections>) colectionsList);


    }

    private void setColectionsRecycler(ArrayList<Colections> dataList) {
        StaggeredGridLayoutManager staggeredGridLayoutManager= new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        colectionsRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        colectionsAdapter = new ColectionsAdapter(this,dataList);
        colectionsRecyclerView.setAdapter(colectionsAdapter);
    }





}