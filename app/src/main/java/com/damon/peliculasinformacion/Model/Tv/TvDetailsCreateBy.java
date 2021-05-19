package com.damon.peliculasinformacion.Model.Tv;

public class TvDetailsCreateBy {
    private Integer id;
    private String credit_id;
    private String name;
    private int gender;
    private String profile_path;

    public TvDetailsCreateBy() {
    }

    public TvDetailsCreateBy(Integer id, String credit_id, String name, int gender, String profile_path) {
        this.id = id;
        this.credit_id = credit_id;
        this.name = name;
        this.gender = gender;
        this.profile_path = profile_path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getProfile_path() {
        String baseUrl = "https://image.tmdb.org/t/p/w500";
        return baseUrl+ profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }
}
