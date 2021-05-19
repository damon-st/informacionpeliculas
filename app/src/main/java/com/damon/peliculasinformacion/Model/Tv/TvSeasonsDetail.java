package com.damon.peliculasinformacion.Model.Tv;

import java.util.List;

public class TvSeasonsDetail {

//    private Integer _id;
//    private String air_date;
//    private List<TvSeasonsDetailEpisodes> episodes;
//    private String name;
//    private String overview;
//    private Integer id;
//    private String poster_path;
//    private Integer season_number;
//
//    public TvSeasonsDetail() {
//    }
//
//    public TvSeasonsDetail(Integer _id, String air_date, List<TvSeasonsDetailEpisodes> episodes, String name, String overview, Integer id, String poster_path, Integer season_number) {
//        this._id = _id;
//        this.air_date = air_date;
//        this.episodes = episodes;
//        this.name = name;
//        this.overview = overview;
//        this.id = id;
//        this.poster_path = poster_path;
//        this.season_number = season_number;
//    }
//
//    public Integer get_id() {
//        return _id;
//    }
//
//    public void set_id(Integer _id) {
//        this._id = _id;
//    }
//
//    public String getAir_date() {
//        return air_date;
//    }
//
//    public void setAir_date(String air_date) {
//        this.air_date = air_date;
//    }
//
//    public List<TvSeasonsDetailEpisodes> getEpisodes() {
//        return episodes;
//    }
//
//    public void setEpisodes(List<TvSeasonsDetailEpisodes> episodes) {
//        this.episodes = episodes;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getOverview() {
//        return overview;
//    }
//
//    public void setOverview(String overview) {
//        this.overview = overview;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getPoster_path() {
//        String baseUrl = "https://image.tmdb.org/t/p/w500";
//        return baseUrl+poster_path;
//    }
//
//    public void setPoster_path(String poster_path) {
//        this.poster_path = poster_path;
//    }
//
//    public Integer getSeason_number() {
//        return season_number;
//    }
//
//    public void setSeason_number(Integer season_number) {
//        this.season_number = season_number;
//    }


    private List<TvSeasonsDetailEpisodes> episodes;

    private Integer id;

    private String poster_path;

    private Integer season_number;

    private String name;

    private String air_date;




    public TvSeasonsDetail() {
    }


    public TvSeasonsDetail(List<TvSeasonsDetailEpisodes> episodes, Integer id, String poster_path, Integer season_number, String name, String air_date) {
        this.episodes = episodes;
        this.id = id;
        this.poster_path = poster_path;
        this.season_number = season_number;
        this.name = name;
        this.air_date = air_date;
    }

    public List<TvSeasonsDetailEpisodes> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<TvSeasonsDetailEpisodes> episodes) {
        this.episodes = episodes;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeason_number() {
        return season_number;
    }

    public void setSeason_number(Integer season_number) {
        this.season_number = season_number;
    }

    public String getPoster_path() {
        String baseUrl = "https://image.tmdb.org/t/p/w500";
        return baseUrl+poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
