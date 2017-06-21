package com.example.chris.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Proteco on 20/06/2017.
 */
public class GirescopioActivity extends AppCompatActivity{
    GravityView gravityView;
    ImageView vista_imagen;
    boolean is_supported;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giroscopio_layout);
        vista_imagen = (ImageView) findViewById(R.id.imagen);
        gravityView = GravityView,getInstance(this)
                .setImage(R.drawable.land_image)
                .center();

        if (!is_supported){
            Toast.makeText(this,"No se soporta girescopio",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        gravityView.registerListener();
    }

    @Override
    protected void onStop() {
        super.onStop();
        gravityView.unregisterListener();
    }

    public void inInfo(View view){
        Intent i  = new Intent(this,GirescopioInfo.class);
        startActivity(i);
    }
}
