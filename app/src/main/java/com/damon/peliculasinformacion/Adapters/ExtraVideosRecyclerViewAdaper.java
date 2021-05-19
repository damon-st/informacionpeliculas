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

import com.damon.peliculasinformacion.Model.Movie.MovieVideosResults;
import com.damon.peliculasinformacion.R;
import com.damon.peliculasinformacion.VideoPlayActivity;
import com.damon.peliculasinformacion.ViewHolder.MovieVideosViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ExtraVideosRecyclerViewAdaper  extends RecyclerView.Adapter<MovieVideosViewHolder> {

    private Activity activity;
    private List<MovieVideosResults> movieVideosResultsList ;

    public ExtraVideosRecyclerViewAdaper(Activity activity, List<MovieVideosResults> movieVideosResultsList) {
        this.activity = activity;
        this.movieVideosResultsList = movieVideosResultsList;
    }

    @NonNull
    @Override
    public MovieVideosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(activity).inflate(R.layout.video_layout,parent,false);

        return new MovieVideosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieVideosViewHolder holder, int position) {

        MovieVideosResults movieVideosResults = movieVideosResultsList.get(position);

        String baseUrl = "https://wwww.youtube.com/watch?v=";
        String videoUrl = baseUrl +movieVideosResults.getKey();

        holder.setThumbnailView(activity,videoUrl);
        holder.videoTitle.setText(movieVideosResults.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<MovieVideosResults> movieVideosResultsArrayList = new ArrayList<>(movieVideosResultsList);

                Intent intent = new Intent(activity, VideoPlayActivity.class);

                //set Animation to open the video

                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,holder.thumbnailView, ViewCompat.getTransitionName(holder.thumbnailView));

                //put the current video position and video list
                intent.putExtra("movie","movie");
                intent.putExtra("position",String.valueOf(holder.getAdapterPosition()));
                intent.putExtra("video",movieVideosResultsArrayList);


                activity.startActivity(intent,compat.toBundle());

            }
        });

    }

    @Override
    public int getItemCount() {
        return movieVideosResultsList.size();
    }

}
