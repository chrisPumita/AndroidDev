package com.android.chrisrcsg.notificationsexample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotification = (Button)findViewById(R.id.btnNotify);
        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v4.app.NotificationCompat.Builder notiBuilder =
                        new NotificationCompat.Builder(MainActivity.this)
                                .setSmallIcon(android.R.drawable.stat_notify_missed_call)
                                .setContentTitle("Ya valio, tienes Perdida")
                                .setContentText("Ver la llamda perdida")
                                .setTicker("LLamada Perdida");
                Intent notIntent = new Intent(MainActivity.this,MainActivity.class);
                PendingIntent i = PendingIntent.getActivity(MainActivity.this,0,notIntent,0);

                notiBuilder.setContentIntent(i);
                NotificationManager notifym = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notifym.notify(1,notiBuilder.build());
            }
        });
    }
}
