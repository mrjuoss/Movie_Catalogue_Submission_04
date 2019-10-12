package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.BuildConfig;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.movie.ResponseMovie;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.network.MovieRepository;

public class MovieViewModel extends ViewModel {

    private MutableLiveData<ResponseMovie> mutableLiveDataMovie;
    private MovieRepository movieRepository;

    public void init(final String data) {
        if (mutableLiveDataMovie != null) {
            return;
        }

        movieRepository = MovieRepository.getInstance();
        mutableLiveDataMovie = movieRepository.getMovies(BuildConfig.API_KEY);

    }

    public LiveData<ResponseMovie> getMoviesRepository() {
        return mutableLiveDataMovie;
    }
}
