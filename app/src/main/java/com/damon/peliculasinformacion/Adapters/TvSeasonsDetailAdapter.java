package com.damon.peliculasinformacion.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.peliculasinformacion.Model.Tv.TvDetailsSeasons;
import com.damon.peliculasinformacion.R;
import com.damon.peliculasinformacion.SeasonDetailActivity;
import com.damon.peliculasinformacion.ViewHolder.TvSeasonsViewHolder;

import java.util.List;

public class TvSeasonsDetailAdapter extends RecyclerView.Adapter<TvSeasonsViewHolder> {

    private Activity activity;
    private List<TvDetailsSeasons> tvDetailsSeaonslist;
    private int id;

    public TvSeasonsDetailAdapter(Activity activity, List<TvDetailsSeasons> movieDetailsProductionCompaniesList, int id) {
        this.activity = activity;
        this.tvDetailsSeaonslist = movieDetailsProductionCompaniesList;
        this.id =id;
    }

    @NonNull
    @Override
    public TvSeasonsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.layout_seasons,parent,false);
        return new TvSeasonsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TvSeasonsViewHolder holder, int position) {

        TvDetailsSeasons tvDetailsSeasons = tvDetailsSeaonslist.get(position);

        holder.setSeasonView(activity,tvDetailsSeasons.getPoster_path());

        holder.season_name.setText(tvDetailsSeasons.getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity, SeasonDetailActivity.class);
                intent.putExtra("season_number",String.valueOf(tvDetailsSeasons.getSeason_number()));
                intent.putExtra("id",String.valueOf(id));
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_letf);

            }
        });



    }

    @Override
    public int getItemCount() {
        return tvDetailsSeaonslist.size();
    }
}
