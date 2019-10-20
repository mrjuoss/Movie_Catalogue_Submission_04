package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.CustomOnItemClickListener;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.R;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission04.room.Favorite;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder> {

    private ArrayList<Favorite> listFavorites = new ArrayList<>();
    private Context context;

    public FavoriteAdapter(Context context, ArrayList<Favorite> listFavorite) {
        this.context = context;
        this.listFavorites = listFavorite;
    }

    public ArrayList<Favorite> getListFavorites() {
        return listFavorites;
    }

    public void setListFavorites(ArrayList<Favorite> listFavorites) {

        if (listFavorites.size() > 0) {
            this.listFavorites.clear();
        }

        this.listFavorites.addAll(listFavorites);

        notifyDataSetChanged();
    }

    public void addItem(Favorite favorite) {
        this.listFavorites.add(favorite);
        notifyItemInserted(listFavorites.size() - 1);
    }

    public void removeItem(int position) {
        this.listFavorites.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listFavorites.size());
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_card_view_movie, parent, false);
        return new FavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {
        String url_poster = "https://image.tmdb.org/t/p/w185"+ listFavorites.get(position).getPosterPath();

        holder.textTitleFavorite.setText(listFavorites.get(position).getTitle());
        holder.textReleaseFavorite.setText(listFavorites.get(position).getReleaseDate());
        holder.textOverviewFavorite.setText(listFavorites.get(position).getOverview());

        Glide.with(holder.itemView.getContext())
                .load(url_poster)
                .into(holder.imgPosterFavorite);

        holder.cardViewFavorite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                // Not Yet
            }
        }));
    }

    @Override
    public int getItemCount() {
        return listFavorites.size();
    }

    public class FavoriteViewHolder extends RecyclerView.ViewHolder {

        CardView cardViewFavorite;
        ImageView imgPosterFavorite;
        TextView textTitleFavorite, textReleaseFavorite, textOverviewFavorite;

        public FavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            cardViewFavorite = itemView.findViewById(R.id.card_view_movie);
            textTitleFavorite = itemView.findViewById(R.id.text_title);
            textReleaseFavorite = itemView.findViewById(R.id.text_release);
            textOverviewFavorite = itemView.findViewById(R.id.text_overview_movie);
            imgPosterFavorite = itemView.findViewById(R.id.image_poster);
        }
    }
}
