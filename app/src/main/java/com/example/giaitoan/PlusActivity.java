package com.example.giaitoan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.giaitoan.R;
import com.example.giaitoan.data.PlusDatabaseHelper;
import com.example.giaitoan.model.QuestionWithAnswersModel;

public class PlusActivity extends AppCompatActivity {
    QuestionWithAnswersModel questionWithAnswersModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus);
        getDataPlus();
    }

    private void getDataPlus() {
        PlusDatabaseHelper plusDatabaseHelper= new PlusDatabaseHelper(PlusActivity.this);
        questionWithAnswersModel= plusDatabaseHelper.getRandomQuestionAndAnswers();
        Log.d("Test_1", "question: "+questionWithAnswersModel.getQuestion().getText());
        for (int i=0;i<questionWithAnswersModel.getAnswers().size();i++){
            Log.d("Test_1", "answer: "+questionWithAnswersModel.getAnswers().get(i).getText());
        }
    }
}