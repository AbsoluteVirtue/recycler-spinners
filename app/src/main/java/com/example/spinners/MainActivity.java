package com.example.spinners;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.spinners.model.AuthResponseTest;
import com.example.spinners.model.AuthTest;
import com.example.spinners.model.QaItem;
import com.example.spinners.sample.SampleDataProvider;
import com.example.spinners.utils.JsonHelper;
import com.example.spinners.utils.SurveyClientFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<QaItem> dataFromJson;
    SurveysService mApi;
    AuthResponseTest resp;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestData();

        //test Swagger Auth API
        //attemptAuth();
    }

    private void attemptAuth() {
        AuthTest credentials = new AuthTest("foo@example.com", "hello");

        mApi = SurveyClientFactory.getSurveyService();
        Call<AuthResponseTest> getCall = mApi.signIn(credentials);
        getCall.enqueue(new Callback<AuthResponseTest>() {
            @Override
            public void onResponse(Call<AuthResponseTest> call, Response<AuthResponseTest> response) {
                if(response.isSuccessful()) {
                    resp = response.body();
                    token = resp.getData().getToken();
                    Toast.makeText(MainActivity.this, token, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<AuthResponseTest> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void requestData() {
        mApi = SurveyClientFactory.getSurveyService();
        Call<List<QaItem>> getCall = mApi.getTestSurvey();
        getCall.enqueue(new Callback<List<QaItem>>() {
            @Override
            public void onResponse(Call<List<QaItem>> call, Response<List<QaItem>> response) {
                if(response.isSuccessful()) {
                    dataFromJson = response.body();
                    updateDisplay();
                }
            }

            @Override
            public void onFailure(Call<List<QaItem>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void updateDisplay() {
        QaAdapter adapter = new QaAdapter(this, dataFromJson);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recViewItems);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case R.id.action_submit:
                Toast.makeText(this, "Action menu button clicked", Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
