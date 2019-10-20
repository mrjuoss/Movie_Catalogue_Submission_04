package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Favorite.class}, version = 3, exportSchema = false)
public abstract class FavoriteDatabase extends RoomDatabase {

    private static FavoriteDatabase instance;

    public abstract FavoriteDao favoriteDao();

    public static synchronized FavoriteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FavoriteDatabase.class,
                    "db_favorite")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private FavoriteDao favoriteDao;

        private PopulateDbAsyncTask(FavoriteDatabase db) {
            favoriteDao = db.favoriteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            favoriteDao.insert(new Favorite("El Camino", "In the wake of his dramatic escape", "2019-10-11", "/ePXuKdXZuJx8hHMNr2yM4jY2L7Z.jpg", "/uLXK1LQM28XovWHPao3ViTeggXA.jpg", "movie"));
            favoriteDao.insert(new Favorite("A Breaking", "dramatic escape from captivity", "2019-11-11", "/ePXuKdXZuJx8hHMNr2yM4jY2L7Z.jpg", "/uLXK1LQM28XovWHPao3ViTeggXA.jpg", "tv"));
            favoriteDao.insert(new Favorite("Bad Movie", "In the wake of his captivity", "2019-12-11", "/ePXuKdXZuJx8hHMNr2yM4jY2L7Z.jpg", "/uLXK1LQM28XovWHPao3ViTeggXA.jpg", "tv"));
            favoriteDao.insert(new Favorite("Test Movie", "In the wake of captivity", "2019-09-11", "/ePXuKdXZuJx8hHMNr2yM4jY2L7Z.jpg", "/uLXK1LQM28XovWHPao3ViTeggXA.jpg", "movie"));
            return null;
        }
    }
}
