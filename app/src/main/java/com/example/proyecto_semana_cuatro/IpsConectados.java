package com.example.proyecto_semana_cuatro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpsConectados extends AppCompatActivity {

    private Button salidaHomeDos;
    private TextView ips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ips_conectados);

        salidaHomeDos = findViewById(R.id.SalidaHomeDos);
        ips = findViewById(R.id.Ips);

        try {
            ips.setText("");
            for (int i = 1; i < 255; i++) {
                InetAddress inetAddress = InetAddress.getByName("192.168.0." + i);
                String ipsEnConexion = inetAddress.getHostAddress();


                new Thread(
                        () -> {
                            try {
                                boolean conectado = inetAddress.isReachable(1000);
                                if (conectado == true) {
                                    ips.append(ipsEnConexion + "\n");
                                    Log.e("estados", String.valueOf(ips));
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        salidaHomeDos.setOnClickListener(

                (v)->{
                    finish();
                }

        );
    }
}