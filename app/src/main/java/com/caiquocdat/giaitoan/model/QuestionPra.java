package com.caiquocdat.giaitoan.model;

import java.util.List;

public class QuestionPra {
    private int id;
    private Integer x;
    private String pt;
    private Integer y;
    private Integer z;
    private List<String> answers;
    private String correctAnswer;

    // Constructor with optional values


    public QuestionPra(int id, Integer x, String pt, Integer y, Integer z, List<String> answers, String correctAnswer) {
        this.id = id;
        this.x = x;
        this.pt = pt;
        this.y = y;
        this.z = z;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
