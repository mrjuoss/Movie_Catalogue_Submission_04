package com.mrjuoss.dt.dicoding.moviecatalogue_submission04.model.tv;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem implements Parcelable {

	@SerializedName("first_air_date")
	private String firstAirDate;

	@SerializedName("overview")
	private String overview;

	@SerializedName("original_language")
	private String originalLanguage;

	@SerializedName("genre_ids")
	private List<Integer> genreIds;

	@SerializedName("poster_path")
	private String posterPath;

	@SerializedName("origin_country")
	private List<String> originCountry;

	@SerializedName("backdrop_path")
	private String backdropPath;

	@SerializedName("original_name")
	private String originalName;

	@SerializedName("popularity")
	private double popularity;

	@SerializedName("vote_average")
	private double voteAverage;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("vote_count")
	private int voteCount;

	public void setFirstAirDate(String firstAirDate){
		this.firstAirDate = firstAirDate;
	}

	public String getFirstAirDate(){
		return firstAirDate;
	}

	public void setOverview(String overview){
		this.overview = overview;
	}

	public String getOverview(){
		return overview;
	}

	public void setOriginalLanguage(String originalLanguage){
		this.originalLanguage = originalLanguage;
	}

	public String getOriginalLanguage(){
		return originalLanguage;
	}

	public void setGenreIds(List<Integer> genreIds){
		this.genreIds = genreIds;
	}

	public List<Integer> getGenreIds(){
		return genreIds;
	}

	public void setPosterPath(String posterPath){
		this.posterPath = posterPath;
	}

	public String getPosterPath(){
		return posterPath;
	}

	public void setOriginCountry(List<String> originCountry){
		this.originCountry = originCountry;
	}

	public List<String> getOriginCountry(){
		return originCountry;
	}

	public void setBackdropPath(String backdropPath){
		this.backdropPath = backdropPath;
	}

	public String getBackdropPath(){
		return backdropPath;
	}

	public void setOriginalName(String originalName){
		this.originalName = originalName;
	}

	public String getOriginalName(){
		return originalName;
	}

	public void setPopularity(double popularity){
		this.popularity = popularity;
	}

	public double getPopularity(){
		return popularity;
	}

	public void setVoteAverage(double voteAverage){
		this.voteAverage = voteAverage;
	}

	public double getVoteAverage(){
		return voteAverage;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setVoteCount(int voteCount){
		this.voteCount = voteCount;
	}

	public int getVoteCount(){
		return voteCount;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.firstAirDate);
		dest.writeString(this.overview);
		dest.writeString(this.originalLanguage);
		dest.writeList(this.genreIds);
		dest.writeString(this.posterPath);
		dest.writeStringList(this.originCountry);
		dest.writeString(this.backdropPath);
		dest.writeString(this.originalName);
		dest.writeDouble(this.popularity);
		dest.writeDouble(this.voteAverage);
		dest.writeString(this.name);
		dest.writeInt(this.id);
		dest.writeInt(this.voteCount);
	}

	public ResultsItem() {
	}

	protected ResultsItem(Parcel in) {
		this.firstAirDate = in.readString();
		this.overview = in.readString();
		this.originalLanguage = in.readString();
		this.genreIds = new ArrayList<Integer>();
		in.readList(this.genreIds, Integer.class.getClassLoader());
		this.posterPath = in.readString();
		this.originCountry = in.createStringArrayList();
		this.backdropPath = in.readString();
		this.originalName = in.readString();
		this.popularity = in.readDouble();
		this.voteAverage = in.readDouble();
		this.name = in.readString();
		this.id = in.readInt();
		this.voteCount = in.readInt();
	}

	public static final Parcelable.Creator<ResultsItem> CREATOR = new Parcelable.Creator<ResultsItem>() {
		@Override
		public ResultsItem createFromParcel(Parcel source) {
			return new ResultsItem(source);
		}

		@Override
		public ResultsItem[] newArray(int size) {
			return new ResultsItem[size];
		}
	};
}