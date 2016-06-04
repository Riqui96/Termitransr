package com.example.equipo.termitransr;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends Activity implements View.OnClickListener {


    Button btnEntrar;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferences = getSharedPreferences("preferencias",MODE_PRIVATE);

        boolean login = preferences.getBoolean("login",false);
        if(login){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        setContentView(R.layout.activity_login);



        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        SharedPreferences.Editor edit = preferences.edit();
        edit.putBoolean("login", true);
        edit.commit();
        finish();

    }
}
