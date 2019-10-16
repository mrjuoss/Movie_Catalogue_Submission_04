package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.ui.favorite.FavoriteFragment;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.ui.movie.MovieFragment;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.ui.tv.TvShowFragment;

public class TabPageAdapter extends FragmentPagerAdapter {

    private int tabCount;

    public TabPageAdapter(@NonNull FragmentManager fm, int numberOfTabs) {
        super(fm, numberOfTabs);
        this.tabCount = numberOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MovieFragment();
            case 1:
                return new TvShowFragment();
            case 2:
                return new FavoriteFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
