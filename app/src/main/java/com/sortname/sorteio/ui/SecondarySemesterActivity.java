package com.sortname.sorteio.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
                "ROBERTO PARENTE DA SILVA"
        };
        int sorteado = new Random().nextInt(nomes.length);
        TextView divulgarNome = findViewById(R.id.txtView);

        divulgarNome.setText(nomes[sorteado]);
    }
}