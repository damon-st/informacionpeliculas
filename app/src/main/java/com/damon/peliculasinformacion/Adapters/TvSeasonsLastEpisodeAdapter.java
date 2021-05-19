package com.damon.peliculasinformacion.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.peliculasinformacion.Model.Tv.TvDetailsLastEspisodeToAir;
import com.damon.peliculasinformacion.R;
import com.damon.peliculasinformacion.ViewHolder.TvLastEpisodeToAirViewHolder;

import java.util.List;

public class TvSeasonsLastEpisodeAdapter extends RecyclerView.Adapter<TvLastEpisodeToAirViewHolder> {

    private Activity activity;
    private List<TvDetailsLastEspisodeToAir> tvDetailsLastEspisodeToAirList ;

    public TvSeasonsLastEpisodeAdapter(Activity activity, List<TvDetailsLastEspisodeToAir> tvDetailsLastEspisodeToAirList) {
        this.activity = activity;
        this.tvDetailsLastEspisodeToAirList = tvDetailsLastEspisodeToAirList;
    }

    @NonNull
    @Override
    public TvLastEpisodeToAirViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.layout_last_espisode_air,parent,false);
        return new TvLastEpisodeToAirViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull TvLastEpisodeToAirViewHolder holder, int position) {
        TvDetailsLastEspisodeToAir espisodeToAir = tvDetailsLastEspisodeToAirList.get(position);

        holder.setImagen_las_episode(activity,espisodeToAir.getStill_path());
        holder.name_episode_last.setText(espisodeToAir.getName());
        holder.fecha_last_episode.setText(espisodeToAir.getAir_date());
        holder.overview_last_episode.setText(espisodeToAir.getOverview());

    }

    @Override
    public int getItemCount() {
        return tvDetailsLastEspisodeToAirList.size();
    }
}
