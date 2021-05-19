package com.damon.peliculasinformacion.Model.Tv;

import java.util.ArrayList;
import java.util.List;

public class TvDetails {

//    private String backdrop_path;
//    private List<TvDetailsCreateBy> created_by;
//    private List<Integer> episode_run_time;
//    private String first_airt_date;
//
//    private List<TvDetailsGenres> genres;
//
//    private String homepage;
//    private Integer id;
//    private boolean in_production;
//    private List<String> laguages;
//    private String last_air_date;
//    private List<TvDetailsLastEspisodeToAir> last_episode_to_air;
//    private String name;
//    private Integer next_episode_to_air;
//    private List<TvDetailsNetworks> networks;
//    private Integer number_of_episodes;
//    private Integer number_of_seasons;
//
//    private List<Integer> origin_country;
//    private String original_lenguage;
//    private String original_name;
//
//    private Double popularity;
//    private String poster_path;
//    private List<TvDetailsProductionCompanies> production_companies;
//    private List<TvDetailsSeasons> seasons;
//    private String status;
//    private String type;
//    private float vote_average;
//    private float vote_count;
//
//    public TvDetails() {
//    }
//
//    public TvDetails(String backdrop_path, List<TvDetailsCreateBy> created_by, List<Integer> episode_run_time, String first_airt_date, List<TvDetailsGenres> genres, String homepage, Integer id, boolean in_production, List<String> laguages, String last_air_date, List<TvDetailsLastEspisodeToAir> last_episode_to_air, String name, Integer next_episode_to_air, List<TvDetailsNetworks> networks, Integer number_of_episodes, Integer number_of_seasons, List<Integer> origin_country, String original_lenguage, String original_name, String overview, Double popularity, String poster_path, List<TvDetailsProductionCompanies> production_companies, List<TvDetailsSeasons> seasons, String status, String type, float vote_average, float vote_count) {
//        this.backdrop_path = backdrop_path;
//        this.created_by = created_by;
//        this.episode_run_time = episode_run_time;
//        this.first_airt_date = first_airt_date;
//        this.genres = genres;
//        this.homepage = homepage;
//        this.id = id;
//        this.in_production = in_production;
//        this.laguages = laguages;
//        this.last_air_date = last_air_date;
//        this.last_episode_to_air = last_episode_to_air;
//        this.name = name;
//        this.next_episode_to_air = next_episode_to_air;
//        this.networks = networks;
//        this.number_of_episodes = number_of_episodes;
//        this.number_of_seasons = number_of_seasons;
//        this.origin_country = origin_country;
//        this.original_lenguage = original_lenguage;
//        this.original_name = original_name;
//        this.overview = overview;
//        this.popularity = popularity;
//        this.poster_path = poster_path;
//        this.production_companies = production_companies;
//        this.seasons = seasons;
//        this.status = status;
//        this.type = type;
//        this.vote_average = vote_average;
//        this.vote_count = vote_count;
//    }
//
//    public String getBackdrop_path() {
//        String baseUrl = "https://image.tmdb.org/t/p/w500";
//        return baseUrl+backdrop_path;
//    }
//
//    public void setBackdrop_path(String backdrop_path) {
//        this.backdrop_path = backdrop_path;
//    }
//
//    public List<TvDetailsCreateBy> getCreated_by() {
//        return created_by;
//    }
//
//    public void setCreated_by(List<TvDetailsCreateBy> created_by) {
//        this.created_by = created_by;
//    }
//
//    public List<Integer> getEpisode_run_time() {
//        return episode_run_time;
//    }
//
//    public void setEpisode_run_time(List<Integer> episode_run_time) {
//        this.episode_run_time = episode_run_time;
//    }
//
//    public String getFirst_airt_date() {
//        return first_airt_date;
//    }
//
//    public void setFirst_airt_date(String first_airt_date) {
//        this.first_airt_date = first_airt_date;
//    }
//
//    public List<TvDetailsGenres> getGenres() {
//        return genres;
//    }
//
//    public void setGenres(List<TvDetailsGenres> genres) {
//        this.genres = genres;
//    }
//
//    public String getHomepage() {
//        return homepage;
//    }
//
//    public void setHomepage(String homepage) {
//        this.homepage = homepage;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public boolean isIn_production() {
//        return in_production;
//    }
//
//    public void setIn_production(boolean in_production) {
//        this.in_production = in_production;
//    }
//
//    public List<String> getLaguages() {
//        return laguages;
//    }
//
//    public void setLaguages(List<String> laguages) {
//        this.laguages = laguages;
//    }
//
//    public String getLast_air_date() {
//        return last_air_date;
//    }
//
//    public void setLast_air_date(String last_air_date) {
//        this.last_air_date = last_air_date;
//    }
//
//    public List<TvDetailsLastEspisodeToAir> getLast_episode_to_air() {
//        return last_episode_to_air;
//    }
//
//    public void setLast_episode_to_air(List<TvDetailsLastEspisodeToAir> last_episode_to_air) {
//        this.last_episode_to_air = last_episode_to_air;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getNext_episode_to_air() {
//        return next_episode_to_air;
//    }
//
//    public void setNext_episode_to_air(Integer next_episode_to_air) {
//        this.next_episode_to_air = next_episode_to_air;
//    }
//
//    public List<TvDetailsNetworks> getNetworks() {
//        return networks;
//    }
//
//    public void setNetworks(List<TvDetailsNetworks> networks) {
//        this.networks = networks;
//    }
//
//    public Integer getNumber_of_episodes() {
//        return number_of_episodes;
//    }
//
//    public void setNumber_of_episodes(Integer number_of_episodes) {
//        this.number_of_episodes = number_of_episodes;
//    }
//
//    public Integer getNumber_of_seasons() {
//        return number_of_seasons;
//    }
//
//    public void setNumber_of_seasons(Integer number_of_seasons) {
//        this.number_of_seasons = number_of_seasons;
//    }
//
//    public List<Integer> getOrigin_country() {
//        return origin_country;
//    }
//
//    public void setOrigin_country(List<Integer> origin_country) {
//        this.origin_country = origin_country;
//    }
//
//    public String getOriginal_lenguage() {
//        return original_lenguage;
//    }
//
//    public void setOriginal_lenguage(String original_lenguage) {
//        this.original_lenguage = original_lenguage;
//    }
//
//    public String getOriginal_name() {
//        return original_name;
//    }
//
//    public void setOriginal_name(String original_name) {
//        this.original_name = original_name;
//    }
//
//    public String getOverview() {
//        return overview;
//    }
//
//    public void setOverview(String overview) {
//        this.overview = overview;
//    }
//
//    public Double getPopularity() {
//        return popularity;
//    }
//
//    public void setPopularity(Double popularity) {
//        this.popularity = popularity;
//    }
//
//    public String getPoster_path() {
//        String baseUrl = "https://image.tmdb.org/t/p/w500";
//        return baseUrl+poster_path;
//    }
//
//    public void setPoster_path(String poster_path) {
//        this.poster_path = poster_path;
//    }
//
//    public List<TvDetailsProductionCompanies> getProduction_companies() {
//        return production_companies;
//    }
//
//    public void setProduction_companies(List<TvDetailsProductionCompanies> production_companies) {
//        this.production_companies = production_companies;
//    }
//
//    public List<TvDetailsSeasons> getSeasons() {
//        return seasons;
//    }
//
//    public void setSeasons(List<TvDetailsSeasons> seasons) {
//        this.seasons = seasons;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public float getVote_average() {
//        return vote_average;
//    }
//
//    public void setVote_average(float vote_average) {
//        this.vote_average = vote_average;
//    }
//
//    public float getVote_count() {
//        return vote_count;
//    }
//
//    public void setVote_count(float vote_count) {
//        this.vote_count = vote_count;
//    }



