package com.example.spinners;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
