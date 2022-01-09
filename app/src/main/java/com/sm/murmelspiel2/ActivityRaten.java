package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityRaten extends AppCompatActivity {

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
        setContentView(R.layout.activity_raten);

        buttonGerade = findViewById(R.id.buttonGerade);
        buttonUngerade = findViewById(R.id.buttonUngerade);


        buttonGerade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GewinnerGerade();
                openActivitySpieler2();
            }
        });
        buttonUngerade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GewinnerUngerade();
                openActivitySpieler2();
            }
        });

    }
    public void onBackPressed(){ }

    public void GewinnerGerade(){
        if(points1 % 2 == 0){
            Spieler2gewinnt();
        }else{
            Spieler1gewinnt();
        }
    }
    public void GewinnerUngerade(){
        if(points1 % 2 == 0){
            Spieler1gewinnt();
        }else{
            Spieler2gewinnt();
        }
    }
    public void Spieler1gewinnt(){
        buttonGerade.setVisibility(View.GONE);
        buttonUngerade.setVisibility(View.GONE);

        application.anzahl1= anzahl1+points1*2;
        application.anzahl2= anzahl2-points1;
        application.points1 = 0;

        Toast.makeText(ActivityRaten.this,"Spieler 1 gewinnt!", Toast.LENGTH_LONG).show();


    }
    public void Spieler2gewinnt(){
        buttonGerade.setVisibility(View.GONE);
        buttonUngerade.setVisibility(View.GONE);
        application.anzahl2= anzahl2+points1;
        application.points1 = 0;

        Toast.makeText(ActivityRaten.this, "Spieler 2 gewinnt!", Toast.LENGTH_LONG).show();

    }
    public void openActivitySpieler2(){

        Intent intent = new Intent(this, ActivitySpieler2.class);
        startActivity(intent);
    }
}







