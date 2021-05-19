package com.damon.peliculasinformacion.ViewHolder;

import android.app.Activity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.peliculasinformacion.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

public class TvLastEpisodeToAirViewHolder extends RecyclerView.ViewHolder {


    public KenBurnsView imagen_las_episode;
    public AppCompatTextView name_episode_last;
    public AppCompatTextView fecha_last_episode;
    public AppCompatTextView overview_last_episode;


    public TvLastEpisodeToAirViewHolder(@NonNull View itemView) {
        super(itemView);

        imagen_las_episode = itemView.findViewById(R.id.imagen_las_episode);
        name_episode_last = itemView.findViewById(R.id.name_episode_last);
        fecha_last_episode = itemView.findViewById(R.id.fecha_last_episode);
        overview_last_episode = itemView.findViewById(R.id.overview_last_episode);



    }

    public void setImagen_las_episode(Activity activity ,String url) {
        Picasso.with(activity).load(url).into(imagen_las_episode);
    }
}
