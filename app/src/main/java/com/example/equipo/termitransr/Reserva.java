package com.example.equipo.termitransr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Reserva extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Random myRandom = new Random(6);

        Button OpcionReserve = (Button) findViewById(R.id.Generar_codigo);
        final TextView GenerateNumber = (TextView)findViewById(R.id.codigo);
        OpcionReserve.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GenerateNumber.setText(String.valueOf(myRandom.nextInt()));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


}
