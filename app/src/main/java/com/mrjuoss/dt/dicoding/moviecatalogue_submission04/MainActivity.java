package com.mrjuoss.dt.dicoding.moviecatalogue_submission04;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.helper.MyConstant;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.movie.ResultsItem;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.network.RestApiMovie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = findViewById(R.id.text_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyConstant.BASE_URL_MOVIE+"api_key="+BuildConfig.API_KEY+"&language=en-US/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestApiMovie restApiMovie = retrofit.create(RestApiMovie.class);

        Call<List<ResultsItem>> call = restApiMovie.getMovies();

        call.enqueue(new Callback<List<ResultsItem>>() {
            @Override
            public void onResponse(Call<List<ResultsItem>> call, Response<List<ResultsItem>> response) {
                if (!response.isSuccessful()) {
                    textResult.setText("Status Code : " + response.code());
                    return;
                }

                List<ResultsItem> movies = response.body();

                for (ResultsItem movie : movies) {
                    String content = "";
                    content += "ID : " + movie.getId() +"\n";
                    content += "Title : " + movie.getTitle();

                    textResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<ResultsItem>> call, Throwable t) {
                textResult.setText(t.getMessage());
            }
        });
    }
}
