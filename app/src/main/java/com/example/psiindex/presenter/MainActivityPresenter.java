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

public class MainActivityPresenter  {

    private PSIApiDataRepository psiApiDataRepository;
    private MainActivity context;

public MainActivityPresenter(MainActivity context)
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
                    context.setResponseData(response.body());
                } else {
                    context.setResponseData(null);
                }
            }

            @Override
            public void onFailure(Call<PSIResponse> call, Throwable t) {

                context.setResponseData(null);
            }
        });
    }



}
