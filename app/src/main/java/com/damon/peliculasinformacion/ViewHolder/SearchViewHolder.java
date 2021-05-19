package com.damon.peliculasinformacion.ViewHolder;

import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.peliculasinformacion.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;
import com.squareup.picasso.Picasso;

public class SearchViewHolder extends RecyclerView.ViewHolder {

    private KenBurnsView posterImageView;
    public AppCompatTextView posterTitle;

    public SearchViewHolder(@NonNull View itemView) {
        super(itemView);

        posterImageView = itemView.findViewById(R.id.poster_image_view);
        posterTitle = itemView.findViewById(R.id.poster_title);

        RandomTransitionGenerator generator = new RandomTransitionGenerator(1000,new DecelerateInterpolator());
        posterImageView.setTransitionGenerator(generator);


    }

    public void setPosterImageView(Context context ,String posterURL){
        Picasso.with(context).load(posterURL).into(posterImageView);
    }
}
