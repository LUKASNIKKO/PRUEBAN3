package com.stto.prueban3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
        Button BTNVOTAR;
        Button BTNRESULTADOS;
        RadioButton NULO;
        RadioButton GABRI;
        RadioButton KAST;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BTNVOTAR=(Button) findViewById(R.id.button);
        BTNRESULTADOS=(Button)findViewById(R.id.button2);
        NULO=(RadioButton)findViewById(R.id.radioButton);
        GABRI=(RadioButton)findViewById(R.id.radioButton2);
        KAST=(RadioButton)findViewById(R.id.radioButton3);

        SQLiteDatabase db;
        Dbhelper conn = new Dbhelper(getApplicationContext());
        db=conn.getWritableDatabase();
        ContentValues CV= new ContentValues();
        BTNVOTAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(NULO.isChecked()==true)
                {

                    CV.put("voto_nulo",NULO.getText().toString());
                    db.insert("VOTO",null,CV);

                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(I);


                }
                else if(GABRI.isChecked()==true)
                {

                    CV.put("voto_boric",NULO.getText().toString());
                    db.insert("VOTO",null,CV);
                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(I);

                }
                else if(KAST.isChecked()==true)
                {

                    CV.put("voto_kast",NULO.getText().toString());
                    db.insert("VOTO",null,CV);
                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(I);

                }


                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("ESTA SEGURO DE VOTAR EN BLANCO?")
                            .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                                    I.putExtra("VA","0");
                                    I.putExtra("NULO","0");
                                    I.putExtra("BO","0");
                                    I.putExtra("KK","0");

                                    startActivity(I);

                                }
                            })
                            .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                    builder.create();
                    builder.show();

                }



            }
        });
        BTNRESULTADOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("¿Quiere Ver Los Votos?")
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent I =new Intent(getApplicationContext(),MainActivity2.class);
                                startActivity(I);

                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                builder.create();
                builder.show();

            }
        });

    }
}