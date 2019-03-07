package com.example.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ListAllActivity extends AppCompatActivity {

    private List<Question> quiz;
    private RecyclerView listAllItems;
    private CRUDQuiz crudQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all);

        listAllItems = findViewById(R.id.listAllItems);
    }

}
