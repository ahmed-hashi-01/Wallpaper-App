package com.example.wallpaperapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Imagemodel> modelClassList;
    private RecyclerView recyclerView;
    Adapter adapter;
    CardView mnature,mbus,mcar,mtrain,mtrending;
    EditText editText;
    ImageButton search;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        recyclerView= findViewById(R.id.recyclerview);
        mnature = findViewById(R.id.nature);
        mbus = findViewById(R.id.bus);
        mcar  = findViewById(R.id.car);
        mtrain = findViewById(R.id.train);
        mtrending = findViewById(R.id.trending);
        editText = findViewById(R.id.edittext);
        search = findViewById(R.id.serach);

        modelClassList = new ArrayList<>();
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setHasFixedSize(true);
        adapter = new Adapter(getApplicationContext(),modelClassList);
        recyclerView.setAdapter(adapter);
        findphotos();
        
        mnature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "nature";
                getsearchimage(query);
            }
        });
        mcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "car";
                getsearchimage(query);
            }
        });
        mbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "bus";
                getsearchimage(query);
            }
        });
        mtrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "train";
                getsearchimage(query);
            }
        });
        mtrending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                findphotos();
            }
        });
        mnature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "nature";
                getsearchimage(query);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query  = editText.getText().toString().trim().toLowerCase();
                if  (query.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter somthing ", Toast.LENGTH_SHORT).show();
                }else {
                    getsearchimage(query);
                }
            }
        });
    }

    private void getsearchimage(String query) {
       ApiUtilities.getApiInterface().getSearchImage(query,1,20).enqueue(new Callback<SearchModel>() {
           @Override
           public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {
               modelClassList.clear();
               Log.d("respon1", response+"");
               if (response.isSuccessful()){
                   modelClassList.addAll(response.body().getPhotos());
                   adapter.notifyDataSetChanged();
               }else {
                   Toast.makeText(getApplicationContext(),"Not able to get ", Toast.LENGTH_SHORT).show();
               }
           }

           @Override
           public void onFailure(Call<SearchModel> call, Throwable t) {

           }
       });
    }

    private void findphotos() {
        ApiUtilities.getApiInterface().getImage(1,20).enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {
                Log.d("respon2", response+"");
                Log.d("respon2", response.isSuccessful()+"");
                Log.d("respon2", response.body().getPhotos()+"");
                modelClassList.clear();
                if (response.isSuccessful()){

                    modelClassList.addAll(response.body().getPhotos());
                    adapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(getApplicationContext(),"Not able to get ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable t) {

            }
        });
    }
}