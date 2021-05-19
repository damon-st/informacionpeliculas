package com.damon.peliculasinformacion.ViewHolder;

import android.app.Activity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.peliculasinformacion.R;
import com.squareup.picasso.Picasso;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    public AppCompatImageView profileImage;

    public ImageViewHolder(@NonNull View itemView) {
        super(itemView);

        profileImage = itemView.findViewById(R.id.profile_image);

    }

    public void setProfileImage(Activity activity,String profilePath){
        Picasso.with(activity).load(profilePath).into(profileImage);
    }
}
