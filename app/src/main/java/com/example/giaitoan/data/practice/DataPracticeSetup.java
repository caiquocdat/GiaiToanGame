package com.example.giaitoan.data.practice;

import android.content.Context;

import com.example.giaitoan.model.QuestionPra;

import java.util.ArrayList;
import java.util.List;

public class DataPracticeSetup {
    private Context context;

    public DataPracticeSetup(Context context) {
        this.context = context;
    }
    public void setUpDataPra() {
        List<String> answer_1= new ArrayList<>();
        answer_1.add("1");
        answer_1.add("2");
        answer_1.add("3");
        answer_1.add("4");
        QuestionPra questionPra_1 = new QuestionPra(
                1,"+",2,null,answer_1,"3"
        );
        List<String> answer_2= new ArrayList<>();
        answer_2.add("+");
        answer_2.add("-");
        answer_2.add("x");
        answer_2.add(":");
        QuestionPra questionPra_2 = new QuestionPra(
                3,null,2,6,answer_2,"x"
        );
        List<String> answer_3= new ArrayList<>();
        answer_3.add("+");
        answer_3.add("-");
        answer_3.add("x");
        answer_3.add(":");
        QuestionPra questionPra_3 = new QuestionPra(
                18,null,2,9,answer_3,":"
        );
        List<String> answer_4= new ArrayList<>();
        answer_4.add("10");
        answer_4.add("21");
        answer_4.add("31");
        answer_4.add("5");
        QuestionPra questionPra_4 = new QuestionPra(
                20,":",4,null,answer_4,"5"
        );
        List<String> answer_5= new ArrayList<>();
        answer_5.add("14");
        answer_5.add("51");
        answer_5.add("20");
        answer_5.add("10");
        QuestionPra questionPra_5 = new QuestionPra(
                null,"x",4,80,answer_5,"20"
        );
        List<String> answer_6= new ArrayList<>();
        answer_6.add("+");
        answer_6.add("-");
        answer_6.add("x");
        answer_6.add(":");
        QuestionPra questionPra_6 = new QuestionPra(
                91,null,19,72,answer_6,"-"
        );
        List<String> answer_7= new ArrayList<>();
        answer_7.add("5");
        answer_7.add("2");
        answer_7.add("3");
        answer_7.add("4");
        QuestionPra questionPra_7 = new QuestionPra(
                18,"x",null,64,answer_7,"4"
        );
        List<String> answer_8= new ArrayList<>();
        answer_8.add("18");
        answer_8.add("19");
        answer_8.add("16");
        answer_8.add("15");
        QuestionPra questionPra_8 = new QuestionPra(
                90,":",5,null,answer_8,"18"
        );
        List<String> answer_9= new ArrayList<>();
        answer_9.add("5");
        answer_9.add("6");
        answer_9.add("7");
        answer_9.add("8");
        QuestionPra questionPra_9 = new QuestionPra(
                null,"x",8,64,answer_9,"8"
        );
        List<String> answer_10= new ArrayList<>();
        answer_10.add("+");
        answer_10.add("-");
        answer_10.add("x");
        answer_10.add(":");
        QuestionPra questionPra_10 = new QuestionPra(
                99,null,9,11,answer_10,":"
        );
        List<QuestionPra> questionPraList= new ArrayList<>();
        questionPraList.add(questionPra_1);
        questionPraList.add(questionPra_2);
        questionPraList.add(questionPra_3);
        questionPraList.add(questionPra_4);
        questionPraList.add(questionPra_5);
        questionPraList.add(questionPra_6);
        questionPraList.add(questionPra_7);
        questionPraList.add(questionPra_8);
        questionPraList.add(questionPra_9);
        questionPraList.add(questionPra_10);
        PracticeDatabaseHelper practiceDatabaseHelper= new PracticeDatabaseHelper(context);
        practiceDatabaseHelper.addQuestions(questionPraList);
    }
}
