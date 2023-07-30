package com.example.giaitoan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {
    ImageView againImg;
    TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        mapping();
        hideSystemUI();
        Intent intent= getIntent();
        int point= intent.getIntExtra("point",0);
        resultTv.setText("ĐIỂM: "+point);
        againImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOverActivity.this, HomeActivity.class);
                startActivity(intent);
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
        againImg=findViewById(R.id.againImg);
        resultTv=findViewById(R.id.resultTv);
    }
    @Override
    public void onBackPressed() {
        // Không làm gì cả để ngăn người dùng nhấn nút back
    }
}