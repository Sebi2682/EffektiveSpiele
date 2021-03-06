package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.lang.Math;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ActivityBot extends AppCompatActivity {

    private Button buttonGerade;
    private Button buttonUngerade;
    private int min = 1;
    private int max = MyApplication.anzahl2;
    private int spielerMax = MyApplication.anzahl1;
    private int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);

        buttonGerade = findViewById(R.id.buttonGeradeBot);
        buttonUngerade = findViewById(R.id.buttonUngeradeBot);

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
        if(max<=spielerMax) {
            x = (int) (Math.random() * ((max - min) + 1)) + min;
        }else{
            x = (int) (Math.random() * ((spielerMax- min)+1)) +min;
        }
    }

    public void GewinnerGerade() {
        if ((x % 2) == 0) {
            Spieler1gewinnt();
        } else {
            BotGewinnt();
        }
    }

    public void GewinnerUngerade() {
        if ((x % 2) == 0) {
            BotGewinnt();
        } else {
            Spieler1gewinnt();
        }
    }


    private void BotGewinnt() {
        buttonGerade.setVisibility(View.GONE);
        buttonUngerade.setVisibility(View.GONE);
        MyApplication.anzahl2 = MyApplication.anzahl2 + x;
        MyApplication.anzahl1 = MyApplication.anzahl1 - x;

        Toast.makeText(ActivityBot.this,
                " Du hast verloren. Der Bot hat "

                +x+

                " Murmel(n) gesetzt",
                Toast.LENGTH_LONG).show();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void Spieler1gewinnt() {
        buttonGerade.setVisibility(View.GONE);
        buttonUngerade.setVisibility(View.GONE);

        MyApplication.anzahl1 = MyApplication.anzahl1 + x;
        MyApplication.anzahl2 = MyApplication.anzahl2 -x;

        Toast.makeText(ActivityBot.this,
                "Du hast gewonnen! Der Bot hat "

                +x+

                " Murmel(n) gesetzt",
                Toast.LENGTH_LONG).show();
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

        Intent intent2 = new Intent( this, ActivityBotEnde.class);
        startActivity(intent2);
    }

}