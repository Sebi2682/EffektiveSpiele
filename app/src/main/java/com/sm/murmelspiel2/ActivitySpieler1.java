package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class ActivitySpieler1 extends AppCompatActivity{

    private TextView tvPoints;
    private TextView textAnzahl;
    private Button buttonOk;
    private Button buttonKleiner;
    private Button buttonGroesser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spieler1);

        tvPoints = findViewById(R.id.tvPoints);
        textAnzahl = findViewById(R.id.textAnzahl);
        buttonOk = findViewById(R.id.buttonOk);
        textAnzahl.setText(Integer.toString(MyApplication.anzahl1));
        buttonKleiner = findViewById(R.id.buttonKleiner);
        buttonGroesser = findViewById(R.id.buttonGroesser);

        buttonKleiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kleiner();
                murmelkleiner();
            }
        });

        buttonGroesser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groesser();
                murmelGroesser();
            }
        });

        buttonOk.setOnClickListener(v -> openActivityRaten());
    }

    public void openActivityRaten() {
        if(MyApplication.points1 != 0) {
            Intent intent = new Intent(this, ActivityRaten.class);
            startActivity(intent);
        }
    }

    public void onBackPressed(){ }


    public void kleiner(){
        Animation a = AnimationUtils.loadAnimation(this,R.anim.murmel_animation);
        buttonKleiner.startAnimation(a);
    }

    public void groesser(){
        Animation a = AnimationUtils.loadAnimation(this,R.anim.murmel_animation);
        buttonGroesser.startAnimation(a);
    }

    private void murmelkleiner() {

        if(MyApplication.anzahl1 <10) {
                MyApplication.points1--;
                MyApplication.anzahl1++;
            tvPoints.setText(Integer.toString(MyApplication.points1));
            textAnzahl.setText(Integer.toString(MyApplication.anzahl1));

        }
    }

    private void murmelGroesser(){
        if(MyApplication.anzahl1 >0)
        {
            MyApplication.points1++;
            MyApplication.anzahl1--;
            tvPoints.setText(Integer.toString(MyApplication.points1));
            textAnzahl.setText(Integer.toString(MyApplication.anzahl1));

        }
    }
}
