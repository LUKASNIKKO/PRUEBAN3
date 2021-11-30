package com.stto.prueban3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbhelper extends SQLiteOpenHelper{
    public static String Nombre_BD= "voto.db";
    public static int Version_DB=1;
    public static String Tabla_VOTO="create table VOTO (id_voto integer  primary key autoincrement,voto_blaco integer, voto_nulo integer,voto_boric integer,voto_kast integer)";
    public Dbhelper(Context context) {
        super(context, Nombre_BD, null, Version_DB);
    }





    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Tabla_VOTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
