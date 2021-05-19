package com.damon.peliculasinformacion.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.peliculasinformacion.Model.Person.PersonDetailMovieCreditsCast;
import com.damon.peliculasinformacion.MovieDetailActivity;
import com.damon.peliculasinformacion.R;
import com.damon.peliculasinformacion.ViewHolder.MovieCreditsViewHolder;

import java.util.List;

public class PersonCredistCastAdapter extends RecyclerView.Adapter<MovieCreditsViewHolder> {

    private Activity activity;
    private List<PersonDetailMovieCreditsCast> personDetailMovieCreditsCastList;

    public PersonCredistCastAdapter(Activity activity, List<PersonDetailMovieCreditsCast> personDetailMovieCreditsCastList) {
        this.activity = activity;
        this.personDetailMovieCreditsCastList = personDetailMovieCreditsCastList;
    }

    @NonNull
    @Override
    public MovieCreditsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.movie_credits_layout,parent,false);
        return new MovieCreditsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieCreditsViewHolder holder, int position) {
        PersonDetailMovieCreditsCast creditsCast = personDetailMovieCreditsCastList.get(position);

        holder.setMovieCreditsImageView(activity,creditsCast.getPoster_path());
        holder.movieCreditsName.setText(creditsCast.getTitle());
        holder.movieCreditsCharacter.setText("Personaje: "+creditsCast.getCharacter());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, MovieDetailActivity.class);
                intent.putExtra("id",String.valueOf(creditsCast.getId()));
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_letf);
            }
        });

    }

    @Override
    public int getItemCount() {
        return personDetailMovieCreditsCastList.size();
    }
}
