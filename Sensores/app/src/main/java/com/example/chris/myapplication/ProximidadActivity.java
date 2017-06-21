package com.example.chris.Sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.Bundle;
import android.os.StrictMode;

/**
 * Created by ChrisRCSG on 21/06/17.
 */

public class ProximidadActivity AppCompactActivity implements SensorEventListener {

    public void onCreate(Bundle savedInterfaceState){
        super.onCreate(savedInterfaceState);
        num_entradas = 0;
        setContentView(R.layout.LayoutAc)

    }

    public void onSensorChanged(SensorEvent event){
        String  distancia = String.valueOf(event.values[0]);
        num_entradas++;
        contador.setText("Entrada: "+num_entradas);
        info.setText("Distancia: "+ distancia);
        float
    }

    public void on
}
