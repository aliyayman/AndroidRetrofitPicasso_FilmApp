package com.aliyayman.filmlerAppRetrofit;

public class ApiUtils {

    public static final String BASE_URL = "http://www.byrmkus.tk/";

    public static KategorilerDaoInterface getKategorilerDaoInterface() {
        return RetrofitClient.getClient(BASE_URL).create(KategorilerDaoInterface.class);

    }

    public static FilmlerDaoInterface getFilmlerDaoInterface() {
        return RetrofitClient.getClient(BASE_URL).create(FilmlerDaoInterface.class);
    }
}
