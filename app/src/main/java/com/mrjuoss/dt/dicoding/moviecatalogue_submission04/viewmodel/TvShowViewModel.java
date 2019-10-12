package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.BuildConfig;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.tv.ResponseTvShow;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.network.TvShowRepository;

public class TvShowViewModel extends ViewModel {

    private MutableLiveData<ResponseTvShow> mutableLiveDataTv;
    private TvShowRepository tvShowRepository;

    public void init(final String data) {
        if (mutableLiveDataTv != null) {
            return;
        }

        tvShowRepository = TvShowRepository.getInstance();
        mutableLiveDataTv = tvShowRepository.getTvShows(BuildConfig.API_KEY);

    }

    public LiveData<ResponseTvShow> getTvShowRepository() {
        return mutableLiveDataTv;
    }
}
