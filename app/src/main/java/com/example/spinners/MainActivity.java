package com.example.spinners;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.spinners.model.QaItem;
import com.example.spinners.sample.SampleDataProvider;
import com.example.spinners.utils.JsonHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String dummyJson = SampleDataProvider.rawJson;
    List<QaItem> dataFromJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataFromJson = JsonHelper.importJson(this, dummyJson);

        QaAdapter adapter = new QaAdapter(this, dataFromJson);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recViewItems);
        recyclerView.setAdapter(adapter);
    }
}
