package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.lang.Math;

import java.util.concurrent.TimeUnit;

public class ActivityBot extends AppCompatActivity {

    private Button buttonGerade;
    private Button buttonUngerade;
    private int min = 1;
    private int max = MyApplication.anzahl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);

        buttonGerade = findViewById(R.id.buttonGerade);
        buttonUngerade = findViewById(R.id.buttonUngerade);

        randomNumber();

        buttonGerade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GewinnerGerade();
                openNextActivity();
            }
        });

        buttonUngerade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GewinnerUngerade();
                openNextActivity();
            }
        });
    }
    public void onBackPressed(){}

    private void randomNumber() {
        int x = (int)(Math.random() * ((max - min) + 1)) + min;
        MyApplication.points2 = x;
    }

    public void GewinnerGerade() {
        if ((MyApplication.points2 % 2) == 0) {
            Spieler1gewinnt();
        } else {
            BotGewinnt();
        }
    }

    public void GewinnerUngerade() {
        if ((MyApplication.points2 % 2) == 0) {
            BotGewinnt();
        } else {
            Spieler1gewinnt();
        }
    }

    private void BotGewinnt() {
        buttonGerade.setVisibility(View.GONE);
        buttonUngerade.setVisibility(View.GONE);
        MyApplication.anzahl2 = MyApplication.anzahl2 + MyApplication.points2 * 2;
        MyApplication.anzahl1 = MyApplication.anzahl1 - MyApplication.points2;
        MyApplication.points2 = 0;

        Toast.makeText(ActivityBot.this, " Du hast verloren", Toast.LENGTH_LONG).show();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void Spieler1gewinnt() {
        buttonGerade.setVisibility(View.GONE);
        buttonUngerade.setVisibility(View.GONE);

        MyApplication.anzahl1 = MyApplication.anzahl1 + MyApplication.points2;
        MyApplication.points2 = 0;

        Toast.makeText(ActivityBot.this, "Du hast gewonnen!", Toast.LENGTH_LONG).show();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openNextActivity() {
        if (MyApplication.anzahl2 > 0 && MyApplication.anzahl1 > 0) {
            openActivityBotSetzen();
        } else {
            openActivityBotEnde();
        }
    }

    public void openActivityBotSetzen(){

        Intent intent = new Intent(this, ActivityBotSetzen.class);
        startActivity(intent);
    }

    public void openActivityBotEnde(){

        Intent intent = new Intent( this, ActivityBotEnde.class);
        startActivity(intent);
    }

}