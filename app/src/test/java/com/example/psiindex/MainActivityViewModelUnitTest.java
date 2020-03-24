package com.example.psiindex;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.psiindex.psi_model.PSIResponse;
import com.example.psiindex.repository.PSIApiDataRepository;
import com.example.psiindex.viewmodel.MainActivityViewModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MainActivityViewModelUnitTest {
    public MutableLiveData<com.example.psiindex.psi_model.PSIResponse> PSIResponse;

    private PSIResponse testData= null;

    private MainActivityViewModel mainActivityViewModel;

    @Mock
    private PSIApiDataRepository psiApiDataRepository;

    @Mock
    Observer<PSIResponse> responseObserver;

    @Mock
    private Application application;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mainActivityViewModel =new MainActivityViewModel(application);
        testData= TestUtils.getResponseData();
    }

    @Test
    public void testApiFetchData_null() {
        Mockito.verify(responseObserver).onChanged(testData);

    }


}
