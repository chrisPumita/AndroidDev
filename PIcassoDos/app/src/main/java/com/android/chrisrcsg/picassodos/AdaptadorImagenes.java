package com.android.chrisrcsg.picassodos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by ChrisRCSG on 23/06/17.
 */

public class AdaptadorImagenes extends ArrayAdapter{
    private Context contexto;
    private LayoutInflater inflater;
    private String[] perritos;

    public AdaptadorImagenes(Context contexto, String[] perritos){
        super(contexto, R.layout.elemento, perritos);

        this.contexto = contexto;
        this.perritos = perritos;

        inflater = LayoutInflater.from(contexto);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.elemento, parent, false);

        Picasso.with(contexto).load(perritos[position]).into((ImageView) convertView);
        return convertView;
    }
}

