package com.example.quiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateDB extends SQLiteOpenHelper {

    public static final String DBNAME = "quiz.sqlite";
    public static final int VERSION = 1;

    public CreateDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS Quiz(" +
                "_id INT NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "question TEXT, " +
                "a1 TEXT, " +
                "a2 TEXT, " +
                "a3 TEXT";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Quiz";
        db.execSQL(sql);
        onCreate(db);
    }
}
