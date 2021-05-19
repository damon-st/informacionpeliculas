package com.damon.peliculasinformacion.Utils;

import android.app.Activity;
import android.view.View;

public class FullSreenHelper {

    private Activity activity;
    private View[] views;

    public FullSreenHelper(Activity activity, View... views) {
        this.activity = activity;
        this.views = views;
    }

    private void showSystemUi(View decorView){

        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }

    private void hideSystemUi(View decorView){
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        |View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
    public void enterFullScreen(){

        View view = activity.getWindow().getDecorView();

        hideSystemUi(view);

        for ( View view1 : views){

            view1.setVisibility(View.GONE);
            view1.invalidate();
        }
    }

    public void exitFullScreen(){

        View view = activity.getWindow().getDecorView();

        hideSystemUi(view);

        for ( View view1 : views){

            view1.setVisibility(View.VISIBLE);
            view1.invalidate();
        }
    }


}
