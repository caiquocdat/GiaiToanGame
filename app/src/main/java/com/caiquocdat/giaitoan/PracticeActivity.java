package com.caiquocdat.giaitoan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.caiquocdat.giaitoan.adapter.AnswerPraAdapter;
import com.caiquocdat.giaitoan.data.practice.PracticeDatabaseHelper;
import com.caiquocdat.giaitoan.model.OnSelectAnswer;
import com.caiquocdat.giaitoan.model.QuestionPra;
import com.caiquocdat.giaitoan.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashSet;

public class PracticeActivity extends AppCompatActivity {
    QuestionPra questionPra;
    ProgressBar progressBar;
    RecyclerView resultRcv;
    AnswerPraAdapter answerPraAdapter;
    GridLayoutManager gridLayoutManager;
    TextView xTv, yTv, ptTv, zTv, pointTv;
    private CountDownTimer countDownTimer;
    ImageView xImg,yImg,ptImg,zImg;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private HashSet<Integer> seenQuestionIds;
    HashSet<Integer> retrievedSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        mapping();
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
        hideSystemUI();
        getDataPra();
        Intent intentCalcu = getIntent();
        String pointResult = pointTv.getText().toString();
        int pointIntResult = Integer.parseInt(pointResult);
        Log.d("Test_14", "onCreate: " + pointIntResult);
        int point = intentCalcu.getIntExtra("point", -1);
        if (point == -1) {
            pointTv.setText("0");
        } else {
            pointTv.setText((point + 1) + "");
        }
        progressBar.setMax(100);
        countDownTimer=new CountDownTimer(10000, 100) { // Tổng thời gian là 10000 milliseconds (10 giây), và khoảng thời gian giữa các lần cập nhật là 100 milliseconds
            public void onTick(long millisUntilFinished) {
                int progress = (int) (millisUntilFinished / 100);
                progressBar.setProgress(progress);
            }

            public void onFinish() {
                String pointResult = pointTv.getText().toString();
                int pointIntResult = Integer.parseInt(pointResult);
                progressBar.setProgress(0);
                Intent intent = new Intent(PracticeActivity.this, GameOverActivity.class);
                intent.putExtra("point", pointIntResult);
                startActivity(intent);
            }
        }.start();
    }



    private void getDataPra() {
        PracticeDatabaseHelper practiceDatabaseHelper = new PracticeDatabaseHelper(PracticeActivity.this);
        questionPra = practiceDatabaseHelper.getRandomQuestionAndAnswersExcept(retrievedSet);
        seenQuestionIds.add(questionPra.getId()); // remember this question
        retrievedSet.add(questionPra.getId());
        Gson gson = new Gson();
        String json = gson.toJson(retrievedSet);
        editor.putString("seenQuestionIds", json);
        editor.apply();
        answerPraAdapter = new AnswerPraAdapter(questionPra.getAnswers(), PracticeActivity.this, questionPra.getCorrectAnswer());
        gridLayoutManager = new GridLayoutManager(this, 2);
        resultRcv.setLayoutManager(gridLayoutManager);
        resultRcv.setAdapter(answerPraAdapter);
        String x = questionPra.getX().toString();
        String pt = questionPra.getPt();
        String y = questionPra.getY().toString();
        String z = questionPra.getZ().toString();
        if (x.equals("0")) {
            xTv.setText("?");
            ptTv.setText(pt);
            yTv.setText(y);
            zTv.setText(z);
            xImg.setVisibility(View.VISIBLE);
        } else if (pt == null) {
            xTv.setText(x);
            ptTv.setText("?");
            yTv.setText(y);
            zTv.setText(z);
            ptImg.setVisibility(View.VISIBLE);
        } else if (y.equals("0")) {
            xTv.setText(x);
            ptTv.setText(pt);
            yTv.setText("?");
            zTv.setText(z);
            yImg.setVisibility(View.VISIBLE);
        } else if (z.equals("0")) {
            xTv.setText(x);
            ptTv.setText(pt);
            yTv.setText(y);
            zTv.setText("?");
            zImg.setVisibility(View.VISIBLE);
        }
        Log.d("Test_12", questionPra.getX() + questionPra.getPt() + questionPra.getY() + "=" + questionPra.getZ());
        Log.d("Test_12", "correct: " + questionPra.getCorrectAnswer());
        for (int i = 0; i < questionPra.getAnswers().size(); i++) {
            Log.d("Test_12", "answer: " + questionPra.getAnswers().get(i));
        }
        //check click
        answerPraAdapter.setListener(new OnSelectAnswer() {
            @Override
            public void onSelect(String check) {
                if (check.equals("true")) {
                    String point = pointTv.getText().toString();
                    int pointIntSent = Integer.parseInt(point);
                    if (pointIntSent == 9) {
                        Intent intent = new Intent(PracticeActivity.this, GameOverActivity.class);
                        intent.putExtra("point", pointIntSent+1);
                        startActivity(intent);
                        countDownTimer.cancel();
                    } else {
                        Intent intent = new Intent(PracticeActivity.this, InfoTrueActivity.class);
                        intent.putExtra("check", "true");
                        intent.putExtra("point", pointIntSent);
                        intent.putExtra("activity", "pra");
                        startActivity(intent);
                        countDownTimer.cancel();
                    }
                } else {
                    Intent intent = new Intent(PracticeActivity.this, InfoFalseActivity.class);
                    intent.putExtra("check", "false");
                    intent.putExtra("activity", "pra");
                    startActivity(intent);
                    countDownTimer.cancel();
                }
            }
        });
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
        progressBar = findViewById(R.id.progressBar);
        resultRcv = findViewById(R.id.resultRcv);
        xTv = findViewById(R.id.xTv);
        ptTv = findViewById(R.id.ptTv);
        yTv = findViewById(R.id.yTv);
        zTv = findViewById(R.id.zTv);
        xImg = findViewById(R.id.xImg);
        yImg = findViewById(R.id.yImg);
        ptImg = findViewById(R.id.ptImg);
        zImg = findViewById(R.id.zImg);
        pointTv = findViewById(R.id.pointTv);
    }
    @Override
    public void onBackPressed() {
        // Không làm gì cả để ngăn người dùng nhấn nút back
    }
}