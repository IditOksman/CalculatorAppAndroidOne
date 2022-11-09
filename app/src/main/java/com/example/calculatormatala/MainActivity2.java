package com.example.calculatormatala;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView resultScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        resultScreen = findViewById(R.id.result);

        Bundle box = getIntent().getExtras();
        Double finalResult = box.getDouble("key1");
        showResult(finalResult.toString());
    }

    private void showResult(String result) {
        resultScreen.setText(result);
    }
}

