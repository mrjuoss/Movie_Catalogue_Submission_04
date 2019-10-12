package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.R;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.tv.ResultsItem;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.ui.tv.TvShowDetailActivity;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {

    private final String TAG = this.getClass().getSimpleName();

    private final Context context;
    private final ArrayList<ResultsItem> dataTvShow;

    public TvShowAdapter(Context context, ArrayList<ResultsItem> listTvShow) {
        this.context = context;
        this.dataTvShow = listTvShow;
    }

    public ArrayList<ResultsItem> getDataTvShow() {
        return dataTvShow;
    }

    public void setDataTvShow(ArrayList<ResultsItem> items) {
        dataTvShow.clear();
        dataTvShow.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view =  LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_card_view_tv, parent, false);
       return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewHolder holder, int position) {
        holder.bind(dataTvShow.get(position));
    }

    @Override
    public int getItemCount() {
        return dataTvShow.size();
    }

    public class TvShowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imagePosterTv;
        TextView textNameTv, textReleaseTv, textOverviewTv;
        public TvShowViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePosterTv = itemView.findViewById(R.id.image_poster_tv);
            textNameTv = itemView.findViewById(R.id.text_title_tv);
            textReleaseTv = itemView.findViewById(R.id.text_release_tv);
            textOverviewTv = itemView.findViewById(R.id.text_overview_tv);

            itemView.setOnClickListener(this);
        }

        public void bind(ResultsItem tvShow) {
            String url_poster_tv = "https://image.tmdb.org/t/p/w185" + tvShow.getPosterPath();

            textNameTv.setText(tvShow.getName());
            textReleaseTv.setText(tvShow.getFirstAirDate());
            textOverviewTv.setText(tvShow.getOverview());

            Glide.with(itemView.getContext())
                    .load(url_poster_tv)
                    .placeholder(R.color.colorPrimary)
                    .dontAnimate().into(imagePosterTv);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            ResultsItem tvShow = dataTvShow.get(position);

            Intent intentDetailTv = new Intent(itemView.getContext(), TvShowDetailActivity.class);
            intentDetailTv.putExtra(TvShowDetailActivity.EXTRA_TV_SHOW, tvShow);
            itemView.getContext().startActivity(intentDetailTv);

        }
    }
}
