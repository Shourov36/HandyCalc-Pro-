package com.example.grideview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class Zakat extends AppCompatActivity {


    TextInputEditText goldValue, silverValue, savingsValue;
    TextView tvDisplay;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_zakat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        goldValue = findViewById(R.id.goldValue);
        silverValue = findViewById(R.id.silverValue);
        savingsValue = findViewById(R.id.savingsValue);
        tvDisplay = findViewById(R.id.tvDisplay);
        btnCalculate = findViewById(R.id.btnCalculate);



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gold = goldValue.getText().toString();
                String silver = silverValue.getText().toString();
                String savings = savingsValue.getText().toString();

                if (gold.isEmpty()) {
                    goldValue.setError("If you don't have gold please enter 0");
                    return;

                }
                if (silver.isEmpty()) {
                    silverValue.setError("If you don't have silver please enter 0");
                    return;

                }
                if (savings.isEmpty()) {
                    savingsValue.setError("If you don't have savings please enter 0");
                    return;

                }

                Double goldAmount = Double.parseDouble(gold);
                Double silverAmount = Double.parseDouble(silver);
                Double savingsAmount = Double.parseDouble(savings);



                Double totalamount = (Double) (goldAmount + silverAmount + savingsAmount);

                Double zakat = (Double) (totalamount*0.025);


                tvDisplay.setText("Zakat Amount: " + zakat +"TK");


            }
        });


    }
}