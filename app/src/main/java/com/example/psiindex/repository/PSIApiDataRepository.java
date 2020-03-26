package com.example.psiindex.repository;

import com.example.psiindex.api.ApiClient;
import com.example.psiindex.api.PSIApiService;
import com.example.psiindex.psimodel.PSIResponse;


public class PSIApiDataRepository {
    private static PSIApiDataRepository psiApiDataRepository;
    public PSIApiService apiService;


    public PSIApiDataRepository() {
        apiService = ApiClient.getClient().create(PSIApiService.class);
    }

    public static PSIApiDataRepository getInstance() {
        if (psiApiDataRepository == null) {
            psiApiDataRepository = new PSIApiDataRepository();
        }
        return psiApiDataRepository;
    }


}

