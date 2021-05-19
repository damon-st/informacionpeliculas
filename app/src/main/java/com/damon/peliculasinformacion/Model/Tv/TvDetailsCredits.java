package com.damon.peliculasinformacion.Model.Tv;

import com.damon.peliculasinformacion.Model.Tv.TvCreditsCast;
import com.damon.peliculasinformacion.Model.Tv.TvCreditsCrew;

import java.util.List;

public class TvDetailsCredits {



    private List<TvCreditsCast> cast;
    private List<TvCreditsCrew> crew;
    private Integer id;

    public TvDetailsCredits() {
    }

    public TvDetailsCredits(List<TvCreditsCast> cast, List<TvCreditsCrew> crew, Integer id) {
        this.cast = cast;
        this.crew = crew;
        this.id = id;
    }

    public List<TvCreditsCast> getCast() {
        return cast;
    }

    public void setCast(List<TvCreditsCast> cast) {
        this.cast = cast;
    }

    public List<TvCreditsCrew> getCrew() {
        return crew;
    }

    public void setCrew(List<TvCreditsCrew> crew) {
        this.crew = crew;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
