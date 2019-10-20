package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.room.Favorite;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.room.FavoriteRepository;

public class FavoriteViewModel extends ViewModel {

    private MutableLiveData<Favorite> mutableLiveDataFavorite;
    private FavoriteRepository favoriteRepository;

    public void init(final String data) {
        if (mutableLiveDataFavorite != null) {
            return;
        }

        favoriteRepository = FavoriteRepository.getInstance();
    }

    public LiveData<Favorite> getFavoriteRepository() {
        return mutableLiveDataFavorite;
    }
}
