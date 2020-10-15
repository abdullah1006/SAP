package com.task.sap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class main_menu extends AppCompatActivity implements View.OnClickListener {

    private CardView card1,card2,card3,card4,card5,card6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        card1 = (CardView)findViewById(R.id.cardBMI);
        card2 = (CardView)findViewById(R.id.cardTest);
        card3 = (CardView)findViewById(R.id.card2D);
        card4 = (CardView)findViewById(R.id.card3DCalc);
        card5 = (CardView)findViewById(R.id.cardTempCalc);
        card6 = (CardView)findViewById(R.id.cardAbout);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.cardBMI :
                i = new Intent(this,bmi.class);
                startActivity(i);
                break;
            case R.id.cardTest:
                i=new Intent(this,test_value.class);
                startActivity(i);
                break;
            case R.id.card2D:
                i=new Intent(this,two_d_shapes.class);
                startActivity(i);
                break;
            case R.id.card3DCalc:
                i=new Intent(this,three_d_shapes.class);
                startActivity(i);
                break;
            case R.id.cardTempCalc:
                i=new Intent(this,temperature.class);
                startActivity(i);
                break;
            case R.id.cardAbout:
                i=new Intent(this,about.class);
                startActivity(i);
                break;
        }
    }
}