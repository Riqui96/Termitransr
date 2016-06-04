package com.example.equipo.termitransr.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by EQUIPO on 1/06/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="destinos.db";
    static int version = 1;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE destinos (_id INTEGER AUTO_INCREMENT PRIMARY KEY"
                +", nombre VARCHAR"
                +")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE destinos");
        onCreate(db);
    }
}
