package com.damon.peliculasinformacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.damon.peliculasinformacion.Utils.ZoomageView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.UUID;

import dmax.dialog.SpotsDialog;

public class ImageViewActivity extends AppCompatActivity {


    FloatingActionButton guardar;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        guardar = findViewById(R.id.guardar);

        //set full screen for the activity

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();

        ZoomageView zoomageView = findViewById(R.id.zoom_image_view);

        if (intent !=null && intent.getExtras() !=null){

            if (intent.getExtras().getString("image_url")!=null){

                 url = intent.getStringExtra("image_url");

                Picasso.with(this).load(url).into(zoomageView);


                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (ActivityCompat.checkSelfPermission(ImageViewActivity.this,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                            }
                        }else {
                            AlertDialog dialog = new SpotsDialog(ImageViewActivity.this);
                            dialog.show();
                            dialog.setMessage("Porfavor Espere....");

                            String filename = UUID.randomUUID().toString()+".png";
                            Picasso.with(ImageViewActivity.this)
                                    .load(url)
                                    .into(new SaveImageHelper(getBaseContext(),
                                            dialog,
                                            getApplicationContext().getContentResolver(),
                                            filename,
                                            "Descripcion"));
                            //primer paremetro el contexto
                            //segundo parametro el dialogo
                            //tercero el resolver utiliando picaso
                            //nombre y descipcion
                        }


                    }
                });


            }
        }


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 100:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                    AlertDialog dialog = new SpotsDialog(ImageViewActivity.this);
                    dialog.show();
                    dialog.setMessage("Porfavor Espere....");

                    String filename = UUID.randomUUID().toString()+".png";
                    Picasso.with(ImageViewActivity.this)
                            .load(url)
                            .into(new SaveImageHelper(getBaseContext(),
                                    dialog,
                                    getApplicationContext().getContentResolver(),
                                    filename,
                                    "Descripcion"));
                }else {
                    Toast.makeText(this, "Permiso Necesario Para Descargar Imagenes", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


}
