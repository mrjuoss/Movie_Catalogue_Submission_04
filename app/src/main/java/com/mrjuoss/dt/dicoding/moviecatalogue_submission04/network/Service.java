package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.network;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.movie.ResponseMovie;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.tv.ResponseTvShow;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    @GET("movie")
    Call<ResponseMovie> getResultsMovie(
            @Query("api_key") String apiKey
    );

    @GET("movie/popular")
    Call<ResponseMovie> getPopularMoview(
        @Query("api_key") String apiKey
    );

    @GET("tv")
    Call<ResponseTvShow> getResultsTvShow(
            @Query("api_key") String apiKey
    );
}
