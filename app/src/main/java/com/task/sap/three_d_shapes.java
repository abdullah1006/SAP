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

public class three_d_shapes extends AppCompatActivity {
    String [] item ={"Sylinder","Cubois","Sphere"};
    private CardView cardSylinder,cardCubois;
    private EditText radiusSylinder,heightSylinder,width,length,heightCubois,radiusSphere;
    private TextView txtResult;
    Spinner shapes;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_d_shapes);
        //Initialize
        cardSylinder= findViewById(R.id.cardSylinder);
        cardCubois= findViewById(R.id.cardCubois);
        final LinearLayout viewSphere= findViewById(R.id.viewSphere);
        radiusSylinder=findViewById(R.id.radiusSylinder);
        heightSylinder=findViewById(R.id.heightSylinder);
        width=findViewById(R.id.width);
        length=findViewById(R.id.length);
        heightCubois=findViewById(R.id.heightCubois);
        radiusSphere=findViewById(R.id.radiusSphere);
        txtResult=findViewById(R.id.txtResult);
        //
        shapes = findViewById(R.id.spinner);

        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, item);
        shapes.setAdapter(adapter);

        shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        cardSylinder.setVisibility(View.VISIBLE);
                        cardCubois.setVisibility(View.GONE);
                        viewSphere.setVisibility(View.GONE);
                        radiusSylinder.setText("");
                        heightSylinder.setText("");
                        length.setText("");
                        width.setText("");
                        heightCubois.setText("");
                        radiusSphere.setText("");
                        txtResult.setText("");
                        break;
                    case 1:
                        cardSylinder.setVisibility(View.GONE);
                        cardCubois.setVisibility(View.VISIBLE);
                        viewSphere.setVisibility(View.GONE);
                        radiusSylinder.setText("");
                        heightSylinder.setText("");
                        length.setText("");
                        width.setText("");
                        heightCubois.setText("");
                        radiusSphere.setText("");
                        txtResult.setText("");
                        break;
                    case 2:
                        cardSylinder.setVisibility(View.GONE);
                        cardCubois.setVisibility(View.GONE);
                        viewSphere.setVisibility(View.VISIBLE);
                        radiusSylinder.setText("");
                        heightSylinder.setText("");
                        length.setText("");
                        width.setText("");
                        heightCubois.setText("");
                        radiusSphere.setText("");
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
        radiusSylinder.setText("");
        heightSylinder.setText("");
        length.setText("");
        width.setText("");
        heightCubois.setText("");
        radiusSphere.setText("");
        txtResult.setText("");
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void Result(View view) {
        try {
            double valueResult;
            int index = shapes.getSelectedItemPosition();
            if (item[index].equals("Sylinder")){
                double valueRadiusSylinder = Double.parseDouble(radiusSylinder.getText().toString());
                double valueHeightSylinder = Double.parseDouble(heightSylinder.getText().toString());
                valueResult = 22/7*valueRadiusSylinder*valueRadiusSylinder*valueHeightSylinder;
                txtResult.setText(String.format("%.2f", valueResult)+" Cm³");
            }
            if (item[index].equals("Cubois")){
                double valueWidth = Double.parseDouble(width.getText().toString());
                double valueLength = Double.parseDouble(length.getText().toString());
                double valueHeightCubois = Double.parseDouble(heightCubois.getText().toString());
                valueResult = valueWidth * valueLength*valueHeightCubois;
                txtResult.setText(String.format("%.2f", valueResult)+" Cm³");
            }
            if (item[index].equals("Sphere")){
                double valueRadius = Double.parseDouble(radiusSphere.getText().toString());
                valueResult = valueRadius * 4/3 * valueRadius * valueRadius;
                txtResult.setText(String.format("%.2f", valueResult)+" Cm³");
            }



        }catch (Exception e){
            alert();
        }
    }
    private void alert() {
        Toast.makeText(this, "Check Again",Toast.LENGTH_SHORT).show();
    }
}