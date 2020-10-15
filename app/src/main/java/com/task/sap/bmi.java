package com.task.sap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bmi extends AppCompatActivity {
    EditText weight,height;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        initialize();
    }

    private void initialize() {
        weight= findViewById(R.id.weight);
        height= findViewById(R.id.height);
        result = findViewById(R.id.txtHasilBMI);
    }
    @SuppressLint("DefaultLocale")
    public void Calculate(View v) {
        try {
            int beratBadan = Integer.parseInt(weight.getText().toString());
            int tinggiBadan = Integer.parseInt(height.getText().toString());
            double hasil = (beratBadan/(tinggiBadan*tinggiBadan*0.0001));
            result.setText(String.format("%.2f", hasil));

        } catch (Exception e){
            alert();
        }

    }
    public void clear(View v){
        weight.setText("");
        height.setText("");
    }

    private void alert() {
        Toast.makeText(this, "Check Again",Toast.LENGTH_SHORT).show();
    }
}