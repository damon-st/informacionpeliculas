package com.damon.peliculasinformacion.ViewHolder;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.codewaves.youtubethumbnailview.ImageLoader;
import com.codewaves.youtubethumbnailview.ThumbnailLoadingListener;
import com.codewaves.youtubethumbnailview.ThumbnailView;
import com.damon.peliculasinformacion.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class MovieVideosViewHolder extends RecyclerView.ViewHolder {

    public ThumbnailView thumbnailView;
    public AppCompatTextView videoTitle;


    public MovieVideosViewHolder(@NonNull View itemView) {
        super(itemView);

        thumbnailView = itemView.findViewById(R.id.video_image_view);
        videoTitle = itemView.findViewById(R.id.video_title);





    }

    public void setThumbnailView(Activity activity,String videoUrl) {
       
        thumbnailView.loadThumbnail(videoUrl, new ThumbnailLoadingListener() {
            @Override
            public void onLoadingStarted(@NonNull String url, @NonNull View view) {

            }

            @Override
            public void onLoadingComplete(@NonNull String url, @NonNull View view) {


            }

            @Override
            public void onLoadingCanceled(@NonNull String url, @NonNull View view) {

            }

            @Override
            public void onLoadingFailed(@NonNull String url, @NonNull View view, Throwable error) {

//                Toast.makeText(activity, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("ERRO--"+error.getLocalizedMessage());
              //  Toast.makeText(activity, url, Toast.LENGTH_SHORT).show();

            }
        });



    }
}
