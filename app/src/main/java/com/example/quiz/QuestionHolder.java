package com.example.quiz;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class QuestionHolder extends RecyclerView.ViewHolder {

    TextView question;
    TextView r1;
    TextView r2;
    TextView r3;

    public QuestionHolder(@NonNull View itemView) {
        super(itemView);
        question = itemView.findViewById(R.id.questionItem);
        r1 = itemView.findViewById(R.id.correctAnswerItem);
        r2 = itemView.findViewById(R.id.answer2);
        r3 = itemView.findViewById(R.id.answer3);
    }

    public TextView getQuestion() {
        return question;
    }

    public void setQuestion(TextView question) {
        this.question = question;
    }

    public TextView getR1() {
        return r1;
    }

    public void setR1(TextView r1) {
        this.r1 = r1;
    }

    public TextView getR2() {
        return r2;
    }

    public void setR2(TextView r2) {
        this.r2 = r2;
    }

    public TextView getR3() {
        return r3;
    }

    public void setR3(TextView r3) {
        this.r3 = r3;
    }
}
