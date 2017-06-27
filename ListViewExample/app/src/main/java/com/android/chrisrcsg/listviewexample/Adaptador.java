package com.android.chrisrcsg.listviewexample;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ChrisRCSG on 26/06/17.
 */

public class Adaptador extends BaseAdapter {

    private List<Conversacion>conversaciones;
    private Context contexto;
    private int layout;


    public Adaptador(List<Conversacion> conversaciones, Context contexto, int layout) {
        this.conversaciones = conversaciones;
        this.contexto = contexto;
        this.layout = layout;
    }



    //elementos que contendra la vista de la lista en la interfaz
    static class ViewHolder{
        private TextView nombreTV;
        private TextView mensajeTV;
        private ImageView imagenTV;
    }

    //contar los elementos delos listView
    @Override
    public int getCount() {
        return this.conversaciones.size();
    }


    //
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Instanciando la clase VieHolder
        ViewHolder elemento;

        if (convertView == null){
            //si no hay elementos en la lista se creará
            LayoutInflater layoutInflater = LayoutInflater.from(this.contexto);
            convertView = layoutInflater.inflate(this.layout, null);

            elemento = new ViewHolder();

            elemento.nombreTV = (TextView)convertView.findViewById(R.id.nombre);
            elemento.mensajeTV = (TextView)convertView.findViewById(R.id.mensaje);
            elemento.imagenTV = (ImageView) convertView.findViewById(R.id.imagen);


            //loigando elementos
            convertView.setTag(elemento);
        }
        else {
            elemento = (ViewHolder)convertView.getTag();

            Conversacion conversacionActual = conversaciones.get(position);

            elemento.nombreTV.setText(conversacionActual.getNombre());
            elemento.mensajeTV.setText(conversacionActual.getMensaje());
            elemento.imagenTV.setImageResource(conversacionActual.getImagen());

            return convertView;

        }

        return null;
    }

    @Override
    public Object getItem(int position) {
        return this.conversaciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
