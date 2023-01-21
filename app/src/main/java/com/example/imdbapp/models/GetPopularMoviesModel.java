package com.example.imdbapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.versionedparcelable.ParcelField;
import androidx.versionedparcelable.VersionedParcelize;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

@VersionedParcelize
public class GetPopularMoviesModel{
    @SerializedName("original_language")
    public String original_language;

    @SerializedName("original_title")
    public String original_title;

    @SerializedName("popularity")
    public Double popularity;

    @SerializedName("release_date")
    public String release_date;

    @SerializedName("genre_ids")
    private List<Integer> genreIds = new ArrayList<Integer>();

    @SerializedName("overview")
    public String overview;

    @SerializedName("title")
    public String title;

    @SerializedName("id")
    public Integer movieId;

    @SerializedName("poster_path")
    public String poster_path;

    @SerializedName("backdrop_path")
    public String backdrop_path;

    @SerializedName("vote_average")
    public Double vote_average;

    @SerializedName("vote_count")
    public Integer vote_count;

    @SerializedName("adult")
    public String adult;

    @SerializedName("video")
    public boolean video;

    public GetPopularMoviesModel(String original_language, String original_title, Double popularity, String release_date, List<Integer> genreIds, String overview, String title, Integer movieId, String poster_path, String backdrop_path, Double vote_average, Integer vote_count, String adult, boolean video) {
        this.original_language = original_language;
        this.original_title = original_title;
        this.popularity = popularity;
        this.release_date = release_date;
        this.genreIds = genreIds;
        this.overview = overview;
        this.title = title;
        this.movieId = movieId;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.adult = adult;
        this.video = video;
    }
//sekili gosteren BASE_URL
//    String baseImageUrl = "https://image.tmdb.org/t/p/w500";

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getPoster_path() {
        return "https://image.tmdb.org/t/p/w500" + poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }



}
