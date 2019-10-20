package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoAccess {

    @Insert
    Long insertFavorite(Favorite favorite);

    @Query("SELECT * FROM Favorite ORDER BY id asc")
    LiveData<List<Favorite>> fetchAll();

    @Query("SELECT * FROM Favorite WHERE id =:favoriteId")
    LiveData<Favorite> getFavorite(int favoriteId);

    @Update
    void updateFavorite(Favorite favorite);

    @Delete
    void deleteFavorite(Favorite favorite);
}
