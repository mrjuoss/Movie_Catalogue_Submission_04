package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "dbfavorite";

    private static final int DATABASE_VERSION = 1 ;

    private static final String SQL_CREATE_TABLE_FAVORITE = String.format(
      "CREATE TABLE %s"
            + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
              " %s TEXT NOT NULL," +
              " %s TEXT NOT NULL," +
              " %s TEXT NOT NULL," +
              " %s TEXT NOT NULL," +
              " %s TEXT NOT NULL," +
              " %s TEXT NOT NULL," +
              " %s TEXT NOT NULL)",
            DatabaseContract.TABLE_NAME,
            DatabaseContract.FavoriteColumns._ID,
            DatabaseContract.FavoriteColumns.ID_FAVORITE,
            DatabaseContract.FavoriteColumns.TITLE,
            DatabaseContract.FavoriteColumns.OVERVIEW,
            DatabaseContract.FavoriteColumns.RELEASE_DATE,
            DatabaseContract.FavoriteColumns.POSTER_PATH,
            DatabaseContract.FavoriteColumns.BACKDROP_PATH,
            DatabaseContract.FavoriteColumns.TYPE_FAVORITE
    );

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_FAVORITE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_NAME);
        onCreate(db);
    }
}
