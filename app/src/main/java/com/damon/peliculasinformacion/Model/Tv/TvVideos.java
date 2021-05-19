package com.damon.peliculasinformacion.Model.Tv;

import java.util.List;

public class TvVideos {

    private Integer id;


    private List<TvSeasonsVideoResults> results;


    public TvVideos() {
    }

    public TvVideos(Integer id, List<TvSeasonsVideoResults> results) {
        this.id = id;
        this.results = results;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<TvSeasonsVideoResults> getResults() {
        return results;
    }

    public void setResults(List<TvSeasonsVideoResults> results) {
        this.results = results;
    }
}
