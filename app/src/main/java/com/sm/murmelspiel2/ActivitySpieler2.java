package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class ActivitySpieler2 extends AppCompatActivity{

    private TextView tvPoints;
    private TextView textAnzahl;
    private Button buttonOk;
    private Button buttonKleiner2;
    private Button buttonGroesser2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spieler2);

        tvPoints = findViewById(R.id.tvPoints);
        textAnzahl = findViewById(R.id.textAnzahl);
        buttonOk = findViewById(R.id.buttonOk);
        buttonOk.setOnClickListener(v -> openActivityRaten2());
        textAnzahl.setText(Integer.toString(MyApplication.anzahl2));
        buttonKleiner2 = findViewById(R.id.buttonKleiner2);
        buttonGroesser2 = findViewById(R.id.buttonGroesser2);

        buttonKleiner2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kleiner();
                murmelkleiner();
            }
        });

        buttonGroesser2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groesser();
                murmelGroesser();
            }
        });
    }

    public void openActivityRaten2() {
        if(MyApplication.points2 == 0){
        }else {
            Intent intent = new Intent(this, ActivityRaten2.class);
            startActivity(intent);
        }
    }

    public void onBackPressed(){ }

    public void kleiner(){
        Animation a = AnimationUtils.loadAnimation(this,R.anim.murmel_animation);
        buttonKleiner2.startAnimation(a);
    }

    public void groesser(){
        Animation a = AnimationUtils.loadAnimation(this,R.anim.murmel_animation);
        buttonGroesser2.startAnimation(a);
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