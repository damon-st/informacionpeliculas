package com.damon.peliculasinformacion.Model.Tv;

public class TvDetailsNetworks {
    private String name;
    private Integer id;
    private String logo_path;
    private String origin_country;

    public TvDetailsNetworks() {
    }

    public TvDetailsNetworks(String name, Integer id, String logo_path, String origin_country) {
        this.name = name;
        this.id = id;
        this.logo_path = logo_path;
        this.origin_country = origin_country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }
}
