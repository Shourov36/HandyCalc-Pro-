package com.example.grideview;

import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    LinearLayout bmicalculator_layout, profitcalculator_layout, oddevencalculator_layout,tasbih, zakat,info;
    LottieAnimationView lottieAnimationView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        info = findViewById(R.id.info);
        zakat = findViewById(R.id.zakat);
        tasbih = findViewById(R.id.tasbih);
        profitcalculator_layout = findViewById(R.id.profitcalculator_layout);
        bmicalculator_layout = findViewById(R.id.bmicalculator_layout);
        oddevencalculator_layout = findViewById(R.id.oddevencalculator_layout);
        lottieAnimationView = findViewById(R.id.lottieAnimationView);



        oddevencalculator_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Bmi.class);
                startActivity(intent);
            }
        });


        tasbih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Tasbih.class);
                startActivity(intent);
            }
        });

        profitcalculator_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, PorfitCalculator.class);
                startActivity(intent);
            }
        });


        oddevencalculator_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, OddEven.class);
                startActivity(intent);
            }
        });


        zakat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Zakat.class);
                startActivity(intent);
            }
        });



        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Info.class);
                startActivity(intent);
            }
        });


        bmicalculator_layout.setOnClickListener(v -> {
            // Show and play the Lottie animation
            lottieAnimationView.setVisibility(View.VISIBLE);
            lottieAnimationView.playAnimation();

            // Add an animation listener to start the next activity after the animation ends
            lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {}

                @Override
                public void onAnimationEnd(Animator animation) {
                    // Start Bmi activity after animation ends
                    Intent intent = new Intent(MainActivity.this, Bmi.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish(); // Finish MainActivity to prevent it from showing again
                }

                @Override
                public void onAnimationCancel(Animator animation) {}

                @Override
                public void onAnimationRepeat(Animator animation) {}
            });
        });




    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Do you really want to exit?")

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finishAndRemoveTask();
                    }
                })



                .show();
    }
}






