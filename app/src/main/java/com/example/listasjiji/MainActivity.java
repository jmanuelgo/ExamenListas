package com.example.listasjiji;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    EditText nombre,ape1,ape2,codigo,direc;
    Button registro,ver;
    RadioButton hombre,mujer;
    ArrayList<Paciente>paciente=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nombre=findViewById(R.id.txtNombre);
        ape1=findViewById(R.id.txtApe1);
        ape2=findViewById(R.id.txtApe2);
        codigo=findViewById(R.id.txtCodigo);
        direc=findViewById(R.id.txtDir);
        registro=findViewById(R.id.btnRegistrar);
        ver=findViewById(R.id.btnMostrar);
        hombre=findViewById(R.id.rbHombre);
        mujer=findViewById(R.id.rbMujer);
    }
    public void Registrar(View v){
        String nombrePaciente = nombre.getText().toString();
        String ape1Paciente = ape1.getText().toString();
        String ape2Paciente = ape2.getText().toString();
        String codigoPaciente = codigo.getText().toString();
        String direccionPaciente = direc.getText().toString();
        String generoPaciente = hombre.isChecked() ? "Hombre" : "Mujer";
        Paciente nuevoPaciente = new Paciente(nombrePaciente, ape1Paciente, ape2Paciente, codigoPaciente, generoPaciente,direccionPaciente );
        paciente.add(nuevoPaciente);
        paciente.sort(new Comparator<Paciente>() {
            @Override
            public int compare(Paciente p1, Paciente p2) {
                return p1.getApellido1().compareToIgnoreCase(p2.getApellido1());

            }
        });
        nombre.setText("");
        ape1.setText("");
        ape2.setText("");
        codigo.setText("");
        direc.setText("");
        hombre.setChecked(false);
        mujer.setChecked(false);
        Toast.makeText(this, "Paciente Registrado", Toast.LENGTH_SHORT).show();
    }
    public void Mostrar(View v){
        Intent it=new Intent(getApplicationContext(), Lista.class);
        it.putExtra("Lista",(Serializable) paciente);
        startActivity(it);
    }
}