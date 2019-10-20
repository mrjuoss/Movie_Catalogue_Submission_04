package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.R;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.movie.ResultsItem;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.ui.movie.MovieDetailActivity;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private final String TAG = this.getClass().getSimpleName();

    private final Context context;
    private final ArrayList<ResultsItem> dataMovie;

    public MovieAdapter(Context context, ArrayList<ResultsItem> listMovie) {
        this.context = context;
        this.dataMovie = listMovie;
    }

    public ArrayList<ResultsItem> getDataMovie() {
        return dataMovie;
    }

    public void setDataMovie(ArrayList<ResultsItem> items) {
        dataMovie.clear();
        dataMovie.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_card_view_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(dataMovie.get(position));
    }

    @Override
    public int getItemCount() {
        return dataMovie.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgPosterMovie;
        TextView textTitleMovie, textReleaseMovie, textOverviewMovie;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPosterMovie = itemView.findViewById(R.id.image_poster);
            textTitleMovie = itemView.findViewById(R.id.text_title);
            textReleaseMovie = itemView.findViewById(R.id.text_release);
            textOverviewMovie = itemView.findViewById(R.id.text_overview_movie);

            itemView.setOnClickListener(this);
        }

        public void bind(ResultsItem movie) {
            String url_poster = "https://image.tmdb.org/t/p/w185"+ movie.getPosterPath();

            textTitleMovie.setText(movie.getTitle());
            textReleaseMovie.setText(movie.getReleaseDate());
            textOverviewMovie.setText(movie.getOverview());

            Glide.with(itemView.getContext())
                    .load(url_poster)
                    .into(imgPosterMovie);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            ResultsItem movie = dataMovie.get(position);

            Intent intentDetailMovie = new Intent(itemView.getContext(), MovieDetailActivity.class);
            intentDetailMovie.putExtra(MovieDetailActivity.EXTRA_MOVIE, movie);
            itemView.getContext().startActivity(intentDetailMovie);
        }
    }
}
