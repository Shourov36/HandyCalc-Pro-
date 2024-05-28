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

public class PorfitCalculator extends AppCompatActivity {

    TextInputEditText buyingPrice, sellingPrice;
    Button calculate;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_porfit_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buyingPrice = findViewById(R.id.buyingPrice);
        sellingPrice = findViewById(R.id.sellingPrice);
        calculate = findViewById(R.id.button);
        tvDisplay = findViewById(R.id.tvDisplay);



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                String buyPrice = buyingPrice.getText().toString();
                String sellPrice = sellingPrice.getText().toString();

              if (buyPrice.isEmpty()) {
                  buyingPrice.setError("Please enter a number");
                  return;
              }
              if (sellPrice.isEmpty()) {
                  sellingPrice.setError("Please enter a number");
              }


                Float buyPriceFloat = Float.parseFloat(buyPrice);
                Float sellPriceFloat = Float.parseFloat(sellPrice);

                Float profit = sellPriceFloat - buyPriceFloat;

                if (profit < 0) {

                    tvDisplay.setText("Your loss is: " + Math.abs(profit));
                }else {
                    tvDisplay.setText("Your profit is: " + profit);
                }




            }
        });



    }
}