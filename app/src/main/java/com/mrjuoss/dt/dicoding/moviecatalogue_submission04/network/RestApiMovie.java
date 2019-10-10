package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.network;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.movie.ResultsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiMovie {

    @GET("results")
    Call<List<ResultsItem>> getMovies();
}
