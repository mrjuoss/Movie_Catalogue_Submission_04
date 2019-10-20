package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.ui.favorite;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
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

    private ArrayList<Favorite> favoriteArrayList = new ArrayList<>();
    private FavoriteAdapter favoriteAdapter;
    private FavoriteViewModel favoriteViewModel;

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        
        progressBarFavorite = view.findViewById(R.id.progress_bar_favorite);
        receyclerViewFavorite = view.findViewById(R.id.recycler_view_favorite);
        
        receyclerViewFavorite.setLayoutManager(new LinearLayoutManager(this.getContext()));
        receyclerViewFavorite.setHasFixedSize(true);
        
        favoriteAdapter = new FavoriteAdapter(getContext(), favoriteArrayList);
        receyclerViewFavorite.setAdapter(favoriteAdapter);
        
        showLoading(true);
        //TextView textFavorite = view.findViewById(R.id.text_favorite);

        FavoriteRepository favoriteRepository = new FavoriteRepository(getContext());

        favoriteRepository.getFavorites().observe(this, new Observer<List<Favorite>>() {
            @Override
            public void onChanged(List<Favorite> favorites) {
                for (Favorite favorite : favorites) {
                    System.out.println("------------");
                    System.out.println(favorite.getId());
                    System.out.println(favorite.getTitle());
                    System.out.println(favorite.getReleaseDate());
                    System.out.println(favorite.getOverview());
                    System.out.println(favorite.getPosterPath());
                    System.out.println(favorite.getBackdropPath());
                    System.out.println(favorite.getTypeFavorite());

                    Log.d("Favorite", "onChanged: " +favorite.getTitle());
                }

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
