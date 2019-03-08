package com.example.quiz;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAllActivity extends BaseActivity {

    private RecyclerView listAllItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all);

        listAllItems = findViewById(R.id.listAllItems);
        crudQuiz = new CRUDQuiz(getApplicationContext());
        quiz = loadList(crudQuiz.getAll());

        listAllItems.setAdapter(new Adapter(quiz));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        listAllItems.setLayoutManager(layoutManager);
    }

}
