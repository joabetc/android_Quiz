package com.example.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private Button btnAdd;
    private Button btnDelete;
    private EditText edtQuestion;
    private EditText edtCorrectAnswer;
    private EditText edtA2;
    private EditText edtA3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);

        edtQuestion = findViewById(R.id.edtQuestion);
        edtCorrectAnswer = findViewById(R.id.edtCorrectAnswer);
        edtA2 = findViewById(R.id.edtA2);
        edtA3 = findViewById(R.id.edtA3);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question question = new Question();
                question.setQuestion(edtQuestion.getText().toString());
                question.setA1(edtCorrectAnswer.getText().toString());
                question.setA2(edtA2.getText().toString());
                question.setA3(edtA3.getText().toString());

                CRUDQuiz crud = new CRUDQuiz(getApplicationContext());
                String message = crud.insert(question);
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                clean();
            }
        });
    }

    public void clean() {
        edtQuestion.setText("");
        edtCorrectAnswer.setText("");
        edtA2.setText("");
        edtA3.setText("");
        edtQuestion.requestFocus();
    }
}
