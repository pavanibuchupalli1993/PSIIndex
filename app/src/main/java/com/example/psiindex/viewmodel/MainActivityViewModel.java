package com.example.psiindex.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.psiindex.psi_model.PSIResponse;
import com.example.psiindex.repository.PSIApiDataRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {

    public MutableLiveData<PSIResponse> PSIResponse = new MutableLiveData<>();
    private PSIApiDataRepository psiApiDataRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public void fetchPSIData() {

        psiApiDataRepository = PSIApiDataRepository.getInstance(getApplication());

        psiApiDataRepository.apiService.getPSIInfo().enqueue(new Callback<PSIResponse>() {
            @Override
            public void onResponse(Call<PSIResponse> call,
                                   Response<PSIResponse> response) {
                if (response.isSuccessful()) {
                    PSIResponse.setValue(response.body());
                } else {
                    PSIResponse.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<PSIResponse> call, Throwable t) {

                PSIResponse.setValue(null);
            }
        });
    }

}
