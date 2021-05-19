package com.damon.peliculasinformacion.Client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static  final  String baseUri = "http://api.themoviedb.org/3/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit == null){

            retrofit = new Retrofit.Builder().baseUrl(baseUri).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
