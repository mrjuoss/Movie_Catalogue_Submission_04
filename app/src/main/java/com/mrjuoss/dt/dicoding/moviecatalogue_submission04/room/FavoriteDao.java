package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavoriteDao {

    @Insert
    void insert(Favorite... favorites);

    @Delete
    void delete(Favorite favorite);

    @Query("DELETE FROM table_favorite")
    void deleteAll();

    @Query("SELECT * FROM table_favorite")
    LiveData<List<Favorite>> getAllFavorites();
}
