package com.damon.peliculasinformacion.Model.Person;

import java.util.List;

public class PersonTvCreditsCast {



//    private String credit_id;
    private String original_name;
    private Integer id;
//    private List<Integer> genre_ids;
    private String character;
    private String name;
    private String poster_path;
//    private float vote_count;
//    private Double vote_average;
//    private Integer popularity;
//    private Integer episode_count;
//    private String original_lenguage;
//    private String first_air_date;
    private String backdrop_path;
//    private String overview;
//    private List<Integer> origin_country;

    public PersonTvCreditsCast() {
    }



    public PersonTvCreditsCast(String original_name, Integer id, String character, String name, String poster_path, String backdrop_path) {
        this.original_name = original_name;
        this.id = id;
        this.character = character;
        this.name = name;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoster_path() {
        String baseUrl = "https://image.tmdb.org/t/p/w500";
        return baseUrl+poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }



    public String getBackdrop_path() {
        String baseUrl = "https://image.tmdb.org/t/p/w500";
        return baseUrl+backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }


}

