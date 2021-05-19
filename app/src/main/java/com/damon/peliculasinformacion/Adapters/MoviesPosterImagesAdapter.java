package com.damon.peliculasinformacion.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.peliculasinformacion.ImageViewActivity;
import com.damon.peliculasinformacion.Model.Movie.MovieImagesBackDropsAndPosters;
import com.damon.peliculasinformacion.R;
import com.damon.peliculasinformacion.ViewHolder.ImageViewHolder;

import java.util.List;

public class MoviesPosterImagesAdapter extends RecyclerView.Adapter<ImageViewHolder> {

    private Activity activity;
    private List<MovieImagesBackDropsAndPosters>movieImagesBackDropsAndPostersList;

    public MoviesPosterImagesAdapter(Activity activity, List<MovieImagesBackDropsAndPosters> movieImagesBackDropsAndPostersList) {
        this.activity = activity;
        this.movieImagesBackDropsAndPostersList = movieImagesBackDropsAndPostersList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.profile_images_layout,parent,false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        MovieImagesBackDropsAndPosters imagesBackDropsAndPosters = movieImagesBackDropsAndPostersList.get(position);

        holder.setProfileImage(activity,imagesBackDropsAndPosters.getFile_path());

        holder.profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent imageViewIntent = new Intent(activity, ImageViewActivity.class);

                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,holder.profileImage, ViewCompat.getTransitionName(holder.profileImage));

                imageViewIntent.putExtra("image_url",imagesBackDropsAndPosters.getFile_path());
                activity.startActivity(imageViewIntent,compat.toBundle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieImagesBackDropsAndPostersList.size();
    }
}
