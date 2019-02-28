package com.example.quiz;

import java.util.Objects;

public class Question {

    private int _id;
    private String question;
    private String a1;
    private String a2;
    private String a3;

    public Question(int _id, String question, String a1, String a2, String a3) {
        this._id = _id;
        this.question = question;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    public Question() { }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question1 = (Question) o;
        return _id == question1._id &&
                Objects.equals(question, question1.question) &&
                Objects.equals(a1, question1.a1) &&
                Objects.equals(a2, question1.a2) &&
                Objects.equals(a3, question1.a3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, question, a1, a2, a3);
    }

    @Override
    public String toString() {
        return "Question{" +
                "_id=" + _id +
                ", question='" + question + '\'' +
                ", a1='" + a1 + '\'' +
                ", a2='" + a2 + '\'' +
                ", a3='" + a3 + '\'' +
                '}';
    }
}
