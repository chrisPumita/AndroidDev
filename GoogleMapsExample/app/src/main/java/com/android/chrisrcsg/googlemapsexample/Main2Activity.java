package com.android.chrisrcsg.googlemapsexample;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebViewFragment;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.MapFragment;

public class Main2Activity extends AppCompatActivity {

    private WelcomeFragment currentFragment;
    private MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        /*
        *

        if (savedInstanceState == null){
            currentFragment = new WelcomeFragment();
            changeFragment(currentFragment);
        }
                * */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.welcome: //vamos a ir al Wlcome Gragment
                currentFragment = new WelcomeFragment();
                break;
            case R.id.gomap:
                mapFragment = new MapFragment();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //hacemos la transaccion de fragmentos
    private void changeFragment(android.support.v4.app.Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_cotainer,fragment).commit();
    }
}
