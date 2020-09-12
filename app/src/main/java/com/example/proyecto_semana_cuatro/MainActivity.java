package com.example.proyecto_semana_cuatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText valorUno;
    private EditText valorDos;
    private EditText valorTres;
    private EditText valorCuatro;
    private Button activadorPing;
    private Button buscadorIps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorUno = findViewById(R.id.ValorUno);
        valorDos = findViewById(R.id.ValorDos);
        valorTres = findViewById(R.id.ValorTres);
        valorCuatro = findViewById(R.id.ValorCuatro);

        activadorPing = findViewById(R.id.Activador);
        buscadorIps = findViewById(R.id.Buscador);

        activadorPing.setOnClickListener(

                (v)->{
                    String ipSeleccionada = valorUno.getText().toString() + "."
                            + valorDos.getText().toString() + "."
                            + valorTres.getText().toString() + "."
                            + valorCuatro.getText().toString();

                    Intent i = new Intent(this,IpsConectados.class);
                    startActivity(i);

                    i.putExtra("ipObjetivo",ipSeleccionada);
    }
        );

        buscadorIps.setOnClickListener(

                (v)->{

                    Intent i = new Intent(this,IpsConectados.class);
                    startActivity(i);
                }
        );

    }
}