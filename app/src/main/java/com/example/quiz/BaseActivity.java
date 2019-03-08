package com.example.quiz;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

abstract class BaseActivity extends AppCompatActivity {

    protected List<Question> quiz;
    protected CRUDQuiz crudQuiz;

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
