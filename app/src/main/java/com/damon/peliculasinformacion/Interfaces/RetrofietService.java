package com.damon.peliculasinformacion.Interfaces;

import com.damon.peliculasinformacion.Model.Movie.MovieDetails;
import com.damon.peliculasinformacion.Model.Movie.MovieImages;
import com.damon.peliculasinformacion.Model.Movie.MovieResponse;
import com.damon.peliculasinformacion.Model.Movie.MovieSimilar;
import com.damon.peliculasinformacion.Model.Movie.MovieVideos;
import com.damon.peliculasinformacion.Model.Movie.MoviesCredits;
import com.damon.peliculasinformacion.Model.Person.PersonDetailMovieCredits;
import com.damon.peliculasinformacion.Model.Person.PersonTvCredits;
import com.damon.peliculasinformacion.Model.Tv.TvDetailsCredits;
import com.damon.peliculasinformacion.Model.Person.PersonDetails;
import com.damon.peliculasinformacion.Model.Person.PersonImages;
import com.damon.peliculasinformacion.Model.Person.PersonsResponse;
import com.damon.peliculasinformacion.Model.Tv.TvDetails;
import com.damon.peliculasinformacion.Model.Tv.TvRecomendations;
import com.damon.peliculasinformacion.Model.Tv.TvSeasonsDetail;
import com.damon.peliculasinformacion.Model.Tv.TvShowsResponse;
import com.damon.peliculasinformacion.Model.Tv.TvVideos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofietService {


    //metodo para buscar pelicula por su nombre
    @GET("search/movie")
    Call<MovieResponse> getMoviesByQuery(@Query("api_key")String api_key,@Query("query")String query);

    //metodo para que salgan las peliculas mas populares
    @GET("movie/popular")
    Call<MovieResponse> getMoviesPopularByQuery(@Query("api_key")String api_key);

    //metodo para recuperar todos los detalles de la pelicula
    @GET("movie/{movie_id}?language=es-ES")
    Call<MovieDetails> getMovieDetailsById(@Path("movie_id")int movie_id, @Query("api_key")String api_key);

    // metodo para recuperar los actores de la pelicula
    @GET("movie/{movie_id}/credits")
    Call<MoviesCredits> getMovieCreditsById(@Path("movie_id")int movie_id, @Query("api_key")String api_key);

    //metodo para recuperar todas las fotos de la pelicula por su id
    @GET("movie/{movie_id}/images")
    Call<MovieImages> getMovieImagesById(@Path("movie_id")int movie_id, @Query("api_key")String api_key);

   //metodo para recuperar los videos que tenga por su id
    @GET("movie/{movie_id}/videos")
    Call<MovieVideos> getMovieVideosById(@Path("movie_id")int movie_id, @Query("api_key")String api_key);

    //metodo para recuperar las peliculas similares o recomendadas
    @GET("movie/{movie_id}/similar")
    Call<MovieSimilar> getMovieSimilarById(@Path("movie_id")int movie_id,@Query("api_key")String  api_key);


    //now create  a service form te person

    //before the create a model for person result

    //metodo para buscar el actor por su nombre
    @GET("search/person")
    Call<PersonsResponse> getPersonsByQuery(@Query("api_key")String api_key, @Query("query")String query);

    //metodo para recuperar todos los detalles del actor
    @GET("person/{person_id}")
    Call<PersonDetails> getPersonDetailsById(@Path("person_id")int person_id,@Query("api_key")String api_key);

    //metodo para recuperar las imagenes del actor por su id
    @GET("person/{person_id}/images")
    Call<PersonImages> getPersonImagesById(@Path("person_id")int person_id, @Query("api_key")String api_key);

    //metodo para recuperar las peliculas donde participe el actor
    @GET("person/{person_id}/movie_credits")
    Call<PersonDetailMovieCredits> getPersonMovieCredits(@Path("person_id")int person_id,@Query("api_key")String api_key);

    //metodo para recuperar las series donde participe el actor
    @GET("person/{person_id}/tv_credits")
    Call<PersonTvCredits> getPersonTvcredits(@Path("person_id")int person_id,@Query("api_key")String api_key);





    //metodo para repuerar las series o tv por su nombre
    @GET("search/tv")
    Call<TvShowsResponse> getTvShowByQuery(@Query("api_key")String api_key, @Query("query")String query);

    //metodo para recuperar todos lo datos de la tv o serie por su id
    @GET("tv/{tv_id}?language=es-MX")
    Call<TvDetails> getTvDetailsById(@Path("tv_id")int movie_id, @Query("api_key")String api_key);

    //metodo para recuperar los actores de la serie o tv
    @GET("tv/{tv_id}/credits")
    Call<TvDetailsCredits> getTvCreditsById(@Path("tv_id")int movie_id, @Query("api_key")String api_key);

    // metodo para recuperar todos las series mas vistas
    @GET("tv/popular")
    Call<TvShowsResponse> getTvPopular(@Query("api_key")String apikey);

    //metodo para recuérar los detalles de la serie por su numero de temporada
    @GET("tv/{tv_id}/season/{season_number}?language=es-ES")
    Call<TvSeasonsDetail> getTvSeasonDetail(@Path("tv_id")int movie_id, @Path("season_number") int season_number,@Query("api_key")String api_key);


    // metodo para recuperar los videos que tenga en su temporada
    @GET("tv/{tv_id}/season/{season_number}/videos")
    Call<TvVideos> getSeasonsVideo(@Path("tv_id")int movie_id, @Path("season_number") int season_number, @Query("api_key")String api_key);

    //metodo pare recuperar las recomendaciones de las series
    @GET("tv/{tv_id}/recommendations")
    Call<TvRecomendations> getTvRecomendations(@Path("tv_id") int tv_id,@Query("api_key")String api_key);

}
