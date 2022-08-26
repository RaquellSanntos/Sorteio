package com.sortname.sorteio.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import com.sortname.sorteio.R;
import com.sortname.sorteio.db.PrimaryUtil;
import com.sortname.sorteio.db.SecundaryUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PrimaryUtil.dataBaseInit(this);

        RadioButton btPrimarySem = findViewById(R.id.bt_primary);
        RadioButton btSecundarySem = findViewById(R.id.bt_segundo);

        btPrimarySem.setOnClickListener(view -> btSecundarySem.setChecked(false));
        btSecundarySem.setOnClickListener(view -> btPrimarySem.setChecked(false));

        Intent intent = new Intent(MainActivity.this,ListaAlunosActivity.class);
        Bundle b = new Bundle();

        Button btLista = findViewById(R.id.bt_primary);
        btLista.setOnClickListener(view -> {
            b.putBoolean("dbPrimary", btPrimarySem.isChecked());
            intent.putExtras(b);
            startActivity(intent);
        });
    }
    protected void onDestroy(){
        super.onDestroy();
        PrimaryUtil.dataBaseClose();
       // SecundaryUtil.dataBaseClose();

    }
}