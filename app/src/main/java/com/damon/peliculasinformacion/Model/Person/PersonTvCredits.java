package com.damon.peliculasinformacion.Model.Person;

import java.util.List;

public class PersonTvCredits {

    private Integer id;

    private List<PersonTvCreditsCast> cast;


    public PersonTvCredits() {
    }

    public PersonTvCredits(Integer id, List<PersonTvCreditsCast> cast) {
        this.id = id;
        this.cast = cast;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PersonTvCreditsCast> getCast() {
        return cast;
    }

    public void setCast(List<PersonTvCreditsCast> cast) {
        this.cast = cast;
    }
}
