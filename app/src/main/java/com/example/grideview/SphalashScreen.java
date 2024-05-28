package com.example.grideview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class SphalashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphalash_screen);



        LottieAnimationView lottieAnimationView = findViewById(R.id.splash_animation);

        // Delay for the duration of the Lottie animation
        int splashDuration = 1500; // Example duration, adjust as needed

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start MainActivity after the delay
                Intent intent = new Intent(SphalashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, splashDuration);
    }
}


