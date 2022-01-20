package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;

public class ActivityBotSetzen extends AppCompatActivity {

    private TextView tvPoints;
    private TextView textAnzahl;
    private Button buttonOk;
    private Button buttonKleiner;
    private Button buttonGroesser;
    private int min = 1;
    private int max = 2;


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
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.click);

        buttonKleiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                kleiner();
                murmelkleiner();
            }
        });

        buttonGroesser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                groesser();
                murmelGroesser();
            }
        });

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geradeUngerade();
                openNextActivity();
            }
        });
    }
    public void onBackPressed(){}

    public void geradeUngerade(){
        int x = (int)(Math.random() * ((max - min) + 1)) + min;
        if(x == 1){
            Spieler1gewinnt();
        } else {
            BotGewinnt();
        }

    }

    private void BotGewinnt() {
        MyApplication.anzahl2 = MyApplication.anzahl2 + MyApplication.points2 * 2;
        MyApplication.anzahl1 = MyApplication.anzahl1 - MyApplication.points2;
        MyApplication.points2 = 0;

        Toast.makeText(ActivityBotSetzen.this, " Du hast verloren", Toast.LENGTH_LONG).show();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void Spieler1gewinnt() {
        MyApplication.anzahl1 = MyApplication.anzahl1 + MyApplication.points2;
        MyApplication.points2 = 0;

        Toast.makeText(ActivityBotSetzen.this, "Du hast gewonnen!", Toast.LENGTH_LONG).show();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openNextActivity() {
        if (MyApplication.anzahl2 > 0 && MyApplication.anzahl1 > 0) {
            openActivityBot();
        } else {
            openActivityBotEnde();
        }
    }

    public void openActivityBot(){
        Intent intent = new Intent(this, ActivityBot.class);
        startActivity(intent);
    }

    public void openActivityBotEnde(){
        Intent intent = new Intent( this, ActivityBotEnde.class);
        startActivity(intent);
    }

    public void kleiner(){
        Animation a = AnimationUtils.loadAnimation(this,R.anim.murmel_animation);
        buttonKleiner.startAnimation(a);
    }

    public void groesser(){
        Animation a = AnimationUtils.loadAnimation(this,R.anim.murmel_animation);
        buttonGroesser.startAnimation(a);
    }

    private void murmelkleiner() {

        if(MyApplication.points1 >0) {
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