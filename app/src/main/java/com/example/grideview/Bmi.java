package com.example.grideview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;

public class Bmi extends AppCompatActivity {


    TextInputEditText edName, edWeight, edFeet, edInches;
    Button btnCalculate;
    TextView tvDisplay;
    LottieAnimationView congratulation, warning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edName = findViewById(R.id.edName);
        edWeight = findViewById(R.id.edWeight);
        edFeet = findViewById(R.id.edFeet);
        edInches = findViewById(R.id.edInches);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvDisplay = findViewById(R.id.tvDisplay);
        congratulation = findViewById(R.id.congratulation);
        warning = findViewById(R.id.warning);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String Sname = edName.getText().toString();
                String Sweight = edWeight.getText().toString();
                String Sfeet = edFeet.getText().toString();
                String Sinches = edInches.getText().toString();


                if (Sname.length() == 0 || Sweight.length() == 0 || Sfeet.length() == 0 || Sinches.length() == 0) {
                    if (Sname.length() == 0)
                        edName.setError("Please enter your name");
                    if (Sweight.length() == 0)
                        edWeight.setError("Please enter your weight");
                    if (Sfeet.length() == 0)
                        edFeet.setError("Please enter your height");
                    if (Sinches.length() == 0)
                        edInches.setError("Please enter your height");
                    return;
                }


                Float Fweight = Float.parseFloat(Sweight);
                Float Ffeet = Float.parseFloat(Sfeet);
                Float Finches = Float.parseFloat(Sinches);

                Float feetToMeter = Ffeet * 0.3048f;
                Float inchesToMeter = Finches * 0.0254f;
                Float totalMeter = feetToMeter + inchesToMeter;

                Float BMI = Fweight / (totalMeter * totalMeter);


                if (BMI < 18.5) {
                    tvDisplay.setText(Sname + " Your BMI is " + BMI +"\n"+ " You are underweight");
                    congratulation.setVisibility(View.GONE);
                    warning.setVisibility(View.VISIBLE);

                    warning.playAnimation();

                } else if (BMI > 24.9) {
                    tvDisplay.setText(Sname + " Your BMI is " + BMI +"\n"+ " You are overweight");
                    congratulation.setVisibility(View.GONE);
                    warning.setVisibility(View.VISIBLE);
                    warning.playAnimation();


                } else {
                    tvDisplay.setText(Sname + " Your BMI is " + BMI +"\n"+ " You are healthy");
                    warning.setVisibility(View.GONE);
                    congratulation.setVisibility(View.VISIBLE);
                    congratulation.playAnimation();

                }


            }
        });


    }

    @Override
    public void onBackPressed() {
        // Start MainActivity and clear the activity stack
        super.onBackPressed();
        Intent intent = new Intent(Bmi.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // Finish the current activity
    }

}