package com.android.chrisrcsg.myappsrcsg;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener
{

    public Button s_button;
    public Button p_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instaciar las variables
        s_button = (Button)findViewById(R.id.simple_btn);
        p_button = (Button)findViewById(R.id.simple2_btn);

        //Hacer contexto al botón
        s_button.setOnClickListener(this);
        p_button.setOnClickListener(this);
        /*
        s_button.setOnClickListener(new View.OnClickListener())
        {
            public void onClick(View v)
            {
                //CODE
            }
        }); */
    }
    @Override
    public void onClick(View v)
    {
        //Botones que mandan mensaje
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        switch(v.getId()) {
            case (R.id.simple_btn):
                //Definimos compotamiento
                //debugiar el codigo en la consola
                Log.d("Error:", "Se tuvo un error al entrar al boton simple_btn");
                builder.setMessage(R.string.dialog_mss)
                        .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Mostrar los ensajes de dialogo
                                Toast.makeText(MainActivity.this, R.string.deleteSucc, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, R.string.deleteFail, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton(R.string.neutral_BTN, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, R.string.neutral_BTN, Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.create().show();
                break;
            case (R.id.simple2_btn):
                //comportamiento del boton 2
                Toast.makeText(MainActivity.this, R.string.deleteFail, Toast.LENGTH_SHORT).show();
                break;
            case (R.id.img1):
                Toast.makeText(MainActivity.this, R.string.imgMss, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}