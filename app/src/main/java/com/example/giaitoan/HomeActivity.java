package com.example.giaitoan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.giaitoan.data.PlusDatabaseHelper;
import com.example.giaitoan.model.AnswerModel;
import com.example.giaitoan.model.QuestionModel;
import com.example.giaitoan.model.QuestionWithAnswersModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    TextView plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mapping();
        hideSystemUI();
        setUpDataPlus();
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,PlusActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setUpDataPlus() {
        // câu hỏi 1
        QuestionModel questionModel_1= new QuestionModel(1,"1+1");
        AnswerModel answerModel_1= new AnswerModel(1,1,"2");
        AnswerModel answerModel_2= new AnswerModel(2,1,"3");
        AnswerModel answerModel_3= new AnswerModel(3,1,"6");
        AnswerModel answerModel_4= new AnswerModel(4,1,"1");
        AnswerModel answerModel_5= new AnswerModel(5,1,"7");
        AnswerModel answerModel_6= new AnswerModel(6,1,"9");
        List<AnswerModel> answerModelList= new ArrayList<>();
        answerModelList.add(answerModel_1);
        answerModelList.add(answerModel_2);
        answerModelList.add(answerModel_3);
        answerModelList.add(answerModel_4);
        answerModelList.add(answerModel_5);
        answerModelList.add(answerModel_6);
        QuestionWithAnswersModel questionWithAnswersModel= new QuestionWithAnswersModel(questionModel_1,answerModelList);
        // câu hỏi 2
        QuestionModel questionModel_2= new QuestionModel(2,"3+5");
        AnswerModel answerModel2_1= new AnswerModel(1,2,"5");
        AnswerModel answerModel2_2= new AnswerModel(2,2,"3");
        AnswerModel answerModel2_3= new AnswerModel(3,2,"6");
        AnswerModel answerModel2_4= new AnswerModel(4,2,"10");
        AnswerModel answerModel2_5= new AnswerModel(5,2,"8");
        AnswerModel answerModel2_6= new AnswerModel(6,2,"2");
        List<AnswerModel> answerModelList_2= new ArrayList<>();
        answerModelList_2.add(answerModel2_1);
        answerModelList_2.add(answerModel2_2);
        answerModelList_2.add(answerModel2_3);
        answerModelList_2.add(answerModel2_4);
        answerModelList_2.add(answerModel2_5);
        answerModelList_2.add(answerModel2_6);
        QuestionWithAnswersModel questionWithAnswersModel_2= new QuestionWithAnswersModel(questionModel_2,answerModelList_2);
        // câu hỏi 3
        List<QuestionWithAnswersModel> withAnswersModelList= new ArrayList<>();
        withAnswersModelList.add(questionWithAnswersModel);
        withAnswersModelList.add(questionWithAnswersModel_2);
        PlusDatabaseHelper plusDatabaseHelper= new PlusDatabaseHelper(HomeActivity.this);
        plusDatabaseHelper.addQuestionsWithAnswers(withAnswersModelList);
    }

    private void mapping() {
        plus=findViewById(R.id.plus);
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUI();
    }
}