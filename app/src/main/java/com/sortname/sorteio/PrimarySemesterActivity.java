package com.sortname.sorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class PrimarySemesterActivity extends AppCompatActivity {
    private Button btprimary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_semester);

         btprimary = findViewById(R.id.bt_primary);
        btprimary.setOnClickListener(view -> ganhadorPrimary());
    }

    public void ganhadorPrimary() {
        String[] nomes = {
                "ANDERSEN LUCAS LOPES BORBA",
                "BRUNO DOURADO MACHADO",
                "CAIO BRASIL GOMES",
//                "DAMYZ CASSIANO OLIVEIRA DA SILVA", (Sorteado)
                "DANIELLA SILVA DOS SANTOS",
                "DENIS FARIAS RAMOS",
                "GUILHERME DE ALMEIDA OBANDO",
                "HAROLDO DE SOUZA CALDERARO",
                "HEWERTON BRITO ASCENCAO",
//                "JOAO PAULO PINHEIRO DA SILVA", (Sorteado)
                "JONATHAN SILVA SANTOS",
                "KELLY CHRISTINA PIMENTEL DA SILVA",
                "LEANDRO SOUZA DOS SANTOS",
//                "LUIZ AMERICO GRIJO CARDOSO", (Ausente)
                "MARCUS VINICIUS DE ARAUJO",
                "MATEUS SANTOS SOUZA",
                "MAYR DI FRANCO NAJAR AROUCHAR",
                "NAELEM SILVA DE SOUZA",
                "PAULO DEYVID BARROS DO NASCIMENTO",
                "ROGER MILLER DA SILVA DOS SANTOS",
                "SARAH CRISTINNY OLIVEIRA LOPES",
                "VICTOR SAULO LITAIFF PEREIRA",
                "VITOR ANDES DOS SANTOS"
        };
        int sorteado = new Random().nextInt(nomes.length);
        TextView divulgarNome = findViewById(R.id.txtView);

        divulgarNome.setText(nomes[sorteado]);
    }
}