package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.viewmodel;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.BuildConfig;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.movie.ResponseMovie;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.movie.ResultsItem;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.network.Client;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.network.MovieRepository;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.network.Service;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {

    private MutableLiveData<ResponseMovie> mutableLiveData;
    private MovieRepository movieRepository;

    public void init(final String movies) {
        if (mutableLiveData != null) {
            return;
        }

        movieRepository = MovieRepository.getInstance();
        mutableLiveData = movieRepository.getMovies("api_key", BuildConfig.API_KEY);

    }

    public LiveData<ResponseMovie> getMoviesRepository() {
        return mutableLiveData;
    }
}
