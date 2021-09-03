package com.aliyayman.filmlerAppRetrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FilmlerDaoInterface {

    @POST("filmler/filmler_by_kategori_id.php")
    @FormUrlEncoded
    Call<FilmlerCevap> tumFilmlerByKategoriId(@Field("kategori_id")int kategori_id);

}
