package com.sortname.sorteio.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.sortname.sorteio.R;
import com.sortname.sorteio.alunoDAO.AlunoDAO;
import com.sortname.sorteio.model.Aluno;

import org.jetbrains.annotations.NotNull;

public class FormularioAlunoActivity extends AppCompatActivity {

    private EditText campoNome;
    private EditText campoPhone;
    private EditText campoEmail;
    AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_formulario);
        setTitle("Novo Aluno");
        initCampos();
        settingsButtonSave();
    }

    private void settingsButtonSave() {
        Button btSalvar = findViewById(R.id.bt_salvar);
        btSalvar.setOnClickListener(view -> {
            Aluno alunoCriado = criaAluno();
            salva(alunoCriado);
        });
    }

    private void initCampos() {
        campoNome = findViewById(R.id.ed_name);
        campoPhone = findViewById(R.id.ed_phone);
        campoEmail = findViewById(R.id.ed_email);
    }

    private void salva(Aluno alunoCriado) {
        dao.salvar(alunoCriado);
        finish();
    }

    @NotNull
    private Aluno criaAluno() {
        String nome = campoNome.getText().toString();
        String phone = campoPhone.getText().toString();
        String email = campoEmail.getText().toString();

        Aluno alunoCriado = new Aluno(nome, phone, email);
        return alunoCriado;
    }
}