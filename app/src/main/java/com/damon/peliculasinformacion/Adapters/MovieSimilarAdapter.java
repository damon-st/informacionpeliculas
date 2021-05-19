package com.damon.peliculasinformacion.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.peliculasinformacion.Model.Movie.MovieDetailsProductionCompanies;
import com.damon.peliculasinformacion.Model.Movie.MovieSimilarResults;
import com.damon.peliculasinformacion.MovieDetailActivity;
import com.damon.peliculasinformacion.R;
import com.damon.peliculasinformacion.ViewHolder.MovieProductionCompanyViewHolder;

import java.util.List;

public class MovieSimilarAdapter extends RecyclerView.Adapter<MovieProductionCompanyViewHolder> {

    private Activity activity;
    private List<MovieSimilarResults> movieDetailsProductionCompaniesList;

    public MovieSimilarAdapter(Activity activity, List<MovieSimilarResults> movieDetailsProductionCompaniesList) {
        this.activity = activity;
        this.movieDetailsProductionCompaniesList = movieDetailsProductionCompaniesList;
    }

    @NonNull
    @Override
    public MovieProductionCompanyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.production_company_layout,parent,false);
        return new MovieProductionCompanyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MovieProductionCompanyViewHolder holder, int position) {

        MovieSimilarResults movieDetailsProductionCompanies =movieDetailsProductionCompaniesList.get(position);

        holder.setProductionCompanyImageView(activity,movieDetailsProductionCompanies.getBackdrop_path());

        holder.productionCompanyName.setText(movieDetailsProductionCompanies.getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, MovieDetailActivity.class);
                intent.putExtra("id",String.valueOf(movieDetailsProductionCompanies.getId()));
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_letf);
            }
        });


    }

    @Override
    public int getItemCount() {
        return movieDetailsProductionCompaniesList.size();
    }
}
