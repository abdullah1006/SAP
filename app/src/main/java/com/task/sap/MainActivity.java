package com.task.sap;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.idbtnStart);
    }
    public void clickStart(View v){
        Intent i = new Intent(this,main_menu.class);
        startActivity(i);
    }
}