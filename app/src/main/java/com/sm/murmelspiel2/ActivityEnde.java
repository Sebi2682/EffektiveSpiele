package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
        textSpieler1Gewinnt = findViewById(R.id.textSpieler1Gewinnt);
        textSpieler2Gewinnt = findViewById(R.id.textSpieler2Gewinnt);

        werGewinnt();

        SharedPreferences sp = getApplicationContext().getSharedPreferences("namenspeicher", Context.MODE_PRIVATE);
        String name1 = sp.getString("keyname", "");
        String name2 = sp.getString("keyname2", "");


        textSpieler1Gewinnt.setText(name2 + " ist König/in der Murmeln!");
        textSpieler2Gewinnt.setText(name1 + " ist König/in der Murmeln!");

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

    }
    public void onBackPressed(){ }

    public void werGewinnt() {
        if(MyApplication.anzahl1 <= 0) {
            textSpieler2Gewinnt.setVisibility(View.VISIBLE);
        }else{
                textSpieler1Gewinnt.setVisibility(View.VISIBLE);
        }
        MyApplication.anzahl1 = 10;
        MyApplication.anzahl2 = 10;
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}