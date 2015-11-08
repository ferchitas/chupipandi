package com.example.ferch.chupipadiparty;

import android.content.Intent;
import android.content.SharedPreferences;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class activarTTS extends AppCompatActivity {

    TextToSpeech textToSpeech;
    int result;
    TextView tvMen;

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
        setContentView(R.layout.activar_tts);

        sharedPreferences = getSharedPreferences("VALUES",MODE_PRIVATE);


        tvMen = (TextView) findViewById(R.id.tvMensaje);

        textToSpeech = new TextToSpeech(activarTTS.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status){

                if (status == TextToSpeech.SUCCESS){

                    result = textToSpeech.setLanguage(Locale.getDefault());
                    if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA ){

                        Toast.makeText(getApplicationContext(),"Feature not supported in your device 1",Toast.LENGTH_SHORT).show();
                    }
                    else{

                        textToSpeech.speak(tvMen.getText().toString() , TextToSpeech.QUEUE_FLUSH , null);
                    }
                }
                else{

                    Toast.makeText(getApplicationContext(),"Feature not supported in your device",Toast.LENGTH_SHORT).show();
                }
            }
        });


        final Button btsi = (Button) findViewById(R.id.btsi);
        final Button btno = (Button) findViewById(R.id.btno);
        final TextView tvmensaje = (TextView) findViewById(R.id.tvMensaje);

        tvmensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textToSpeech = new TextToSpeech(activarTTS.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status){

                        if (status == TextToSpeech.SUCCESS){

                            result = textToSpeech.setLanguage(Locale.getDefault());
                            if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA ){

                                Toast.makeText(getApplicationContext(),"Feature not supported in your device 1",Toast.LENGTH_SHORT).show();
                            }
                            else{

                                textToSpeech.speak(tvMen.getText().toString() , TextToSpeech.QUEUE_FLUSH , null);
                            }
                        }
                        else{

                            Toast.makeText(getApplicationContext(),"Feature not supported in your device",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences.edit().putInt("TTS",1).apply();
                Intent intent1 = new Intent(activarTTS.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        btsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences.edit().putInt("TTS",2).apply();
                Intent intent1 = new Intent(activarTTS.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        textToSpeech.stop();
    }

    @Override
    protected void onStop() {
        super.onStop();

        textToSpeech.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        textToSpeech.stop();

    }
}