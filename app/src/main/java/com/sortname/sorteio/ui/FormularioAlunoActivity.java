package com.sortname.sorteio.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.sortname.sorteio.R;
import com.sortname.sorteio.alunoDAO.AlunoDAO;
import com.sortname.sorteio.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_formulario);

        AlunoDAO primaryDAO = new AlunoDAO();

        final EditText campoNome = findViewById(R.id.ed_name);
        final EditText campoPhone = findViewById(R.id.ed_phone);
        final EditText campoEmail = findViewById(R.id.ed_email);

        Button btSalvar = findViewById(R.id.bt_salvar);
        btSalvar.setOnClickListener(view -> {
            String nome = campoNome.getText().toString();
            String phone = campoPhone.getText().toString();
            String email = campoEmail.getText().toString();

            Aluno alunoCriado = new Aluno(nome, phone, email);
            primaryDAO.salvar(alunoCriado);

            finish();
        });
    }
}