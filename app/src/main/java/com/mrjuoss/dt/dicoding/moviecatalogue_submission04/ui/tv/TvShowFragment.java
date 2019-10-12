package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.ui.tv;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {


    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

}
