package com.dmytro.kuchura.cityplaces;

import android.content.Intent;
import android.os.Handler;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

public class WelcomeActivity extends FragmentActivity {

    int SPLASH_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mySuperIntent = new Intent(WelcomeActivity.this, OnBoardingActivity.class);
                startActivity(mySuperIntent);
                finish();
            }
        }, SPLASH_TIME);
    }
}