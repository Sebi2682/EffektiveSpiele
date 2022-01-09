package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityEnde extends AppCompatActivity {

    private TextView textSpieler1Gewinnt;
    private TextView textSpieler2Gewinnt;
    MyApplication application = (MyApplication) getApplication();
    int points1 = application.points1;
    int points2 = application.points2;
    int anzahl1 = application.anzahl1;
    int anzahl2 = application.anzahl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ende);
        textSpieler1Gewinnt.setVisibility(View.GONE);
        textSpieler2Gewinnt.setVisibility(View.GONE);
        WerGewinnt();
        openMainActivity();


    }

    public void WerGewinnt(){
        if(points1 <= 0){
            textSpieler2Gewinnt.setVisibility(View.VISIBLE);
        }else{
            textSpieler1Gewinnt.setVisibility(View.VISIBLE);
        }

    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}