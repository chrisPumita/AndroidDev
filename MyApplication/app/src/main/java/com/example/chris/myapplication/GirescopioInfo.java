package com.example.chris.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Christian on 20/06/2017.
 */
public class GirescopioInfo extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    Sensor sensor;

    TextView textX, textY, textZ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gyro_info_layout);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        if (sensor==null){
            Toast.makeText(this,"No se cuenta con girescopio",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        textX.setText("X :" + (int)x+" rad/s");
        textY.setText("Y :" + (int)y+" rad/s");
        textZ.setText("Z :" + (int)z+" rad/s");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
