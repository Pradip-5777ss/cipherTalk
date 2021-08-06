package com.PradipSahoo7722.ciphertalk.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.PradipSahoo7722.ciphertalk.MainScreen.MainActivity;
import com.PradipSahoo7722.ciphertalk.R;

public class SplashScreen extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.SplashScreenLogo);

        new Handler().postDelayed(() -> startActivity(new Intent(getApplicationContext(), MainActivity.class)),500);
    }
}