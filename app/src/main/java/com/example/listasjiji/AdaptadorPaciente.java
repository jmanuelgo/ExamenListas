package com.example.listasjiji;


import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdaptadorPaciente extends ArrayAdapter<Paciente> {
    private Context context;
    private List<Paciente> pacientes;

    public AdaptadorPaciente(Context context, List<Paciente> pacientes) {
        super(context, 0, pacientes);
        this.context = context;
        this.pacientes = pacientes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listviewpersonalizado, parent, false);
        }

        Paciente paciente = pacientes.get(position);


        TextView InfoPaciente = convertView.findViewById(R.id.textLista);
        ImageView ImagenGenero= convertView.findViewById(R.id.imagenPaciente);
        TextView InicialPaciente = convertView.findViewById(R.id.ini);
        String inicialApellido1 = paciente.getApellido1().substring(0, 1);

        InicialPaciente.setText(inicialApellido1);


        String textoPaciente ="<b>"+paciente.getCodigoPaciente() + "</b><br>" +paciente.getNombre() + " " + paciente.getApellido1() + " " + paciente.getApellido2();
        InfoPaciente.setText(Html.fromHtml(textoPaciente));

        if ("Hombre".equals(paciente.getSexo())) {
            ImagenGenero.setImageResource(R.drawable.hombres);
        } else  {
            ImagenGenero.setImageResource(R.drawable.mujers);
        }

        return convertView;
    }
}

