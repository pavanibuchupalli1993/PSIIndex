package com.example.psiindex.api;

import com.example.psiindex.model.PSIResponse;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PSIApiService {

    @GET(value = "psi")
    public Call<PSIResponse > getPSIInfo();

}
