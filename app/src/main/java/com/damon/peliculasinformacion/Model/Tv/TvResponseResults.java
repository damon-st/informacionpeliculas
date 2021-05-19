package com.damon.peliculasinformacion.Model.Tv;

import java.util.List;

public class TvResponseResults {

    private String original_name;
    private List<Integer> gener_ids;
    private String name;
    private float popularity;
    private List<String> original_country;
    private Integer vote_count;
    private String first_air_date;
    private String backdrop_path;
    private String original_language;
    private int id;
    private float vote_average;
    private String overview;
    private String  poster_path;

    public TvResponseResults() {
    }

    public TvResponseResults(String original_name, List<Integer> gener_ids, String name, float popularity, List<String> original_country, Integer vote_count, String first_air_date, String backdrop_path, String original_language, int id, float vote_average, String overview, String poster_path) {
        this.original_name = original_name;
        this.gener_ids = gener_ids;
        this.name = name;
        this.popularity = popularity;
        this.original_country = original_country;
        this.vote_count = vote_count;
        this.first_air_date = first_air_date;
        this.backdrop_path = backdrop_path;
        this.original_language = original_language;
        this.id = id;
        this.vote_average = vote_average;
        this.overview = overview;
        this.poster_path = poster_path;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public List<Integer> getGener_ids() {
        return gener_ids;
    }

    public void setGener_ids(List<Integer> gener_ids) {
        this.gener_ids = gener_ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public List<String> getOriginal_country() {
        return original_country;
    }

    public void setOriginal_country(List<String> original_country) {
        this.original_country = original_country;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public String getBackdrop_path() {
        String baseUrl = "https://image.tmdb.org/t/p/w500";
        return baseUrl+backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        String baseUrl = "https://image.tmdb.org/t/p/w500";
        return baseUrl+poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
