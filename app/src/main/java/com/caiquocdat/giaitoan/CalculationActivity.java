package com.caiquocdat.giaitoan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.caiquocdat.giaitoan.adapter.AnswerAdapter;
import com.caiquocdat.giaitoan.data.subtraction.SubtractionDatabaseHelper;
import com.caiquocdat.giaitoan.model.OnSelectAnswer;
import com.caiquocdat.giaitoan.model.QuestionWithAnswersModel;
import com.caiquocdat.giaitoan.R;
import com.caiquocdat.giaitoan.data.division.DivisionDatabaseHelper;
import com.caiquocdat.giaitoan.data.multiplication.MultiplicationDatabaseHelper;
import com.caiquocdat.giaitoan.data.plus.PlusDatabaseHelper;
import com.caiquocdat.giaitoan.model.AnswerModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CalculationActivity extends AppCompatActivity {
    QuestionWithAnswersModel questionWithAnswersModel;
    RecyclerView answerRcv;
    TextView questionTv, pointTv;
    AnswerAdapter answerAdapter;
    List<AnswerModel> answerModelList;
    GridLayoutManager gridLayoutManager;
    private HashSet<Integer> seenQuestionIds;
    HashSet<Integer> retrievedSet;
    String point;
    int pointInt;
    int pointCount = 0;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus);
        seenQuestionIds = new HashSet<>();
         preferences = getSharedPreferences("Check", Context.MODE_PRIVATE);
         editor = preferences.edit();
         Gson gsonResult=new Gson();
        String jsonResult = preferences.getString("seenQuestionIds", "");
        Type type = new TypeToken<HashSet<Integer>>(){}.getType();
        retrievedSet = gsonResult.fromJson(jsonResult, type);
        if (retrievedSet == null) {
            retrievedSet = new HashSet<>();
        }
        Log.d("Test_20", "onCreate: "+retrievedSet.size());

        mapping();
        hideSystemUI();
        Intent intentCalcu = getIntent();
        int point = intentCalcu.getIntExtra("point", -1);
        Log.d("Test_6", "onCreate: " + point);
        if (point == -1) {
            pointTv.setText("0");
        } else {
            pointTv.setText((point + 1) + "");
        }
        String activity = intentCalcu.getStringExtra("activity");
        if (activity.equals("plus")) {
           getDataPlusClick();
        }else if (activity.equals("sub")) {
            Log.d("Test_10", "onCreate: "+activity);
            getDataSubClick();
        }else if (activity.equals("div")) {
            Log.d("Test_10", "onCreate: "+activity);
            getDataDivClick();
        }else if (activity.equals("mul")) {
            Log.d("Test_10", "onCreate: "+activity);
            getDataMulClick();
        }else {
            getDataPra();
            Log.d("Test_10", "onCreate: "+activity);
        }


    }

    private void getDataMulClick() {
        MultiplicationDatabaseHelper multiplicationDatabaseHelper = new MultiplicationDatabaseHelper(CalculationActivity.this);
        questionWithAnswersModel = multiplicationDatabaseHelper.getRandomQuestionAndAnswersExcept(retrievedSet);
        Log.d("Test_17", "getDataPlusClick: "+questionWithAnswersModel.getQuestion().getText());
        Log.d("Test_17", "getDataPlusClick: "+questionWithAnswersModel.getQuestion().getResult());
        for (int i=0;i<questionWithAnswersModel.getAnswers().size();i++){
            Log.d("Test_17", "getDataPlusClick: "+questionWithAnswersModel.getAnswers().get(i));
        }
        seenQuestionIds.add(questionWithAnswersModel.getQuestion().getId()); // remember this question
        retrievedSet.add(questionWithAnswersModel.getQuestion().getId());
        Gson gson = new Gson();
        String json = gson.toJson(retrievedSet);
        editor.putString("seenQuestionIds", json);
        editor.apply();
        updateQuestionMul();
    }

    private void getDataDivClick() {
        DivisionDatabaseHelper divisionDatabaseHelper = new DivisionDatabaseHelper(CalculationActivity.this);
        questionWithAnswersModel = divisionDatabaseHelper.getRandomQuestionAndAnswersExcept(retrievedSet);
        Log.d("Test_17", "getDataPlusClick: "+questionWithAnswersModel.getQuestion().getText());
        Log.d("Test_17", "getDataPlusClick: "+questionWithAnswersModel.getQuestion().getResult());
        for (int i=0;i<questionWithAnswersModel.getAnswers().size();i++){
            Log.d("Test_17", "getDataPlusClick: "+questionWithAnswersModel.getAnswers().get(i));
        }
        seenQuestionIds.add(questionWithAnswersModel.getQuestion().getId()); // remember this question
        retrievedSet.add(questionWithAnswersModel.getQuestion().getId());
        Gson gson = new Gson();
        String json = gson.toJson(retrievedSet);
        editor.putString("seenQuestionIds", json);
        editor.apply();
        updateQuestionDiv();

    }

    private void getDataSubClick() {
        SubtractionDatabaseHelper subtractionDatabaseHelper = new SubtractionDatabaseHelper(CalculationActivity.this);
        questionWithAnswersModel = subtractionDatabaseHelper.getRandomQuestionAndAnswersExcept(retrievedSet);
        Log.d("Test_17", "getDataPlusClick: "+questionWithAnswersModel.getQuestion().getText());
        Log.d("Test_17", "getDataPlusClick: "+questionWithAnswersModel.getQuestion().getResult());
        for (int i=0;i<questionWithAnswersModel.getAnswers().size();i++){
            Log.d("Test_17", "getDataPlusClick: "+questionWithAnswersModel.getAnswers().get(i));
        }
        seenQuestionIds.add(questionWithAnswersModel.getQuestion().getId()); // remember this question
        retrievedSet.add(questionWithAnswersModel.getQuestion().getId());
        Gson gson = new Gson();
        String json = gson.toJson(retrievedSet);
        editor.putString("seenQuestionIds", json);
        editor.apply();
        updateQuestionSub();
    }

    private void getDataPra() {
    }

    private void getDataMul() {
        MultiplicationDatabaseHelper multiplicationDatabaseHelper = new MultiplicationDatabaseHelper(CalculationActivity.this);
        questionWithAnswersModel = multiplicationDatabaseHelper.getRandomQuestionAndAnswers();
        updateQuestionMul();
    }

    private void updateQuestionMul() {
        questionTv.setText(questionWithAnswersModel.getQuestion().getText());
        answerModelList = new ArrayList<>();
        answerModelList = questionWithAnswersModel.getAnswers();
        answerAdapter = new AnswerAdapter(answerModelList, this, questionWithAnswersModel.getQuestion().getResult());

        answerAdapter.setListener(new OnSelectAnswer() {
            @Override
            public void onSelect(String check) {
                if (check.equals("true")) {
                    String point = pointTv.getText().toString();
                    int pointIntSent = Integer.parseInt(point);
                    Log.d("Test_6", "onSelect: " + pointCount);
                    if (pointIntSent == 9) {
                        Intent intent = new Intent(CalculationActivity.this, GameOverActivity.class);
                        intent.putExtra("point", pointIntSent+1);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(CalculationActivity.this, InfoTrueActivity.class);
                        intent.putExtra("check", "true");
                        intent.putExtra("point", pointIntSent);
                        intent.putExtra("activity", "mul");
                        startActivity(intent);
                    }
                } else {
                    Intent intent = new Intent(CalculationActivity.this, InfoFalseActivity.class);
                    intent.putExtra("check", "false");
                    intent.putExtra("activity", "mul");
                    startActivity(intent);
                }
            }
        });

        gridLayoutManager = new GridLayoutManager(this, 3);
        answerRcv.setLayoutManager(gridLayoutManager);
        answerRcv.setAdapter(answerAdapter);
    }

    private void getDataDiv() {
        DivisionDatabaseHelper divisionDatabaseHelper = new DivisionDatabaseHelper(CalculationActivity.this);
        questionWithAnswersModel = divisionDatabaseHelper.getRandomQuestionAndAnswers();
        updateQuestionDiv();

    }

    private void updateQuestionDiv() {
        questionTv.setText(questionWithAnswersModel.getQuestion().getText());
        answerModelList = new ArrayList<>();
        answerModelList = questionWithAnswersModel.getAnswers();
        answerAdapter = new AnswerAdapter(answerModelList, this, questionWithAnswersModel.getQuestion().getResult());

        answerAdapter.setListener(new OnSelectAnswer() {
            @Override
            public void onSelect(String check) {
                if (check.equals("true")) {
                    String point = pointTv.getText().toString();
                    int pointIntSent = Integer.parseInt(point);
                    Log.d("Test_6", "onSelect: " + pointCount);
//                    pointInt=pointInt+1;
//                    pointTv.setText(pointInt+"");
                    if (pointIntSent == 9) {
                        Intent intent = new Intent(CalculationActivity.this, GameOverActivity.class);
                        intent.putExtra("point", pointIntSent+1);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(CalculationActivity.this, InfoTrueActivity.class);
                        intent.putExtra("check", "true");
                        intent.putExtra("point", pointIntSent);
                        intent.putExtra("activity", "div");
                        startActivity(intent);
                    }
                } else {
                    Intent intent = new Intent(CalculationActivity.this, InfoFalseActivity.class);
                    intent.putExtra("check", "false");
                    intent.putExtra("activity", "div");
                    startActivity(intent);
                }
            }
        });

        gridLayoutManager = new GridLayoutManager(this, 3);
        answerRcv.setLayoutManager(gridLayoutManager);
        answerRcv.setAdapter(answerAdapter);
    }

    private void getDataSub() {
        SubtractionDatabaseHelper subtractionDatabaseHelper = new SubtractionDatabaseHelper(CalculationActivity.this);
        questionWithAnswersModel = subtractionDatabaseHelper.getRandomQuestionAndAnswers();
        updateQuestionSub();

    }

    private void updateQuestionSub() {
        questionTv.setText(questionWithAnswersModel.getQuestion().getText());
        answerModelList = new ArrayList<>();
        answerModelList = questionWithAnswersModel.getAnswers();
        answerAdapter = new AnswerAdapter(answerModelList, this, questionWithAnswersModel.getQuestion().getResult());

        answerAdapter.setListener(new OnSelectAnswer() {
            @Override
            public void onSelect(String check) {
                if (check.equals("true")) {
                    String point = pointTv.getText().toString();
                    int pointIntSent = Integer.parseInt(point);
                    Log.d("Test_6", "onSelect: " + pointCount);
//                    pointInt=pointInt+1;
//                    pointTv.setText(pointInt+"");
                    if (pointIntSent == 9) {
                        Intent intent = new Intent(CalculationActivity.this, GameOverActivity.class);
                        intent.putExtra("point", pointIntSent+1);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(CalculationActivity.this, InfoTrueActivity.class);
                        intent.putExtra("check", "true");
                        intent.putExtra("point", pointIntSent);
                        intent.putExtra("activity", "sub");
                        startActivity(intent);
                    }
                } else {
                    Intent intent = new Intent(CalculationActivity.this, InfoFalseActivity.class);
                    intent.putExtra("check", "false");
                    intent.putExtra("activity", "sub");
                    startActivity(intent);
                }
            }
        });

        gridLayoutManager = new GridLayoutManager(this, 3);
        answerRcv.setLayoutManager(gridLayoutManager);
        answerRcv.setAdapter(answerAdapter);
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    private void mapping() {
        answerRcv = findViewById(R.id.answerRcv);
        questionTv = findViewById(R.id.questionTv);
        pointTv = findViewById(R.id.pointTv);
    }

    private void getDataPlus() {
        PlusDatabaseHelper plusDatabaseHelper = new PlusDatabaseHelper(CalculationActivity.this);
        questionWithAnswersModel = plusDatabaseHelper.getRandomQuestionAndAnswers();
        updateQuestion();
    }
    private void getDataPlusClick() {
        PlusDatabaseHelper plusDatabaseHelper = new PlusDatabaseHelper(CalculationActivity.this);
        questionWithAnswersModel = plusDatabaseHelper.getRandomQuestionAndAnswersExcept(retrievedSet);
        Log.d("Test_17", "getDataPlusClick: "+questionWithAnswersModel.getQuestion().getText());
        Log.d("Test_17", "getDataPlusClick: "+questionWithAnswersModel.getQuestion().getResult());
        for (int i=0;i<questionWithAnswersModel.getAnswers().size();i++){
            Log.d("Test_17", "getDataPlusClick: "+questionWithAnswersModel.getAnswers().get(i));
        }
        seenQuestionIds.add(questionWithAnswersModel.getQuestion().getId()); // remember this question
        retrievedSet.add(questionWithAnswersModel.getQuestion().getId());
        Gson gson = new Gson();
        String json = gson.toJson(retrievedSet);
        editor.putString("seenQuestionIds", json);
        editor.apply();


        updateQuestion();
    }


    private void updateQuestion() {
        questionTv.setText(questionWithAnswersModel.getQuestion().getText());
        answerModelList = new ArrayList<>();
        answerModelList = questionWithAnswersModel.getAnswers();
        Log.d("Test_16", "updateQuestion: "+questionWithAnswersModel.getQuestion().getResult());
        answerAdapter = new AnswerAdapter(answerModelList, this, questionWithAnswersModel.getQuestion().getResult());

        answerAdapter.setListener(new OnSelectAnswer() {
            @Override
            public void onSelect(String check) {
                if (check.equals("true")) {
                    String point = pointTv.getText().toString();
                    int pointIntSent = Integer.parseInt(point);
                    Log.d("Test_6", "onSelect: " + pointCount);
                    if (pointIntSent == 9) {
                        Intent intent = new Intent(CalculationActivity.this, GameOverActivity.class);
                        intent.putExtra("point", pointIntSent+1);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(CalculationActivity.this, InfoTrueActivity.class);
                        intent.putExtra("check", "true");
                        intent.putExtra("point", pointIntSent);
                        intent.putExtra("activity", "plus");
                        startActivity(intent);
                    }
                } else {
                    Intent intent = new Intent(CalculationActivity.this, InfoFalseActivity.class);
                    intent.putExtra("check", "false");
                    intent.putExtra("activity", "plus");
                    startActivity(intent);
                }
            }
        });

        gridLayoutManager = new GridLayoutManager(this, 3);
        answerRcv.setLayoutManager(gridLayoutManager);
        answerRcv.setAdapter(answerAdapter);
    }

    @Override
    public void onBackPressed() {
        // Không làm gì cả để ngăn người dùng nhấn nút back
    }
}