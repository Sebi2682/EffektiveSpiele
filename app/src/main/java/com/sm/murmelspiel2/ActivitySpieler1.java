package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
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
    private TextView txtView1;
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

        txtView1 = findViewById(R.id.txtView1);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("namenspeicher", Context.MODE_PRIVATE);
        String name1 = sp.getString("keyname", "");

        txtView1.setText(name1);


        //inputName1 = findViewById(R.id.inputName1);
       // inputName2 = findViewById(R.id.inputName2);

       // String name1 = getIntent().getStringExtra("keyname");
        //String name2 = getIntent().getStringExtra("keyname2");

       // inputName1.setText(name1);
        //inputName2.setText(name2);

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