    private String backdrop_path;

    private List<TvDetailsCreateBy> created_by;

    private Integer id;

    private String poster_path;

    private List<TvDetailsProductionCompanies> production_companies;

    private String original_name;

    private String overview;

    private Double vote_average;

    private String status;

    private String first_air_date;

    private boolean in_production;

    private List<TvDetailsGenres> genres;

    private String homepage;

    private String original_language;

    private List<TvDetailsSeasons> seasons;

    private Integer number_of_episodes;

    private Integer number_of_seasons;

    private List<Integer> episode_run_time;

    private TvDetailsLastEspisodeToAir   last_episode_to_air;

    private TvDetailsNextEpisodeToAir next_episode_to_air;

    private String last_air_date;

    public TvDetails() {
    }

    public TvDetails(String backdrop_path, List<TvDetailsCreateBy> created_by, Integer id, String poster_path, List<TvDetailsProductionCompanies> production_companies, String original_name, String overview, Double vote_average, String status, String first_air_date, boolean in_production, List<TvDetailsGenres> genres, String homepage, String original_language, List<TvDetailsSeasons> seasons, Integer number_of_episodes, Integer number_of_seasons, List<Integer> episode_run_time, TvDetailsLastEspisodeToAir last_episode_to_air, TvDetailsNextEpisodeToAir next_episode_to_air, String last_air_date) {
        this.backdrop_path = backdrop_path;
        this.created_by = created_by;
        this.id = id;
        this.poster_path = poster_path;
        this.production_companies = production_companies;
        this.original_name = original_name;
        this.overview = overview;
        this.vote_average = vote_average;
        this.status = status;
        this.first_air_date = first_air_date;
        this.in_production = in_production;
        this.genres = genres;
        this.homepage = homepage;
        this.original_language = original_language;
        this.seasons = seasons;
        this.number_of_episodes = number_of_episodes;
        this.number_of_seasons = number_of_seasons;
        this.episode_run_time = episode_run_time;
        this.last_episode_to_air = last_episode_to_air;
        this.next_episode_to_air = next_episode_to_air;
        this.last_air_date = last_air_date;
    }

