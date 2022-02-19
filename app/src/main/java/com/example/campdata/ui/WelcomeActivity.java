package com.example.campdata.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.campdata.R;

import gr.net.maroulis.library.EasySplashScreen;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        EasySplashScreen welcome = new EasySplashScreen(WelcomeActivity.this)
                .withFullScreen()
                .withTargetActivity(HomeActivity.class)
                .withSplashTimeOut(5000)
                //.withLogo(R.drawable.key1)
                .withBackgroundColor(Color.parseColor("#ffffff"))
                .withHeaderText("Dedan Kimathi University Of Technology")
                .withLogo(R.drawable.kimathilogo)
                .withAfterLogoText("Better life through technology")
                .withFooterText("Copyright @ 2022");

        welcome.getHeaderTextView().setTextColor(Color.parseColor("#066304"));
        welcome.getHeaderTextView().setTextSize(15);
        welcome.getFooterTextView().setTextSize(15);
        welcome.getAfterLogoTextView().setTextSize(15);
        welcome.getAfterLogoTextView().setTextColor(Color.parseColor("#066304"));
        welcome.getFooterTextView().setTextColor(Color.parseColor("#066304"));
        

        View view = welcome.create();
        setContentView(view);
    }
}