package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;


public class ActivityRaten extends AppCompatActivity {

    private Button buttonGerade;
    private Button buttonUngerade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raten);

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
////
    }
    public void onBackPressed(){ }

    public void GewinnerGerade() throws InterruptedException {
        if (0 == (MyApplication.points1 % 2)) {
            Spieler2gewinnt();
        } else {
            Spieler1gewinnt();
        }
    }
    public void GewinnerUngerade() throws InterruptedException {
        if(0 == (MyApplication.points1 % 2)){
            Spieler1gewinnt();
        }else{
            Spieler2gewinnt();
        }
    }
    public void Spieler1gewinnt() throws InterruptedException {
        buttonGerade.setVisibility(View.GONE);
        buttonUngerade.setVisibility(View.GONE);

        MyApplication.anzahl1= MyApplication.anzahl1+MyApplication.points1*2;
        MyApplication.anzahl2= MyApplication.anzahl2-MyApplication.points1;
        MyApplication.points1 = 0;

        Toast.makeText(ActivityRaten.this,"Spieler 1 gewinnt!", Toast.LENGTH_LONG).show();
        TimeUnit.SECONDS.sleep(1);


    }
    public void Spieler2gewinnt() throws InterruptedException {
        buttonGerade.setVisibility(View.GONE);
        buttonUngerade.setVisibility(View.GONE);
        MyApplication.anzahl2= MyApplication.anzahl2+MyApplication.points1;
        MyApplication.points1 = 0;

        Toast.makeText(ActivityRaten.this, "Spieler 2 gewinnt!", Toast.LENGTH_LONG).show();
        TimeUnit.SECONDS.sleep(1);
    }

    public void openNextActivity() {
         if (MyApplication.anzahl2 > 0 && MyApplication.anzahl1 > 0) {
            openActivitySpieler2();
        } else {
            openActivityEnde();
        }
    }

    public void openActivitySpieler2(){

        Intent intent = new Intent(this, ActivitySpieler2.class);
        startActivity(intent);
    }
    public void openActivityEnde(){

        Intent intent = new Intent( this, ActivityEnde.class);
        startActivity(intent);
    }

}







