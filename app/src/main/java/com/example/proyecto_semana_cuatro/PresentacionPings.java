package com.example.proyecto_semana_cuatro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PresentacionPings extends AppCompatActivity {

    private Button salidaHome;
    private TextView ping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion_pings);

        String ipObjetivo = getIntent().getExtras().getString("ipObjetivo");

        salidaHome = findViewById(R.id.SalidaHome);
        ping = findViewById((R.id.Pings));

        try{
            ping.setText("");
            InetAddress inetAddress = InetAddress.getByName(ipObjetivo);
            String estadoPings = inetAddress.getHostAddress();

            new Thread(
                    ()->{

                        for(int i = 0; i < 4; i++) {

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            try {
                                boolean coneccion = inetAddress.isReachable(1000);

                                if (coneccion == true) {

                                    ping.append(estadoPings + ":" + " " + "conectado" + "\n");
                                } else {
                                    ping.append(estadoPings + ":" + " " + "fallido" + "\n");
                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
            );



        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        salidaHome.setOnClickListener(

                (v)->{
                    finish();
                }
        );
    }
}