package com.example.calculatormatala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**VARIABLES OF MAINACTIVITY*/

     String firstNumber = "";
     String secondNumber = "";
     String operator = "";
     String tempResult = "";
     TextView screenText;

    /**FUNCTIONS OF MAINACTIVITY*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screenText = findViewById(R.id.result);
        setListeners();
    }

    private void setListeners() {

        findViewById(R.id.zero).setOnClickListener(v -> {
            setNumbersText("0");
        });
        findViewById(R.id.one).setOnClickListener(v -> {
            setNumbersText("1");
        });
        findViewById(R.id.two).setOnClickListener(v -> {
            setNumbersText("2");
        });
        findViewById(R.id.three).setOnClickListener(v -> {
            setNumbersText("3");
        });
        findViewById(R.id.four).setOnClickListener(v -> {
            setNumbersText("4");
        });
        findViewById(R.id.five).setOnClickListener(v -> {
            setNumbersText("5");
        });
        findViewById(R.id.six).setOnClickListener(v -> {
            setNumbersText("6");
        });
        findViewById(R.id.seven).setOnClickListener(v -> {
            setNumbersText("7");
        });
        findViewById(R.id.eight).setOnClickListener(v -> {
            setNumbersText("8");
        });
        findViewById(R.id.nine).setOnClickListener(v -> {
            setNumbersText("9");
        });

        findViewById(R.id.plus).setOnClickListener(v -> {
            setOperatorText("+");
        });

        findViewById(R.id.minus).setOnClickListener(v -> {
            setOperatorText("-");
        });

        findViewById(R.id.multiply).setOnClickListener(v -> {
            setOperatorText("X");
        });

        findViewById(R.id.divide).setOnClickListener(v -> {
            setOperatorText("/");
        });

        findViewById(R.id.clear).setOnClickListener(v -> {
            clearAll();
        });

        findViewById(R.id.delete).setOnClickListener(v -> {
            int endIdx = tempResult.length() - 1;
            tempResult = tempResult.substring(0,endIdx);
            screenText.setText(tempResult);
        });

        findViewById(R.id.equal).setOnClickListener(v -> {
            showFinalResult();
        });
    }


    private void setOperatorText(String op) {
        if(operator.isEmpty()) {
            operator += op;
            tempResult += operator;
            screenText.setText(tempResult);
        }
    }

    private void setNumbersText(String number) {
        if(operator.isEmpty()) {
            firstNumber += number;
        } else {
            secondNumber += number;
        }
        tempResult += number;
        screenText.setText(tempResult);
    }

    private void clearAll(){
        screenText.setText("");
        firstNumber = "";
        secondNumber= "";
        tempResult = "";
        operator = "";
    }

    private void showFinalResult() {
        Double num1 = Double.parseDouble(firstNumber);
        Double num2 = Double.parseDouble(secondNumber);

        Intent intent = new Intent(this,MainActivity2.class);

        switch(operator) {
            case "+": {
                Double result = num1 + num2;
                intent.putExtra("key1",result);
                startActivity(intent);
                break;
            }

            case "-": {
                Double result = num1 - num2;
                intent.putExtra("key1",result);
                startActivity(intent);
                break;
            }

            case "X": {
                Double result = num1 * num2;
                intent.putExtra("key1",result);
                startActivity(intent);
                break;
            }

            case "/": {
                if(secondNumber.equals("0")) {
                    screenText.setText("Can't divide by zero!");
                } else {
                    Double result = num1 / num2;
                    intent.putExtra("key1",result);
                    startActivity(intent);
                }
                break;
            }
        }
    }
}