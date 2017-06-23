package com.android.chrisrcsg.fragment;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener  {

    private boolean isMultiPanel; //Atributo para tener el tamaño del dispositivo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMultipanel();

    }

    private void setMultipanel(){
        isMultipanel = (getSupportFragmentManager()
                .findFragmentById(R.layout.fragment_fragmento_details)!= null);

        }
}

public void sendData(String text){
    if(isMultiPanel){
        //estamos en tablet
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
        detailsFragment.rederText(text);
    }
    else{
        Intent intent = Intent.(this,DetailsActivity.class);
        intent.putExtra("text",text);
        startActivity(intent);
        //estamos en celular

    }
}
