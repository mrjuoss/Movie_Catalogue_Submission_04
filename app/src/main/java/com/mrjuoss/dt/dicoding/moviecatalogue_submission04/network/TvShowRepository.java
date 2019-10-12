package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.network;

import androidx.lifecycle.MutableLiveData;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.BuildConfig;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.tv.ResponseTvShow;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowRepository {
    private static TvShowRepository tvShowRepository;

    public static TvShowRepository getInstance() {
        if (tvShowRepository == null) {
            tvShowRepository = new TvShowRepository();
        }
        return tvShowRepository;
    }

    private Service tvShowApi;

    public TvShowRepository() {
        tvShowApi = Client.getClient().create(Service.class);
    }

    public MutableLiveData<ResponseTvShow> getTvShows(String apiKey) {
        MutableLiveData<ResponseTvShow> tvShowData = new MutableLiveData<>();

        tvShowApi.getResultsTvShow(BuildConfig.API_KEY)
                .enqueue(new Callback<ResponseTvShow>() {
                    @Override
                    public void onResponse(Call<ResponseTvShow> call, Response<ResponseTvShow> response) {

                        if (response.isSuccessful()) {
                            tvShowData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseTvShow> call, Throwable t) {
                        tvShowData.setValue(null);
                    }
                });
        return tvShowData;
    }
}
