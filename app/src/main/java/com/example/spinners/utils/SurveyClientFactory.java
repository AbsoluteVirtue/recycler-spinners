package com.example.spinners.utils;

import com.example.spinners.SurveysService;

public class SurveyClientFactory {

    private SurveyClientFactory() {}

    public static final String BASE_URL = "http://10.0.2.2:3000";

    public static SurveysService getSurveyService() {
        return RetrofitClient.getClient(BASE_URL).create(SurveysService.class);
    }
}
