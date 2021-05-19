package com.damon.peliculasinformacion.Model.Movie;

public class MovieSimilarResults {

    private String backdrop_path;
    private Integer id;
    private String title;

    public MovieSimilarResults() {
    }

    public MovieSimilarResults(String backdrop_path, Integer id, String title) {
        this.backdrop_path = backdrop_path;
        this.id = id;
        this.title = title;
    }

    public String getBackdrop_path() {
        String baseUrl = "https://image.tmdb.org/t/p/w500";
        return baseUrl+ backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
