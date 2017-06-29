package com.android.chrisrcsg.googlemapsexample;


import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements  OnMapReadyCallback, GoogleMap.OnMarkerDragListener{

    private View rootView;
    private GoogleMap googleMap; //mapa
    private MapView mapView; //container del map
    Geocoder geocoder;
    private List<Address>Addresses;

    //customizar el marcador
    private MarkerOptions marker;


    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_map, container,false);
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) rootView.findViewById(R.id.mapView);
        if (mapView!=null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        //Agregando altitut y latitud de un lugar
        LatLng CU = new LatLng(19.332691, -99.185952);

        //definiendo marker manual
        marker = new MarkerOptions();
        //TEXTO QUE TRENDRA EL MARKER
        marker.snippet("Informacion de este lugar");
        marker.title("CHRIS");
        marker.draggable(true);
        marker.icon(BitmapDescriptorFactory.fromResource((R.mipmap.ic_launcher)));
        googleMap.addMarker(marker);
        //googleMap.addMarker(new MarkerOptions().position(CU).title("Hola desde ciudad Universitaria").draggable(true));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(CU));
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        double latitud = marker.getPosition().latitude;
        double longitud = marker.getPosition().longitude;
        try{
            Addresses = geocoder.getFromLocation(latitud,longitud,1);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        String address = Addresses.get(0).getAddressLine(0);
        String city = Addresses.get(0).getLocality();
        String CP = Addresses.get(0).getCountryCode();
        String country = Addresses.get(0).getCountryName();

        Toast.makeText(getContext(),
                "Calle: "+ address +
                "\n Ciudad: "+city+
                 "\nCP" +CP+
                 "\nPais: "+country
                , Toast.LENGTH_SHORT).show();
    }
}
