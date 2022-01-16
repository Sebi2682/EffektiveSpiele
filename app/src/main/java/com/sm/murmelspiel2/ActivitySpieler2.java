package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class ActivitySpieler2 extends AppCompatActivity implements View.OnClickListener{

    private TextView tvPoints;
    private TextView textAnzahl;
    MyApplication application = (MyApplication) this.getApplication();
    int points2 = application.points2;
    int anzahl2 = application.anzahl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spieler2);

        tvPoints = findViewById(R.id.tvPoints);
        textAnzahl = findViewById(R.id.textAnzahl);
        Button buttonOk = findViewById(R.id.buttonOk);
        buttonOk.setOnClickListener(v -> openActivityRaten2());
        textAnzahl.setText(Integer.toString(anzahl2));
    }

    public void openActivityRaten2() {
        if(points2 == 0){
        }else {
            Intent intent = new Intent(this, ActivityRaten2.class);
            startActivity(intent);
        }
    }

    public void onBackPressed(){ }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.imageMurmelSetzen2) {
            Animation a = AnimationUtils.loadAnimation(this,R.anim.murmel_animation);
            a.setAnimationListener(new SimpleAnimationListener(){
                @Override
                public void onAnimationEnd(Animation animation) {
                    murmelClick();
                }
            });
            v.startAnimation(a);
        }
    }

    private void murmelClick() {
        points2++;
        anzahl2--;
        if (anzahl2 > 0) {
            tvPoints.setText(Integer.toString(points2));
            textAnzahl.setText(Integer.toString(anzahl2));
        }
        application.points2= points2;
        application.anzahl2 = anzahl2;
    }
}