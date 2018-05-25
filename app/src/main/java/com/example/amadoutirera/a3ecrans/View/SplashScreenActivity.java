package com.example.amadoutirera.a3ecrans.View;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.amadoutirera.a3ecrans.R;

public class SplashScreenActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;


    // Demmarage SplashScreen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);
        ImageView imageSplashScreen = (ImageView) findViewById(R.id.imageSplashScreen);

        Glide.with(this)
                .load(R.drawable.mic)
                .into(imageSplashScreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, Viewpager_BC.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);


    }
}
