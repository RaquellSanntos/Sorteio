package com.sortname.sorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class PrimarySemesterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_semester);
    }

    public void ganhadorPrimary(View view) {
        String[] nomes = {
                "ANDERSEN LUCAS LOPES BORBA",
                "BRUNO DOURADO MACHADO",
                "DAMYZ CASSIANO OLIVEIRA DA SILVA",
                "DANIELLA SILVA DOS SANTOS",
                "DENIS FARIAS RAMOS",
                "GUILHERME DE ALMEIDA OBANDO",
                "HAROLDO DE SOUZA CALDERARO",
                "HEWERTON BRITO ASCENCAO",
                "JOAO PAULO PINHEIRO DA SILVA",
                "JONATHAN SILVA SANTOS",
                "KELLY CHRISTINA PIMENTEL DA SILVA",
                "LUIZ AMERICO GRIJO CARDOSO",
                "MARCUS VINICIUS DE ARAUJO",
                "MATEUS SANTOS SOUZA",
                "NAELEM SILVA DE SOUZA",
                "PAULO DEYVID BARROS DO NASCIMENTO",
                "ROGER MILLER DA SILVA DOS SANTOS",
                "SARAH CRISTINNY OLIVEIRA LOPES",
                "VICTOR SAULO LITAIFF PEREIRA",
                "VITOR ANDES DOS SANTOS"
        };
        int sorteado = new Random().nextInt(30);
        TextView divulgarNome = findViewById(R.id.txtView);

        divulgarNome.setText(nomes[sorteado]);
    }
}