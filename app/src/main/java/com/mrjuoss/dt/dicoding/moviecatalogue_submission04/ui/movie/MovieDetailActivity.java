package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.ui.movie;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.R;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.movie.ResponseMovie;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.movie.ResultsItem;

public class MovieDetailActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    public static final String EXTRA_MOVIE = "extra_movie";

    private ProgressBar progressBarDetailMovie;
    private ImageView imageDetailPosterMovie;
    private TextView textDetailTitleMovie;
    private TextView textDetailRatingMovie;
    private TextView textDetailreleaseMovie;
    private TextView textDetailOverviewMovie;

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
}
