package com.damon.peliculasinformacion.Model.Tv;

public class TvDetailsLastEspisodeToAir {

    private String air_date;
    private Integer episode_number;
    private Integer id;
    private String name;
    private String overview;
    private String production_code;
    private Integer season_number;
    private Integer show_id;
    private String still_path;
    private Double vote_average;
    private long vote_count;





    public TvDetailsLastEspisodeToAir() {
    }

    public TvDetailsLastEspisodeToAir(String air_date, Integer episode_number, Integer id, String name, String overview, String production_code, Integer season_number, Integer show_id, String still_path, Double vote_average, long vote_count) {
        this.air_date = air_date;
        this.episode_number = episode_number;
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.production_code = production_code;
        this.season_number = season_number;
        this.show_id = show_id;
        this.still_path = still_path;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public Integer getEpisode_number() {
        return episode_number;
    }

    public void setEpisode_number(Integer episode_number) {
        this.episode_number = episode_number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduction_code() {
        return production_code;
    }

    public void setProduction_code(String production_code) {
        this.production_code = production_code;
    }

    public Integer getSeason_number() {
        return season_number;
    }

    public void setSeason_number(Integer season_number) {
        this.season_number = season_number;
    }

    public Integer getShow_id() {
        return show_id;
    }

    public void setShow_id(Integer show_id) {
        this.show_id = show_id;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public long getVote_count() {
        return vote_count;
    }

    public void setVote_count(long vote_count) {
        this.vote_count = vote_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getStill_path() {
        String baseUrl = "https://image.tmdb.org/t/p/w500";
        return baseUrl+still_path;
    }

    public void setStill_path(String still_path) {
        this.still_path = still_path;
    }
}
