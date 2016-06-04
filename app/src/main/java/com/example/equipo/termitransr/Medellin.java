package com.example.equipo.termitransr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.equipo.termitransr.databinding.ActivityCaliBinding;
import com.example.equipo.termitransr.models.Destino;

public class Medellin extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medellin);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActivityCaliBinding binding = ActivityCaliBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        Destino destino = new Destino();
        destino.setNombre("MEDELLIN");
        destino.setDescripcion("Municipio colombiano, capital del departamento de Antioquia, siendo la ciudad más poblada del departamento y la segunda del país.Se asienta en la parte más ancha de la región natural conocida como Valle de Aburrá, en la cordillera central de los Andes, constituyéndose como el mayor centro urbano de tal ramal andino.");
        destino.setImg("http://www.medellin.travel/sites/default/files/museo-antioquia-1_0.jpg");


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
