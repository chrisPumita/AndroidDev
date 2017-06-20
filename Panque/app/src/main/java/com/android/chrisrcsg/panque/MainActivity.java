package com.android.chrisrcsg.panque;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity
{
    private TextView mTextMessage;
    Button sigue;
    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sigue = (Button)findViewById(R.id.btn_sigue);
        sigue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Postre.class);
                startActivity(i);

            }
        });
    }

    public void funcion_sigue(View view)
    {
        Intent i = new Intent(MainActivity.this,Postre.class);
        startActivity(i);

    }


}
