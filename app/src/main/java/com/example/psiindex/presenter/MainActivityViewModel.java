package com.example.psiindex.presenter;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.psiindex.psimodel.PSIResponse;
import com.example.psiindex.repository.PSIApiDataRepository;
import com.example.psiindex.view.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {

    private PSIApiDataRepository psiApiDataRepository;
    private MainActivity context;
    private MutableLiveData<PSIResponse> psiResponse=new MutableLiveData<>();

public MainActivityViewModel(MainActivity context)
{
    this.context=context;
}
    public void fetchPSIData() {

        psiApiDataRepository = PSIApiDataRepository.getInstance();

        psiApiDataRepository.apiService.getPSIInfo().enqueue(new Callback<PSIResponse>() {
            @Override
            public void onResponse(Call<PSIResponse> call,
                                   Response<PSIResponse> response) {
                if (response.isSuccessful()) {
                   psiResponse.setValue(response.body());
                } else {
                    psiResponse.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<PSIResponse> call, Throwable t) {

                psiResponse.setValue(null);
            }
        });
    }

    public MutableLiveData<PSIResponse> getPsiResponse()
    {
        return psiResponse;
    }

}
