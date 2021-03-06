package com.damon.peliculasinformacion.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.damon.peliculasinformacion.Model.Movie.MovieDetailsProductionCompanies;

import com.damon.peliculasinformacion.R;

import com.damon.peliculasinformacion.ViewHolder.MovieProductionCompanyViewHolder;

import java.util.List;

public class MovieProductionCompaniesAdapter extends RecyclerView.Adapter<MovieProductionCompanyViewHolder> {

    private Activity activity;
    private List<MovieDetailsProductionCompanies> movieDetailsProductionCompaniesList;

    public MovieProductionCompaniesAdapter(Activity activity, List<MovieDetailsProductionCompanies> movieDetailsProductionCompaniesList) {
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

        MovieDetailsProductionCompanies movieDetailsProductionCompanies =movieDetailsProductionCompaniesList.get(position);

        holder.setProductionCompanyImageView(activity,movieDetailsProductionCompanies.getLogo_path());

        holder.productionCompanyName.setText(movieDetailsProductionCompanies.getName());




    }

    @Override
    public int getItemCount() {
        return movieDetailsProductionCompaniesList.size();
    }
}
