package com.example.spinners;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.spinners.model.QaItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] dummy = {"One", "Two", "Three"};
    List<QaItem> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();

        QaItem item1 = new QaItem(1, "Who?", dummy);
        data.add(item1);
        QaItem item2 = new QaItem(2, "What?", dummy);
        data.add(item2);
        QaItem item3 = new QaItem(3, "Where?", dummy);
        data.add(item3);

        QaAdapter adapter = new QaAdapter(this, data);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recViewItems);
        recyclerView.setAdapter(adapter);
    }
}
