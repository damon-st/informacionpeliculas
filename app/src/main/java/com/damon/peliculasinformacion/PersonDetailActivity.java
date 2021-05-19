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
import android.widget.Toast;

import com.damon.peliculasinformacion.Adapters.PersonCredistCastAdapter;
import com.damon.peliculasinformacion.Adapters.PersonProfilesImagesAdapter;
import com.damon.peliculasinformacion.Adapters.PersonTvCredistCastAdapter;
import com.damon.peliculasinformacion.Client.RetrofitClient;
import com.damon.peliculasinformacion.Interfaces.RetrofietService;
import com.damon.peliculasinformacion.Model.Person.PersonDetailMovieCredits;
import com.damon.peliculasinformacion.Model.Person.PersonDetailMovieCreditsCast;
import com.damon.peliculasinformacion.Model.Person.PersonDetails;
import com.damon.peliculasinformacion.Model.Person.PersonImages;
import com.damon.peliculasinformacion.Model.Person.PersonImagesProfiles;
import com.damon.peliculasinformacion.Model.Person.PersonTvCredits;
import com.damon.peliculasinformacion.Model.Person.PersonTvCreditsCast;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonDetailActivity extends AppCompatActivity {

    private KenBurnsView personDetailProfileImageView;
    private LinearLayoutCompat personDetailAlsoKnowAsLayout;
    private LinearLayoutCompat personDetailBirthdayLayout;
    private LinearLayoutCompat personDetailPlaceOFbirthLayout;
    private LinearLayoutCompat personDetailDeathDayLayout;
    private LinearLayoutCompat personDetailDApartamentLayout;
    private LinearLayoutCompat personDetailHompageLayout;
    private LinearLayoutCompat personDetailBiographyLayout;
    private LinearLayoutCompat personDetailProfileImagesLayout;
    private LinearLayoutCompat person_detail_conicido_por_layout;
    private LinearLayoutCompat person_conicido_por_layout;

    private AppCompatTextView personDetailAlsoKnowAs;
    private AppCompatTextView personDetailBirthday;
    private AppCompatTextView personDetailPlaceOFbirth;
    private AppCompatTextView personDetailDeathDay;
    private AppCompatTextView personDetailDApartament;
    private AppCompatTextView personDetailHompage;
    private AppCompatTextView personDetailBiography;
    private AppCompatTextView personDetailName;

    private RecyclerView personDetailProfileImagesRecyclerView;
    private RecyclerView person_detail_conocido_por_recyclerview;
    private RecyclerView person_conocido_por_recyclerview;

    private PersonProfilesImagesAdapter personProfilesImagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        Intent intent = getIntent();

        //istance the retrofi service

        RetrofietService retrofietService = RetrofitClient.getClient().create(RetrofietService.class);

        personDetailProfileImageView = findViewById(R.id.person_detail_profile_image_view);


        personDetailAlsoKnowAsLayout = findViewById(R.id.person_detail_also_knwon_as_layout);
        personDetailBirthdayLayout = findViewById(R.id.person_detail_birthday_layout);
        personDetailPlaceOFbirthLayout = findViewById(R.id.person_detail_place_of_birth_layout);
        personDetailDeathDayLayout = findViewById(R.id.person_detail_deathday_layout);
        personDetailDApartamentLayout = findViewById(R.id.person_detail_known_for_departament_layout);
        personDetailHompageLayout =  findViewById(R.id.person_detail_homepage_layout);
        personDetailBiographyLayout = findViewById(R.id.person_detail_biography_layout);
        personDetailProfileImagesLayout = findViewById(R.id.person_detail_profile_images_layout);
        person_detail_conicido_por_layout = findViewById(R.id.person_detail_conicido_por_layout);
        person_conicido_por_layout = findViewById(R.id.person_conicido_por_layout);



        personDetailAlsoKnowAs = findViewById(R.id.person_detail_also_known_as);
        personDetailBirthday = findViewById(R.id.person_detail_birthday);
        personDetailPlaceOFbirth = findViewById(R.id.person_detail_place_birth);
        personDetailDeathDay = findViewById(R.id.person_detail_deathday);
        personDetailDApartament = findViewById(R.id.person_detail_know_for_departament);
        personDetailHompage =  findViewById(R.id.person_detail_homepage);
        personDetailBiography = findViewById(R.id.person_detail_biography);
        personDetailName = findViewById(R.id.person_detail_name);

        personDetailProfileImagesRecyclerView = findViewById(R.id.person_detail_profile_images_recyclerView);
        personDetailProfileImagesRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        person_detail_conocido_por_recyclerview = findViewById(R.id.person_detail_conocido_por_recyclerview);
        person_detail_conocido_por_recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        person_conocido_por_recyclerview = findViewById(R.id.person_conocido_por_recyclerview);
        person_conocido_por_recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));





        if (intent !=null && intent.getExtras() !=null){
            //get the id from previos
            if (intent.getExtras().getString("id")!=null){
                int id = Integer.parseInt(intent.getExtras().getString("id"));

                Call<PersonDetails> personDetailsCall = retrofietService.getPersonDetailsById(id,BuildConfig.THE_MOVIE_DB_API_KEY);
                personDetailsCall.enqueue(new Callback<PersonDetails>() {
                    @Override
                    public void onResponse(@NonNull Call<PersonDetails> call, @NonNull Response<PersonDetails> response) {
                        PersonDetails personDetailsResponse = response.body();

                        if (personDetailsResponse !=null){
                            preparePersonDetails(personDetailsResponse);
                        }else {
                            Toast.makeText(PersonDetailActivity.this, "No ay detalles encontrados :(", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<PersonDetails> call,@NonNull Throwable t) {

                    }
                });

                //aqui sale alas imagnes profile
                Call<PersonImages> personImagesCall = retrofietService.getPersonImagesById(id,BuildConfig.THE_MOVIE_DB_API_KEY);
                personImagesCall.enqueue(new Callback<PersonImages>() {
                    @Override
                    public void onResponse(@NonNull Call<PersonImages> call,@NonNull Response<PersonImages> response) {
                        PersonImages personImages  = response.body();

                        if (personImages !=null){
                            List<PersonImagesProfiles> personImagesProfilesList = personImages.getProfiles();

                            if (personImagesProfilesList!=null && personImagesProfilesList.size()>0){

                                personDetailProfileImagesLayout.setVisibility(View.VISIBLE);

                                personProfilesImagesAdapter = new PersonProfilesImagesAdapter(PersonDetailActivity.this,personImagesProfilesList);

                                personDetailProfileImagesRecyclerView.setAdapter(personProfilesImagesAdapter);

                                LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(PersonDetailActivity.this,R.anim.layout_slide_right);
                                personDetailProfileImagesRecyclerView.setLayoutAnimation(controller);
                                personDetailProfileImagesRecyclerView.scheduleLayoutAnimation();

                            }else {
                                personDetailProfileImagesLayout.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<PersonImages> call, @NonNull Throwable t) {

                    }
                });
                Call<PersonDetailMovieCredits> creditsCall =  retrofietService.getPersonMovieCredits(id,BuildConfig.THE_MOVIE_DB_API_KEY);
                creditsCall.enqueue(new Callback<PersonDetailMovieCredits>() {
                    @Override
                    public void onResponse(@NonNull Call<PersonDetailMovieCredits> call,@NonNull  Response<PersonDetailMovieCredits> response) {

                        PersonDetailMovieCredits personresponse =response.body();

                        if (personresponse!=null){
                            List<PersonDetailMovieCreditsCast> creditsCasts =  personresponse.getCast();
                            if (creditsCasts.size()>0){

                                PersonCredistCastAdapter adapter = new PersonCredistCastAdapter(PersonDetailActivity.this,creditsCasts);
                                person_detail_conicido_por_layout.setVisibility(View.VISIBLE);
                                person_detail_conocido_por_recyclerview.setAdapter(adapter);
                                LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(PersonDetailActivity.this,R.anim.layout_slide_right);
                                person_detail_conocido_por_recyclerview.setLayoutAnimation(controller);
                                person_detail_conocido_por_recyclerview.scheduleLayoutAnimation();

                            }else {
                                person_detail_conicido_por_layout.setVisibility(View.GONE);
                            }
                        }else {
                            person_detail_conicido_por_layout.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull  Call<PersonDetailMovieCredits> call,@NonNull  Throwable t) {

                    }
                });

                Call<PersonTvCredits> personTvCreditsCall = retrofietService.getPersonTvcredits(id,BuildConfig.THE_MOVIE_DB_API_KEY);
                personTvCreditsCall.enqueue(new Callback<PersonTvCredits>() {
                    @Override
                    public void onResponse(@NonNull Call<PersonTvCredits> call, @NonNull Response<PersonTvCredits> response) {

                        PersonTvCredits tvCredits = response.body();

                        if (tvCredits!=null){
                            List<PersonTvCreditsCast> tvCreditsCastList = tvCredits.getCast();
                            if (tvCreditsCastList.size()>0){
                                PersonTvCredistCastAdapter adapter =new PersonTvCredistCastAdapter(PersonDetailActivity.this,tvCreditsCastList);

                                 person_conicido_por_layout.setVisibility(View.VISIBLE);
                                person_conocido_por_recyclerview.setAdapter(adapter);
                                LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(PersonDetailActivity.this,R.anim.layout_slide_right);
                                person_conocido_por_recyclerview.setLayoutAnimation(controller);
                                person_conocido_por_recyclerview.scheduleLayoutAnimation();

                            }else {
                                person_conicido_por_layout.setVisibility(View.GONE);
                            }
                        }else {
                            person_conicido_por_layout.setVisibility(View.GONE);
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<PersonTvCredits> call, @NonNull Throwable t) {

                    }
                });

            }
        }

    }

    private void preparePersonDetails(PersonDetails personDetailsResponse) {
        
        String profilePath = personDetailsResponse.getProfile_path();

        String name =personDetailsResponse.getName();
        String birthday = personDetailsResponse.getBirthday();
        String placeOfBirth = personDetailsResponse.getPlace_of_birth();
        String deathDay = personDetailsResponse.getDeathday();
        String department = personDetailsResponse.getKnown_for_deparment();
        String homepage = personDetailsResponse.getHomepage();
        String biography = personDetailsResponse.getBiography();

        List<String> alsoKnowAsList = personDetailsResponse.getAlso_known_as();
        Picasso.with(this).load(profilePath).into(personDetailProfileImageView);

        if (name !=null){
            if (name.length()>0){

                personDetailName.setText(name);
                personDetailName.setVisibility(View.VISIBLE);
            }else {
                personDetailName.setVisibility(View.GONE);
            }
        }else {
            personDetailName.setVisibility(View.GONE);
        }

        if (alsoKnowAsList !=null){
            if (alsoKnowAsList.size()>0){
                StringBuilder stringBuilder = new StringBuilder();
                for (int i =0; i< alsoKnowAsList.size();i++){
                    if (i==alsoKnowAsList.size()-1){
                        stringBuilder.append(alsoKnowAsList.get(i));
                    }else {
                        stringBuilder.append(alsoKnowAsList.get(i)).append(", ");
                    }
                }
                personDetailAlsoKnowAs.setText(stringBuilder.toString());
                personDetailAlsoKnowAsLayout.setVisibility(View.VISIBLE);
            }else {
                personDetailAlsoKnowAsLayout.setVisibility(View.GONE);
            }
        }else {
            personDetailAlsoKnowAsLayout.setVisibility(View.GONE);
        }



        if (biography !=null){
            if (biography.length()>0){

                personDetailBiography.setText(biography);
                personDetailBiographyLayout.setVisibility(View.VISIBLE);
            }else {
                personDetailBiographyLayout.setVisibility(View.GONE);
            }
        }else {
            personDetailBiographyLayout.setVisibility(View.GONE);
        }


        if (placeOfBirth !=null){
            if (placeOfBirth.length()>0){

                personDetailPlaceOFbirth.setText(placeOfBirth);
                personDetailPlaceOFbirthLayout.setVisibility(View.VISIBLE);
            }else {
                personDetailPlaceOFbirthLayout.setVisibility(View.GONE);
            }
        }else {
            personDetailPlaceOFbirthLayout.setVisibility(View.GONE);
        }


        if (deathDay !=null){
            if (deathDay.length()>0){

                personDetailDeathDay.setText(deathDay);
                personDetailDeathDayLayout.setVisibility(View.VISIBLE);
            }else {
                personDetailDeathDayLayout.setVisibility(View.GONE);
            }
        }else {
            personDetailDeathDayLayout.setVisibility(View.GONE);
        }


        if (department !=null){
            if (department.length()>0){

                personDetailDApartament.setText(department);
                personDetailDApartamentLayout.setVisibility(View.VISIBLE);
            }else {
                personDetailDApartamentLayout.setVisibility(View.GONE);
            }
        }else {
            personDetailDApartamentLayout.setVisibility(View.GONE);
        }



        if (homepage !=null){
            if (homepage.length()>0){

                personDetailHompage.setText(homepage);
                personDetailHompageLayout.setVisibility(View.VISIBLE);
            }else {
                personDetailHompageLayout.setVisibility(View.GONE);
            }
        }else {
            personDetailHompageLayout.setVisibility(View.GONE);
        }


        if (birthday !=null){
            if (birthday.length()>0){

                personDetailBirthday.setText(birthday);
                personDetailBirthdayLayout.setVisibility(View.VISIBLE);
            }else {
                personDetailBirthdayLayout.setVisibility(View.GONE);
            }
        }else {
            personDetailBirthdayLayout.setVisibility(View.GONE);
        }



    }

    //set animation for back to main activity


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_letf,R.anim.slide_out_right);
    }
}
