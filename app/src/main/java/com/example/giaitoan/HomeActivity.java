package com.example.giaitoan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.giaitoan.data.DataPlusSetup;
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
        DataPlusSetup dataPlusSetupHelper = new DataPlusSetup(this);
        dataPlusSetupHelper.setUpDataPlus();
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,PlusActivity.class);
                startActivity(intent);
            }
        });
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