package com.android.chrisrcsg.googlemapsexample;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap; // mapa del google maps



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.gomap);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        //Agregando altitut y latitud de un lugar
        LatLng CU = new LatLng(19.332691, -99.185952);
        mMap.addMarker(new MarkerOptions().position(CU).title("Hola desde ciudad Universitaria").draggable(true));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CU));


        CameraPosition cameraPosition = new CameraPosition.Builder()
                .bearing(90) //totacion de la rosa de los vientos hacia el este en grados
                .tilt(45) //Elevacion de los edificios MAX 0-50
                .zoom(18) // del 1 añ 21 donde 1 es el mundo y 21 es nivel calle
                .target(CU) //Latitud y logitud
                .build();//Construimos la posocion
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),null);

        mMap.setOnMapClickListener(this); //Listener para cuando hacemos clic en el mapa

        //Cuando hacemos un long clic en el mapa
        mMap.setOnMapLongClickListener(this);

        //traer informacion del Marker
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                //esta posicionado en una parte del mapa
                Toast.makeText(MapsActivity.this ,
                        "MARCADO: "+marker.getPosition().latitude +
                                "\n " +marker.getPosition().longitude , Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        //Metodos con el macador
        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override //Cuando tomamos el marcador
            public void onMarkerDragStart(Marker marker) {

            }

            @Override // Arrastramos el marcador
            public void onMarkerDrag(Marker marker) {

            }

            @Override //cuando soltamos el marcador
            public void onMarkerDragEnd(Marker marker) {
                Toast.makeText(MapsActivity.this ,
                        "LLEGASTE A: "+marker.getPosition().latitude +"\n " +
                                marker.getPosition().longitude , Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Metodo que se sobre escribe implementado de OnMapClickListener
    @Override
    public void onMapClick(LatLng latLng) {
        Toast.makeText(this, "latitud: "+latLng.latitude + "\n Longitud: " + latLng.longitude, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        Toast.makeText(this, "LOOOONG \n latitud: "+latLng.latitude + "\n Longitud: " + latLng.longitude, Toast.LENGTH_SHORT).show();
    }
}
