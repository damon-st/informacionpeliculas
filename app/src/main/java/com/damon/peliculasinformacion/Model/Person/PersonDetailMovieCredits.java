package com.damon.peliculasinformacion.Model.Person;

import java.util.List;

public class PersonDetailMovieCredits {

    private Integer id;
    private List<PersonDetailMovieCreditsCast> cast;

    public PersonDetailMovieCredits() {
    }

    public PersonDetailMovieCredits(Integer id, List<PersonDetailMovieCreditsCast> cast) {
        this.id = id;
        this.cast = cast;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PersonDetailMovieCreditsCast> getCast() {
        return cast;
    }

    public void setCast(List<PersonDetailMovieCreditsCast> cast) {
        this.cast = cast;
    }
}
