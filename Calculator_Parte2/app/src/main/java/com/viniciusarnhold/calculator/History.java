package com.viniciusarnhold.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {

    TextView textHistory;

    ArrayList<String> history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Intent intent = getIntent();

        history = intent.getStringArrayListExtra("listHistory");
        textHistory = findViewById(R.id.historyCalculator);
        for(String linha : history){
            textHistory.setText(textHistory.getText() + linha + "\n--------------------\n");
        }
    }

    public void retornarMain(View view) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }
}