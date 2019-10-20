package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.room.Favorite;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.room.FavoriteRepository;

import java.util.List;

public class FavoriteViewModel extends AndroidViewModel {

    private FavoriteRepository repository;
    private LiveData<List<Favorite>> listFavorite;

    public FavoriteViewModel(@NonNull Application application) {
        super(application);
        repository = new FavoriteRepository(application);
        listFavorite = repository.getAllFavorites();
    }

    public void insert(Favorite favorite) {
        repository.insert(favorite);
    }

    public void delete(Favorite favorite) {
        repository.delete(favorite);
    }
    public void deleteAll() {
        repository.deleteAll();
    }

    public LiveData<List<Favorite>> getListFavorite() {
        return listFavorite;
    }

}
