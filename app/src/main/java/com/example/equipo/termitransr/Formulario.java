package com.example.equipo.termitransr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.equipo.termitransr.databinding.ActivityEmpresasBinding;
import com.example.equipo.termitransr.databinding.ActivityFormularioBinding;

public class Formulario extends AppCompatActivity  {

    Spinner spiner;
    ArrayAdapter<CharSequence> adapter;
    EditText date,name,nit,mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActivityFormularioBinding binding = ActivityFormularioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //binding.reserve.setOnClickListener(this);

        date = (EditText) findViewById(R.id.date);
        name = (EditText) findViewById(R.id.name);
        nit = (EditText) findViewById(R.id.nit);
        mail = (EditText)findViewById(R.id.mail);

        spiner = (Spinner) findViewById(R.id.spiner);
        adapter = ArrayAdapter.createFromResource(this, R.array.horary, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner.setAdapter(adapter);
        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " Selecciono ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    public void pasoReserve (View v){

        String input = name.getText().toString();

        if (input.equals(""))
        {
            Toast.makeText(this,"Ingrese el Nombre",Toast.LENGTH_SHORT).show();
        }
        if (input.equals(""))
        {
            Toast.makeText(this,"Ingrese Su Identificacion",Toast.LENGTH_SHORT).show();
        }
        if (input.equals(""))
        {
            Toast.makeText(this, "Ingrese Email", Toast.LENGTH_SHORT).show();
        }

        if (input.equals(""))
        {
            Toast.makeText(this, "Ingrese Fecha De Reserva", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Intent intent = new Intent(this, Reserva.class);
            startActivity(intent);
        }
    }

}
