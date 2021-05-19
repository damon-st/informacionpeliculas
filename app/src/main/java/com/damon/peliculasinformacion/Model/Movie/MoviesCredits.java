package com.damon.peliculasinformacion.Model.Movie;

import com.damon.peliculasinformacion.Model.Movie.MovieCreditsCats;
import com.damon.peliculasinformacion.Model.Movie.MovieCreditsCrew;

import java.util.List;

public class MoviesCredits {
    private Integer id;
    private List<MovieCreditsCats> cast;

    private List<MovieCreditsCrew> crew;

    public MoviesCredits() {
    }

    public MoviesCredits(Integer id, List<MovieCreditsCats> cast, List<MovieCreditsCrew> crew) {
        this.id = id;
        this.cast = cast;
        this.crew = crew;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<MovieCreditsCats> getCast() {
        return cast;
    }

    public void setCast(List<MovieCreditsCats> cast) {
        this.cast = cast;
    }

    public List<MovieCreditsCrew> getCrew() {
        return crew;
    }

    public void setCrew(List<MovieCreditsCrew> crew) {
        this.crew = crew;
    }
}
