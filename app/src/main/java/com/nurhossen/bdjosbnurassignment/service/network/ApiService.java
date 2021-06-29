package com.nurhossen.bdjosbnurassignment.service.network;

import com.nurhossen.bdjosbnurassignment.service.model.Responsebdjobsdata;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/interviewtest/InterviewJson.json")
    Call<Responsebdjobsdata>getData();

}
