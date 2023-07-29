package com.example.giaitoan.model;

public class QuestionModel {
    private int id;
    private String text;

    public QuestionModel(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public QuestionModel() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
