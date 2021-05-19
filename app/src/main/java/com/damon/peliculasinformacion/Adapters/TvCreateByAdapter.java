package com.damon.peliculasinformacion.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.peliculasinformacion.Model.Tv.TvDetailsCreateBy;
import com.damon.peliculasinformacion.PersonDetailActivity;
import com.damon.peliculasinformacion.R;
import com.damon.peliculasinformacion.ViewHolder.MovieProductionCompanyViewHolder;

import java.util.List;

public class TvCreateByAdapter extends RecyclerView.Adapter<MovieProductionCompanyViewHolder> {

    private Activity activity;
    private List<TvDetailsCreateBy> movieDetailsProductionCompaniesList;

    public TvCreateByAdapter(Activity activity, List<TvDetailsCreateBy> movieDetailsProductionCompaniesList) {
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

        TvDetailsCreateBy movieDetailsProductionCompanies =movieDetailsProductionCompaniesList.get(position);

        holder.setProductionCompanyImageView(activity,movieDetailsProductionCompanies.getProfile_path());

        holder.productionCompanyName.setText(movieDetailsProductionCompanies.getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PersonDetailActivity.class);
                intent.putExtra("id",String.valueOf(movieDetailsProductionCompanies.getId()));
                activity.startActivity(intent);
                // create som animationto open
                activity.overridePendingTransition(R.anim.slide_in_letf,R.anim.slide_out_right);
            }
        });


    }

    @Override
    public int getItemCount() {
        return movieDetailsProductionCompaniesList.size();
    }
}
