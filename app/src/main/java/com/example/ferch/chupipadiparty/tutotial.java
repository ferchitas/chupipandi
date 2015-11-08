package com.example.ferch.chupipadiparty;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class tutotial extends AppCompatActivity {

    int position;

    Button tb1;
    Button tb2,tb3;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPreferences = getSharedPreferences("VALUES",MODE_PRIVATE);
        int theme = sharedPreferences.getInt("THEME",2);

        switch (theme){
            case 1: setTheme(R.style.AppThemeAM);
                break;
            case 2: setTheme(R.style.AppTheme);
                break;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutotial);

        tb1 =(Button) findViewById(R.id.button2);

        tb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences.edit().putInt("THEME",1).apply();
                Intent intent = new Intent(tutotial.this, tutotial.class);
                startActivity(intent);
                Intent intent1 = new Intent(tutotial.this, activarTTS.class);
                startActivity(intent1);
            }
        });

        tb2 =(Button) findViewById(R.id.button3);

        tb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().putInt("THEME",2).apply();
                Intent intent = new Intent(tutotial.this, tutotial.class);
                startActivity(intent);
                Intent intent1 = new Intent(tutotial.this, activarTTS.class);
                startActivity(intent1);

            }
        });


    }
}
