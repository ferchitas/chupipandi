package com.example.ferch.chupipadiparty;

import android.app.ActionBar;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class j_fantasma_opera extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.j_fantasma_opera);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        final Button btp11 = (Button) findViewById(R.id.p11);
        final Button btp12 = (Button) findViewById(R.id.p12);
        final Button btp13 = (Button) findViewById(R.id.p13);
        final Button btp21 = (Button) findViewById(R.id.p21);
        final Button btp22 = (Button) findViewById(R.id.p22);
        final Button btp23 = (Button) findViewById(R.id.p23);
        final Button btp31 = (Button) findViewById(R.id.p31);
        final Button btp32 = (Button) findViewById(R.id.p32);
        final Button btp33 = (Button) findViewById(R.id.p33);


        btp11.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btp11.setBackgroundDrawable(getResources().getDrawable(R.drawable.cantando));
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    btp11.setBackgroundDrawable(getResources().getDrawable(R.drawable.puerta));
                }
                return false;
            }
        });

        btp12.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    btp12.setBackgroundDrawable(getResources().getDrawable(R.drawable.cantando));
                }
                else if (event.getAction() == MotionEvent.ACTION_UP){
                    btp12.setBackgroundDrawable(getResources().getDrawable(R.drawable.puerta));
                }
                return false;
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
        if(!previouslyStarted) {
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(getString(R.string.pref_previously_started), Boolean.TRUE);
            edit.commit();
            showHelp();
        }
    }

    private void showHelp() {
        
    }
}
