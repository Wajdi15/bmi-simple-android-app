package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText editTextWeight, editTextHeight;
    Button buttonCalculate;
    TextView textViewResult,title;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);
        title = findViewById(R.id.bmiId);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String userName = extras.getString("user");
            String titleString = String.format("Calculate your BMI %s",userName);
            title.setText(titleString);
        }


        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = editTextWeight.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            textViewResult.setText("Please enter weight and height.");
            return;
        }

        float weight = Float.parseFloat(weightStr);
        float height = Float.parseFloat(heightStr);

        float bmi = weight / (height * height);

        String result;
        String color;
        if (bmi < 18.5) {
            result = "Underweight";
            color = "#87b1d9";

        } else if (bmi < 25) {
            result = "Normal weight";
            color = "#3dd365";
        } else if (bmi < 30) {
            result = "Overweight";
            color = "#eee133";
        } else {
            result = "Obesity";
            color = "#f95353";
        }

        String bmiText = String.format("BMI: %.2f\n%s", bmi, result);
        textViewResult.setText(bmiText);
        textViewResult.setTextColor(Color.parseColor(color));
    }

}