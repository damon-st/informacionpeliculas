package com.damon.peliculasinformacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.damon.peliculasinformacion.Adapters.MovieSearchAdapter;
import com.damon.peliculasinformacion.Client.RetrofitClient;
import com.damon.peliculasinformacion.Interfaces.RetrofietService;
import com.damon.peliculasinformacion.Model.Movie.MovieResponse;
import com.damon.peliculasinformacion.Model.Movie.MovieResponseResults;
import com.google.gson.Gson;

import java.util.List;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularMovie extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RetrofietService retrofietService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_movie);
        retrofietService = RetrofitClient.getClient().create(RetrofietService.class);


        recyclerView = findViewById(R.id.recycler_popular);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


        Call<MovieResponse> movieResponseCall = retrofietService.getMoviesPopularByQuery(BuildConfig.THE_MOVIE_DB_API_KEY);

        movieResponseCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {

                MovieResponse movieResponse = response.body();

                if (movieResponse !=null){
                    List<MovieResponseResults> movieResponseResults = movieResponse.getResults();
                    System.out.println("Mirar .- "+movieResponseResults.toString());
                    MovieSearchAdapter movieSearchAdapter = new MovieSearchAdapter(PopularMovie.this,movieResponseResults);
                    recyclerView.setAdapter(movieSearchAdapter);

                    LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(PopularMovie.this,R.anim.layout_slide_right);
                    recyclerView.setLayoutAnimation(controller);
                    recyclerView.scheduleLayoutAnimation();

                    //now store the result in pager davase to acces offline
                    Paper.book().write("cache",new Gson().toJson(movieResponse));
                    //store also the cateforey to setr the spinner at app star
                    Paper.book().write("source","movie");

                }
            }

            @Override
            public void onFailure(@NonNull Call<MovieResponse> call,@NonNull Throwable t) {

            }
        });

    }
}
