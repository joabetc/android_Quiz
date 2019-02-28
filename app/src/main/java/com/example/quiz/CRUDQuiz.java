package com.example.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CRUDQuiz {

    private SQLiteDatabase db;
    private CreateDB createDB;

    public CRUDQuiz(Context context) {
        createDB = new CreateDB(context, CreateDB.DBNAME, null, CreateDB.VERSION);
    }

    public String insert(Question question) {
        ContentValues values = new ContentValues();
        values.put("question", question.getQuestion());
        values.put("a1", question.getA1());
        values.put("a2", question.getA2());
        values.put("a3", question.getA3());

        db = createDB.getWritableDatabase();
        long result = db.insert("Quiz", null, values);
        db.close();

        if (result == -1) {
            return "Error on inserting Question";
        } else {
            return "Question successfully created";
        }
    }

    public void update(Question question) {
        ContentValues values = new ContentValues();
        values.put("question", question.getQuestion());
        values.put("a1", question.getA1());
        values.put("a2", question.getA2());
        values.put("a3", question.getA3());
        String where = "_id = " + question.get_id();

        db = createDB.getWritableDatabase();
        db.update("Quiz", values, where, null);
        db.close();
    }

    public void delete(Question question) {
        String where = "_id = " + question.get_id();

        db = createDB.getWritableDatabase();
        db.delete("Quiz", where, null);
        db.close();
    }

    public Cursor getAll() {
        Cursor cursor;
        String[] columns = {"_id", "question", "a1", "a2", "a3"};
        String order = "question";

        db = createDB.getReadableDatabase();
        cursor = db.query("Quiz", columns, null, null, null, null, order);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }
}
