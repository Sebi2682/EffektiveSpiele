package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityEnde extends AppCompatActivity {

    private TextView textSpieler1Gewinnt;
    private TextView textSpieler2Gewinnt;
    private Button buttonOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ende);
        buttonOK = findViewById(R.id.buttonOK);

        WerGewinnt();

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

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