package com.example.quiz;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
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
        crudQuiz = new CRUDQuiz(getApplicationContext());
        quiz = loadList(crudQuiz.getAll());

        listAllItems.setAdapter(new Adapter(quiz));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        listAllItems.setLayoutManager(layoutManager);
    }

    public List<Question> loadList(Cursor cursor) {
        List<Question> quiz = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Question question = new Question(
                        cursor.getInt(cursor.getColumnIndex("_id")),
                        cursor.getString(cursor.getColumnIndex("question")),
                        cursor.getString(cursor.getColumnIndex("a1")),
                        cursor.getString(cursor.getColumnIndex("a2")),
                        cursor.getString(cursor.getColumnIndex("a3")));
                quiz.add(question);
            } while (cursor.moveToNext());
        }

        return quiz;
    }

}
