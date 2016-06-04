package com.example.equipo.termitransr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.equipo.termitransr.databinding.ActivityEmpresasBinding;
import com.example.equipo.termitransr.databinding.ActivityPopayanBinding;
import com.example.equipo.termitransr.models.Destino;

public class Empresas extends AppCompatActivity {

    ListView list;
    String[] empresas = {"Velotax","TransBelalcazar","Bolivariano"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresas);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActivityEmpresasBinding binding = ActivityEmpresasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        list = (ListView) findViewById(R.id.list);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,empresas);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView adapterView, View view, int posicion, long l) {
                //Toast.makeText(getApplicationContext(), "posicion " + (i + 1) + personas[i], Toast.LENGTH_SHORT).show();
                switch (posicion) {
                    case 0 :
                        Intent intent = new Intent(getApplicationContext(), Formulario.class);
                        startActivity(intent);
                        break;

                    case 1 :
                        intent = new Intent(getApplicationContext(), Formulario.class);
                        startActivity(intent);
                        break;

                    case 2 :
                        intent = new Intent(getApplicationContext(), Formulario.class);
                        startActivity(intent);
                        break;

                }
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
