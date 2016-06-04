package com.example.equipo.termitransr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.equipo.termitransr.adapters.DestinoAdapter;
import com.example.equipo.termitransr.databinding.ActivityMainBinding;
import com.example.equipo.termitransr.databinding.HeaderNavBinding;
import com.example.equipo.termitransr.models.Destino;
import com.example.equipo.termitransr.models.Usuario;
import com.example.equipo.termitransr.util.C;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, NavigationView.OnNavigationItemSelectedListener {

    DestinoAdapter adapter;

    ActivityMainBinding b;
    SharedPreferences preferences;
    ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        //Configuracion Header
        HeaderNavBinding header = HeaderNavBinding.inflate(getLayoutInflater());
        Usuario usuario = new Usuario();
        usuario.setNombre("Albert Einstein");
        usuario.setImagen("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Albert_Einstein_Head.jpg/260px-Albert_Einstein_Head.jpg");
        usuario.setImagenBanner("http://pbs.twimg.com/media/CcHWmnMWAAAontS.jpg");

        header.setUsuario(usuario);
        b.nav.addHeaderView(header.getRoot());

        //Configuracion Boton Hamburguesa
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this,b.drawer,R.string.open_nav,R.string.close_nav);
        b.drawer.addDrawerListener(this);
        b.nav.setNavigationItemSelectedListener(this);



        C.data = new ArrayList<>();
        adapter = new DestinoAdapter(getLayoutInflater(), C.data);
        b.setAdapter(adapter);

        //binding.list.setOnItemClickListener(this);

        preferences = getSharedPreferences("preferencias",MODE_PRIVATE);

        loadDestinos();

        b.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView adapterView, View view, int posicion, long l) {
                //Toast.makeText(getApplicationContext(), "posicion " + (i + 1) + personas[i], Toast.LENGTH_SHORT).show();
                switch (posicion) {
                    case 0 :
                        Intent intent = new Intent(getApplicationContext(), Popayan.class);
                        startActivity(intent);
                        break;

                    case 1 :
                        intent = new Intent(getApplicationContext(), Cali.class);
                        startActivity(intent);
                        break;

                    case 2 :
                        intent = new Intent(getApplicationContext(), Medellin.class);
                        startActivity(intent);
                        break;

                }
            }
        });
    }

    //Paso A otra Actividad IconRegistry

    public void pasarRegistry(View v){

        Intent siguiente=new Intent(this,Empresas.class);
        startActivity(siguiente);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opc,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(toggle.onOptionsItemSelected(item))
            return true;


        switch (item.getItemId()){
            case R.id.action_add:
                Toast.makeText(this,"Seleccionaste Agregar ",Toast.LENGTH_SHORT).show();

                break;
            case R.id.action_about:
                Toast.makeText(this,"Seleccionaste Acerca de ",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_help:
                Toast.makeText(this,"Seleccionaste Ayuda ",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadDestinos() {

        Destino d1 = new Destino();
        d1.setNombre("POPAYAN");
        d1.setImg("http://cache-graphicslib.viator.com/graphicslib/thumbs674x446/22244/SITours/day-trip-popay-n-history-and-culture-from-cali-in-cali-264250.jpg");

        Destino d2 = new Destino();
        d2.setNombre("CALI");
        d2.setImg("http://www.elpais.com.co/elpais/sites/default/files/imagecache/x490/multimedia/fotos/2015/06/babativa2780.jpg");

        Destino d3 = new Destino();
        d3.setNombre("MEDELLIN");
        d3.setImg("http://www.medellin.travel/sites/default/files/museo-antioquia-1_0.jpg");

        C.data.add(d1);
        C.data.add(d2);
        C.data.add(d3);



        adapter.notifyDataSetChanged();
    }

    //region  Preparacion del Boton Hamburguesa
    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

        toggle.onDrawerSlide(drawerView, slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        toggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        toggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        b.drawer.closeDrawers();
        switch (item.getItemId()){

            case R.id.nav_logout:

                SharedPreferences.Editor editor =  preferences.edit();
                editor.putBoolean("login", false);
                editor.commit();

                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
                finish();

        }
        return false;
    }

    //endregion
}
