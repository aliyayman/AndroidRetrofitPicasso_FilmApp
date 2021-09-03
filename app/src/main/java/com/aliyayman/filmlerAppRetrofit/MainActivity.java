package com.aliyayman.filmlerAppRetrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;




import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView rvkategori;
    private ArrayList<Kategoriler> kategorilerArrayList;
    private KategoriAdapter adapter;
    private KategorilerDaoInterface kategorilerDaoInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        rvkategori=findViewById(R.id.rvkategori);




        toolbar.setTitle("Kategoriler");
        setSupportActionBar(toolbar);

        rvkategori.setHasFixedSize(true);
        rvkategori.setLayoutManager(new LinearLayoutManager(this));

        kategorilerDaoInterface=ApiUtils.getKategorilerDaoInterface();
        kategorilerDaoInterface.tumKategoriler().enqueue(new Callback<KategoriCevap>() {
            @Override
            public void onResponse(Call<KategoriCevap> call, Response<KategoriCevap> response) {

                List<Kategoriler> kategoriler=response.body().getKategoriler();

                adapter=new KategoriAdapter(MainActivity.this,kategoriler);
                rvkategori.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<KategoriCevap> call, Throwable t) {

            }
        });

    }



}