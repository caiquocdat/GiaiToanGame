package com.caiquocdat.giaitoan.model;

import java.util.List;

public class QuestionWithAnswersModel {
    private QuestionModel question;
    private List<AnswerModel> answers;


    public QuestionWithAnswersModel() {
    }

    public QuestionWithAnswersModel(QuestionModel question, List<AnswerModel> answers) {
        this.question = question;
        this.answers = answers;
    }

    public QuestionModel getQuestion() {
        return question;
    }

    public void setQuestion(QuestionModel question) {
        this.question = question;
    }

    public List<AnswerModel> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerModel> answers) {
        this.answers = answers;
    }
}
