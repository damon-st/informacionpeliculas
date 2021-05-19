package com.damon.peliculasinformacion.Model.Tv;

public class TvDetailsProductionCompanies {

    private Integer id;
    private String logo_path;
    private String name;
    private String original_country;

    public TvDetailsProductionCompanies() {
    }

    public TvDetailsProductionCompanies(Integer id, String logo_path, String name, String original_country) {
        this.id = id;
        this.logo_path = logo_path;
        this.name = name;
        this.original_country = original_country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogo_path() {
        String baseUrl = "https://image.tmdb.org/t/p/w500";
        return baseUrl+logo_path;
    }

    public void setLogo_path(String logo_path) {
        this.logo_path = logo_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginal_country() {
        return original_country;
    }

    public void setOriginal_country(String original_country) {
        this.original_country = original_country;
    }
}
