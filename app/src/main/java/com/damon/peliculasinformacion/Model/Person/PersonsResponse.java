package com.damon.peliculasinformacion.Model.Person;

import java.util.List;

public class PersonsResponse {

    private int page;
    private int total_results;
    private int total_pages;
    private List<PersonsResponseResults> results;

    public PersonsResponse() {
    }

    public PersonsResponse(int page, int total_results, int total_pages, List<PersonsResponseResults> results) {
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

    public List<PersonsResponseResults> getResults() {
        return results;
    }

    public void setResults(List<PersonsResponseResults> results) {
        this.results = results;
    }
}
