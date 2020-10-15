package com.task.sap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;



public class temperature extends AppCompatActivity {

    String[] item={"Celcius","Reamur","Farenheit","Kelvin"};
    EditText tempFrom;
    EditText txtResult;
    Spinner from,to;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        //Initialize
        tempFrom=findViewById(R.id.tempFrom);
        txtResult=findViewById(R.id.txtResult);
        from = findViewById(R.id.spinner);
        to = findViewById(R.id.spinner2);
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, item);
        from.setAdapter(adapter);
        to.setAdapter(adapter);
        txtResult.setKeyListener(null);
    }

    @SuppressLint("DefaultLocale")
    public void Result(View view) {
        try {
            double valueResult ;
            double valueFrom = Double.parseDouble(tempFrom.getText().toString());
            int indexFrom = from.getSelectedItemPosition();
            int indexTo = to.getSelectedItemPosition();

            //From Celcius
            if(item[indexFrom].equals("Celcius")&& item[indexTo].equals("Reamur")){
                    valueResult = 4.0 / 5.0*valueFrom;
                txtResult.setText(String.format("%.2f", valueResult));
            }
            if(item[indexFrom].equals("Celcius")&& item[indexTo].equals("Farenheit")){
                valueResult = 9.0 / 5.0 * valueFrom +32;
                txtResult.setText(String.format("%.2f", valueResult));
            }
            if(item[indexFrom].equals("Celcius")&& item[indexTo].equals("Kelvin")){
                valueResult = valueFrom+273;
                txtResult.setText(String.format("%.2f", valueResult));
            }
            if(item[indexFrom].equals("Celcius")&& item[indexTo].equals("Celcius")){
                valueResult = valueFrom;
                txtResult.setText(String.format("%.2f", valueResult));
            }
            //From Reamur
            if(item[indexFrom].equals("Reamur")&& item[indexTo].equals("Celcius")){
                valueResult =5.0/4.0*valueFrom;
                txtResult.setText(String.format("%.2f", valueResult));
            }
            if(item[indexFrom].equals("Reamur")&& item[indexTo].equals("Farenheit")){
                valueResult =(9.0/4.0*valueFrom)+32;
                txtResult.setText(String.format("%.2f", valueResult));
            }
            if(item[indexFrom].equals("Reamur")&& item[indexTo].equals("Kelvin")){
                valueResult =5.0/4.0*valueFrom+273;
                txtResult.setText(String.format("%.2f", valueResult));

            }
            if(item[indexFrom].equals("Reamur")&& item[indexTo].equals("Reamur")){
                valueResult = valueFrom;
                txtResult.setText(String.format("%.2f", valueResult));
            }
            //From Farenheit
            if(item[indexFrom].equals("Farenheit")&& item[indexTo].equals("Reamur")){
                valueResult =4.0/9.0*(valueFrom-32);
                txtResult.setText(String.format("%.2f", valueResult));
            }
            if(item[indexFrom].equals("Farenheit")&& item[indexTo].equals("Celcius")){
                valueResult =5.0/9.0*(valueFrom-32);
                txtResult.setText(String.format("%.2f", valueResult));
            }
            if(item[indexFrom].equals("Farenheit")&& item[indexTo].equals("Kelvin")){
                valueResult =5.0/9.0*(valueFrom-32)+273;
                txtResult.setText(String.format("%.2f", valueResult));
            }
            if(item[indexFrom].equals("Farenheit")&& item[indexTo].equals("Farenheit")){
                valueResult =valueFrom;
                txtResult.setText(String.format("%.2f", valueResult));
            }
            //From Kelvin
            if(item[indexFrom].equals("Kelvin")&& item[indexTo].equals("Reamur")){
                valueResult =4.0/5.0*(valueFrom-273);
                txtResult.setText(String.format("%.2f", valueResult));
            }
            if(item[indexFrom].equals("Kelvin")&& item[indexTo].equals("Celcius")){
                valueResult =(valueFrom-273);
                txtResult.setText(String.format("%.2f", valueResult));
            }
            if(item[indexFrom].equals("Kelvin")&& item[indexTo].equals("Farenheit")){
                valueResult = ((9.0 / 5.0) * (valueFrom - 273)) + 32;
                txtResult.setText(String.format("%.2f", valueResult));
            }
            if(item[indexFrom].equals("Kelvin")&& item[indexTo].equals("Kelvin")){
                valueResult =valueFrom;
                txtResult.setText(String.format("%.2f", valueResult));
            }
        }catch (Exception e){
            alert();
        }
            
    }

    public void reset(View view) {
        tempFrom.setText("");
        txtResult.setText("");
    }
    private void alert() {
        Toast.makeText(this, "Check Again",Toast.LENGTH_SHORT).show();
    }
}