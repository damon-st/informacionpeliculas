package com.damon.peliculasinformacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;

import com.codewaves.youtubethumbnailview.ThumbnailLoader;
import com.codewaves.youtubethumbnailview.ThumbnailView;
import com.damon.peliculasinformacion.Adapters.ExtraTvVideosRecyclerViewAdaper;
import com.damon.peliculasinformacion.Adapters.ExtraVideosRecyclerViewAdaper;
import com.damon.peliculasinformacion.Model.Movie.MovieVideosResults;
import com.damon.peliculasinformacion.Model.Tv.TvSeasonsVideoResults;
import com.damon.peliculasinformacion.Utils.FullSreenHelper;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerInitListener;

import java.util.ArrayList;

public class VideoPlayActivity extends AppCompatActivity {

    private ThumbnailView thumbnailView;
    private YouTubePlayerView playerView;

    private ProgressBar progressBar;

    private RecyclerView otherVideoRecyclerView;

    private FullSreenHelper fullSreenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);

        Intent intent = getIntent();

        ThumbnailLoader.initialize(BuildConfig.THE_YOUTUBE_API_KEY);

        fullSreenHelper = new FullSreenHelper(this);

        thumbnailView = findViewById(R.id.video_thumbnail_view);
        playerView = findViewById(R.id.video_player_view);

        AppCompatTextView videoTitle = findViewById(R.id.play_video_title);
        AppCompatTextView noResultFound = findViewById(R.id.no_result_found);

        otherVideoRecyclerView = findViewById(R.id.other_videos_recycler_view);
        otherVideoRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        progressBar  = findViewById(R.id.progress_bar);

        progressBar.getIndeterminateDrawable().setColorFilter(0XFFFFFFFF, PorterDuff.Mode.MULTIPLY);

        //now get the arraylist and position

        if (intent !=null && intent.getExtras()!=null){

            String movie = intent.getExtras().getString("movie");
            String tv = intent.getExtras().getString("tv");

            if (movie!=null &&movie.equals("movie")){


                movie(intent, videoTitle, noResultFound);


            }else if (tv!=null &&tv.equals("tv")){

                tv(intent, videoTitle, noResultFound);

            }


        }

    }

    private void tv(Intent intent, AppCompatTextView videoTitle, AppCompatTextView noResultFound) {
        ArrayList<TvSeasonsVideoResults> movieVideosResultsArrayList = intent.getExtras().getParcelableArrayList("video");

        int position = Integer.parseInt(intent.getExtras().getString("position"));

        if (movieVideosResultsArrayList !=null && movieVideosResultsArrayList.size()>0){
            String videoId = movieVideosResultsArrayList.get(position).getKey();
            String title = movieVideosResultsArrayList.get(position).getName();

            if (title!=null){
                videoTitle.setText(title);
            }
            if (videoId !=null){
                String baseUrl = "https://wwww.youtube.com/watch?v=";

                thumbnailView.loadThumbnail(baseUrl+videoId);

                playerView.initialize(new YouTubePlayerInitListener() {
                    @Override
                    public void onInitSuccess(@NonNull YouTubePlayer youTubePlayer) {

                        youTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                            @Override
                            public void onReady() {

                                //when video is ready to play hide the thumnail and progress bar
                                thumbnailView.setVisibility(View.GONE);
                                progressBar.setVisibility(View.GONE);

                                //show the youtube player
                                playerView.setVisibility(View.VISIBLE);

                                if (getLifecycle().getCurrentState()== Lifecycle.State.RESUMED){
                                    youTubePlayer.loadVideo(videoId,0);
                                }else {
                                    youTubePlayer.cueVideo(videoId,0);
                                }
                            }

                        });

                        playerView.addFullScreenListener(new YouTubePlayerFullScreenListener() {
                            @Override
                            public void onYouTubePlayerEnterFullScreen() {

                                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                                fullSreenHelper.enterFullScreen();
                            }

                            @Override
                            public void onYouTubePlayerExitFullScreen() {
                                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                                fullSreenHelper.exitFullScreen();
                            }
                        });
                    }
                },true);

                //load other videos in recycler view

                ArrayList<TvSeasonsVideoResults> movieVideosResultsList = new ArrayList<>(movieVideosResultsArrayList);

                //remove current video from the list

                movieVideosResultsList.remove(position);

                if (movieVideosResultsList.size()>0){
                    noResultFound.setVisibility(View.GONE);

                    ExtraTvVideosRecyclerViewAdaper adaper = new ExtraTvVideosRecyclerViewAdaper(VideoPlayActivity.this,movieVideosResultsList);

                    otherVideoRecyclerView.setAdapter(adaper);

                    otherVideoRecyclerView.setVisibility(View.VISIBLE);

                    //crete animation fotr the loagin items

                    LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(this,R.anim.layout_slide_bottom);
                    otherVideoRecyclerView.setLayoutAnimation(controller);
                    otherVideoRecyclerView.scheduleLayoutAnimation();

                }else {
                    otherVideoRecyclerView.setVisibility(View.GONE);
                    noResultFound.setVisibility(View.VISIBLE);
                }

            }

        }
    }

    private void movie(Intent intent, AppCompatTextView videoTitle, AppCompatTextView noResultFound) {
        ArrayList<MovieVideosResults> movieVideosResultsArrayList = intent.getExtras().getParcelableArrayList("video");

        int position = Integer.parseInt(intent.getExtras().getString("position"));

        if (movieVideosResultsArrayList !=null && movieVideosResultsArrayList.size()>0){
            String videoId = movieVideosResultsArrayList.get(position).getKey();
            String title = movieVideosResultsArrayList.get(position).getName();

            if (title!=null){
                videoTitle.setText(title);
            }
            if (videoId !=null){
                String baseUrl = "https://wwww.youtube.com/watch?v=";

                thumbnailView.loadThumbnail(baseUrl+videoId);

                playerView.initialize(new YouTubePlayerInitListener() {
                    @Override
                    public void onInitSuccess(@NonNull YouTubePlayer youTubePlayer) {

                        youTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                            @Override
                            public void onReady() {

                                //when video is ready to play hide the thumnail and progress bar
                                thumbnailView.setVisibility(View.GONE);
                                progressBar.setVisibility(View.GONE);

                                //show the youtube player
                                playerView.setVisibility(View.VISIBLE);

                                if (getLifecycle().getCurrentState()== Lifecycle.State.RESUMED){
                                    youTubePlayer.loadVideo(videoId,0);
                                }else {
                                    youTubePlayer.cueVideo(videoId,0);
                                }
                            }

                        });

                        playerView.addFullScreenListener(new YouTubePlayerFullScreenListener() {
                            @Override
                            public void onYouTubePlayerEnterFullScreen() {

                                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                                fullSreenHelper.enterFullScreen();
                            }

                            @Override
                            public void onYouTubePlayerExitFullScreen() {
                                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                                fullSreenHelper.exitFullScreen();
                            }
                        });
                    }
                },true);

                //load other videos in recycler view

                ArrayList<MovieVideosResults> movieVideosResultsList = new ArrayList<>(movieVideosResultsArrayList);

                //remove current video from the list

                movieVideosResultsList.remove(position);

                if (movieVideosResultsList.size()>0){
                    noResultFound.setVisibility(View.GONE);

                    ExtraVideosRecyclerViewAdaper adaper = new ExtraVideosRecyclerViewAdaper(VideoPlayActivity.this,movieVideosResultsList);

                    otherVideoRecyclerView.setAdapter(adaper);

                    otherVideoRecyclerView.setVisibility(View.VISIBLE);

                    //crete animation fotr the loagin items

                    LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(this,R.anim.layout_slide_bottom);
                    otherVideoRecyclerView.setLayoutAnimation(controller);
                    otherVideoRecyclerView.scheduleLayoutAnimation();

                }else {
                    otherVideoRecyclerView.setVisibility(View.GONE);
                    noResultFound.setVisibility(View.VISIBLE);
                }

            }

        }
    }
    //exit the fullscreen on backprese

    @Override
    protected void onDestroy() {
        super.onDestroy();
        playerView.release();
    }

    @Override
    public void onBackPressed() {

        if (playerView.isFullScreen()){
            playerView.exitFullScreen();
        }else {
            otherVideoRecyclerView.setVisibility(View.GONE);
            playerView.setVisibility(View.GONE);
            thumbnailView.setVisibility(View.VISIBLE);
            super.onBackPressed();
        }
    }

}
