package com.example.giaitoan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InfoFalseActivity extends AppCompatActivity {
    TextView playAgain,homeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_false);
        hideSystemUI();
        mapping();
        Intent intent = getIntent();
        String check = intent.getStringExtra("check");
        String activity = intent.getStringExtra("activity");
        int point = intent.getIntExtra("point",0);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(activity.equals("pra")){
                    Intent intent_1 = new Intent(InfoFalseActivity.this, PracticeActivity.class);
                    startActivity(intent_1);
                }else {
                    Intent intent_1 = new Intent(InfoFalseActivity.this, CalculationActivity.class);
                    intent_1.putExtra("activity", activity);
                    startActivity(intent_1);
                }
                remoteDataId();
            }
        });
        homeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_2= new Intent(InfoFalseActivity.this,HomeActivity.class);
                startActivity(intent_2);
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
    private void remoteDataId() {
        SharedPreferences preferences = getSharedPreferences("Check", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("seenQuestionIds");
        editor.apply();
    }

    private void mapping() {
        playAgain=findViewById(R.id.playAgain);
        homeTv=findViewById(R.id.homeTv);
    }
    @Override
    public void onBackPressed() {
        // Không làm gì cả để ngăn người dùng nhấn nút back
    }
}