package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.ui.favorite;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.R;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.adapter.FavoriteAdapter;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.room.Favorite;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.viewmodel.FavoriteViewModel;

import java.util.ArrayList;

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


        return view;
    }

}
