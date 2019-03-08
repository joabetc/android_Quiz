package com.example.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends BaseActivity {

    private int totalPoints;
    private int currentQuestion;
    private TextView question;
    private Button btnA1;
    private Button btnA2;
    private Button btnA3;
    private TextView points;
    private View.OnClickListener clickListener;

    private void checkAnswer(String btnTitle) {
        if (this.btnA1.getText().equals(btnTitle)) {
            totalPoints++;
            showAlert("Good job!");
        } else {
            showAlert("Sorry!");
        }
    }

    private void showAlert(String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Message");
        builder.setMessage(s);

        builder.setPositiveButton("Next Question",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        nextQuestion();
                    }
                });

        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(PlayActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        builder.create();
        builder.show();
    }

    private void nextQuestion() {
        currentQuestion++;
        if (quiz.size() == currentQuestion) {
            showAlert("End Game!");
        } else {
            loadQuestion(quiz.get(currentQuestion));
        }
    }

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

        clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btnTitle = ((Button) v).getText().toString();
                checkAnswer(btnTitle);
            }
        };

        btnA1.setOnClickListener(clickListener);
        btnA2.setOnClickListener(clickListener);
        btnA3.setOnClickListener(clickListener);
    }

    private void loadQuestion(Question question) {
        this.question.setText(question.getQuestion());
        this.btnA1.setText(question.getA1());
        this.btnA2.setText(question.getA2());
        this.btnA3.setText(question.getA3());
    }
}
