package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private Button buttonRegeln;
    private Button buttonSpielen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        setContentView(R.layout.activity_main);

        buttonRegeln = findViewById(R.id.buttonRegeln);
        buttonSpielen = findViewById(R.id.buttonSpielen);

        buttonRegeln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityRegeln();
            }
        });
        buttonSpielen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySpielen();
            }
        });

    }
    public void onBackPressed(){ }

    public void openActivityRegeln() {
        Intent intent = new Intent(this, ActivityRegeln.class);
        startActivity(intent);
    }
    public void openActivitySpielen(){
        Intent intent = new Intent(this, ActivitySpieler1.class);
        startActivity(intent);
    }
}