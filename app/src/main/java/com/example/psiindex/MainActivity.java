package com.example.psiindex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.example.psiindex.model.PSIResponse;
import com.example.psiindex.viewmodel.MainActivityViewModel;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private SupportMapFragment mapFragment;
    private MainActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map));

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mapFragment.getMapAsync(this);

        viewModel.response.observe(this, new Observer<PSIResponse>() {
            @Override
            public void onChanged(PSIResponse psiResponse) {


                Log.i("psiresposne",psiResponse.toString());
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        viewModel.fetchPSIIndexInfo();

    }
}
