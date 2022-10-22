package com.sortname.sorteio.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sortname.sorteio.R;

import java.util.Random;

public class SecondarySemesterActivity extends AppCompatActivity {
    Button btsecondary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_semester);

        btsecondary = findViewById(R.id.bt_secondary);
        btsecondary.setOnClickListener(view -> ganhadorSecundary());
    }
    public void ganhadorSecundary() {
        String[] nomes = {
//                "BRENO DA SILVA ROCHA", (sorteado)
//                "CINTIA BRANDÃO DA SILVA", (sorteada)
                "DANIEL BRUNO MEDEIROS",
               // "GUIBSON JUNIOR FERREIRA DOS SANTOS",(Ausente)
                "JOÃO VITOR BARROS DA SIVA",
                "JOSUÉ DOS SANTOS CALDAS",
                "LEONARDO ABNER RIBEIRO",
                "LUAN MACHADO DA FONSECA",
                "MARIA EDUARDA SOUZA DOS SANTOS",
                "NEG ELIAS ESPINO FERRER",
                "RICKSON WILLIAM DANTAS FERREIRA",
                "ROBERTO PARENTE DA SILVA",
                "TALYSSON DE ABREU GARCIA"
        };
        int sorteado = new Random().nextInt(nomes.length);
        TextView divulgarNome = findViewById(R.id.txtView);

        divulgarNome.setText(nomes[sorteado]);
    }
}