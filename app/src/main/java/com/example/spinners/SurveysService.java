package com.example.spinners;

import com.example.spinners.model.AuthResponseTest;
import com.example.spinners.model.AuthTest;
import com.example.spinners.model.QaItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SurveysService {

    @GET("/test_survey")
    Call<List<QaItem>> getTestSurvey();

    @POST("/auth/signin")
    Call<AuthResponseTest> signIn(@Body AuthTest credentials);

}
