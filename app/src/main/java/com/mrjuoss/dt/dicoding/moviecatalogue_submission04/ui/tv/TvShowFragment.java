package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.ui.tv;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.R;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.adapter.TvShowAdapter;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.tv.ResultsItem;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.viewmodel.TvShowViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    private ProgressBar progressBarTvShow;
    private RecyclerView recyclerViewTvShow;

    private ArrayList<ResultsItem> tvShowArrayList = new ArrayList<>();
    private TvShowAdapter tvShowAdapter;
    private TvShowViewModel tvShowViewModel;

    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv_show, container, false);

        progressBarTvShow = view.findViewById(R.id.progress_bar_tv);
        recyclerViewTvShow = view.findViewById(R.id.recycler_view_tv);

        recyclerViewTvShow.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewTvShow.setHasFixedSize(true);

        tvShowAdapter = new TvShowAdapter(getContext(), tvShowArrayList);
        recyclerViewTvShow.setAdapter(tvShowAdapter);

        showLoading(true);

        tvShowViewModel = ViewModelProviders.of(this).get(TvShowViewModel.class);
        tvShowViewModel.init("EXTRA_TV_SHOW");
        tvShowViewModel.getTvShowRepository()
                .observe(this, responseTvShow -> {
                    List<ResultsItem> tvShows = responseTvShow.getResults();
                    tvShowArrayList.addAll(tvShows);
                    tvShowAdapter.notifyDataSetChanged();
                    showLoading(true);
                });

        return view;
    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBarTvShow.setVisibility(View.VISIBLE);
        } else {
            progressBarTvShow.setVisibility(View.GONE);
        }
    }

}
