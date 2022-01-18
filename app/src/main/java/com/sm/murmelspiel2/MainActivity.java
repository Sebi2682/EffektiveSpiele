package com.sm.murmelspiel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button buttonRegeln;
    private Button buttonSpielen;
    private Button buttonBot;
    private Button buttonLokal;
    private Button buttonOKname;

    EditText inputName1;
    EditText inputName2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        setContentView(R.layout.activity_main);

        buttonRegeln = findViewById(R.id.buttonRegeln);
        buttonSpielen = findViewById(R.id.buttonSpielen);
        buttonBot = findViewById(R.id.buttonBot);
        buttonLokal = findViewById(R.id.buttonLokal);
        buttonOKname = findViewById(R.id.buttonOKname);

        buttonRegeln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityRegeln();
            }
        });
        buttonSpielen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcherModus();
            }
        });
        buttonBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityBot();
            }
        });
        buttonLokal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                inputName();
            }
            }
        );

        buttonOKname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySpielen();
            }
        });

        inputName1 = (EditText) findViewById(R.id.inputName1);
        inputName2 = (EditText) findViewById(R.id.inputName2);

    }
    public void onBackPressed(){ }

    public void welcherModus(){
        buttonSpielen.setVisibility(View.INVISIBLE);
        buttonRegeln.setVisibility(View.INVISIBLE);
        buttonLokal.setVisibility(View.VISIBLE);
        buttonBot.setVisibility(View.VISIBLE);
    }

    public void inputName() {

        inputName1.setVisibility(View.VISIBLE);
        inputName2.setVisibility(View.VISIBLE);
        buttonLokal.setVisibility(View.INVISIBLE);
        buttonBot.setVisibility(View.INVISIBLE);
        buttonOKname.setVisibility(View.VISIBLE);
    }

    public void openActivityRegeln() {
        Intent intent = new Intent(this, ActivityRegeln.class);
        startActivity(intent);
    }

    public void openActivitySpielen() {
        Intent intent = new Intent(this, ActivitySpieler1.class);
        startActivity(intent);
    }

    public void openActivityBot()  {
        Intent intent2 = new Intent(this, ActivityBot.class);
        startActivity(intent2);
    }
}
