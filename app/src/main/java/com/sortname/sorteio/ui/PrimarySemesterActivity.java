package com.sortname.sorteio.ui;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sortname.sorteio.R;

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
                "DENIS FARIAS RAMOS",
//                "GUILHERME DE ALMEIDA OBANDO",(2meses suspenso temporário)
//                "HEWERTON BRITO ASCENCAO", (2suspensão)
                "Jessica Mayumi de Araújo Ikuno ",
                "JONATHAN SILVA SANTOS",
                "NAELEM SILVA DE SOUZA",
                "ROGER MILLER DA SILVA DOS SANTOS",
                "SARAH CRISTINNY OLIVEIRA LOPES",
                "VITOR ANDES DOS SANTOS"
        };
        int sorteado = new Random().nextInt(nomes.length);
        TextView divulgarNome = findViewById(R.id.txtView);

        divulgarNome.setText(nomes[sorteado]);
    }
}