package com.example.equipo.termitransr.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.equipo.termitransr.models.Destino;
import com.example.equipo.termitransr.models.DestinoBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EQUIPO on 1/06/2016.
 */
public class DestinoDao {

    private static final String TABLE="destino";
    private static final String C_NOMBRE="nombre";

    SQLiteDatabase db;

    public DestinoDao(Context context)
    {
        DataBaseHelper helper = new DataBaseHelper(context);
        db = helper.getWritableDatabase();
    }

    public void insert(DestinoBase destinoBase)
    {
        ContentValues cV = new ContentValues();
        cV.put(C_NOMBRE, destinoBase.getNombre());
        db.insert(TABLE, null, cV);
    }

    public void update(DestinoBase destinoBase)
    {
        ContentValues cV = new ContentValues();
        cV.put(C_NOMBRE, destinoBase.getNombre());
        db.update(TABLE,cV, "_id=?", new String[]{destinoBase.getId()+""});

    }

    public void delete(long id){
        db.delete(TABLE,"_id="+id, null);
    }

    public DestinoBase getById(long id){

        Cursor cursor =  db.rawQuery("SELECT * FROM destinobase WHERE _id="+id,null);
        return cursorToDestinoBase(cursor);
    }

    public List<DestinoBase> getAll(){
        Cursor cursor =  db.rawQuery("SELECT * FROM destinobase", null);
        return  cursorToList(cursor);
    }

    public List<DestinoBase> getByNombre(String nombre){
        Cursor cursor =  db.rawQuery("SELECT * FROM destinobase WHERE nombre LIKE '%"+nombre+"%'", null);
        return  cursorToList(cursor);
    }

    private DestinoBase cursorToDestinoBase(Cursor cursor) {
        DestinoBase Destinobase =  null;
        if(cursor.moveToNext()){
            Destinobase =  new DestinoBase();
            Destinobase.setId(cursor.getLong(0));
            Destinobase.setNombre(cursor.getString(1));

        }
        return Destinobase;
    }

    private List<DestinoBase> cursorToList(Cursor cursor) {
        List<DestinoBase> data = new ArrayList<>();

        int size =  cursor.getCount();
        for(int i = 0; i<size; i++){
            DestinoBase p = cursorToDestinoBase(cursor);
            data.add(p);
        }

        return data;
    }

}
