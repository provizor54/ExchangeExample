package com.example.user.exchangeexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.exchangeexample.manager.DatabaseManager;
import com.example.user.exchangeexample.model.History;

import java.util.List;

import javax.inject.Inject;

public class HistoryActivity extends AppCompatActivity {
    @Inject
    DatabaseManager databaseManager;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        App.getComponentInstance().inject(this);

        List<History> histories = databaseManager.getHistory();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new Adapter(histories));
    }
}
