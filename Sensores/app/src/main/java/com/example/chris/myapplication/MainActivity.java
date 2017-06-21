package com.example.chris.myapplication;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements TextView.OnClickListener {
    TextView salida;
    Button vibrador, girescopio, proximidad, acelerometo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibrador = (Button)findViewById(R.id.vibrador);
        girescopio = (Button)findViewById(R.id.giroscopio);
        proximidad = (Button)findViewById(R.id.proximidad);
        acelerometo = (Button)findViewById(R.id.acelerometro);
        salida = (TextView)findViewById(R.id.salida);

        acelerometo.setOnClickListener(this);
        vibrador.setOnClickListener(this);
        proximidad.setOnClickListener(this);
        girescopio.setOnClickListener(this);

        SensorManager sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor: listaSensores) {
            log(sensor.getName());
        }
    }

    public void log(String string){
        salida.append(string + "\n");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.vibrador:
                Intent inx = new Intent(this,VIbracionActivity.class);
                startActivity(inx);
                break;

            case R.id.acelerometro:
                Intent i = new Intent(this,AcelerometroActivity.class);
                startActivity(i);
                break;

            case R.id.giroscopio:
                Intent in = new Intent(this,AcelerometroActivity.class);
                startActivity(in);
            break;


            case R.id.proximidad:
                Intent prox = new Intent(this,AcelerometroActivity.class);
                startActivity(prox);
                break;

            default:
                break;
        }
    }


}
