package com.mrjuoss.dt.dicoding.moviecatalogue_submission04;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.adapter.TabPageAdapter;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textResult = findViewById(R.id.text_result);
        //progressBar = findViewById(R.id.progress_bar_movie);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        configureTabLayout();
        //loadData();

    }

    private void configureTabLayout() {
        final TabLayout tabLayout = findViewById(R.id.tab_layout);
        final ViewPager viewPager = findViewById(R.id.view_pager);

        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_movie)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_tv)));

        final PagerAdapter adapter = new TabPageAdapter(
          getSupportFragmentManager(),
          tabLayout.getTabCount()
        );

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Log.d(TAG, "onTabSelected !!!");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.action_change_Setting) {
            Intent menuIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(menuIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
