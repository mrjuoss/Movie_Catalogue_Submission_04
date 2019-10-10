package com.mrjuoss.dt.dicoding.moviecatalogue_submission04;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.movie.ResponseMovie;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.movie.ResultsItem;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.network.Client;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.network.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView textResult;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = findViewById(R.id.text_result);
        progressBar = findViewById(R.id.progress_bar_movie);

        loadData();

    }

    private void loadData() {
        try {
            if (BuildConfig.API_KEY.isEmpty()) {
                Toast.makeText(this, "You must get API KEY", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                return;
            }

            Client client = new Client();

            Service apiService = Client.getClient().create(Service.class);

            Call<ResponseMovie> call = apiService.getResults(BuildConfig.API_KEY);

            progressBar.setVisibility(View.VISIBLE);

            call.enqueue(new Callback<ResponseMovie>() {
                @Override
                public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                    List<ResultsItem> results = response.body().getResults();

                    for (ResultsItem result : results) {
                        String content = "";
                        content += "ID : " + result.getId() + "\n";
                        content += "Title : " + result.getTitle() + "\n";
                        content += "Release Date : " + result.getReleaseDate() + "\n";
                        content += "\n";

                        textResult.append(content);
                    }

                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<ResponseMovie> call, Throwable t) {

                }
            });

        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            Toast.makeText(this, "Error fet Data From API", Toast.LENGTH_SHORT).show();
        }
    }
}
