package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.network.MovieRepository;

import java.util.List;

public class FavoriteRepository {

    private String DATABASE_NAME = "db_favorite";

    private FavoriteDatabase favoriteDatabase;
    private static FavoriteRepository favoriteRepository;

    public static FavoriteRepository getInstance() {
        if (favoriteRepository == null) {
            favoriteRepository = new FavoriteRepository();
        }
        return favoriteRepository;
    }

    public FavoriteRepository() {
    }

    public FavoriteRepository(Context context) {
        favoriteDatabase = Room.databaseBuilder(
                context,
                FavoriteDatabase.class,
                DATABASE_NAME
        ).build();
    }

    public void insertFavorite(
            String title,
            String overview,
            String releaseDate,
            String posterPath,
            String backdropPath,
            String fovoriteType) {
        //insertFavorite(title, overview, releaseDate, posterPath, backdropPath, fovoriteType);
        Favorite favorite = new Favorite();
        favorite.setTitle(title);
        favorite.setOverview(overview);
        favorite.setReleaseDate(releaseDate);
        favorite.setPosterPath(posterPath);
        favorite.setBackdropPath(backdropPath);

        insertFavorite(favorite);
    }

    public void insertFavorite(final Favorite favorite) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                favoriteDatabase.daoAccess().insertFavorite(favorite);
                return null;
            }
        }.execute();
    }

    public void deleteFavorite(final int id) {
        final LiveData<Favorite> favorite = getFavorite(id);

        if (favorite != null) {
            new AsyncTask<Void, Void, Void>() {

                @Override
                protected Void doInBackground(Void... voids) {
                    favoriteDatabase.daoAccess().deleteFavorite(favorite.getValue());
                    return null;
                }
            }.execute();
        }
    }
    public void deleteFavorite(final Favorite favorite) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                favoriteDatabase.daoAccess().deleteFavorite(favorite);
                return null;
            }
        }.execute();
    }

    public LiveData<Favorite> getFavorite(int id) {
        return favoriteDatabase.daoAccess().getFavorite(id);
    }

    public LiveData<List<Favorite>> getFavorites() {
        return favoriteDatabase.daoAccess().fetchAll();
    }




}
