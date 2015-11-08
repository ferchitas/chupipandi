package com.example.ferch.chupipadiparty;

import android.app.ActionBar;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import android.content.SharedPreferences;

import com.example.ferch.chupipadiparty.tutotial.*;

import java.io.IOException;


public class MainActivity extends AppCompatActivity { //text to speech here: https://www.youtube.com/watch?v=sU38Yhux-3g


    SharedPreferences sharedPreferences;

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //esconder la barra de arriba
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //cambio de tema
        sharedPreferences = getSharedPreferences("VALUES",MODE_PRIVATE);
        int theme = sharedPreferences.getInt("THEME",2);

        switch (theme){
            case 1: setTheme(R.style.AppTheme);
                break;
            case 2: setTheme(R.style.AppTheme_AppBarOverlay);
                break;
        }

        //cosas de la musica de fondo
        mMediaPlayer = MediaPlayer.create(this, R.raw.polkainicialf);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.setVolume(100, 100);
        mMediaPlayer.start();

        setContentView(R.layout.main);

        //sonidos para los botones
        final MediaPlayer mp = new MediaPlayer();
        mp.setVolume(100, 100);


        //para hacer el tutorial ¡¡NO TOCAR NUNCA!!
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        //para ver si se ha ejecutado por primera vez o no y mostrar esta activity o mostrar la del tutorial
        if (isFirstRun) {
            //show start activity

            startActivity(new Intent(MainActivity.this, tutotial.class));
            Toast.makeText(MainActivity.this, "First Run", Toast.LENGTH_LONG)
                    .show();
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();



        final Button btNuevaPartida = (Button) findViewById(R.id.nuevaPartida);
        final Button btEntrenamiento = (Button) findViewById(R.id.entrenamiento);
        final Button btAjustes =  (Button) findViewById(R.id.ajustes);


        btNuevaPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp.isPlaying())
                {
                    mp.stop();
                }

                try {
                    mp.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("btsound.mp3");
                    mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                    mp.prepare();
                    mp.start();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    Intent intent = new Intent(v.getContext(), nueva_partida.class);
                    startActivity(intent);
            }
        });

        btEntrenamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp.isPlaying())
                {
                    mp.stop();
                }

                try {
                    mp.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("btsound.mp3");
                    mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                    mp.prepare();
                    mp.start();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(v.getContext(), entrenamiento.class);
                startActivity(intent);

            }
        });

        btAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp.isPlaying())
                {
                    mp.stop();
                }

                try {
                    mp.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("btsound.mp3");
                    mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                    mp.prepare();
                    mp.start();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(v.getContext(), Ajustes.class );
                startActivity(intent);

            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();

        /*
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
        if(!previouslyStarted) {
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(getString(R.string.pref_previously_started), Boolean.TRUE);
            edit.commit();
            //showHelp();
        }
        */
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Music.stop(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        //Music.stop(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mMediaPlayer.stop();
        mMediaPlayer.release();
    }
}
