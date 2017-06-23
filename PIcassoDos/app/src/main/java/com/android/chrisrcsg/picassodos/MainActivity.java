package com.android.chrisrcsg.picassodos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    String[] perritos = {
            "https://s-media-cache-ak0.pinimg.com/736x/6f/7e/41/6f7e41ba3a4bed8ab76836e86e9b1f25--pomeranians-chihuahuas.jpg",
            "http://www.significado-de-nombres.com/wp-content/uploads/2016/01/perro-pequeno-macho.jpg",
            "http://www.significado-de-nombres.com/wp-content/uploads/2016/01/nombres-para-perritos.jpg",
            "https://s-media-cache-ak0.pinimg.com/736x/6f/7e/41/6f7e41ba3a4bed8ab76836e86e9b1f25--pomeranians-chihuahuas.jpg",
            "http://www.significado-de-nombres.com/wp-content/uploads/2016/01/perro-pequeno-macho.jpg",
            "http://www.significado-de-nombres.com/wp-content/uploads/2016/01/nombres-para-perritos.jpg",
            "https://s-media-cache-ak0.pinimg.com/736x/6f/7e/41/6f7e41ba3a4bed8ab76836e86e9b1f25--pomeranians-chihuahuas.jpg",
            "http://www.significado-de-nombres.com/wp-content/uploads/2016/01/perro-pequeno-macho.jpg",
            "http://www.significado-de-nombres.com/wp-content/uploads/2016/01/nombres-para-perritos.jpg",
            "https://s-media-cache-ak0.pinimg.com/736x/6f/7e/41/6f7e41ba3a4bed8ab76836e86e9b1f25--pomeranians-chihuahuas.jpg",
            "http://www.significado-de-nombres.com/wp-content/uploads/2016/01/perro-pequeno-macho.jpg",
            "http://www.significado-de-nombres.com/wp-content/uploads/2016/01/nombres-para-perritos.jpg",
            "https://s-media-cache-ak0.pinimg.com/736x/6f/7e/41/6f7e41ba3a4bed8ab76836e86e9b1f25--pomeranians-chihuahuas.jpg",
            "http://www.significado-de-nombres.com/wp-content/uploads/2016/01/perro-pequeno-macho.jpg",
            "http://www.significado-de-nombres.com/wp-content/uploads/2016/01/nombres-para-perritos.jpg",
            "https://s-media-cache-ak0.pinimg.com/736x/6f/7e/41/6f7e41ba3a4bed8ab76836e86e9b1f25--pomeranians-chihuahuas.jpg",
            "http://www.significado-de-nombres.com/wp-content/uploads/2016/01/perro-pequeno-macho.jpg",
            "http://www.significado-de-nombres.com/wp-content/uploads/2016/01/nombres-para-perritos.jpg",
            
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.lista);
        gridView.setAdapter(new AdaptadorImagenes(MainActivity.this, perritos));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Picasso.with(MainActivity.this)
                        .load(perritos[i])
                        .rotate(180)
                        .fit()
                        .into((ImageView)view);
            }
        });
    }
}
