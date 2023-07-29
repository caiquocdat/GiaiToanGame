package com.example.giaitoan.model;

public class AnswerModel {
    private int id;
    private int questionId;
    private String text;

    public AnswerModel(int id, int questionId, String text) {
        this.id = id;
        this.questionId = questionId;
        this.text = text;
    }

    public AnswerModel() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
