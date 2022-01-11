package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class ActivityRaten2 extends AppCompatActivity {


    private Button buttonGerade;
    private Button buttonUngerade;
    MyApplication application = (MyApplication) getApplication();
    int points1 = application.points1;
    int points2 = application.points2;
    int anzahl1 = application.anzahl1;
    int anzahl2 = application.anzahl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raten2);

        buttonGerade = findViewById(R.id.buttonGerade);
        buttonUngerade = findViewById(R.id.buttonUngerade);


        buttonGerade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    GewinnerGerade();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                openNextActivity();
            }
        });
        buttonUngerade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    GewinnerUngerade();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                openNextActivity();
            }
        });

    }
    public void onBackPressed(){ }

    public void GewinnerGerade() throws InterruptedException {
        if((points2 % 2) == 0){
            Spieler1gewinnt();
        }else{
            Spieler2gewinnt();
        }
    }
    public void GewinnerUngerade() throws InterruptedException {
        if((points2 % 2) == 0){
            Spieler2gewinnt();
        }else{
            Spieler1gewinnt();
        }
    }
    public void Spieler1gewinnt() throws InterruptedException {
        buttonGerade.setVisibility(View.GONE);
        buttonUngerade.setVisibility(View.GONE);

        application.anzahl1= anzahl1+points2;
        application.points2 = 0;

        Toast.makeText(ActivityRaten2.this, "Spieler 1 gewinnt!", Toast.LENGTH_LONG).show();
        TimeUnit.SECONDS.sleep(1);

    }
    public void Spieler2gewinnt() throws InterruptedException {
        buttonGerade.setVisibility(View.GONE);
        buttonUngerade.setVisibility(View.GONE);
        application.anzahl2= anzahl2+points2*2;
        application.anzahl1= anzahl1-points2;
        application.points2 = 0;

        Toast.makeText(ActivityRaten2.this, "Spieler 2 gewinnt!", Toast.LENGTH_LONG).show();
        TimeUnit.SECONDS.sleep(1);
    }

    public void openNextActivity(){
        if(application.anzahl2 <= 0 || application.anzahl1 <= 0){
            openActivityEnde();
        }else{
            openActivitySpieler1();
        }
    }

    public void openActivitySpieler1(){
        Intent intent = new Intent(this, ActivitySpieler1.class);
        startActivity(intent);
    }

    public void openActivityEnde(){

        Intent intent = new Intent( this, ActivityEnde.class);
        startActivity(intent);
    }
}
