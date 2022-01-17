package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityBot extends AppCompatActivity {

    private Button buttonGerade;
    private Button buttonUngerade;
    private int Min = 1;
    private int Max = MyApplication.anzahl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);

        buttonGerade = findViewById(R.id.buttonGerade);
        buttonUngerade = findViewById(R.id.buttonUngerade);
        int x = Min + (int)(Math.random() * ((Max - Min) + 1));
        MyApplication.points2 = x;

        buttonGerade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityBotSetzen();
            }
        });

        buttonUngerade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityBotSetzen();
            }
        });





    }

    public void openActivityBotSetzen() {

        Intent intent = new Intent(this, ActivityBotSetzen.class);
        startActivity(intent);

    }
}