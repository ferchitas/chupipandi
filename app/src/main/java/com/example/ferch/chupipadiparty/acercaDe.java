package com.example.ferch.chupipadiparty;

import android.content.SharedPreferences;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class acercaDe extends AppCompatActivity {

    TextToSpeech textToSpeech;
    int result;
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
        setContentView(R.layout.activity_acerca_de);

        final TextView tvAcercaD = (TextView) findViewById(R.id.tvacercaDtocho);

        tvAcercaD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences = getSharedPreferences("VALUES",MODE_PRIVATE);
                int tts = sharedPreferences.getInt("TTS",2);

                if (tts == 2){

                    textToSpeech = new TextToSpeech(acercaDe.this, new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status){

                            if (status == TextToSpeech.SUCCESS){

                                result = textToSpeech.setLanguage(Locale.getDefault());
                                if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA ){

                                    Toast.makeText(getApplicationContext(), "Feature not supported in your device 1", Toast.LENGTH_SHORT).show();
                                }
                                else{

                                    textToSpeech.speak(tvAcercaD.getText().toString() , TextToSpeech.QUEUE_FLUSH , null);
                                }
                            }
                            else{

                                Toast.makeText(getApplicationContext(),"Feature not supported in your device",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(),"Opcion de lectura de textos no activadas" +
                            ".",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        int tts = sharedPreferences.getInt("TTS",2);

        if (tts == 2){
            textToSpeech.stop();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        int tts = sharedPreferences.getInt("TTS",2);

        if (tts == 2){
            textToSpeech.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        int tts = sharedPreferences.getInt("TTS",2);

        if (tts == 2){
            textToSpeech.stop();
        }
    }
}
