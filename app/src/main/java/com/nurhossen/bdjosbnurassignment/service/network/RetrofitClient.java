package com.nurhossen.bdjosbnurassignment.service.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.nurhossen.bdjosbnurassignment.utils.ApiConstant.BASE_URL;

public class RetrofitClient {

    private static volatile Retrofit retrofitinstance =null;

    private RetrofitClient(){}

    public  static Retrofit getInstance(){
        if(retrofitinstance==null){
            synchronized(RetrofitClient.class){
                if(retrofitinstance==null){
                    retrofitinstance =  new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }

        return  retrofitinstance;
    }
}