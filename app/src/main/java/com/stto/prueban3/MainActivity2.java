package com.stto.prueban3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button BTNVOLVER;
        TextView K,N,B,VB;
        BTNVOLVER=(Button)findViewById(R.id.button3);
        K=(TextView)findViewById(R.id.V_K);
        N=(TextView)findViewById(R.id.V_NU);
        VB=(TextView)findViewById(R.id.V_BLA);
        B=(TextView)findViewById(R.id.V_BORIC);
        Integer NULO=0,KAST=0,BORIC=0,VACIO=0;
        SQLiteDatabase db;
        Dbhelper conn = new Dbhelper(getApplicationContext());
        db= conn.getReadableDatabase();
        Cursor C =db.query("VOTO",null,null,null,null,null,null);
        if(C!=null)
        {
            if(C.moveToFirst())
            {
                do{
                    if(C.getString(3).equals("voto_nulo"))
                    {

                        NULO++;
                    }
                    else if (C.getString(5).equals("voto_kast"))
                    {
                        KAST++;
                    }
                    else if (C.getString(4).equals("voto_boric"))
                    {
                        BORIC++;
                    }
                    else
                    {
                        VACIO++;
                    }
                }
                while(C.moveToNext());
            }

        }
        K.setText(""+KAST);
        N.setText(""+NULO);
        VB.setText(""+VACIO);
        B.setText(""+BORIC);


        BTNVOLVER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(I);
            }
        });
    }
}