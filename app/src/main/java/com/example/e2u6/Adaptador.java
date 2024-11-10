package com.example.e2u6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adaptador extends ArrayAdapter<Datos> {
    private Datos[] datos;

    public Adaptador(Context context, Datos[] datos) {
        super(context, R.layout.elemento, datos);
        this.datos = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View elemento = inflater.inflate(R.layout.elemento, parent, false);

        TextView texto1 = elemento.findViewById(R.id.miTexto1);
        TextView texto2 = elemento.findViewById(R.id.miTexto2);

        texto1.setText(datos[position].getPais());
        texto2.setText(datos[position].getCapital());

        return elemento;
    }
}
