package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.ui.favorite;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.R;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.adapter.FavoriteAdapter;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.room.Favorite;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.room.FavoriteRepository;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.viewmodel.FavoriteViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {

    private ProgressBar progressBarFavorite;
    private RecyclerView receyclerViewFavorite;

    private FavoriteViewModel favoriteViewModel;

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        
        progressBarFavorite = view.findViewById(R.id.progress_bar_favorite);
        receyclerViewFavorite = view.findViewById(R.id.recycler_view_favorite);
        
        receyclerViewFavorite.setLayoutManager(new LinearLayoutManager(this.getContext()));
        receyclerViewFavorite.setHasFixedSize(true);
        
        FavoriteAdapter adapter = new FavoriteAdapter();
        receyclerViewFavorite.setAdapter(adapter);
        
        showLoading(true);

        favoriteViewModel = ViewModelProviders.of(this).get(FavoriteViewModel.class);
        favoriteViewModel.getListFavorite().observe(this, new Observer<List<Favorite>>() {
            @Override
            public void onChanged(@Nullable List<Favorite> favorites) {
                adapter.setFavorites(favorites);
                Toast.makeText(getContext(), "RecyclerView Favorite onChanged", Toast.LENGTH_SHORT).show();
                showLoading(false);
            }
        });

        return view;
    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBarFavorite.setVisibility(View.VISIBLE);
        } else {
            progressBarFavorite.setVisibility(View.GONE);
        }
    }

}
