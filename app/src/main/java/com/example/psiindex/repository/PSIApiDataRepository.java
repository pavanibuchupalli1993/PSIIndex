package com.example.psiindex.repository;

import android.content.Context;

import com.example.psiindex.api.ApiClient;
import com.example.psiindex.api.PSIApiService;
import com.example.psiindex.model.psimodel.PSIResponse;


public class PSIApiDataRepository {
    private static PSIApiDataRepository psiApiDataRepository;
    public PSIApiService apiService;
    private PSIResponse result;

    public PSIApiDataRepository(Context context) {
        apiService = ApiClient.getClient(context).create(PSIApiService.class);
    }

    public static PSIApiDataRepository getInstance(Context context) {
        if (psiApiDataRepository == null) {
            psiApiDataRepository = new PSIApiDataRepository(context);
        }
        return psiApiDataRepository;
    }


}

