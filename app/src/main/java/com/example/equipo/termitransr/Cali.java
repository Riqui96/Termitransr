package com.example.equipo.termitransr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.equipo.termitransr.databinding.ActivityCaliBinding;
import com.example.equipo.termitransr.databinding.ActivityPopayanBinding;
import com.example.equipo.termitransr.models.Destino;

public class Cali extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cali);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    ActivityCaliBinding binding = ActivityCaliBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());



    Destino destino = new Destino();
    destino.setNombre("CALI");
    destino.setDescripcion("Es un municipio colombiano,capital del departamento del Valle del Cauca,es la tercera ciudad más poblada de Colombia. Está situada en la región Sur del Valle del Cauca, entre la cordillera occidental y la cordillera central de los Andes.");
    destino.setImg("http://www.elpais.com.co/elpais/sites/default/files/imagecache/x490/multimedia/fotos/2015/06/babativa2780.jpg");


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


