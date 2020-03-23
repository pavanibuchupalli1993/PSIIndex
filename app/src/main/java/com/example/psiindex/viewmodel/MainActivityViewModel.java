package com.example.psiindex.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.psiindex.api.ApiClient;
import com.example.psiindex.api.PSIApiService;
import com.example.psiindex.model.PSIResponse;
import com.example.psiindex.repository.PSIApiDataRepository;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivityViewModel extends AndroidViewModel {

    public MutableLiveData<PSIResponse> response=new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private PSIApiService apiService;
    private PSIApiDataRepository psiApiDataRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

    }

    public void fetchPSIIndexInfo()
    {
        if (response != null){
            return;
        }
        psiApiDataRepository = PSIApiDataRepository.getInstance(getApplication());
        response = psiApiDataRepository.fetchPSIData();

    }



}
