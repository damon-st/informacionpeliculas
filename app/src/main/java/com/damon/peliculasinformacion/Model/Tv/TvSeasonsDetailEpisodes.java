package com.damon.peliculasinformacion.Model.Tv;

import java.util.List;

public class TvSeasonsDetailEpisodes {

//    private String air_date;
//    private int episode_number;
//    private Integer id;
//    private String name;
//    private String overview;
//    private Integer production_code;
//    private int season_number;
//    private Integer show_id;
//    private String still_path;
//    private long vote_average;
//    private long vote_count;
//    private List<TvCreditsCrew> crew;


    private String still_path;
    private String name;
    private Integer episode_number;
    private Double vote_average;
    private String overview;


    public TvSeasonsDetailEpisodes() {
    }


    public TvSeasonsDetailEpisodes(String still_path, String name, Integer episode_number, Double vote_average, String overview) {
        this.still_path = still_path;
        this.name = name;
        this.episode_number = episode_number;
        this.vote_average = vote_average;
        this.overview = overview;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public Integer getEpisode_number() {
        return episode_number;
    }

    public void setEpisode_number(Integer episode_number) {
        this.episode_number = episode_number;
    }

    public String getStill_path() {
        String baseUrl = "https://image.tmdb.org/t/p/w500";
        return baseUrl+still_path;
    }

    public void setStill_path(String still_path) {
        this.still_path = still_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
