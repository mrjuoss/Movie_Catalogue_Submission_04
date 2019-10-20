package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.ui.movie;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.R;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.adapter.MovieAdapter;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.movie.ResultsItem;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.viewmodel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    private ProgressBar progressBarMovie;
    private RecyclerView recyclerViewMovie;

    private ArrayList<ResultsItem> movieArrayList = new ArrayList<>();
    private MovieAdapter movieAdapter;
    private MovieViewModel movieViewModel;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        progressBarMovie = view.findViewById(R.id.progress_bar_movie);

        recyclerViewMovie = view.findViewById(R.id.recycler_view_movie);

        recyclerViewMovie.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewMovie.setHasFixedSize(true);

        movieAdapter = new MovieAdapter(getContext(), movieArrayList);
        recyclerViewMovie.setAdapter(movieAdapter);

        showLoading(true);

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.init("EXTRA_MOVIE");
        movieViewModel.getMoviesRepository().observe(this, responseMovie -> {
            List<ResultsItem> movies = responseMovie.getResults();
            movieArrayList.addAll(movies);
            movieAdapter.notifyDataSetChanged();
            showLoading(true);
        });

        //movieViewModel.setMovies("EXTRA_MOVIE");
        return view;

    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBarMovie.setVisibility(View.VISIBLE);
        } else {
            progressBarMovie.setVisibility(View.GONE);
        }
    }


}
