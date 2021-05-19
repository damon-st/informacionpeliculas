package com.damon.peliculasinformacion.Model.Tv;

public class TvRecomendationsResults {

    private String backdrop_path;
    private String name;
    private Integer id;

    public TvRecomendationsResults() {
    }

    public TvRecomendationsResults(String backdrop_path, String name, Integer id) {
        this.backdrop_path = backdrop_path;
        this.name = name;
        this.id = id;
    }

    public String getBackdrop_path() {
        String baseUrl = "https://image.tmdb.org/t/p/w500";

        return baseUrl+ backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
