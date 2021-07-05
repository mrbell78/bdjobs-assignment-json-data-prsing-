package com.nurhossen.bdjosbnurassignment.viewmodel;

import android.app.Application;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.nurhossen.bdjosbnurassignment.service.model.Datum;
import com.nurhossen.bdjosbnurassignment.service.model.Responsebdjobsdata;
import com.nurhossen.bdjosbnurassignment.service.repository.BdjosbdataRepository;

import java.util.List;

public class MainActivityViewmodel extends AndroidViewModel {

    BdjosbdataRepository bdjobsrepo;
    MutableLiveData<List<Datum>> mdata;

    public MainActivityViewmodel(@NonNull Application application) {
        super(application);
        bdjobsrepo= BdjosbdataRepository.getInstance(application);
    }

    public LiveData<List<Datum>> getdata(){
        return  bdjobsrepo.getalldata();
    }
}
