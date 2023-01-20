package com.example.imdbapp.service;

import com.example.imdbapp.models.ResponseMovies;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieAPI {
//baseUrl- https://api.themoviedb.org/3/
    //    movie/popular?api_key=23bebf3b33f0f530bc8a0154b193a911&language=en-US&page=1


    @GET("movie/popular?api_key=23bebf3b33f0f530bc8a0154b193a911&language=en-US&page=1")
    Call<ResponseMovies> getData();


}
