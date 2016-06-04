package com.example.equipo.termitransr.models;

/**
 * Created by EQUIPO on 1/06/2016.
 */
public class DestinoBase extends Destino {

    private long id;
    private String nombre;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
