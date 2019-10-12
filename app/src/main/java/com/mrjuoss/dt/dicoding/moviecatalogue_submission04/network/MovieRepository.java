package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.network;

import androidx.lifecycle.MutableLiveData;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.BuildConfig;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.movie.ResponseMovie;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.movie.ResultsItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private static MovieRepository movieRepository;

    public static MovieRepository getInstance() {
        if (movieRepository == null) {
            movieRepository = new MovieRepository();
        }
        return movieRepository;
    }

    private Service moviesApi;

    public MovieRepository() {
        moviesApi = Client.getClient().create(Service.class);
    }

    public MutableLiveData<ResponseMovie> getMovies(String apiKey) {
        MutableLiveData<ResponseMovie> moviesData = new MutableLiveData<>();

        moviesApi.getResultsMovie(BuildConfig.API_KEY)
                .enqueue(new Callback<ResponseMovie>() {
                    @Override
                    public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {

                        if (response.isSuccessful()) {
                            moviesData.setValue(response.body());
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseMovie> call, Throwable t) {
                        moviesData.setValue(null);
                    }
                });
        return moviesData;
    }


}
