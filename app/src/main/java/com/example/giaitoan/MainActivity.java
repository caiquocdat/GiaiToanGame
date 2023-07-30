package com.example.giaitoan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.giaitoan.data.plus.DataPlusSetup;
import com.example.giaitoan.data.subtraction.DataSubtractionSetup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideSystemUI();
        setUpdataPlus();
        setUpdataSubtraction();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Splash_2_Activity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);  // thời gian delay là 3000 milliseconds (3 giây)
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
    private void setUpdataPlus() {
        DataPlusSetup dataPlusSetupHelper = new DataPlusSetup(this);
        dataPlusSetupHelper.setUpDataPlus();
    }
    private void setUpdataSubtraction() {
        DataSubtractionSetup dataSubtractionSetup = new DataSubtractionSetup(this);
        dataSubtractionSetup.setUpDataPlus();
    }
    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUI();
    }
    @Override
    public void onBackPressed() {
        // Không làm gì cả để ngăn người dùng nhấn nút back
    }
}