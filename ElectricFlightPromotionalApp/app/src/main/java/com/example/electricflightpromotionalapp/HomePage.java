package com.example.electricflightpromotionalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    TextView hourEmission, dayEmission, hourSave, daySave, homeCirclenumber;
    ImageView cf, aelecair;
    ConstraintLayout continuebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        continuebtn = findViewById(R.id.continueHomePage);
        hourEmission = findViewById(R.id.tvHourEmission);
        aelecair = findViewById(R.id.aelecairlogo);
        cf = findViewById(R.id.cflogo);
        dayEmission = findViewById(R.id.tvYesterdayEmission);
        hourSave = findViewById(R.id.tvHourSaving);
        daySave = findViewById(R.id.tvYesterdaySaved);
        homeCirclenumber = findViewById(R.id.homeCircleNumber);

        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://chhotakarde.ga/video"));
                startActivity(viewIntent);
            }
        });

        long all = getIntent().getLongExtra("ALL", 483578245);
        long hr = getIntent().getLongExtra("HR", 382545);
        long hrsave = getIntent().getLongExtra("HRSAVE", 32304);
        long allsave = getIntent().getLongExtra("ALLSAVE", 3198443);
        dayEmission.setText(String.valueOf(all));
        homeCirclenumber.setText(String.valueOf(getIntent().getIntExtra("CARBON", (int) all)));
        hourEmission.setText(String.valueOf(hr));
        hourSave.setText(String.valueOf(hrsave));
        daySave.setText(String.valueOf(allsave));
        aelecair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}