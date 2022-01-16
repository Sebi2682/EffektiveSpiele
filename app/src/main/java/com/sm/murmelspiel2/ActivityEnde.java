package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityEnde extends AppCompatActivity {

    private final TextView textSpieler1Gewinnt;
    private final TextView textSpieler2Gewinnt;
    MyApplication application;

    {
        application = (MyApplication) getApplication();
    }

    public ActivityEnde(TextView textSpieler1Gewinnt, TextView textSpieler2Gewinnt) {
        this.textSpieler1Gewinnt = textSpieler1Gewinnt;
        this.textSpieler2Gewinnt = textSpieler2Gewinnt;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ende);
        Button buttonOK = findViewById(R.id.buttonOK);

        WerGewinnt();

        buttonOK.setOnClickListener(v -> openMainActivity());

    }

    public void WerGewinnt() {
        if (MyApplication.anzahl1 <= 0) {
            textSpieler2Gewinnt.setVisibility(View.VISIBLE);
            MyApplication.anzahl1 = 10;
            MyApplication.anzahl2 = 10;

        }
        if (MyApplication.anzahl2 <= 0) {
                textSpieler1Gewinnt.setVisibility(View.VISIBLE);
                MyApplication.anzahl1 = 10;
                MyApplication.anzahl2 = 10;

        }
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}