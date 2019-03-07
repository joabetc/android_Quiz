package com.example.quiz;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class Adapter extends RecyclerView.Adapter {

    private final List<Question> quiz;

    public Adapter(List<Question> quiz) {
        this.quiz = quiz;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        QuestionHolder questionHolder = new QuestionHolder(view);
        return questionHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof QuestionHolder) {
            QuestionHolder questionHolder = (QuestionHolder) viewHolder;
            questionHolder.getQuestion().setText(quiz.get(i).getQuestion());
            questionHolder.getR1().setText(quiz.get(i).getA1());
            questionHolder.getR2().setText(quiz.get(i).getA2());
            questionHolder.getR3().setText(quiz.get(i).getA3());
        }
    }

    @Override
    public int getItemCount() {
        return quiz.size();
    }
}
