package com.example.psiindex.api;


import com.example.psiindex.model.psimodel.PSIResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PSIApiService {

    @GET(value = "PSI")
    public Call<PSIResponse> getPSIInfo();

}
