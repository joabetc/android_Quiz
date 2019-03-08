package com.example.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends BaseActivity {

    private TextView question;
    private Button btnA1;
    private Button btnA2;
    private Button btnA3;
    private TextView points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        question = findViewById(R.id.question);
        btnA1 = findViewById(R.id.btnA1);
        btnA2 = findViewById(R.id.btnA2);
        btnA3 = findViewById(R.id.btnA3);

        crudQuiz = new CRUDQuiz(getApplicationContext());
        quiz = loadList(crudQuiz.getAll());

        if (quiz.size() > 0) {
            Question question = new Question();
            question = quiz.get(0);
            loadQuestion(question);
        } else {
            Toast.makeText(getApplicationContext(), "There are not questions", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadQuestion(Question question) {
        this.question.setText(question.getQuestion());
        this.btnA1.setText(question.getA1());
        this.btnA2.setText(question.getA2());
        this.btnA3.setText(question.getA3());
    }
}
