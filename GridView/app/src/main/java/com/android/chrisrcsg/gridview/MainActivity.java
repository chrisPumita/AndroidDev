package com.android.chrisrcsg.gridview;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private List<Conversacion> conversaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);
        conversaciones = new ArrayList<Conversacion>();
        Conversacion conversacion;

        conversacion = new Conversacion("Alan Escamilla","Hola a todos",R.mipmap.ic_launcher_round);
        conversaciones.add(conversacion);

        conversacion = new Conversacion("Lixbeth","No se duerman",R.mipmap.ic_launcher_round);
        conversaciones.add(conversacion);

        conversacion = new Conversacion("Luis Roberto","Hola mundo",R.mipmap.ic_launcher_round);
        conversaciones.add(conversacion);

        conversacion = new Conversacion("Ivan","Ya quedó la App",R.mipmap.ic_launcher_round);
        conversaciones.add(conversacion);

        conversacion = new Conversacion("Sergio","Buenos Dias",R.mipmap.ic_launcher_round);
        conversaciones.add(conversacion);

        conversacion = new Conversacion("Roberto","Regresa temprano",R.mipmap.ic_launcher_round);
        conversaciones.add(conversacion);

        conversacion = new Conversacion("Moises","Hola de nuevo",R.mipmap.ic_launcher_round);
        conversaciones.add(conversacion);

        conversacion = new Conversacion("Nataly","Hola mundo",R.mipmap.ic_launcher_round);
        conversaciones.add(conversacion);

        conversacion = new Conversacion("Luis","Esta app no la tiene ni Obama",R.mipmap.ic_launcher_round);
        conversaciones.add(conversacion);

        conversacion = new Conversacion("Felipe","¿Ya es hora del receso?",R.mipmap.ic_launcher_round);
        conversaciones.add(conversacion);

        conversacion = new Conversacion("Erick","Aqui en el gym",R.mipmap.ic_launcher_round);
        conversaciones.add(conversacion);

        conversacion = new Conversacion("Erika","Temgo hambre y frio",R.mipmap.ic_launcher_round);
        conversaciones.add(conversacion);

        conversacion = new Conversacion("Lizbeth","No se duerman",R.mipmap.ic_launcher_round);
        conversaciones.add(conversacion);

        conversacion = new Conversacion("Christian","Quiero Café",R.mipmap.ic_launcher_round);
        conversaciones.add(conversacion);

        conversacion = new Conversacion("Daniel","Aun no sumen el proyecto",R.mipmap.ic_launcher_round);
        conversaciones.add(conversacion);

        conversacion = new Conversacion("Beatriz","Estoy en clase de Android",R.mipmap.ic_launcher_round);
        conversaciones.add(conversacion);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Abriendo conversacion con: "+
                        conversaciones.get(position).getNombre(), Toast.LENGTH_SHORT).show();
            }
        } );

        Adaptador adaptador = new Adaptador(conversaciones, this, R.layout.elemento);
        gridView.setAdapter(adaptador);

    }
}
