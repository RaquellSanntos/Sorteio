package com.sortname.sorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sortname.sorteio.model.Aluno;
import com.sortname.sorteio.alunoDAO.AlunoPrimaryDAO;

public class CadastroPrimarySemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_primary_sem);

        AlunoPrimaryDAO primaryDAO = new AlunoPrimaryDAO();

        final EditText campoNome = findViewById(R.id.ed_name);
        final EditText campoPhone = findViewById(R.id.ed_phone);
        final EditText campoEmail = findViewById(R.id.ed_email);

        Button btSalvar = findViewById(R.id.bt_salvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = campoNome.getText().toString();
                String phone = campoPhone.getText().toString();
                String email = campoEmail.getText().toString();

                Aluno novoAluno = new Aluno(nome, phone, email);
                primaryDAO.salvar(novoAluno);

            }
        });
    }
}