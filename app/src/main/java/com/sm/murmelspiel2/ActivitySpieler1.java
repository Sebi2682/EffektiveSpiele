package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class ActivitySpieler1 extends AppCompatActivity implements View.OnClickListener{

    private TextView tvPoints;
    private TextView textAnzahl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spieler1);

        tvPoints = findViewById(R.id.tvPoints);
        textAnzahl = findViewById(R.id.textAnzahl);
        Button buttonOk = findViewById(R.id.buttonOk);
        textAnzahl.setText(Integer.toString(MyApplication.anzahl1));


        buttonOk.setOnClickListener(v -> openActivityRaten());
    }

    public void openActivityRaten() {
        if(MyApplication.points1 != 0) {
            Intent intent = new Intent(this, ActivityRaten.class);
            startActivity(intent);
        }
    }

    public void onBackPressed(){ }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.imageMurmelSetzen1) {
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

        if(MyApplication.anzahl1 >=0)
            {
            tvPoints.setText(Integer.toString(MyApplication.points1));
            textAnzahl.setText(Integer.toString(MyApplication.anzahl1));
                MyApplication.points1++;
                MyApplication.anzahl1--;
        }
    }
}
