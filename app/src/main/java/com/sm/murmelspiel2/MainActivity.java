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

public class MainActivity extends AppCompatActivity {
    private Button buttonRegeln;
    private Button buttonSpielen;
    private Button buttonBot;
    private Button buttonLokal;
    private Button ButtonOKname;

     EditText inputName1;
     TextView inputName11;

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
        ButtonOKname = findViewById(R.id.buttonOKname);


        inputName1 = (EditText) findViewById(R.id.inputName1);
        inputName11 = (TextView) findViewById(R.id.inputName11);

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
            public void onClick(View v){ NamenSetzen();

            }
                                       }
        );

        ButtonOKname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText();
                openActivitySpielen();
            }
        });



    }
    public void onBackPressed(){ }

    public void updateText() {
        inputName11.setText(inputName1.getText());
    }

    public void welcherModus(){
        buttonSpielen.setVisibility(View.INVISIBLE);
        buttonRegeln.setVisibility(View.INVISIBLE);
        buttonLokal.setVisibility(View.VISIBLE);
        buttonBot.setVisibility(View.VISIBLE);
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

    public void NamenSetzen() {
        ButtonOKname.setVisibility(View.VISIBLE);
        buttonSpielen.setVisibility(View.INVISIBLE);
        buttonRegeln.setVisibility(View.INVISIBLE);
        inputName1.setVisibility(View.VISIBLE);
    }

}
