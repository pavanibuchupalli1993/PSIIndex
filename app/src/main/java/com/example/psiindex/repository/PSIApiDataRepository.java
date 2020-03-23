package com.example.psiindex.repository;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;

import com.example.psiindex.api.ApiClient;
import com.example.psiindex.api.PSIApiService;
import com.example.psiindex.api.PSIServiceProvider;
import com.example.psiindex.model.PSIResponse;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PSIApiDataRepository {
    private static PSIApiDataRepository psiApiDataRepository;

    private PSIApiService apiService;
    MutableLiveData<PSIResponse> newsData = new MutableLiveData<>();

    public PSIApiDataRepository(Context context) {
        apiService = ApiClient.getClient(context).create(PSIApiService.class);
    }


    public static PSIApiDataRepository getInstance(Context context){
        if (psiApiDataRepository == null){
            psiApiDataRepository = new PSIApiDataRepository(context);
        }
        return psiApiDataRepository;
    }

    public MutableLiveData<PSIResponse> fetchPSIData(){

        apiService.getPSIInfo().enqueue(new Callback<PSIResponse>() {
            @Override
            public void onResponse(Call<PSIResponse> call,
                                   Response<PSIResponse> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PSIResponse> call, Throwable t) {
                newsData.setValue(null);
            }
        });
        return newsData;
    }
}

