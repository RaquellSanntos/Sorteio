package com.sortname.sorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class SecondarySemesterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_semester);
    }
    public void ganhadorSecundary(View view) {
        String[] nomes = {
                "BRENO DA SILVA ROCHA",
                "CINTIA BRANDÃO DA SILVA",
                "DANIEL BRUNO MEDEIROS",
                "GUIBSON JUNIOR FERREIRA DOS SANTOS",
                "JOÃO VITOR BARROS DA SIVA",
                "JOSUÉ DOS SANTOS CALDAS",
                "LEONARDO ABNER RIBEIRO",
                "LUAN MACHADO DA FONSECA",
                "JONATHAN SILVA SANTOS",
                "MARIA EDUARDA SOUZA DOS SANTOS",
                "NEG ELIAS ESPINO FERRER",
                "RICKSON WILLIAM DANTAS FERREIRA",
                "ROBERTO PARENTE DA SILVA",
                "TALYSSON DE ABREU GARCIA",
                "WASHINGTON SMITH ROCHA DA CUNHA"
        };
        int sorteado = new Random().nextInt(30);
        TextView divulgarNome = findViewById(R.id.txtView);

        divulgarNome.setText(nomes[sorteado]);
    }
}