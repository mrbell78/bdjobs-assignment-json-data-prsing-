package com.nurhossen.bdjosbnurassignment.service.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.nurhossen.bdjosbnurassignment.service.model.Datum;
import com.nurhossen.bdjosbnurassignment.service.model.Responsebdjobsdata;
import com.nurhossen.bdjosbnurassignment.service.network.ApiService;
import com.nurhossen.bdjosbnurassignment.service.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.ContentValues.TAG;

public class BdjosbdataRepository {

    private static BdjosbdataRepository instance;
    private static Context mcontext;


    MutableLiveData data;
    Responsebdjobsdata responsebdjobsdata;
    List<Datum> rawlist=new ArrayList<>();



    public static BdjosbdataRepository getInstance(Context context){
        if(instance==null){
            mcontext=context;
            instance= new BdjosbdataRepository();

        }
        return  instance;
    }

    public MutableLiveData<List<Datum>> getalldata(){

        if(data==null){
            data= new MutableLiveData();
        }
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);

        Call<Responsebdjobsdata> call = apiService.getData();

        call.enqueue(new Callback<Responsebdjobsdata>() {
            @Override
            public void onResponse(Call<Responsebdjobsdata> call, Response<Responsebdjobsdata> response) {
                Log.d(TAG, "onResponse: response code "+response.code());

                responsebdjobsdata=  response.body();
                rawlist=responsebdjobsdata.getData();
                data.postValue(rawlist);

                Log.d(TAG, "onResponse: total data size"+ rawlist.size());

            }

            @Override
            public void onFailure(Call<Responsebdjobsdata> call, Throwable t) {

                Log.d(TAG, "onFailure: error reason "+ t.getMessage());

            }
        });

        return  data;
    }
}
