package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.database;

import android.provider.BaseColumns;

public class DatabaseContract {

    static String TABLE_NAME = "favorite";

    static final class FavoriteColumns implements BaseColumns {

        static int ID_FAVORITE = Integer.valueOf("id");
        static String TITLE = "title";
        static String OVERVIEW = "overview";
        static String RELEASE_DATE = "releaseDate";
        static String POSTER_PATH = "posterPath";
        static String BACKDROP_PATH = "backdropPath";
        static String TYPE_FAVORITE = "typeFavorite";

    }
}
