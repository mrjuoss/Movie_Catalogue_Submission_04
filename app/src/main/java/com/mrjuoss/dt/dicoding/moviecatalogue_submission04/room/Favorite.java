package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Favorite implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String overview;
    private String releaseDate;
    private String posterPath;
    private String backdropPath;
    private String typeFavorite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getTypeFavorite() {
        return typeFavorite;
    }

    public void setTypeFavorite(String typeFavorite) {
        this.typeFavorite = typeFavorite;
    }
}
