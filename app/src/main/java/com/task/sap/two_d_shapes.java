package com.task.sap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class two_d_shapes extends AppCompatActivity {

    String [] item ={"Triangle","Square","Circle"};
    private CardView cardTriangle,cardSquare;
    private EditText base,height,length,width,radius;
    private TextView txtResult;

    Spinner shapes;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_d_shapes);
        //Initialize
        cardTriangle= findViewById(R.id.cardTriangle);
        cardSquare= findViewById(R.id.cardSquare);
        final LinearLayout circle = findViewById(R.id.RadiusView);
        base= findViewById(R.id.base);
        height= findViewById(R.id.height);
        length= findViewById(R.id.length);
        width= findViewById(R.id.width);
        radius=findViewById(R.id.radius);
        txtResult = findViewById(R.id.txtResult);
        //

        shapes = findViewById(R.id.spinner);

        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, item);
        shapes.setAdapter(adapter);

        shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        cardSquare.setVisibility(View.GONE);
                        cardTriangle.setVisibility(View.VISIBLE);
                        circle.setVisibility(View.GONE);
                        base.setText("");
                        height.setText("");
                        length.setText("");
                        width.setText("");
                        radius.setText("");
                        txtResult.setText("");
                        break;
                    case 1:
                        cardSquare.setVisibility(View.VISIBLE);
                        cardTriangle.setVisibility(View.GONE);
                        circle.setVisibility(View.GONE);
                        base.setText("");
                        height.setText("");
                        length.setText("");
                        height.setText("");
                        radius.setText("");
                        txtResult.setText("");
                        break;
                    case 2:
                        cardSquare.setVisibility(View.GONE);
                        cardTriangle.setVisibility(View.GONE);
                        circle.setVisibility(View.VISIBLE);
                        base.setText("");
                        height.setText("");
                        length.setText("");
                        height.setText("");
                        radius.setText("");
                        txtResult.setText("");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void reset(View view) {
        base.setText("");
        height.setText("");
        length.setText("");
        width.setText("");
        radius.setText("");
        txtResult.setText("");
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void Result(View view) {
        try {
                double valueResult;
                int index = shapes.getSelectedItemPosition();
                if (item[index].equals("Triangle")){
                    double valueBase = Double.parseDouble(base.getText().toString());
                    double valueHeight = Double.parseDouble(height.getText().toString());
                    valueResult = valueBase * valueHeight/2;
                    txtResult.setText(String.format("%.2f", valueResult) +" Cm²");
                }
            if (item[index].equals("Square")){
                double valueWidth = Double.parseDouble(width.getText().toString());
                double valueLength = Double.parseDouble(length.getText().toString());
                valueResult = valueWidth * valueLength;
                txtResult.setText(String.format("%.2f", valueResult)+" Cm²");
            }
            if (item[index].equals("Circle")){
                double valueRadius = Double.parseDouble(radius.getText().toString());
                valueResult = valueRadius * 22/7 * valueRadius;
                txtResult.setText(String.format("%.2f", valueResult)+" Cm²");
            }



        }catch (Exception e){
            alert();
        }
    }
    private void alert() {
        Toast.makeText(this, "Check Again",Toast.LENGTH_SHORT).show();
    }
}