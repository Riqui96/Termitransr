package com.example.equipo.termitransr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.equipo.termitransr.databinding.ActivityPopayanBinding;
import com.example.equipo.termitransr.models.Destino;
import com.example.equipo.termitransr.util.C;

public class Popayan extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popayan);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActivityPopayanBinding binding = ActivityPopayanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        Destino destino = new Destino();
        destino.setNombre("POPAYAN");
        destino.setDescripcion("Municipio colombiano, capital del departamento del Cauca. Se encuentra localizado en el valle de Pubenza, entre la Cordillera Occidental y Central al suroccidente del país. ");
        destino.setImg("http://cache-graphicslib.viator.com/graphicslib/thumbs674x446/22244/SITours/day-trip-popay-n-history-and-culture-from-cali-in-cali-264250.jpg");


        binding.setDestino(destino);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,Empresas.class);
        startActivity(intent);

    }
}
