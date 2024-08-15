package com.example.listasjiji;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {

    ArrayList<Paciente>pacientes;
    ListView ListaPacientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        ListaPacientes=findViewById(R.id.lwLista);
        pacientes= (ArrayList<Paciente>) getIntent().getSerializableExtra("Lista");
        if (pacientes!=null){
            AdaptadorPaciente adapter=new AdaptadorPaciente(this,pacientes);
            ListaPacientes.setAdapter(adapter);
        }
    }
}