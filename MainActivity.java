package ru.tns.testcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;


/**
 * Программа реализует сложение двух элементов
 */
public class MainActivity extends AppCompatActivity {

    EditText enterText1;
    EditText enterText2;
    String firstText;
    String secondText;
    String result;
    Boolean correct = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterText1 = findViewById(R.id.enter_text_1);
        enterText2 = findViewById(R.id.enter_text_2);
    }

    public void onSendClick(View view) {
        correct = true;
        firstText = enterText1.getText().toString();
        secondText = enterText2.getText().toString();
        if (!(secondText.matches("[+-]?[0-9]+"))) {
            enterText2.setError("введите корректное число");
            correct = false;
        }
        if (!(firstText.matches("[+-]?[0-9]+"))) {
            enterText1.setError("введите корректное число");
            correct = false;
        }

        if (correct) {
            result = Integer.toString(Integer.parseInt(firstText) + Integer.parseInt(secondText));
            Intent intent = new Intent(this, SecondActivity.class);//передаем в активити куда нам нужно
            if (Integer.parseInt(secondText) < 0) {
                secondText = "(" + secondText + ")";
            }
            //сохраняем данные по ключам
            intent.putExtra("firstText", firstText);
            intent.putExtra("secondText", secondText);
            intent.putExtra("result", result);
            startActivity(intent);
        }
    }
}
