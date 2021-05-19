package com.damon.peliculasinformacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.codewaves.youtubethumbnailview.ThumbnailLoader;
import com.damon.peliculasinformacion.Adapters.SeasonDetailTemporadaAdapter;
import com.damon.peliculasinformacion.Adapters.TvSeasonsVideosAdapter;
import com.damon.peliculasinformacion.Client.RetrofitClient;
import com.damon.peliculasinformacion.Interfaces.RetrofietService;
import com.damon.peliculasinformacion.Model.Tv.TvSeasonsDetail;
import com.damon.peliculasinformacion.Model.Tv.TvSeasonsDetailEpisodes;
import com.damon.peliculasinformacion.Model.Tv.TvSeasonsVideoResults;
import com.damon.peliculasinformacion.Model.Tv.TvVideos;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeasonDetailActivity extends AppCompatActivity {

    private KenBurnsView imagen_season;
    private AppCompatTextView season_name;
    private AppCompatTextView fecha_de_salida;
    private RecyclerView recyclerView;
    private RecyclerView recycler_seasons_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season_detail);

        ThumbnailLoader.initialize(BuildConfig.THE_YOUTUBE_API_KEY);

        imagen_season = findViewById(R.id.imagen_season);
        season_name = findViewById(R.id.season_name);
        fecha_de_salida = findViewById(R.id.fecha_de_salida);
        recyclerView =findViewById(R.id.recycler_seasons);
        recycler_seasons_video = findViewById(R.id.recycler_seasons_video);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recycler_seasons_video.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        Intent intent = getIntent();

        RetrofietService  retrofietService = RetrofitClient.getClient().create(RetrofietService.class);




        if (intent !=null && intent.getExtras() !=null){
            if (intent.getExtras().getString("season_number")!=null){

                int season_number= Integer.parseInt(intent.getExtras().getString("season_number"));

                int id = Integer.parseInt(intent.getExtras().getString("id"));



                Call<TvSeasonsDetail> tvSeasonsDetailEpisodesCall = retrofietService.getTvSeasonDetail(id,season_number,BuildConfig.THE_MOVIE_DB_API_KEY);

                tvSeasonsDetailEpisodesCall.enqueue(new Callback<TvSeasonsDetail>() {
                    @Override
                    public void onResponse(@NonNull Call<TvSeasonsDetail> call,@NonNull Response<TvSeasonsDetail> response) {
                        TvSeasonsDetail tvSeasonsDetail = response.body();


                        if (tvSeasonsDetail !=null){

                            createDetail(tvSeasonsDetail);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<TvSeasonsDetail> call,@NonNull Throwable t) {

                    }
                });

                Call<TvVideos> tvSeasonsVideoCall = retrofietService.getSeasonsVideo(id,season_number,BuildConfig.THE_MOVIE_DB_API_KEY);

                tvSeasonsVideoCall.enqueue(new Callback<TvVideos>() {
                    @Override
                    public void onResponse(@NonNull Call<TvVideos> call,@NonNull Response<TvVideos> response) {

                        TvVideos tvSeasonsVideoResponse = response.body();

                        if (tvSeasonsVideoResponse!=null){

                            List<TvSeasonsVideoResults> tvSeasonsVideoResultsList = tvSeasonsVideoResponse.getResults();

                            if (tvSeasonsVideoResultsList !=null && tvSeasonsVideoResultsList.size()>0){

                                TvSeasonsVideosAdapter adapter = new TvSeasonsVideosAdapter(SeasonDetailActivity.this, tvSeasonsVideoResultsList);

                                recycler_seasons_video.setAdapter(adapter);
                                LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(SeasonDetailActivity.this,R.anim.layout_slide_right);
                                recycler_seasons_video.setLayoutAnimation(controller);
                                recycler_seasons_video.scheduleLayoutAnimation();

                            }

                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<TvVideos> call,@NonNull Throwable t) {

                    }
                });

            }
        }

    }

    private void createDetail(TvSeasonsDetail tvSeasonsDetail) {
        String poster_path = tvSeasonsDetail.getPoster_path();
        String name = tvSeasonsDetail.getName();
        String fechasalida = tvSeasonsDetail.getAir_date();

        List<TvSeasonsDetailEpisodes> tvSeasonsDetailEpisodesList = tvSeasonsDetail.getEpisodes();

        Picasso.with(this).load(poster_path).into(imagen_season);


        imagen_season.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeasonDetailActivity.this,ImageViewActivity.class);
                intent.putExtra("image_url",poster_path);
                startActivity(intent);
            }
        });


        if (name!=null){
            if (name.length()>0){
                season_name.setText(name);
            }
        }


        if (fechasalida!=null){
            if (fechasalida.length()>0){
                fecha_de_salida.setText("Fecha de Estro: "+fechasalida);
            }
        }


        if (tvSeasonsDetailEpisodesList!=null && tvSeasonsDetailEpisodesList.size()>0){
            SeasonDetailTemporadaAdapter  adapter = new SeasonDetailTemporadaAdapter(SeasonDetailActivity.this,tvSeasonsDetailEpisodesList);
            recyclerView.setAdapter(adapter);
            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(SeasonDetailActivity.this,R.anim.layout_slide_right);
            recyclerView.setLayoutAnimation(controller);
            recyclerView.scheduleLayoutAnimation();

        }




    }
}
