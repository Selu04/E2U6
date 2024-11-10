package com.example.e2u6;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private TextView textViewSeleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Datos[] datos = new Datos[]{
                new Datos("España", "Madrid"),
                new Datos("Francia", "París"),
                new Datos("Italia", "Roma"),
                new Datos("Alemania", "Berlín"),
                new Datos("Reino Unido", "Londres"),
                new Datos("Portugal", "Lisboa"),
                new Datos("Rusia", "Moscú"),
                new Datos("Japón", "Tokio"),
                new Datos("China", "Pekín"),
                new Datos("Brasil", "Brasilia")
        };

        textViewSeleccion = findViewById(R.id.textViewSeleccion);
        ListView miLista = findViewById(R.id.miLista);

        // Inflar la cabecera
        View miCabecera = getLayoutInflater().inflate(R.layout.cabecera, null);
        miLista.addHeaderView(miCabecera);

        // Crear adaptador personalizado
        Adaptador miAdaptador = new Adaptador(this, datos);
        miLista.setAdapter(miAdaptador);

        miLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adaptador, View v, int position, long id) {
                String capitalSeleccionada = ((Datos) adaptador.getItemAtPosition(position)).getCapital();
                textViewSeleccion.setText("Pulsado: " + capitalSeleccionada);

            }
        });
    }
}
