package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.ui.movie;

import android.content.ContentValues;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.R;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.database.FavoriteHelper;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.Favorite;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.movie.ResultsItem;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.room.FavoriteRepository;

import static com.mrjuoss.dt.dicoding.moviecatalogue_submission04.database.DatabaseContract.FavoriteColumns.*;
public class MovieDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = this.getClass().getSimpleName();
    public static final String EXTRA_MOVIE = "extra_movie";

    private ProgressBar progressBarDetailMovie;
    private ImageView imageDetailPosterMovie;
    private TextView textDetailTitleMovie;
    private TextView textDetailRatingMovie;
    private TextView textDetailreleaseMovie;
    private TextView textDetailOverviewMovie;
    private Button buttonFavorite;
    private FavoriteHelper favoriteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        progressBarDetailMovie = findViewById(R.id.progress_bar_detail_movie);
        imageDetailPosterMovie = findViewById(R.id.image_detail_poster_movie);
        textDetailTitleMovie = findViewById(R.id.text_detail_title_movie);
        textDetailRatingMovie = findViewById(R.id.text_detail_rating_movie);
        textDetailreleaseMovie = findViewById(R.id.text_detail_release_movie);
        textDetailOverviewMovie = findViewById(R.id.text_detail_overview_movie);

        progressBarDetailMovie.setVisibility(View.VISIBLE);

        buttonFavorite = findViewById(R.id.button_favorite_movie);

        buttonFavorite.setOnClickListener(this);

        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ResultsItem movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

                        String rating = Double.toString(movie.getVoteAverage());
                        String url_backdrop = "https://image.tmdb.org/t/p/w185"+ movie.getBackdropPath();

                        textDetailTitleMovie.setText(movie.getTitle());
                        textDetailRatingMovie.setText(rating);
                        textDetailreleaseMovie.setText(movie.getReleaseDate());
                        textDetailOverviewMovie.setText(movie.getOverview());

                        Glide.with(MovieDetailActivity.this)
                                .load(url_backdrop)
                                .placeholder(R.color.colorAccent)
                                .dontAnimate()
                                .into(imageDetailPosterMovie);

                        progressBarDetailMovie.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }).start();

    }

    @Override
    public void onClick(View v) {

        favoriteHelper = FavoriteHelper.getInstance(getApplicationContext());

        if (v.getId() == R.id.button_favorite_movie) {
            ResultsItem movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

            String title = movie.getTitle();
            String overview = movie.getOverview();
            String releaseDate = movie.getReleaseDate();
            String posterPath = movie.getPosterPath();
            String backdropPath = movie.getBackdropPath();
            String favoriteType = "movie";

            Log.d(TAG, "1 : " + title);
            Log.d(TAG, "2 : " + overview);
            Log.d(TAG, "3 : " + releaseDate);
            Log.d(TAG, "4 : " + posterPath);
            Log.d(TAG, "5 : " + backdropPath);
            Log.d(TAG, "6 : " + favoriteType);

            FavoriteRepository favoriteRepository = new FavoriteRepository(getApplicationContext());

            Log.d(TAG, "Insert Favorite : "+title +", "+ overview +", "+ releaseDate +", "+ posterPath +", "+ backdropPath +", "+ favoriteType);
            favoriteRepository.insertFavorite(title, overview, releaseDate, posterPath, backdropPath, favoriteType);

            Log.d(TAG, "Result Insert Favorite : "+favoriteRepository.getFavorites());
        }
    }
}