    public TvDetailsNextEpisodeToAir getNext_episode_to_air() {
        return next_episode_to_air;
    }

    public void setNext_episode_to_air(TvDetailsNextEpisodeToAir next_episode_to_air) {
        this.next_episode_to_air = next_episode_to_air;
    }

    public TvDetailsLastEspisodeToAir getLast_episode_to_air() {
        return last_episode_to_air;
    }

    public void setLast_episode_to_air(TvDetailsLastEspisodeToAir last_episode_to_air) {
        this.last_episode_to_air = last_episode_to_air;
    }

    public String getLast_air_date() {
        return last_air_date;
    }

    public void setLast_air_date(String last_air_date) {
        this.last_air_date = last_air_date;
    }

    public List<Integer> getEpisode_run_time() {
        return episode_run_time;
    }

    public void setEpisode_run_time(List<Integer> episode_run_time) {
        this.episode_run_time = episode_run_time;
    }

    public Integer getNumber_of_seasons() {
        return number_of_seasons;
    }

    public void setNumber_of_seasons(Integer number_of_seasons) {
        this.number_of_seasons = number_of_seasons;
    }

    public Integer getNumber_of_episodes() {
        return number_of_episodes;
    }

    public void setNumber_of_episodes(Integer number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }

    public List<TvDetailsSeasons> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<TvDetailsSeasons> seasons) {
        this.seasons = seasons;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public List<TvDetailsGenres> getGenres() {
        return genres;
    }

    public void setGenres(List<TvDetailsGenres> genres) {
        this.genres = genres;
    }

    public boolean isIn_production() {
        return in_production;
    }

    public void setIn_production(boolean in_production) {
        this.in_production = in_production;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public List<TvDetailsProductionCompanies> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<TvDetailsProductionCompanies> production_companies) {
        this.production_companies = production_companies;
    }

    public String getBackdrop_path() {
        String baseUrl = "https://image.tmdb.org/t/p/w500";

        return baseUrl+backdrop_path;
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

    public String getPoster_path() {
        String baseUrl = "https://image.tmdb.org/t/p/w500";

        return baseUrl+poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<TvDetailsCreateBy> getCreated_by() {
        return created_by;
    }

    public void setCreated_by(List<TvDetailsCreateBy> created_by) {
        this.created_by = created_by;
    }
}
