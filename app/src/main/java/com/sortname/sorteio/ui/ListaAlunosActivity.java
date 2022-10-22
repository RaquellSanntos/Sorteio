package com.sortname.sorteio.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sortname.sorteio.R;
import com.sortname.sorteio.alunoDAO.AlunoDAO;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String LISTA_DE_A_LUNOS = "Lista de ALunos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

       setTitle(LISTA_DE_A_LUNOS);
        settingsNewFAB();
    }

    private void settingsNewFAB() {
        FloatingActionButton AddButton =findViewById(R.id.fab);
        AddButton.setOnClickListener(view -> {
            irFormularioAluno();
        });
    }

    private void irFormularioAluno() {
        Intent intent = new Intent(getApplicationContext(), FormularioAlunoActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AlunoDAO dao = new AlunoDAO();
        settingsList(dao);
    }

    private void settingsList(AlunoDAO dao) {
        ListView listaDeAlunos =findViewById(R.id.listView);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));
    }
}