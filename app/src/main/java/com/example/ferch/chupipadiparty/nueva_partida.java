package com.example.ferch.chupipadiparty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class nueva_partida extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nueva_partida);

        final Button btOersonalizado = (Button) findViewById(R.id.btPersonalizado);
        final Button btSimon = (Button) findViewById(R.id.btSimon);

        btOersonalizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), personalizado.class);
                startActivity(intent);
            }
        });

        btSimon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), simon_says.class);
                startActivity(intent);
            }
        });

    }

}
