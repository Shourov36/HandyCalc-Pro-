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

public class OddEven extends AppCompatActivity {

    TextInputEditText editTextNumber;
    TextView tvDisplay;
    Button btnCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_odd_even);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextNumber = findViewById(R.id.editTextNumber);
        tvDisplay = findViewById(R.id.tvDisplay);
        btnCheck = findViewById(R.id.btnCheck);


        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               String Snumber = editTextNumber.getText().toString();

               if(Snumber.isEmpty()){
                   editTextNumber.setError("Please enter a number");
                   return;
               }


               Float number = Float.parseFloat(Snumber);







                if(number % 2 == 0){
                    tvDisplay.setText("The number is Even");
                }else{
                    tvDisplay.setText("The number is Odd");
                }


            }
        });








    }
}