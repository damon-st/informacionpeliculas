package com.damon.peliculasinformacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import com.codewaves.youtubethumbnailview.ThumbnailLoader;
import com.damon.peliculasinformacion.Adapters.TvCreateByAdapter;
import com.damon.peliculasinformacion.Adapters.TvCredistCastAdapter;
import com.damon.peliculasinformacion.Adapters.TvCredistCrewAdapter;
import com.damon.peliculasinformacion.Adapters.TvProductionCompaniesAdapter;
import com.damon.peliculasinformacion.Adapters.TvRecomendationAdapter;
import com.damon.peliculasinformacion.Adapters.TvSeasonsDetailAdapter;
import com.damon.peliculasinformacion.Adapters.TvSeasonsLastEpisodeAdapter;
import com.damon.peliculasinformacion.Client.RetrofitClient;
import com.damon.peliculasinformacion.Interfaces.RetrofietService;
import com.damon.peliculasinformacion.Model.Tv.TvCreditsCrew;
import com.damon.peliculasinformacion.Model.Tv.TvDetailsCredits;
import com.damon.peliculasinformacion.Model.Tv.TvCreditsCast;
import com.damon.peliculasinformacion.Model.Tv.TvDetails;
import com.damon.peliculasinformacion.Model.Tv.TvDetailsCreateBy;
import com.damon.peliculasinformacion.Model.Tv.TvDetailsGenres;
import com.damon.peliculasinformacion.Model.Tv.TvDetailsLastEspisodeToAir;
import com.damon.peliculasinformacion.Model.Tv.TvDetailsNextEpisodeToAir;
import com.damon.peliculasinformacion.Model.Tv.TvDetailsProductionCompanies;
import com.damon.peliculasinformacion.Model.Tv.TvDetailsSeasons;
import com.damon.peliculasinformacion.Model.Tv.TvRecomendations;
import com.damon.peliculasinformacion.Model.Tv.TvRecomendationsResults;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.github.lzyzsd.circleprogress.ArcProgress;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvDetailActivity extends AppCompatActivity {

    private KenBurnsView movieDetailPosterImageView;
    private CircleImageView movieDetailBackDropPosterCircleImageView;
    private ArcProgress movieDetailRationBar;

    private LinearLayoutCompat movieDetailOriginalTitleLayout;
    private LinearLayoutCompat tvDetailOriginalLanguagueLayout;
    private LinearLayoutCompat movieDetailAdultLayout;
    private LinearLayoutCompat tvDetailStatusLayout;
    private LinearLayoutCompat tvDetailPrimeraEmisionLayout;
    private LinearLayoutCompat tvDetailEnProduccionLayout;
    private LinearLayoutCompat tvDetailCantidadDeEpisodiosLayout;
    private LinearLayoutCompat tvDetailGenreLayout;
    private LinearLayoutCompat movieDetailProductionCountryLayout;
    private LinearLayoutCompat movieDetailReleaseDateLayout;
    private LinearLayoutCompat tvDetailHomePageLayout;
    private LinearLayoutCompat tvDetailOverviewLayout;
    private LinearLayoutCompat movieDetailCastLayout;
    private LinearLayoutCompat tvDetailCrewLayout;
    private LinearLayoutCompat movieDetailProductionCompanyLayout;
    private LinearLayoutCompat tvSeasonsDetailsLayout;
    private LinearLayoutCompat tvRecomendationLayout;
    private LinearLayoutCompat tv_detail_numero_temporada_layout;
    private LinearLayoutCompat tv_detail_episodio_actual_layout;
    private LinearLayoutCompat tv_detail_cast_layout;
    private LinearLayoutCompat tv_anterio_episodio_layout;
    private LinearLayoutCompat tv_detail_last_air_date_layout;




    private AppCompatTextView movieDetailTitle;
    private AppCompatTextView movieDetailOriginalTitle;
    private AppCompatTextView tvDetailOriginalLanguague;
    private AppCompatTextView movieDetailAdult;
    private AppCompatTextView tvDetailStatus;
    private AppCompatTextView tvDetailPrimeraEmision;
    private AppCompatTextView tvDetailEnProduccion;
    private AppCompatTextView tvDetailCantidadEpisodios;
    private AppCompatTextView tvDetailGenre;
    private AppCompatTextView movieDetailProductionCountry;
    private AppCompatTextView movieDetailReleaseDate;
    private AppCompatTextView tvDetailHomePage;
    private AppCompatTextView tvDetailOverview;
    private AppCompatTextView tv_detail_numero_temporada;
    private AppCompatTextView tv_detail_episodio_actual;
    private AppCompatTextView tv_detail_air_date;


    private RecyclerView movieDetailCastRecyclerView;
    private RecyclerView tvDetailCrewRecyclerView;
    private RecyclerView movieDetailProductionCompanyRecyclerView;
    private RecyclerView tvSeasonsDetailRecyclerView;
    private RecyclerView tvRecomendationRecyclerView;
    private RecyclerView tv_detail_cast_recyclerView;


    private CardView car_last_episode,car_next_episode;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_detail);

        Intent intent = getIntent();

        RetrofietService retrofietService = RetrofitClient.getClient().create(RetrofietService.class);

        ThumbnailLoader.initialize(BuildConfig.THE_YOUTUBE_API_KEY);

        movieDetailPosterImageView = findViewById(R.id.movie_detail_poster_image_view);
        movieDetailBackDropPosterCircleImageView = findViewById(R.id.movie_detail_poster_circle_image_view);
        movieDetailRationBar = findViewById(R.id.movie_detail_rating_bar);

        movieDetailOriginalTitleLayout = findViewById(R.id.movie_detail_original_title_layout);
        tvDetailOriginalLanguagueLayout = findViewById(R.id.movie_detail_original_language_layout);
        movieDetailAdultLayout = findViewById(R.id.movie_detail_Adult_layout);
        tvDetailStatusLayout = findViewById(R.id.movie_detail_status_layout);
        tvDetailPrimeraEmisionLayout = findViewById(R.id.movie_detail_runtime_layout);
        tvDetailEnProduccionLayout = findViewById(R.id.movie_detail_budget_layout);
        tvDetailCantidadDeEpisodiosLayout = findViewById(R.id.movie_detail_revenue_layout);
        tvDetailGenreLayout = findViewById(R.id.movie_detail_genre_layout);
        movieDetailProductionCountryLayout = findViewById(R.id.movie_detail_production_country_layout);
        movieDetailReleaseDateLayout = findViewById(R.id.movie_detail_release_date_layout);
        tvDetailHomePageLayout = findViewById(R.id.movie_detail_homepage_layout);
        tvDetailOverviewLayout = findViewById(R.id.movie_detail_overview_layout);
        movieDetailCastLayout = findViewById(R.id.movie_detail_cast_layout);
        tvDetailCrewLayout = findViewById(R.id.movie_detail_crew_layout);
        movieDetailProductionCompanyLayout = findViewById(R.id.movie_detail_production_company_layout);
        tvSeasonsDetailsLayout = findViewById(R.id.movie_detail_images_layout);
        tvRecomendationLayout = findViewById(R.id.movie_detail_videos_layout);
        tv_detail_numero_temporada_layout = findViewById(R.id.tv_detail_numero_temporada_layout);
        tv_detail_episodio_actual_layout = findViewById(R.id.tv_detail_episodio_actual_layout);
        tv_detail_cast_layout = findViewById(R.id.tv_detail_cast_layout);
        tv_anterio_episodio_layout = findViewById(R.id.tv_anterio_episodio_layout);
        tv_detail_last_air_date_layout = findViewById(R.id.tv_detail_last_air_date_layout);




        movieDetailTitle = findViewById(R.id.movie_detail_title);
        movieDetailOriginalTitle = findViewById(R.id.movie_detail_original_title);
        tvDetailOriginalLanguague = findViewById(R.id.movie_detail_original_language);
        movieDetailAdult= findViewById(R.id.movie_detail_adult);
        tvDetailStatus = findViewById(R.id.movie_detail_status);
        tvDetailPrimeraEmision = findViewById(R.id.movie_detail_runtime);
        tvDetailEnProduccion = findViewById(R.id.movie_detail_budget);
        tvDetailCantidadEpisodios = findViewById(R.id.movie_detail_reveue);
        tvDetailGenre = findViewById(R.id.movie_detail_genre);
        movieDetailProductionCountry = findViewById(R.id.movie_detail_production_country);
        movieDetailReleaseDate = findViewById(R.id.movie_detail_release_date);
        tvDetailHomePage = findViewById(R.id.movie_detail_homepage);
        tvDetailOverview = findViewById(R.id.movie_detail_overview);
        tv_detail_numero_temporada = findViewById(R.id.tv_detail_numero_temporada);
        tv_detail_episodio_actual = findViewById(R.id.tv_detail_episodio_actual);
        tv_detail_air_date = findViewById(R.id.tv_detail_air_date);



        car_last_episode= findViewById(R.id.car_last_episode);
        car_next_episode = findViewById(R.id.car_next_episode);


        movieDetailCastRecyclerView = findViewById(R.id.movie_detail_cast_recyclerView);
        movieDetailCastRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        tvDetailCrewRecyclerView = findViewById(R.id.movie_detail_crew_recyclerView);
        tvDetailCrewRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        movieDetailProductionCompanyRecyclerView = findViewById(R.id.movie_detail_production_company_recyclerView);
        movieDetailProductionCompanyRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        tvSeasonsDetailRecyclerView = findViewById(R.id.movie_detail_images_recyclerView);
        tvSeasonsDetailRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        tvRecomendationRecyclerView = findViewById(R.id.movie_detail_videos_recyclerView);
        tvRecomendationRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        tv_detail_cast_recyclerView = findViewById(R.id.tv_detail_cast_recyclerView);
        tv_detail_cast_recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));






        if (intent !=null &&intent.getExtras() !=null){

            if (intent.getExtras().getString("id")!=null){

                id = Integer.parseInt(intent.getExtras().getString("id"));




                Call<TvDetails> tvDetailsCall = retrofietService.getTvDetailsById(id,BuildConfig.THE_MOVIE_DB_API_KEY);
                tvDetailsCall.enqueue(new Callback<TvDetails>() {
                    @Override
                    public void onResponse(@NonNull Call<TvDetails> call,@NonNull Response<TvDetails> response) {

                        TvDetails tvDetailsResponse = response.body();

                        if (tvDetailsResponse !=null){
                            prepareDetails(tvDetailsResponse);

                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<TvDetails> call,@NonNull Throwable t) {

                    }
                });

                Call<TvDetailsCredits> tvCreditsCall = retrofietService.getTvCreditsById(id,BuildConfig.THE_MOVIE_DB_API_KEY);
                tvCreditsCall.enqueue(new Callback<TvDetailsCredits>() {
                    @Override
                    public void onResponse(@NonNull Call<TvDetailsCredits> call, @NonNull Response<TvDetailsCredits> response) {

                        TvDetailsCredits tvDetailsCreditsservice = response.body();

                        if (tvDetailsCreditsservice !=null){

                            List<TvCreditsCast> tvCreditsCastList = tvDetailsCreditsservice.getCast();

                            if (tvCreditsCastList!=null&&tvCreditsCastList.size()>0){

                                TvCredistCastAdapter apater = new TvCredistCastAdapter(TvDetailActivity.this,tvCreditsCastList);
                                tv_detail_cast_recyclerView.setAdapter(apater);

                                tv_detail_cast_layout.setVisibility(View.VISIBLE);

                                LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(TvDetailActivity.this,R.anim.layout_slide_right);
                                tv_detail_cast_recyclerView.setLayoutAnimation(controller);
                                tv_detail_cast_recyclerView.scheduleLayoutAnimation();
                            }else {
                                tv_detail_cast_layout.setVisibility(View.GONE);
                            }

                            List<TvCreditsCrew> tvCreditsCrewList = tvDetailsCreditsservice.getCrew();

                            if (tvCreditsCrewList!=null&&tvCreditsCrewList.size()>0){

                                TvCredistCrewAdapter adapter = new TvCredistCrewAdapter(TvDetailActivity.this,tvCreditsCrewList);
                                tvDetailCrewRecyclerView.setAdapter(adapter);
                                tvDetailCrewLayout.setVisibility(View.VISIBLE);

                                LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(TvDetailActivity.this,R.anim.layout_slide_right);
                                tvDetailCrewRecyclerView.setLayoutAnimation(controller);
                                tvDetailCrewRecyclerView.scheduleLayoutAnimation();

                            }else {
                                tvDetailCrewLayout.setVisibility(View.GONE);
                            }





                        }else {
                            tv_detail_cast_layout.setVisibility(View.GONE);
                            tvDetailCrewLayout.setVisibility(View.GONE);
                        }

                    }


                    @Override
                    public void onFailure(@NonNull Call<TvDetailsCredits> call, @NonNull Throwable t) {

                    }
                });

                Call<TvRecomendations> tvRecomendationsCall = retrofietService.getTvRecomendations(id,BuildConfig.THE_MOVIE_DB_API_KEY);

                tvRecomendationsCall.enqueue(new Callback<TvRecomendations>() {
                    @Override
                    public void onResponse(@NonNull Call<TvRecomendations> call,@NonNull Response<TvRecomendations> response) {

                        TvRecomendations recomendations = response.body();

                        if (recomendations!=null){

                            List<TvRecomendationsResults> resultsList = recomendations.getResults();


                            if (resultsList!=null&& resultsList.size()>0){
                                TvRecomendationAdapter adapter = new TvRecomendationAdapter(TvDetailActivity.this,resultsList);
                                tvRecomendationRecyclerView.setAdapter(adapter);
                                tvRecomendationLayout.setVisibility(View.VISIBLE);
                                LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(TvDetailActivity.this,R.anim.layout_slide_right);
                                tvRecomendationRecyclerView.setLayoutAnimation(controller);
                                tvRecomendationRecyclerView.scheduleLayoutAnimation();
                            }else {
                                tvRecomendationLayout.setVisibility(View.GONE);
                            }

                        }else {
                            tvRecomendationLayout.setVisibility(View.GONE);
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<TvRecomendations> call,@NonNull Throwable t) {

                    }
                });

            }
        }



    }

    private void prepareDetails(TvDetails response) {


        String posterpath = response.getPoster_path();
        String backDropPath = response.getBackdrop_path();
        String original_name = response.getOriginal_name();
        String overview = response.getOverview();
        String status = response.getStatus();
        String primeraEmision = response.getFirst_air_date();
        boolean enProduccion = response.isIn_production();
        String  homepage = response.getHomepage();
        String originalLenguage = response.getOriginal_language();
        int numerodeEpisodios = response.getNumber_of_episodes();
        int numerodeTemporadas = response.getNumber_of_seasons();
        List<Integer> episodioactual = response.getEpisode_run_time();
        String last = response.getLast_air_date();

        Double voteAverage = response.getVote_average()*10;

        Picasso.with(this).load(posterpath).into(movieDetailPosterImageView);
        Picasso.with(this).load(backDropPath).into(movieDetailBackDropPosterCircleImageView);


        List<TvDetailsCreateBy> tvDetailsCreateByList = response.getCreated_by();
        List<TvDetailsProductionCompanies> tvDetailsProductionCompaniesList = response.getProduction_companies();
        List<TvDetailsGenres> genresList = response.getGenres();
        List<TvDetailsSeasons> tvDetailsSeasonsList = response.getSeasons();
       TvDetailsLastEspisodeToAir tvDetailsLastEspisodeToAirList = response.getLast_episode_to_air();
        TvDetailsNextEpisodeToAir tvDetailsNextEpisodeToAir = response.getNext_episode_to_air();


        int rating  = voteAverage.intValue();

        movieDetailRationBar.setProgress(rating);

        if (original_name!=null){
            if (original_name.length()>0){
                movieDetailTitle.setText(original_name);
            }
        }


        movieDetailBackDropPosterCircleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TvDetailActivity.this,ImageViewActivity.class);
                intent.putExtra("image_url",backDropPath);
                startActivity(intent);
            }
        });



        if (primeraEmision!=null){
            if (primeraEmision.length()>0){
                tvDetailPrimeraEmisionLayout.setVisibility(View.VISIBLE);
                tvDetailPrimeraEmision.setText(primeraEmision);
            }else {
                tvDetailPrimeraEmisionLayout.setVisibility(View.GONE);
            }
        }else {
            tvDetailPrimeraEmisionLayout.setVisibility(View.GONE);
        }



        if (overview!=null){
            if (overview.length()>0){
                tvDetailOverviewLayout.setVisibility(View.VISIBLE);
                tvDetailOverview.setText(overview);
            }else {
                tvDetailOverviewLayout.setVisibility(View.GONE);
            }
        }else {
            tvDetailOverviewLayout.setVisibility(View.GONE);
        }


        if (status!=null){
            if (status.length()>0){
                tvDetailStatusLayout.setVisibility(View.VISIBLE);
                tvDetailStatus.setText(status);
            }else {
                tvDetailStatusLayout.setVisibility(View.GONE);
            }
        }else {
            tvDetailStatusLayout.setVisibility(View.GONE);
        }


        if (enProduccion){
            tvDetailEnProduccionLayout.setVisibility(View.VISIBLE);
            tvDetailEnProduccion.setText("SI");
        }else {
            tvDetailEnProduccionLayout.setVisibility(View.VISIBLE);
            tvDetailEnProduccion.setText("NO");
        }


        if (homepage!=null){
            if (homepage.length()>0){
                tvDetailHomePageLayout.setVisibility(View.VISIBLE);
                tvDetailHomePage.setText(homepage);
            }else {
                tvDetailHomePageLayout.setVisibility(View.GONE);
            }
        }else {
            tvDetailHomePageLayout.setVisibility(View.GONE);
        }


        if (originalLenguage!=null){
            if (originalLenguage.length()>0){

                tvDetailOriginalLanguagueLayout.setVisibility(View.VISIBLE);
                tvDetailOriginalLanguague.setText(originalLenguage);

            }else {
                tvDetailOriginalLanguagueLayout.setVisibility(View.GONE);
            }
        }else {
            tvDetailOriginalLanguagueLayout.setVisibility(View.GONE);
        }


        if (numerodeTemporadas!=0){
            if (numerodeTemporadas>0){
                tv_detail_numero_temporada_layout.setVisibility(View.VISIBLE);
                tv_detail_numero_temporada.setText(String.valueOf(numerodeTemporadas));
            }else {
                tv_detail_numero_temporada_layout.setVisibility(View.GONE);
            }
        }else {
            tv_detail_numero_temporada_layout.setVisibility(View.GONE);
        }





        if (numerodeEpisodios!=0){
            if (numerodeEpisodios>0){
                tvDetailCantidadDeEpisodiosLayout.setVisibility(View.VISIBLE);
                tvDetailCantidadEpisodios.setText(String.valueOf(numerodeEpisodios));
            }else {
                tvDetailCantidadDeEpisodiosLayout.setVisibility(View.GONE);
            }
        }else {
            tvDetailCantidadDeEpisodiosLayout.setVisibility(View.GONE);
        }


        if (last!=null){
            if (last.length()>0){
                tv_detail_last_air_date_layout.setVisibility(View.VISIBLE);
                tv_detail_air_date.setText(last);
            }else {
                tv_detail_last_air_date_layout.setVisibility(View.GONE);
            }
        }else {
            tv_detail_last_air_date_layout.setVisibility(View.GONE);
        }



        if (genresList!=null&&genresList.size()>0){

            StringBuilder stringBuilder = new StringBuilder();

            for (int i =0; i<genresList.size();i++){

                if (i==genresList.size()-1){
                    stringBuilder.append(genresList.get(i).getName());
                }else {
                    stringBuilder.append(genresList.get(i).getName()).append(", ");
                }
            }
            tvDetailGenreLayout.setVisibility(View.VISIBLE);
            tvDetailGenre.setText(stringBuilder.toString());
        }else {
            tvDetailGenreLayout.setVisibility(View.GONE);
        }

        if (episodioactual!=null&&episodioactual.size()>0){

            StringBuilder stringBuilder = new StringBuilder();

            for (int i=0;i<episodioactual.size();i++){

                if (i==episodioactual.get(i)-1){
                    stringBuilder.append(episodioactual.get(i).longValue());
                }else {
                    stringBuilder.append(episodioactual.get(i).longValue()).append(", ");
                }
            }
            tv_detail_episodio_actual_layout.setVisibility(View.VISIBLE);
            tv_detail_episodio_actual.setText(stringBuilder.toString()+" minutos");

        }else {
            tv_detail_episodio_actual_layout.setVisibility(View.GONE);
        }



        if (tvDetailsCreateByList!=null && tvDetailsCreateByList.size()>0){

            TvCreateByAdapter tvCreateByAdapter   = new TvCreateByAdapter(TvDetailActivity.this,tvDetailsCreateByList);
            movieDetailCastRecyclerView.setAdapter(tvCreateByAdapter);

            movieDetailCastLayout.setVisibility(View.VISIBLE);

            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(TvDetailActivity.this,R.anim.layout_slide_right);
            movieDetailCastRecyclerView.setLayoutAnimation(controller);
            movieDetailCastRecyclerView.scheduleLayoutAnimation();

        }else {
            movieDetailCastLayout.setVisibility(View.GONE);
        }

        if (tvDetailsProductionCompaniesList!=null&&tvDetailsProductionCompaniesList.size()>0){

            TvProductionCompaniesAdapter tvProductionCompaniesAdapter = new TvProductionCompaniesAdapter(TvDetailActivity.this,tvDetailsProductionCompaniesList);

            movieDetailProductionCompanyRecyclerView.setAdapter(tvProductionCompaniesAdapter);
            movieDetailProductionCompanyLayout.setVisibility(View.VISIBLE);

            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(TvDetailActivity.this,R.anim.layout_slide_right);
            movieDetailProductionCompanyRecyclerView.setLayoutAnimation(controller);
            movieDetailProductionCompanyRecyclerView.scheduleLayoutAnimation();
        }else {
            movieDetailProductionCompanyLayout.setVisibility(View.GONE);
        }

        if (tvDetailsSeasonsList!=null&&tvDetailsSeasonsList.size()>0){
            TvSeasonsDetailAdapter tvSeasonsDetailAdapter = new TvSeasonsDetailAdapter(TvDetailActivity.this,tvDetailsSeasonsList,id);

            tvSeasonsDetailRecyclerView.setAdapter(tvSeasonsDetailAdapter);
            tvSeasonsDetailsLayout.setVisibility(View.VISIBLE);

            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(TvDetailActivity.this,R.anim.layout_slide_right);
            tvSeasonsDetailRecyclerView.setLayoutAnimation(controller);
            tvSeasonsDetailRecyclerView.scheduleLayoutAnimation();

        }else {
            tvSeasonsDetailsLayout.setVisibility(View.GONE);
        }

        String date = tvDetailsLastEspisodeToAirList.getAir_date();
        String nombre = tvDetailsLastEspisodeToAirList.getName();
        String over = tvDetailsLastEspisodeToAirList.getOverview();
        String url = tvDetailsLastEspisodeToAirList.getStill_path();






        if (nombre!=null){
            if (nombre.length()>0){
                car_last_episode.setVisibility(View.VISIBLE);


                KenBurnsView imagen = car_last_episode.findViewById(R.id.imagen_las_episode);
                AppCompatTextView name = car_last_episode.findViewById(R.id.name_episode_last);
                AppCompatTextView fecha  = car_last_episode.findViewById(R.id.fecha_last_episode);
                AppCompatTextView overviews = car_last_episode.findViewById(R.id.overview_last_episode);

                name.setText(nombre);
                Picasso.with(this).load(url).into(imagen);
                fecha.setText(date);
               // overviews.setText(over);


            }else {
                car_last_episode.setVisibility(View.GONE);
            }
        }else {
            car_last_episode.setVisibility(View.GONE);
        }


        try{
            String na=   tvDetailsNextEpisodeToAir.getName();


            if (na!=null){

                if (na.length()>0) {

                    String name = tvDetailsNextEpisodeToAir.getName();
                    String fechas = tvDetailsNextEpisodeToAir.getAir_date();
                    String ovesr = tvDetailsNextEpisodeToAir.getOverview();
                    String urls = tvDetailsNextEpisodeToAir.getStill_path();

                    car_next_episode.setVisibility(View.VISIBLE);


                    KenBurnsView imagens = car_next_episode.findViewById(R.id.imagen_next_episode);
                    AppCompatTextView nombres = car_next_episode.findViewById(R.id.name_episode_next);
                    AppCompatTextView fecha = car_next_episode.findViewById(R.id.fecha_next_episode);
                    AppCompatTextView overviews = car_next_episode.findViewById(R.id.overview_next_episode);


                    nombres.setText(name);
                    Picasso.with(this).load(urls).into(imagens);
                    fecha.setText(fechas);
                    //overviews.setText(ovesr);

                }else {
                    car_next_episode.setVisibility(View.GONE);
                }
            }else {
                car_next_episode.setVisibility(View.GONE);
            }

        }catch (Exception e){
            e.printStackTrace();
        }





    }


}
