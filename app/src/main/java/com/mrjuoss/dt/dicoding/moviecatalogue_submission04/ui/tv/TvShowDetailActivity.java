package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.ui.tv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.R;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.tv.ResultsItem;

public class TvShowDetailActivity extends AppCompatActivity {

    public static final String EXTRA_TV_SHOW = "extra_tv_show";

    private ProgressBar progressBarDetailTv;
    private ImageView imageDetailTv;
    private TextView textDetailTitleTv;
    private TextView textDetailRatingTv;
    private TextView textDetailReleaseTv;
    private TextView textDetailOverviewTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show_detail);

        progressBarDetailTv = findViewById(R.id.progress_bar_detail_tv);
        imageDetailTv = findViewById(R.id.image_detail_poster_tv);
        textDetailTitleTv = findViewById(R.id.text_detail_title_tv);
        textDetailRatingTv = findViewById(R.id.text_detail_rating_tv);
        textDetailReleaseTv = findViewById(R.id.text_detail_release_tv);
        textDetailOverviewTv = findViewById(R.id.text_detail_overview_tv);

        progressBarDetailTv.setVisibility(View.VISIBLE);

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
                        ResultsItem tvShow = getIntent().getParcelableExtra(EXTRA_TV_SHOW);

                        String rating = Double.toString(tvShow.getVoteAverage());
                        String url_poster = "https://image.tmdb.org/t/p/w185"+ tvShow.getPosterPath();

                        textDetailTitleTv.setText(tvShow.getName());
                        textDetailRatingTv.setText(rating);
                        textDetailReleaseTv.setText(tvShow.getFirstAirDate());
                        textDetailOverviewTv.setText(tvShow.getOverview());

                        Glide.with(TvShowDetailActivity.this)
                                .load(url_poster)
                                .placeholder(R.color.colorPrimary)
                                .dontAnimate()
                                .into(imageDetailTv);

                        progressBarDetailTv.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }).start();
    }
}
