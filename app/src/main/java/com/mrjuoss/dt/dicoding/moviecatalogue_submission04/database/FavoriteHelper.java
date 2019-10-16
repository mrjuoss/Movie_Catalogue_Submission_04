package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.Favorite;
import java.util.ArrayList;

import static android.provider.BaseColumns._ID;
import static com.mrjuoss.dt.dicoding.moviecatalogue_submission04.database.DatabaseContract.TABLE_NAME;
import static com.mrjuoss.dt.dicoding.moviecatalogue_submission04.database.DatabaseContract.FavoriteColumns.TITLE;
import static com.mrjuoss.dt.dicoding.moviecatalogue_submission04.database.DatabaseContract.FavoriteColumns.OVERVIEW;
import static com.mrjuoss.dt.dicoding.moviecatalogue_submission04.database.DatabaseContract.FavoriteColumns.RELEASE_DATE;
import static com.mrjuoss.dt.dicoding.moviecatalogue_submission04.database.DatabaseContract.FavoriteColumns.BACKDROP_PATH;
import static com.mrjuoss.dt.dicoding.moviecatalogue_submission04.database.DatabaseContract.FavoriteColumns.POSTER_PATH;


public class FavoriteHelper {
    private static final String DATABASE_TABLE = TABLE_NAME;
    private static DatabaseHelper databaseHelper;
    private static FavoriteHelper INSTANCE;

    private static SQLiteDatabase database;

    private FavoriteHelper(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public static FavoriteHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FavoriteHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public void open() throws SQLException {
        database = databaseHelper.getWritableDatabase();
    }

    public void close() {
        databaseHelper.close();

        if (database.isOpen())
            database.close();
    }

    // Get All Data
    public Cursor queryAll() {
        return database.query(
                DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                _ID + " ASC"
        );
    }

    // Get Data by ID
    public Cursor queryById(String id) {
        return database.query(DATABASE_TABLE, null,
                _ID + " = ?"
                , new String[] {id}
                , null
                , null
                , null
                , null
        );
    }

    // Insert Data
    public long insert(ContentValues values) {
        return database.insert(DATABASE_TABLE, null, values);
    }
    // Update Data
    public int update(String id, ContentValues values) {
        return database.update(DATABASE_TABLE, values, _ID + " = ?", new String[]{id});
    }

    // Delete Data
    public int deleteById(String id) {
        return database.delete(DATABASE_TABLE, _ID + " = ?", new String[]{id});
    }

}
