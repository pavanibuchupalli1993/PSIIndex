package com.example.psiindex;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.psiindex.adaptor.DisplayPSIReadingsDialogAdapter;
import com.example.psiindex.model.dialogmodel.CustomAlertDialog;
import com.example.psiindex.model.dialogmodel.DialogModel;
import com.example.psiindex.model.psimodel.PSIResponse;
import com.example.psiindex.model.psimodel.Reading;
import com.example.psiindex.model.psimodel.RegionMetadatum;
import com.example.psiindex.utils.Utility;
import com.example.psiindex.viewmodel.MainActivityViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private SupportMapFragment mapFragment;
    private GoogleMap googleMap;
    private MainActivityViewModel viewModel;
    private PSIResponse psiData;
    private DialogModel dialogModel=new DialogModel();
    private CustomAlertDialog customAlertDialogg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map));

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        //initializing google map
        mapFragment.getMapAsync(this);

        addObservers();
    }

    /**
     * add Observers
     */
    private void addObservers() {
        viewModel.PSIResponse.observe(this, new Observer<PSIResponse>() {
            @Override
            public void onChanged(PSIResponse psiResponse) {

                displayProgressDialog(false);

                if (psiResponse != null) {
                    psiData = psiResponse;

                    LatLng latLng = null;
                    for (RegionMetadatum regionMetadatum : psiResponse.regionMetadata) {
                        if (!regionMetadatum.name.equalsIgnoreCase(getString(R.string.national_string))) {
                            latLng = new LatLng(regionMetadatum.labelLocation.latitude, regionMetadatum.labelLocation.longitude);
                            addMarkers(latLng, regionMetadatum.name);
                        }
                    }

                    if (latLng != null)
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f));
                } else {
                    displayInfoDialog(getString(R.string.error_msg));
                }
            }
        });
    }
    /**
     * add marker on google map.
     */
    private void addMarkers(LatLng latLng,String name) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng).title(getString(R.string.click)+":"+name);
        markerOptions.position(latLng).snippet(getString(R.string.readings_info));
        googleMap.addMarker(markerOptions);
        googleMap.setOnInfoWindowClickListener(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap=googleMap;
        viewModel.fetchPSIData();
        displayProgressDialog(true);
    }

    /**
     *
     * @param isShow
     * Display progress dialog
     */
    private void displayProgressDialog(boolean isShow)
    {
        dialogModel.displayProgressDialog(this,isShow);
    }

    /**
     *

     * Display Alert dialog
     */
    private void displayInfoDialog(String msg)
    {
        dialogModel.displayAlertDialog(this,msg);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

        ArrayList<Reading> readings = Utility.getReadingDetails(
                psiData.items.get(0).readings,
                Utility.getRegionTitle(marker.getTitle()));
        if (readings.size() > 0) {
            DisplayPSIReadingsDialogAdapter displayPSIReadingsDialogAdapter = new DisplayPSIReadingsDialogAdapter(readings);
            customAlertDialogg = new CustomAlertDialog(MainActivity.this, displayPSIReadingsDialogAdapter);

            customAlertDialogg.show();
            customAlertDialogg.setCanceledOnTouchOutside(true);

        } else {
            dialogModel.displayAlertDialog(this, getString(R.string.no_readings_found));
        }
    }
}
