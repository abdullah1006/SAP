package com.task.sap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class test_value extends AppCompatActivity {
    EditText presence,avg_Task,mid_exam,final__exam;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_value);

        Initialize();
    }

    private void Initialize(){
        presence = findViewById(R.id.presence);
        avg_Task = findViewById(R.id.avg_task);
        mid_exam = findViewById(R.id.mid_exam);
        final__exam = findViewById(R.id.final_exam);
        txtResult = findViewById(R.id.txtResult);
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public void Calculate(View view) {
        try {
            double valuePresence = Double.parseDouble(presence.getText().toString());
            double valueAvgTask = Double.parseDouble(avg_Task.getText().toString());
            double valueMidExam = Double.parseDouble(mid_exam.getText().toString());
            double valueFinalExam = Double.parseDouble(final__exam.getText().toString());
            double valueResult = (((valueAvgTask*0.2) + (valueFinalExam*0.3)+(valueMidExam*0.3)+(valuePresence*0.2)) / 25);

            if (isValidValue(valuePresence, "Presence") && isValidValue (valueAvgTask, "Average Task") && isValidValue(valueFinalExam, "Final Exam") && isValidValue(valueMidExam,"Mid Exam")) {
                txtResult.setText(String.format("%.2f", valueResult) + " / " + convert(valueResult));
            }
        }catch (Exception e){
            alert("Please fill correctly");
        }
    }

    private String convert(double valueResult) {

        String hasil = "";

        if (valueResult <= 4 && valueResult > 3.66){
            hasil = "A";
        } else if (valueResult <= 3.66 && valueResult> 3.33){
            hasil = "A-" ;
        } else if (valueResult <= 3.33 && valueResult > 3){
            hasil = "B+" ;
        } else if (valueResult <= 3 && valueResult > 2.66){
            hasil = "B" ;
        } else if (valueResult <= 2.66 && valueResult > 2.33){
            hasil = "B-" ;
        } else if (valueResult <= 2.33 && valueResult > 2){
            hasil = "C+" ;
        } else if (valueResult <= 2 && valueResult > 1.66){
            hasil = "C" ;
        } else if (valueResult <= 1.66 && valueResult > 0){
            hasil = "D" ;
        } else if (valueResult <= 0){
            hasil = "E" ;
        }

        return hasil ;

    }


    private boolean isValidValue(double val, String teks) {
        if (val <= 100){
            return true ;
        } else {
            alert(teks + " can't be more than 100");
            return false ;
        }
    }

    private void alert(String alert_message) {
        Toast.makeText(this,alert_message, Toast.LENGTH_SHORT).show();
    }

    public void Clear(View view) {
        presence.setText("");
        avg_Task.setText("");
        mid_exam.setText("");
        final__exam.setText("");
    }
}

