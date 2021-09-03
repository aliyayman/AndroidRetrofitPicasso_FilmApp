package com.aliyayman.filmlerAppRetrofit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmlerActivity extends AppCompatActivity {
    private Toolbar toolbar2;
    private RecyclerView rvfilmler;
    private ArrayList<Filmler> filmlerArrayList;
    private FilmlerAdapter adapter;
    private Kategoriler kategori;
    private FilmlerDaoInterface filmlerDaoInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmler);
        toolbar2 = findViewById(R.id.toolbar2);
        rvfilmler = findViewById(R.id.rvfilmler);


        kategori = (Kategoriler) getIntent().getSerializableExtra("kategori_nesne");

        toolbar2.setTitle(kategori.getKategoriAd());
        setSupportActionBar(toolbar2);


        rvfilmler.setHasFixedSize(true);
        rvfilmler.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        filmlerDaoInterface=ApiUtils.getFilmlerDaoInterface();
       filmlerDaoInterface.tumFilmlerByKategoriId(Integer.parseInt(kategori.getKategoriId())).enqueue(new Callback<FilmlerCevap>() {
           @Override
           public void onResponse(Call<FilmlerCevap> call, Response<FilmlerCevap> response) {
               List<Filmler> filmler=response.body().getFilmler();

               adapter=new FilmlerAdapter(FilmlerActivity.this,filmler);
               rvfilmler.setAdapter(adapter);
           }

           @Override
           public void onFailure(Call<FilmlerCevap> call, Throwable t) {

           }
       });
    }
}



