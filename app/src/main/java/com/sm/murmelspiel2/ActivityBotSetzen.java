package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityBotSetzen extends AppCompatActivity {

    private TextView TVpoints;
    private TextView TVanzahl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot_setzen);
        TVpoints = findViewById(R.id.TVPoints);
        Button buttonOK = findViewById(R.id.buttonOK);

    }
}