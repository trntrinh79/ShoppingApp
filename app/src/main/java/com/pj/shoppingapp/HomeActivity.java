package com.pj.shoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pj.shoppingapp.adapter.ColectionsAdapter;
import com.pj.shoppingapp.model.Colections;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    RecyclerView colectionsRecyclerView;
    ColectionsAdapter colectionsAdapter;
    List<Colections> colectionsList;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        colectionsRecyclerView=findViewById(R.id.colectionsRecycler);



        colectionsList = new ArrayList<>();

        //add Colection
        colectionsList.add(new Colections(1,R.drawable.mocha,"Mocha","115$"));
        colectionsList.add(new Colections(2,R.drawable.noble_red,"Red Noble","255$"));
        colectionsList.add(new Colections(3,R.drawable.af1_low,"AF1 low","96$"));
        colectionsList.add(new Colections(4,R.drawable.af1_shadow,"AF1 Shadow","100$"));
        colectionsList.add(new Colections(5,R.drawable.jordan4_retro,"Jordan 4 Retro","200$"));
        colectionsList.add(new Colections(5,R.drawable.jordan_high_retro_og,"Jordan High Retro OG","250$"));

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