package com.damon.peliculasinformacion.ViewHolder;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.peliculasinformacion.R;
import com.squareup.picasso.Picasso;

public class TvSeasonsViewHolder extends RecyclerView.ViewHolder {

    public ImageView season_view;
    public AppCompatTextView season_name;

    public TvSeasonsViewHolder(@NonNull View itemView) {
        super(itemView);

        season_view = itemView.findViewById(R.id.season_view);
        season_name = itemView.findViewById(R.id.season_name);
    }

    public void setSeasonView(Activity activity ,String url){
        Picasso.with(activity).load(url).into(season_view);
    }
}
