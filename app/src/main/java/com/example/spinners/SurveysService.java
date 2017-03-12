package com.example.spinners;

import com.example.spinners.model.QaItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SurveysService {

    @GET("/test_survey")
    Call<List<QaItem>> getTestSurvey();

}
