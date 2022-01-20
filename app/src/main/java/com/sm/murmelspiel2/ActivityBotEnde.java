package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class ActivityBotEnde extends AppCompatActivity {

    private TextView textGewonnen;
    private TextView textVerloren;
    private Button buttonOkEnde;
    LottieAnimationView sadFace,winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot_ende);
        buttonOkEnde = findViewById(R.id.buttonOkEnde);
        textGewonnen = findViewById(R.id.textGewonnen);
        textVerloren = findViewById(R.id.textVerloren);
        sadFace = findViewById(R.id.sadFace);
        winner = findViewById(R.id.winner);

        werGewinnt();

        buttonOkEnde.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMainActivity();
            }
        });

    }
    public void onBackPressed(){}

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
    public void werGewinnt(){
        if(MyApplication.anzahl1 <= 0) {
            textVerloren.setVisibility(View.VISIBLE);
            sadFace.setVisibility(View.VISIBLE);
            sadFace.playAnimation();

        }else{
            textGewonnen.setVisibility(View.VISIBLE);
            winner.setVisibility(View.VISIBLE);
            winner.playAnimation();
        }
        MyApplication.anzahl1 = 10;
        MyApplication.anzahl2 = 10;

    }
}