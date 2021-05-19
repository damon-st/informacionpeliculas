package com.damon.peliculasinformacion.ViewHolder;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.peliculasinformacion.R;
import com.github.lzyzsd.circleprogress.ArcProgress;
import com.squareup.picasso.Picasso;

public class SeasonDetailViewHolder extends RecyclerView.ViewHolder {

    public ImageView imagen_episodio;
    public AppCompatTextView nombre_espisodio;
    public AppCompatTextView episodio_numero;
    public ArcProgress detail_rango;
    public AppCompatTextView season_detail_overview;
    public TextView clik_ver;


    public SeasonDetailViewHolder(@NonNull View itemView) {
        super(itemView);

        imagen_episodio= itemView.findViewById(R.id.imagen_episodio);
        nombre_espisodio = itemView.findViewById(R.id.nombre_espisodio);
        episodio_numero = itemView.findViewById(R.id.episodio_numero);
        detail_rango = itemView.findViewById(R.id.detail_rango);
        season_detail_overview = itemView.findViewById(R.id.season_detail_overview);

        clik_ver = itemView.findViewById(R.id.clik_ver);
    }

    public void setImagen_episodio(Activity activity,String url) {
        Picasso.with(activity).load(url).into(imagen_episodio);
    }
}
