package com.caiquocdat.giaitoan.model;

public class QuestionModel {
    private int id;
    private String text;
    private String result;

    public QuestionModel(int id, String text, String result) {
        this.id = id;
        this.text = text;
        this.result = result;
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
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
