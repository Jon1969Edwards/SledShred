package com.example.sledshred;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng m1 = new LatLng(59.288465598655065, 18.007233473508);


        marker = mMap.addMarker(new MarkerOptions()
                .position(m1)
                .draggable(true)
                .title("marker 1")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.sled24px))

        );

        mMap.setOnMarkerClickListener(this);


        mMap.moveCamera(CameraUpdateFactory.newLatLng(m1));
    }


    @Override
    public boolean onMarkerClick(Marker marker) {

        Toast.makeText(this, "Lat: " + marker.getPosition().latitude
                        + " \nlng" +marker.getPosition().longitude

                ,

                Toast.LENGTH_LONG).show();

        return false;
    }
}