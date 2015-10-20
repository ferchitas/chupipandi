package com.example.ferch.chupipadiparty;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        final Button btNuevaPartida = (Button) findViewById(R.id.nuevaPartida);
        final Button btAjustes =  (Button) findViewById(R.id.ajustes);


        btNuevaPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), nueva_partida.class);
                    startActivity(intent);
            }
        });

        btAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Music.stop(btAjustes.getContext());

            }
        });


        final Button button = (Button) findViewById(R.id.entrenamiento);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getBaseContext(),"holiii!", Toast.LENGTH_LONG).show();
                //Music.play(btAjustes.getContext(),R.raw.theverve);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        //Music.play(this,R.raw.theverve);
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
}
