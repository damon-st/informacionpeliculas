package com.damon.peliculasinformacion.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.peliculasinformacion.ImageViewActivity;
import com.damon.peliculasinformacion.Model.Tv.TvSeasonsDetailEpisodes;
import com.damon.peliculasinformacion.R;
import com.damon.peliculasinformacion.ViewHolder.SeasonDetailViewHolder;

import java.util.List;

public class SeasonDetailTemporadaAdapter extends RecyclerView.Adapter<SeasonDetailViewHolder> {


    private Activity activity;
    private List<TvSeasonsDetailEpisodes> tvSeasonsDetailEpisodesList ;

    public SeasonDetailTemporadaAdapter(Activity activity, List<TvSeasonsDetailEpisodes> tvSeasonsDetailEpisodesList) {
        this.activity = activity;
        this.tvSeasonsDetailEpisodesList = tvSeasonsDetailEpisodesList;
    }

    @NonNull
    @Override
    public SeasonDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.layout_season_detail,parent,false);
        return new SeasonDetailViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SeasonDetailViewHolder holder, int position) {

        TvSeasonsDetailEpisodes tvSeasonsDetailEpisodes = tvSeasonsDetailEpisodesList.get(position);

        holder.setImagen_episodio(activity,tvSeasonsDetailEpisodes.getStill_path());
        holder.nombre_espisodio.setText(tvSeasonsDetailEpisodes.getName());
        holder.episodio_numero.setText("Episodio N°: "+tvSeasonsDetailEpisodes.getEpisode_number());

        Double vote = tvSeasonsDetailEpisodes.getVote_average()*10;
        int rating = vote.intValue();
        holder.detail_rango.setProgress(rating);


        String overview = tvSeasonsDetailEpisodes.getOverview();

        holder.clik_ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (overview!=null &&overview.length()>0){
                    holder.season_detail_overview.setVisibility(View.VISIBLE);
                    holder.season_detail_overview.setText(overview);
                    holder.clik_ver.setVisibility(View.GONE);

                    holder.season_detail_overview.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            holder.clik_ver.setVisibility(View.VISIBLE);
                            holder.season_detail_overview.setVisibility(View.GONE);
                        }
                    });
                }
            }
        });

        holder.imagen_episodio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ImageViewActivity.class);
                intent.putExtra("image_url",tvSeasonsDetailEpisodes.getStill_path());
                activity.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return tvSeasonsDetailEpisodesList.size();
    }


}
