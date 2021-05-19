package com.damon.peliculasinformacion.Model.Person;

import java.util.List;

public class PersonsResponseResultsKnownFor {

    private float vote_average;
    private Integer vote_count;
    private Integer id;
    private boolean video;
    private String media_type;
    private String title;
    private Double popularity;
    private String poster_path;
    private String original_languague;
    private String original_title;

    //create a gener ids a integer

    private List<Integer> genre_ids;
    private String backdrop_path;
    private boolean adult;
    private String overview;

    private String release_data;

    public PersonsResponseResultsKnownFor() {
    }

    public PersonsResponseResultsKnownFor(float vote_average, Integer vote_count, Integer id, boolean video, String media_type, String title, Double popularity, String original_languague, String original_title, List<Integer> genre_ids, String backdrop_path, boolean adult, String overview, String release_data,String poster_path) {
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.id = id;
        this.video = video;
        this.media_type = media_type;
        this.title = title;
        this.popularity = popularity;
        this.original_languague = original_languague;
        this.original_title = original_title;
        this.genre_ids = genre_ids;
        this.backdrop_path = backdrop_path;
        this.adult = adult;
        this.overview = overview;
        this.release_data = release_data;
        this.poster_path = poster_path;
    }

    public String getPoster_path() {
        String baseUrl = "https://image.tmdb.org/t/p/w500";

        return baseUrl+poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPopularity() {

        return  popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getOriginal_languague() {
        return original_languague;
    }

    public void setOriginal_languague(String original_languague) {
        this.original_languague = original_languague;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_data() {
        return release_data;
    }

    public void setRelease_data(String release_data) {
        this.release_data = release_data;
    }
}


