package com.example.psiindex.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.psiindex.psimodel.PSIResponse;
import com.example.psiindex.repository.PSIApiDataRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<PSIResponse> psiResponse = new MutableLiveData<>();
    private PSIApiDataRepository psiApiDataRepository;


    public void fetchPSIData() {

        psiApiDataRepository = PSIApiDataRepository.getInstance();

        psiApiDataRepository.apiService.getPSIInfo().enqueue(new Callback<PSIResponse>() {
            @Override
            public void onResponse(Call<PSIResponse> call,
                                   Response<PSIResponse> response) {
                if (response.isSuccessful()) {
                    psiResponse.postValue(response.body());
                } else {
                    psiResponse.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<PSIResponse> call, Throwable t) {

                psiResponse.postValue(null);
            }
        });
    }

    public MutableLiveData<PSIResponse> getPsiResponse()
    {
        return psiResponse;
    }

}
