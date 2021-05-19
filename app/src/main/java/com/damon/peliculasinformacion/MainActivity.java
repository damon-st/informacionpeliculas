package com.damon.peliculasinformacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.Toast;

import com.damon.peliculasinformacion.Adapters.MovieSearchAdapter;
import com.damon.peliculasinformacion.Adapters.PersonSearchAdapter;
import com.damon.peliculasinformacion.Adapters.TvShowSearchAdapter;
import com.damon.peliculasinformacion.Client.RetrofitClient;
import com.damon.peliculasinformacion.Interfaces.RetrofietService;
import com.damon.peliculasinformacion.Model.Movie.MovieResponse;
import com.damon.peliculasinformacion.Model.Movie.MovieResponseResults;
import com.damon.peliculasinformacion.Model.Person.PersonsResponse;
import com.damon.peliculasinformacion.Model.Person.PersonsResponseResults;
import com.damon.peliculasinformacion.Model.Tv.TvShowsResponse;
import com.damon.peliculasinformacion.Model.Tv.TvResponseResults;
import com.google.gson.Gson;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private NiceSpinner sourceSpinner;
    private AppCompatEditText queryEditText;
    private AppCompatButton querySearchButton;
    private RecyclerView resultsRecyclerView;

    private String movies = "Nombre de Pelicula";
    private String person = "Nombre del Actor";
    private String tv = "Servies de Tv";

    // initaite the retrofit service
    private RetrofietService retrofietService;

    private MovieSearchAdapter movieSearchAdapter;
    private PersonSearchAdapter personSearchAdapter;
    private TvShowSearchAdapter tvShowSearchAdapter;

    private AppCompatTextView app_name;

    private RecyclerView recyclerView;

    private RecyclerView recycler_popular_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //disable the keywoead on star
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        sourceSpinner = findViewById(R.id.source_spinner);
        queryEditText = findViewById(R.id.query_edit_text);
        querySearchButton = findViewById(R.id.query_search_button);
        resultsRecyclerView = findViewById(R.id.results_recycler_view);
        resultsRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        recyclerView = findViewById(R.id.recycler_popular);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        recycler_popular_tv = findViewById(R.id.recycler_popular_tv);
        recycler_popular_tv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        Paper.init(this);


        retrofietService = RetrofitClient.getClient().create(RetrofietService.class);



        app_name = findViewById(R.id.app_name);
        app_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PopularMovie.class);
                startActivity(intent);
            }
        });


        final ArrayList<String> category = new ArrayList<>();

        //set lis for sourceSpinner

        //person name mans actors

        category.add(movies);
        category.add(person);
        category.add(tv);


        sourceSpinner.attachDataSource(category);

        //retrieve the position at star an the set the spinner

        if (Paper.book().read("position")!=null){
            int position = Paper.book().read("position");
            sourceSpinner.setSelectedIndex(position);
        }


        //set the text on edit text on create

        int position = sourceSpinner.getSelectedIndex();

        if (position ==0){
            queryEditText.setHint("Ingresa el nombre de la Pelicula");
        }else if (position==1){
            queryEditText.setHint("Ingresa el nombre del Actor");
        }else {
            queryEditText.setHint("Ingresa el nombre de la Serie");
        }
        sourceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //whe source spinner in clicked chage the tex of  the edixtext
                if (position ==0){
                    queryEditText.setHint("Ingresa el nombre de la Pelicula");
                }else if (position==1){
                    queryEditText.setHint("Ingresa el nombre del Actor");
                }else {
                    queryEditText.setHint("Ingresa el nombre de la Serie");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //lineas para los populares

        Call<MovieResponse> movieResponseCall = retrofietService.getMoviesPopularByQuery(BuildConfig.THE_MOVIE_DB_API_KEY);

        movieResponseCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {

                MovieResponse movieResponse = response.body();

                if (movieResponse !=null){
                    List<MovieResponseResults> movieResponseResults = movieResponse.getResults();
                    System.out.println("Mirar .- "+movieResponseResults.toString());
                    MovieSearchAdapter movieSearchAdapter = new MovieSearchAdapter(MainActivity.this,movieResponseResults);
                    recyclerView.setAdapter(movieSearchAdapter);

                    LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MainActivity.this,R.anim.layout_slide_right);
                    recyclerView.setLayoutAnimation(controller);
                    recyclerView.scheduleLayoutAnimation();
                }
            }

            @Override
            public void onFailure(@NonNull Call<MovieResponse> call,@NonNull Throwable t) {

            }
        });

        Call<TvShowsResponse> tvShowsResponseCall = retrofietService.getTvPopular(BuildConfig.THE_MOVIE_DB_API_KEY);
        tvShowsResponseCall.enqueue(new Callback<TvShowsResponse>() {
            @Override
            public void onResponse(@NonNull Call<TvShowsResponse> call,@NonNull Response<TvShowsResponse> response) {
                TvShowsResponse tvShowsResponse = response.body();

                if (tvShowsResponse!=null){

                    List<TvResponseResults> showsResponseList = tvShowsResponse.getResults();

                    TvShowSearchAdapter tvShowSearchAdapter = new TvShowSearchAdapter(MainActivity.this,showsResponseList);
                    recycler_popular_tv.setAdapter(tvShowSearchAdapter);

                    LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MainActivity.this,R.anim.layout_slide_right);
                    recycler_popular_tv.setLayoutAnimation(controller);
                    recycler_popular_tv.scheduleLayoutAnimation();

                }
            }

            @Override
            public void onFailure(@NonNull Call<TvShowsResponse> call,@NonNull Throwable t) {

            }
        });






        //retrieve the result form paper db and star


        if (Paper.book().read("cache")!=null){
            String results= Paper.book().read("cache");
            if (Paper.book().read("source")!=null){
                String source = Paper.book().read("source");
                if (source.equals("movie")){
                    //convert the string cache to model movie reesponse clas usin gson

                    MovieResponse movieResponse = new Gson().fromJson(results,MovieResponse.class);

                    if (movieResponse !=null){
                        List<MovieResponseResults> movieResponseResults = movieResponse.getResults();

                        movieSearchAdapter = new MovieSearchAdapter(MainActivity.this,movieResponseResults);
                        resultsRecyclerView.setAdapter(movieSearchAdapter);

                        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MainActivity.this,R.anim.layout_slide_right);
                        resultsRecyclerView.setLayoutAnimation(controller);
                        resultsRecyclerView.scheduleLayoutAnimation();

                        //now store the result in pager davase to acces offline
                        Paper.book().write("cache",new Gson().toJson(movieResponse));
                        //store also the cateforey to setr the spinner at app star
                        Paper.book().write("source","movie");

                    }

                }else if (source.equals("person")){
                    PersonsResponse personsResponse = new Gson().fromJson(results,PersonsResponse.class);
                    if (personsResponse !=null){
                        List<PersonsResponseResults> personsResponseResults = personsResponse.getResults();

                        personSearchAdapter = new PersonSearchAdapter(MainActivity.this,personsResponseResults);
                        resultsRecyclerView.setAdapter(personSearchAdapter);

                        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MainActivity.this,R.anim.layout_slide_right);
                        resultsRecyclerView.setLayoutAnimation(controller);
                        resultsRecyclerView.scheduleLayoutAnimation();

                        //now store the result in pager davase to acces offline
                        Paper.book().write("cache",new Gson().toJson(personsResponse));
                        //store also the cateforey to setr the spinner at app star
                        Paper.book().write("source","person");

                    }

                }else {

                    TvShowsResponse personsResponse = new Gson().fromJson(results,TvShowsResponse.class);
                    if (personsResponse !=null){
                        List<TvResponseResults> tvResponseResults = personsResponse.getResults();

                        tvShowSearchAdapter = new TvShowSearchAdapter(MainActivity.this,tvResponseResults);
                        resultsRecyclerView.setAdapter(tvShowSearchAdapter);

                        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MainActivity.this,R.anim.layout_slide_right);
                        resultsRecyclerView.setLayoutAnimation(controller);
                        resultsRecyclerView.scheduleLayoutAnimation();

                        //now store the result in pager davase to acces offline
                        Paper.book().write("cache",new Gson().toJson(personsResponse));
                        //store also the cateforey to setr the spinner at app star
                        Paper.book().write("source","tv");

                    }
                }
            }
        }




        //get the query from user

        querySearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (queryEditText.getText() !=null) {
                    String query = queryEditText.getText().toString();
                    if (query.equals("")||query.equals(" ")){
                        Toast.makeText(MainActivity.this, "Porfabor introduce texto", Toast.LENGTH_SHORT).show();
                    }else {
                        queryEditText.setText("");
                        // get the category to searh the query mobve or person
                        String finalQuery = query.replaceAll(" ","+");
                        if (category.size()>0){
                            String categoryName = category.get(sourceSpinner.getSelectedIndex());
                            if (categoryName.equals(movies)){

                                //metodo para las peliculas

                                Call<MovieResponse> movieResponseCall = retrofietService.getMoviesByQuery(BuildConfig.THE_MOVIE_DB_API_KEY,finalQuery);

                                movieResponseCall.enqueue(new Callback<MovieResponse>() {
                                    @Override
                                    public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {

                                        MovieResponse movieResponse = response.body();

                                        if (movieResponse !=null){
                                            List<MovieResponseResults> movieResponseResults = movieResponse.getResults();
                                            System.out.println("Mirar .- "+movieResponseResults.toString());
                                            movieSearchAdapter = new MovieSearchAdapter(MainActivity.this,movieResponseResults);
                                            resultsRecyclerView.setAdapter(movieSearchAdapter);

                                            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MainActivity.this,R.anim.layout_slide_right);
                                            resultsRecyclerView.setLayoutAnimation(controller);
                                            resultsRecyclerView.scheduleLayoutAnimation();

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

                            }else if (categoryName.equals(person)){

                                //metodo para las personas

                                Call<PersonsResponse> personsResponseCall = retrofietService.getPersonsByQuery(BuildConfig.THE_MOVIE_DB_API_KEY,finalQuery);
                                personsResponseCall.enqueue(new Callback<PersonsResponse>() {
                                    @Override
                                    public void onResponse(@NonNull Call<PersonsResponse> call, @NonNull Response<PersonsResponse> response) {
                                        PersonsResponse personsResponse = response.body();
                                        if (personsResponse !=null){
                                            List<PersonsResponseResults> personsResponseResults = personsResponse.getResults();

                                            personSearchAdapter = new PersonSearchAdapter(MainActivity.this,personsResponseResults);
                                            resultsRecyclerView.setAdapter(personSearchAdapter);

                                            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MainActivity.this,R.anim.layout_slide_right);
                                            resultsRecyclerView.setLayoutAnimation(controller);
                                            resultsRecyclerView.scheduleLayoutAnimation();

                                            //now store the result in pager davase to acces offline
                                            Paper.book().write("cache",new Gson().toJson(personsResponse));
                                            //store also the cateforey to setr the spinner at app star
                                            Paper.book().write("source","person");

                                        }
                                    }

                                    @Override
                                    public void onFailure(@NonNull Call<PersonsResponse> call,@NonNull Throwable t) {

                                    }
                                });
                            }else if (categoryName.equals(tv)){

                                //metodo para las series de tv
                                Call<TvShowsResponse> tvShowsResponseCall = retrofietService.getTvShowByQuery(BuildConfig.THE_MOVIE_DB_API_KEY,finalQuery);
                                tvShowsResponseCall.enqueue(new Callback<TvShowsResponse>() {
                                    @Override
                                    public void onResponse(@NonNull Call<TvShowsResponse> call,@NonNull Response<TvShowsResponse> response) {

                                        TvShowsResponse tvShowsResponse = response.body();
                                        if (tvShowsResponse !=null){
                                            List<TvResponseResults> tvResponseResults = tvShowsResponse.getResults();

                                            tvShowSearchAdapter = new TvShowSearchAdapter(MainActivity.this, tvResponseResults);
                                            resultsRecyclerView.setAdapter(tvShowSearchAdapter);

                                            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MainActivity.this,R.anim.layout_slide_right);
                                            resultsRecyclerView.setLayoutAnimation(controller);
                                            resultsRecyclerView.scheduleLayoutAnimation();

                                            //now store the result in pager davase to acces offline
                                            Paper.book().write("cache",new Gson().toJson(tvShowsResponse));
                                            //store also the cateforey to setr the spinner at app star
                                            Paper.book().write("source","tv");

                                        }

                                    }

                                    @Override
                                    public void onFailure(@NonNull Call<TvShowsResponse> call,@NonNull Throwable t) {

                                    }
                                });
                            }
                        }
                    }
                }
            }
        });






    }

    @Override
    protected void onStop() {
        super.onStop();
        //set the position of sipnner in ofline to retreive at star

        Paper.book().write("position",sourceSpinner.getSelectedIndex());
    }
}
