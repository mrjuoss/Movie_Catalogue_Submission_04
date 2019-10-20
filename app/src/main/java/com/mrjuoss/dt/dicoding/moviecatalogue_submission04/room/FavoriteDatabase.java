package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Favorite.class}, version = 1, exportSchema = false)
public abstract class FavoriteDatabase extends RoomDatabase {

    public abstract DaoAccess daoAccess();
}
