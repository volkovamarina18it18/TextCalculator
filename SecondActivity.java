package ru.tns.testcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 *  Класс создания нового активити с результатами операции
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // заявление макета
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);

        // задание текстового элемента
        TextView textView = new TextView(this);
        textView.setTextSize(50);
        textView.setGravity(Gravity.CENTER);

        //добаваляем в activity_main макет и в макет вставляем текст
        setContentView(linearLayout);
        linearLayout.addView(textView);

        //извлекааем данные при помощь getIntent() и присваиваем данные из прошлого активити
        Intent intent = getIntent();
        String firstText = intent.getStringExtra("firstText");
        String secondtext = intent.getStringExtra("secondText");

        // Выводим результаты операций
        String result = intent.getStringExtra("result");
        String finalText = firstText + " + " + secondtext + " = " + result;
        textView.setText(finalText);
    }
}
