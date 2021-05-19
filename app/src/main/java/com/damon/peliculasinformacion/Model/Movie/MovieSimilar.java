package com.damon.peliculasinformacion.Model.Movie;

import java.util.List;

public class MovieSimilar {

    private Integer page;
    private Integer total_pages;
    private Integer total_results;
    private List<MovieSimilarResults> results;


    public MovieSimilar() {
    }

    public MovieSimilar(Integer page, Integer total_pages, Integer total_results, List<MovieSimilarResults> results) {
        this.page = page;
        this.total_pages = total_pages;
        this.total_results = total_results;
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
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

    public List<MovieSimilarResults> getResults() {
        return results;
    }

    public void setResults(List<MovieSimilarResults> results) {
        this.results = results;
    }
}
