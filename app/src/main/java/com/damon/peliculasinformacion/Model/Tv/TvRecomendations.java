package com.damon.peliculasinformacion.Model.Tv;

import java.util.List;

public class TvRecomendations {

    private Integer page;
    private List<TvRecomendationsResults> results;
    private Integer total_pages;
    private Integer total_results;


    public TvRecomendations() {
    }

    public TvRecomendations(Integer page, List<TvRecomendationsResults> results, Integer total_pages, Integer total_results) {
        this.page = page;
        this.results = results;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<TvRecomendationsResults> getResults() {
        return results;
    }

    public void setResults(List<TvRecomendationsResults> results) {
        this.results = results;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }
}
