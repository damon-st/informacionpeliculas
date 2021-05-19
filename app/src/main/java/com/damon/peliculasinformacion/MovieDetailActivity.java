package com.damon.peliculasinformacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.codewaves.youtubethumbnailview.ThumbnailLoader;
import com.damon.peliculasinformacion.Adapters.MovieCreditsCastAdapter;
import com.damon.peliculasinformacion.Adapters.MovieCreditsCrewAdapter;
import com.damon.peliculasinformacion.Adapters.MovieProductionCompaniesAdapter;
import com.damon.peliculasinformacion.Adapters.MovieSimilarAdapter;
import com.damon.peliculasinformacion.Adapters.MovieVideosAdapter;
import com.damon.peliculasinformacion.Adapters.MoviesPosterImagesAdapter;
import com.damon.peliculasinformacion.Client.RetrofitClient;
import com.damon.peliculasinformacion.Interfaces.RetrofietService;
import com.damon.peliculasinformacion.Model.Movie.MovieCreditsCats;
import com.damon.peliculasinformacion.Model.Movie.MovieCreditsCrew;
import com.damon.peliculasinformacion.Model.Movie.MovieDetails;
import com.damon.peliculasinformacion.Model.Movie.MovieDetailsGenres;
import com.damon.peliculasinformacion.Model.Movie.MovieDetailsProductionCompanies;
import com.damon.peliculasinformacion.Model.Movie.MovieDetailsProductionCountries;
import com.damon.peliculasinformacion.Model.Movie.MovieImages;
import com.damon.peliculasinformacion.Model.Movie.MovieImagesBackDropsAndPosters;
import com.damon.peliculasinformacion.Model.Movie.MovieSimilar;
import com.damon.peliculasinformacion.Model.Movie.MovieSimilarResults;
import com.damon.peliculasinformacion.Model.Movie.MovieVideos;
import com.damon.peliculasinformacion.Model.Movie.MovieVideosResults;
import com.damon.peliculasinformacion.Model.Movie.MoviesCredits;
import com.damon.peliculasinformacion.Model.Movie.MoviesDetailsSpokenLanguages;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.github.lzyzsd.circleprogress.ArcProgress;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailActivity extends AppCompatActivity {

    private KenBurnsView movieDetailPosterImageView;
    private CircleImageView movieDetailBackDropPosterCircleImageView;
    private ArcProgress movieDetailRationBar;

    private LinearLayoutCompat movieDetailOriginalTitleLayout;
    private LinearLayoutCompat movieDetailOriginalLanguagueLayout;
    private LinearLayoutCompat movieDetailAdultLayout;
    private LinearLayoutCompat movieDetailStatusLayout;
    private LinearLayoutCompat movieDetailRuntimeLayout;
    private LinearLayoutCompat movieDetailBudgetLayout;
    private LinearLayoutCompat movieDetailRevenueLayout;
    private LinearLayoutCompat movieDetailGenreLayout;
    private LinearLayoutCompat movieDetailProductionCountryLayout;
    private LinearLayoutCompat movieDetailReleaseDateLayout;
    private LinearLayoutCompat movieDetailHomePageLayout;
    private LinearLayoutCompat movieDetailOverviewLayout;
    private LinearLayoutCompat movieDetailCastLayout;
    private LinearLayoutCompat movieDetailCrewLayout;
    private LinearLayoutCompat movieDetailProductionCompanyLayout;
    private LinearLayoutCompat movieDetailImagesLayout;
    private LinearLayoutCompat movieDetailVideosLayout;
    private LinearLayoutCompat movie_detail_similar_layout;




    private AppCompatTextView movieDetailTitle;
    private AppCompatTextView movieDetailOriginalTitle;
    private AppCompatTextView movieDetailOriginalLanguague;
    private AppCompatTextView movieDetailAdult;
    private AppCompatTextView movieDetailStatus;
    private AppCompatTextView movieDetailRuntime;
    private AppCompatTextView movieDetailBudget;
    private AppCompatTextView movieDetailRevenue;
    private AppCompatTextView movieDetailGenre;
    private AppCompatTextView movieDetailProductionCountry;
    private AppCompatTextView movieDetailReleaseDate;
    private AppCompatTextView movieDetailHomePage;
    private AppCompatTextView movieDetailOverview;

    private RecyclerView movieDetailCastRecyclerView;
    private RecyclerView movieDetailCrewRecyclerView;
    private RecyclerView movieDetailProductionCompanyRecyclerView;
    private RecyclerView movieDetailImagesRecyclerView;
    private RecyclerView movieDetailVideosRecyclerView;
    private RecyclerView movie_detail_similar_recyclerView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Intent intent = getIntent();

        RetrofietService retrofietService = RetrofitClient.getClient().create(RetrofietService.class);

        ThumbnailLoader.initialize(BuildConfig.THE_YOUTUBE_API_KEY);

        movieDetailPosterImageView = findViewById(R.id.movie_detail_poster_image_view);
        movieDetailBackDropPosterCircleImageView = findViewById(R.id.movie_detail_poster_circle_image_view);
        movieDetailRationBar = findViewById(R.id.movie_detail_rating_bar);

        movieDetailOriginalTitleLayout = findViewById(R.id.movie_detail_original_title_layout);
        movieDetailOriginalLanguagueLayout = findViewById(R.id.movie_detail_original_language_layout);
        movieDetailAdultLayout = findViewById(R.id.movie_detail_Adult_layout);
        movieDetailStatusLayout = findViewById(R.id.movie_detail_status_layout);
        movieDetailRuntimeLayout  = findViewById(R.id.movie_detail_runtime_layout);
        movieDetailBudgetLayout = findViewById(R.id.movie_detail_budget_layout);
        movieDetailRevenueLayout = findViewById(R.id.movie_detail_revenue_layout);
        movieDetailGenreLayout = findViewById(R.id.movie_detail_genre_layout);
        movieDetailProductionCountryLayout = findViewById(R.id.movie_detail_production_country_layout);
        movieDetailReleaseDateLayout = findViewById(R.id.movie_detail_release_date_layout);
        movieDetailHomePageLayout = findViewById(R.id.movie_detail_homepage_layout);
        movieDetailOverviewLayout = findViewById(R.id.movie_detail_overview_layout);
        movieDetailCastLayout = findViewById(R.id.movie_detail_cast_layout);
        movieDetailCrewLayout = findViewById(R.id.movie_detail_crew_layout);
        movieDetailProductionCompanyLayout = findViewById(R.id.movie_detail_production_company_layout);
        movieDetailImagesLayout  = findViewById(R.id.movie_detail_images_layout);
        movieDetailVideosLayout  = findViewById(R.id.movie_detail_videos_layout);
        movie_detail_similar_layout = findViewById(R.id.movie_detail_similar_layout);


        movieDetailTitle = findViewById(R.id.movie_detail_title);
        movieDetailOriginalTitle = findViewById(R.id.movie_detail_original_title);
        movieDetailOriginalLanguague = findViewById(R.id.movie_detail_original_language);
        movieDetailAdult= findViewById(R.id.movie_detail_adult);
        movieDetailStatus = findViewById(R.id.movie_detail_status);
        movieDetailRuntime  = findViewById(R.id.movie_detail_runtime);
        movieDetailBudget = findViewById(R.id.movie_detail_budget);
        movieDetailRevenue = findViewById(R.id.movie_detail_reveue);
        movieDetailGenre = findViewById(R.id.movie_detail_genre);
        movieDetailProductionCountry = findViewById(R.id.movie_detail_production_country);
        movieDetailReleaseDate = findViewById(R.id.movie_detail_release_date);
        movieDetailHomePage = findViewById(R.id.movie_detail_homepage);
        movieDetailOverview = findViewById(R.id.movie_detail_overview);

        movieDetailCastRecyclerView = findViewById(R.id.movie_detail_cast_recyclerView);
        movieDetailCastRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        movieDetailCrewRecyclerView = findViewById(R.id.movie_detail_crew_recyclerView);
        movieDetailCrewRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        movieDetailProductionCompanyRecyclerView = findViewById(R.id.movie_detail_production_company_recyclerView);
        movieDetailProductionCompanyRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        movieDetailImagesRecyclerView = findViewById(R.id.movie_detail_images_recyclerView);
        movieDetailImagesRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        movieDetailVideosRecyclerView = findViewById(R.id.movie_detail_videos_recyclerView);
        movieDetailVideosRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


        movie_detail_similar_recyclerView = findViewById(R.id.movie_detail_similar_recyclerView);
        movie_detail_similar_recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        if (intent !=null && intent.getExtras() !=null){

            if (intent.getExtras().getString("id")!=null ){

                int id = Integer.parseInt(intent.getExtras().getString("id"));

                Call<MovieDetails> movieDetailsCall = retrofietService.getMovieDetailsById(id,BuildConfig.THE_MOVIE_DB_API_KEY);



                movieDetailsCall.enqueue(new Callback<MovieDetails>() {
                    @Override
                    public void onResponse(@NonNull Call<MovieDetails> call, @NonNull Response<MovieDetails> response) {

                        MovieDetails movieDetailsReponse =response.body();

                        if (movieDetailsReponse !=null){
                           prepareDetails(movieDetailsReponse) ;
                        }

                    }

                    @Override
                    public void onFailure(@NonNull  Call<MovieDetails> call, @NonNull  Throwable t) {

                    }
                });

                Call<MoviesCredits> moviesCreditsCall = retrofietService.getMovieCreditsById(id,BuildConfig.THE_MOVIE_DB_API_KEY);

                moviesCreditsCall.enqueue(new Callback<MoviesCredits>() {
                    @Override
                    public void onResponse(@NonNull Call<MoviesCredits> call, @NonNull Response<MoviesCredits> response) {

                        MoviesCredits moviesCreditsReponse =response.body();

                        if (moviesCreditsReponse !=null){

                            List<MovieCreditsCats> movieCreditsCatsList = moviesCreditsReponse.getCast();
                            if (movieCreditsCatsList!=null && movieCreditsCatsList.size()>0){

                                MovieCreditsCastAdapter movieCreditsCastAdapter = new MovieCreditsCastAdapter(MovieDetailActivity.this,movieCreditsCatsList);
                                movieDetailCastRecyclerView.setAdapter(movieCreditsCastAdapter);

                                movieDetailCastLayout.setVisibility(View.VISIBLE);

                                LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MovieDetailActivity.this,R.anim.layout_slide_right);
                                movieDetailCastRecyclerView.setLayoutAnimation(controller);
                                movieDetailCastRecyclerView.scheduleLayoutAnimation();

                            }else {
                                movieDetailCastLayout.setVisibility(View.GONE);
                            }

                            List<MovieCreditsCrew> movieCreditsCrewList = moviesCreditsReponse.getCrew();
                            if (movieCreditsCrewList!=null && movieCreditsCrewList.size()>0){

                                MovieCreditsCrewAdapter movieCreditsCrewAdapter = new MovieCreditsCrewAdapter(MovieDetailActivity.this,movieCreditsCrewList);
                                movieDetailCrewRecyclerView.setAdapter(movieCreditsCrewAdapter);

                                movieDetailCrewLayout.setVisibility(View.VISIBLE);

                                LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MovieDetailActivity.this,R.anim.layout_slide_right);
                                movieDetailCrewRecyclerView.setLayoutAnimation(controller);
                                movieDetailCrewRecyclerView.scheduleLayoutAnimation();

                            }else {
                                movieDetailCrewLayout.setVisibility(View.GONE);
                            }

                        }else {
                            movieDetailCastLayout.setVisibility(View.GONE);
                            movieDetailCrewLayout.setVisibility(View.GONE);
                        }

                    }

                    @Override
                    public void onFailure(@NonNull  Call<MoviesCredits> call, @NonNull  Throwable t) {

                    }
                });

                Call<MovieImages> movieImagesCall = retrofietService.getMovieImagesById(id,BuildConfig.THE_MOVIE_DB_API_KEY);

               movieImagesCall.enqueue(new Callback<MovieImages>() {
                   @Override
                   public void onResponse(@NonNull Call<MovieImages> call,@NonNull Response<MovieImages> response) {
                       MovieImages movieImages = response.body();

                       if (movieImages!=null){
                           ArrayList<MovieImagesBackDropsAndPosters> movieImagesBackDropsAndPostersArrayList = new ArrayList<>();

                           List<MovieImagesBackDropsAndPosters> movieImagesBackDropsList = movieImages.getBackdrops();
                           List<MovieImagesBackDropsAndPosters> movieImagesPosterList = movieImages.getPosters();

                           if (movieImagesBackDropsList !=null && movieImagesBackDropsList.size()>0){

                               if (movieImagesPosterList !=null&& movieImagesPosterList.size()>0){
                                   movieImagesBackDropsAndPostersArrayList.addAll(movieImagesBackDropsList);
                                   movieImagesBackDropsAndPostersArrayList.addAll(movieImagesPosterList);

                               }else {
                                   movieImagesBackDropsAndPostersArrayList.addAll(movieImagesBackDropsList);
                               }

                           }else if (movieImagesPosterList!=null&& movieImagesPosterList.size()>0){
                               movieImagesBackDropsAndPostersArrayList.addAll(movieImagesPosterList);
                           }else {
                               movieImagesBackDropsAndPostersArrayList.clear();

                               movieDetailImagesLayout.setVisibility(View.GONE);
                           }
                           if (movieImagesBackDropsAndPostersArrayList.size()>0){

                               MoviesPosterImagesAdapter moviesPosterImagesAdapter = new MoviesPosterImagesAdapter(MovieDetailActivity.this,movieImagesBackDropsAndPostersArrayList);
                               movieDetailImagesRecyclerView.setAdapter(moviesPosterImagesAdapter);

                               movieDetailImagesLayout.setVisibility(View.VISIBLE);

                               LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MovieDetailActivity.this,R.anim.layout_slide_right);
                               movieDetailImagesRecyclerView.setLayoutAnimation(controller);
                               movieDetailImagesRecyclerView.scheduleLayoutAnimation();
                           }

                       }
                   }

                   @Override
                   public void onFailure(@NonNull Call<MovieImages> call,@NonNull Throwable t) {

                   }
               });

                Call<MovieVideos> movieVideosCall = retrofietService.getMovieVideosById(id,BuildConfig.THE_MOVIE_DB_API_KEY);

                movieVideosCall.enqueue(new Callback<MovieVideos>() {
                    @Override
                    public void onResponse(@NonNull Call<MovieVideos> call,@NonNull Response<MovieVideos> response) {
                        MovieVideos movieVideos = response.body();

                        if (movieVideos!=null){

                            List<MovieVideosResults> movieVideosResultsList = movieVideos.getResults();

                            if (movieVideosResultsList !=null&& movieVideosResultsList.size()>0){

                                movieDetailVideosLayout.setVisibility(View.VISIBLE);

                                MovieVideosAdapter adapter = new MovieVideosAdapter(MovieDetailActivity.this,movieVideosResultsList);
                                movieDetailVideosRecyclerView.setAdapter(adapter);



                                LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MovieDetailActivity.this,R.anim.layout_slide_right);
                                movieDetailVideosRecyclerView.setLayoutAnimation(controller);
                                movieDetailVideosRecyclerView.scheduleLayoutAnimation();

                            }else {
                                movieDetailVideosLayout.setVisibility(View.GONE);
                            }

                        } else {
                            movieDetailVideosLayout.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<MovieVideos> call,@NonNull Throwable t) {

                    }
                });

                Call<MovieSimilar> similarCall = retrofietService.getMovieSimilarById(id,BuildConfig.THE_MOVIE_DB_API_KEY);
                similarCall.enqueue(new Callback<MovieSimilar>() {
                    @Override
                    public void onResponse(@NonNull Call<MovieSimilar> call,@NonNull Response<MovieSimilar> response) {
                        MovieSimilar movieSimilarResponse = response.body();

                        if (movieSimilarResponse!=null){
                            List<MovieSimilarResults> results  = movieSimilarResponse.getResults();
                            if (results.size()>0&&results!=null){
                                MovieSimilarAdapter adapter = new MovieSimilarAdapter(MovieDetailActivity.this,results);
                                movie_detail_similar_recyclerView.setAdapter(adapter);
                                movie_detail_similar_layout.setVisibility(View.VISIBLE);
                                LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MovieDetailActivity.this,R.anim.layout_slide_right);
                                movie_detail_similar_recyclerView.setLayoutAnimation(controller);
                                movie_detail_similar_recyclerView.scheduleLayoutAnimation();
                            }else {
                                movie_detail_similar_layout.setVisibility(View.GONE);
                            }

                        }else {
                            movie_detail_similar_layout.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<MovieSimilar> call, Throwable t) {

                    }
                });


            }
        }


    }

    private void prepareDetails(MovieDetails movieDetailsReponse) {

        List<MoviesDetailsSpokenLanguages> moviesDetailsSpokenLanguagesList = movieDetailsReponse.getSpoken_languages();


        String posterpath = movieDetailsReponse.getPoster_path();
        String backDropPath = movieDetailsReponse.getBackdrop_path();

        Double voteAverage = movieDetailsReponse.getVote_average()*10;

        String title = movieDetailsReponse.getTitle();
        String originalTitle = movieDetailsReponse.getOriginal_title();
        String originalLanguage = movieDetailsReponse.getOriginal_lenguage();

        boolean adult = movieDetailsReponse.isAdult();

        String status = movieDetailsReponse.getStatus();
        Integer runtime = movieDetailsReponse.getRuntime();
        float budget = movieDetailsReponse.getBudget();
        float revenue = movieDetailsReponse.getRevenue();

        int b = (int) budget;
        int r = (int) revenue;

        List<MovieDetailsGenres> movieDetailsGenresList = movieDetailsReponse.getGenres();
        List<MovieDetailsProductionCountries> movieDetailsProductionCountriesList = movieDetailsReponse.getProduction_countries();

        String releaseDate = movieDetailsReponse.getRelease_date();
        String homepage = movieDetailsReponse.getHomepage();
        String overview = movieDetailsReponse.getOverview();

        List<MovieDetailsProductionCompanies> movieDetailsProductionCompaniesList = movieDetailsReponse.getProduction_companies();




        Picasso.with(this).load(posterpath).into(movieDetailPosterImageView);
        Picasso.with(this).load(backDropPath).into(movieDetailBackDropPosterCircleImageView);

        movieDetailBackDropPosterCircleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieDetailActivity.this,ImageViewActivity.class);
                intent.putExtra("image_url",backDropPath);
                startActivity(intent);

            }
        });


        int rating  = voteAverage.intValue();

        movieDetailRationBar.setProgress(rating);

        movieDetailTitle.setText(title);

        if (originalTitle != null) {
            if (originalTitle.length() > 0) {
                movieDetailOriginalTitle.setText(originalTitle);
                movieDetailOriginalTitleLayout.setVisibility(View.VISIBLE);
            } else {
                movieDetailOriginalTitleLayout.setVisibility(View.GONE);
            }
        } else {
            movieDetailOriginalTitleLayout.setVisibility(View.GONE);
        }

        if (originalLanguage != null) {
            if (originalLanguage.length() > 0) {
                movieDetailOriginalLanguague.setText(originalLanguage);
                movieDetailOriginalLanguagueLayout.setVisibility(View.VISIBLE);
            } else {
                movieDetailOriginalLanguagueLayout.setVisibility(View.GONE);
            }
        } else {
            movieDetailOriginalLanguagueLayout.setVisibility(View.GONE);
        }


        if (adult) {

            movieDetailAdult.setText("SI");
            movieDetailAdultLayout.setVisibility(View.VISIBLE);
        } else {
            movieDetailAdult.setText("No");
            movieDetailAdultLayout.setVisibility(View.VISIBLE);
        }

        if (status != null) {
            if (status.length() > 0) {
                movieDetailStatus.setText(status);
                movieDetailStatusLayout.setVisibility(View.VISIBLE);
            } else {
                movieDetailStatusLayout.setVisibility(View.GONE);
            }
        } else {
            movieDetailStatusLayout.setVisibility(View.GONE);
        }


        if (runtime != null) {
            if (runtime != 0) {
                movieDetailRuntime.setText(String.valueOf(runtime)+" Minutos");
                movieDetailRuntimeLayout.setVisibility(View.VISIBLE);
            } else {
                movieDetailRuntimeLayout.setVisibility(View.GONE);
            }
        } else {
            movieDetailRuntimeLayout.setVisibility(View.GONE);
        }


        if (b>0){
            if (b !=0){
                movieDetailBudget.setText(String.valueOf(b)+" $");
                movieDetailBudgetLayout.setVisibility(View.VISIBLE);
            }else {
                movieDetailBudgetLayout.setVisibility(View.GONE);
            }
        }else {
            movieDetailBudgetLayout.setVisibility(View.GONE);
        }

        if (r>0){
            if (r !=0){
                movieDetailRevenue.setText(String.valueOf(r)+" $");
                movieDetailRevenueLayout.setVisibility(View.VISIBLE);
            }else {
                movieDetailRevenueLayout.setVisibility(View.GONE);
            }
        }else {
            movieDetailRevenueLayout.setVisibility(View.GONE);
        }

        if (movieDetailsGenresList !=null && movieDetailsGenresList.size()>0){

            StringBuilder stringBuilder = new StringBuilder();

            for (int i =0; i<movieDetailsGenresList.size();i++){

                if (i==movieDetailsGenresList.size()-1){
                    stringBuilder.append(movieDetailsGenresList.get(i).getName());
                }else {
                    stringBuilder.append(movieDetailsGenresList.get(i).getName()).append(", ");
                }
            }
            movieDetailGenre.setText(stringBuilder.toString());
            movieDetailGenreLayout.setVisibility(View.VISIBLE);
        }else {
            movieDetailGenreLayout.setVisibility(View.GONE);
        }

        if (movieDetailsProductionCountriesList !=null && movieDetailsProductionCountriesList.size()>0){

            StringBuilder stringBuilder = new StringBuilder();

            for (int i =0; i<movieDetailsProductionCountriesList.size();i++){

                if (i==movieDetailsProductionCountriesList.size()-1){
                    stringBuilder.append(movieDetailsProductionCountriesList.get(i).getName());
                }else {
                    stringBuilder.append(movieDetailsProductionCountriesList.get(i).getName()).append(", ");
                }
            }
            movieDetailProductionCountry.setText(stringBuilder.toString());
            movieDetailProductionCountryLayout.setVisibility(View.VISIBLE);
        }else {
            movieDetailProductionCountryLayout.setVisibility(View.GONE);
        }


        if (releaseDate != null) {
            if (releaseDate.length() > 0) {
                movieDetailReleaseDate.setText(releaseDate);
                movieDetailReleaseDateLayout.setVisibility(View.VISIBLE);
            } else {
                movieDetailReleaseDateLayout.setVisibility(View.GONE);
            }
        } else {
            movieDetailReleaseDateLayout.setVisibility(View.GONE);
        }

        if (homepage != null) {
            if (homepage.length() > 0) {
                movieDetailHomePage.setText(homepage);
                movieDetailHomePageLayout.setVisibility(View.VISIBLE);
            } else {
                movieDetailHomePageLayout.setVisibility(View.GONE);
            }
        } else {
            movieDetailHomePageLayout.setVisibility(View.GONE);
        }

        if (overview != null) {
            if (overview.length() > 0) {
                movieDetailOverview.setText(overview);
                movieDetailOverviewLayout.setVisibility(View.VISIBLE);
            } else {
                movieDetailOverviewLayout.setVisibility(View.GONE);
            }
        } else {
            movieDetailOverviewLayout.setVisibility(View.GONE);
        }


        if (movieDetailsProductionCompaniesList!=null && movieDetailsProductionCompaniesList.size()>0){

            MovieProductionCompaniesAdapter movieProductionCompaniesAdapter   = new MovieProductionCompaniesAdapter(MovieDetailActivity.this,movieDetailsProductionCompaniesList);
            movieDetailProductionCompanyRecyclerView.setAdapter(movieProductionCompaniesAdapter);

            movieDetailProductionCompanyLayout.setVisibility(View.VISIBLE);

            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MovieDetailActivity.this,R.anim.layout_slide_right);
            movieDetailProductionCompanyRecyclerView.setLayoutAnimation(controller);
            movieDetailProductionCompanyRecyclerView.scheduleLayoutAnimation();

        }else {
            movieDetailProductionCompanyLayout.setVisibility(View.GONE);
        }





    }


    //set animation finish

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_letf,R.anim.slide_out_right);
    }
}
