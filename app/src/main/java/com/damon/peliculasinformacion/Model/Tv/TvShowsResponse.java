package com.damon.peliculasinformacion.Model.Tv;

import com.damon.peliculasinformacion.Model.Tv.TvResponseResults;

import java.util.List;

public class TvShowsResponse {

    private int page;
    private int total_results;
    private int total_pages;

    private List<TvResponseResults> results;

    public TvShowsResponse() {
    }

    public TvShowsResponse(int page, int total_results, int total_pages, List<TvResponseResults> results) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<TvResponseResults> getResults() {
        return results;
    }

    public void setResults(List<TvResponseResults> results) {
        this.results = results;
    }
}