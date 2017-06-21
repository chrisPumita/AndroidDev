package com.example.chris.myapplication;

import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Chris on 20/06/2017.
 */
public class AcelerometroActivity extends AppCompatActivity implements SensorEventListener{
    TextView x,y,z;

    Sensor mAcelerometro;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acelerometro);
        x = (TextView)findViewById(R.id.ejex);
        y = (TextView)findViewById(R.id.ejey);
        z = (TextView)findViewById(R.id.ejez);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SensorManager sn = (SensorManager)getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sn.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if (sensors.size()>0){
            sn.registerListener(this,sensors.get(0),SensorManager.SENSOR_DELAY_GAME);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SensorManager mSN = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSN.unregisterListener(this,mAcelerometro);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SensorManager mSN = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSN.unregisterListener(this,mAcelerometro);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        this.x.setText("Eje x: " + event.values[SensorManager.DATA_X]);
        this.y.setText("Eje y: " + event.values[SensorManager.DATA_Y]);
        this.z.setText("Eje z: " + event.values[SensorManager.DATA_Z]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
