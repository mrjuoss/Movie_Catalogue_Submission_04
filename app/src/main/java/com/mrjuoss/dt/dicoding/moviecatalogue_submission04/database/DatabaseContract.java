package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.database;

import android.provider.BaseColumns;

public class DatabaseContract {

    static String TABLE_NAME = "favorite";

    public static final class FavoriteColumns implements BaseColumns {

        public static String ID_FAVORITE = "id";
        public static String TITLE = "title";
        public static String OVERVIEW = "overview";
        public static String RELEASE_DATE = "releaseDate";
        public static String POSTER_PATH = "posterPath";
        public static String BACKDROP_PATH = "backdropPath";
        public static String TYPE_FAVORITE = "typeFavorite";

    }
}
