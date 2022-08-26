package com.sortname.sorteio.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sortname.sorteio.R;
import com.sortname.sorteio.db.PrimaryUtil;
import com.sortname.sorteio.model.ListaPrimeiroSemestre;
import com.sortname.sorteio.model.ListaSegundoSemestre;

import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView listView;
    private PopupWindow popUp;
    private View popupView;
    private EditText nome;
    private EditText semestre;
    private EditText email;

    private List<ListaPrimeiroSemestre> listaPrimeiroSemestre;
    private ArrayAdapter<ListaPrimeiroSemestre> adapterPrimary;

    private List<ListaPrimeiroSemestre> listaSegundoSemestre;
    private ArrayAdapter<ListaPrimeiroSemestre> adapterSecundary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        listView = findViewById(R.id.lv_lista_alunos);

        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        popupView = inflater.inflate(R.layout.popup_aluno, null);
        popUp = new PopupWindow(popupView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
        popUp.setAnimationStyle(androidx.appcompat.R.style.Animation_AppCompat_Dialog);

        nome = popupView.findViewById(R.id.edTxNome);
        semestre = popupView.findViewById(R.id.edTxSemestre);
        email = popupView.findViewById(R.id.edTxEmail);

        Button btnCancel = popupView.findViewById(R.id.bt_pop_cancelar);
        btnCancel.setOnClickListener(view -> dismissPopUpAndRefreshPrimary());

        Bundle b = getIntent().getExtras();
        final boolean bdRoom = b == null || b.getBoolean("bdRoom");

        FloatingActionButton btnAdd = findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(view -> {
            if(bdRoom){
                popUpListPrimary();
            } else {
                popUpListSecundary();
            }
        });

        if(bdRoom){
            preencheListPrimary();
        } else {
            preencheListSecundary();
        }
    }

    private void preencheListPrimary(){
        listaPrimeiroSemestre= PrimaryUtil.getAll();
        adapterPrimary = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listaPrimeiroSemestre);
        listView.setAdapter(adapterPrimary);
        listView.setOnItemClickListener((adapterView, view,
                                         i, l) -> popUpListPrimary(listaPrimeiroSemestre.get(i)));
    }
    private void preencheListSecundary(){
        listaSegundoSemestre= PrimaryUtil.getAll();
        adapterSecundary = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listaSegundoSemestre);
        listView.setAdapter(adapterSecundary);
        listView.setOnItemClickListener((adapterView, view,
                                         i, l) -> popUpListSecundary(listaSegundoSemestre.get(i)));
    }

    private void popUpListPrimary(ListaPrimeiroSemestre aluno){
        nome.setText(aluno.getNome());
        semestre.setText(aluno.getSemestre());
        email.setText(aluno.getEmail());
        popUp.showAtLocation(popupView, Gravity.CENTER, 0, 0);

        Button btnSalvar = popupView.findViewById(R.id.bt_pop_salvar);
        btnSalvar.setOnClickListener(view -> {
            aluno.setSemestre(semestre.getText().toString());
            aluno.setEmail(email.getText().toString());
            aluno.setNome(nome.getText().toString());
            PrimaryUtil.insertOrUpdate(aluno);
            dismissPopUpAndRefreshPrimary();
        });
        Button btnExcluir = popupView.findViewById(R.id.bt_pop_excluir);
        btnExcluir.setOnClickListener(view -> {
            PrimaryUtil.delete(aluno);
            dismissPopUpAndRefreshPrimary();
        });
    }

    private void popUpListSecundary(){
        nome.setText("");
        semestre.setText("");
        email.setText("");
        popUp.showAtLocation(popupView, Gravity.CENTER, 0, 0);

        Button btnSalvar = popupView.findViewById(R.id.bt_pop_salvar);
        btnSalvar.setOnClickListener(view -> {
            ListaPrimeiroSemestre aluno = new ListaPrimeiroSemestre(nome.getText().toString(),
                    semestre.getText().toString(), email.getText().toString());
            PrimaryUtil.insertOrUpdate(aluno);
            dismissPopUpAndRefreshPrimary();
        });

        Button btnExcluir = popupView.findViewById(R.id.bt_pop_excluir);
        btnExcluir.setOnClickListener(view -> dismissPopUpAndRefreshPrimary());
    }

    private void popUpListSecundary(ListaPrimeiroSemestre aluno){
        nome.setText(aluno.getNome());
        semestre.setText(aluno.getSemestre());
        email.setText(aluno.getEmail());
        popUp.showAtLocation(popupView, Gravity.CENTER, 0, 0);

        Button btnSalvar = popupView.findViewById(R.id.bt_pop_salvar);
        btnSalvar.setOnClickListener(view -> {
            aluno.setSemestre(semestre.getText().toString());
            aluno.setEmail(email.getText().toString());
            aluno.setNome(nome.getText().toString());
            PrimaryUtil.insertOrUpdate(aluno);
            dismissPopUpAndRefreshPrimary();
        });
        Button btnExcluir = popupView.findViewById(R.id.bt_pop_excluir);
        btnExcluir.setOnClickListener(view -> {
            PrimaryUtil.delete(aluno);
            dismissPopUpAndRefreshPrimary();
        });
    }

    private void popUpListPrimary(){
        nome.setText("");
        semestre.setText("");
        email.setText("");
        popUp.showAtLocation(popupView, Gravity.CENTER, 0, 0);

        Button btnSalvar = popupView.findViewById(R.id.bt_pop_salvar);
        btnSalvar.setOnClickListener(view -> {
            ListaPrimeiroSemestre aluno = new ListaPrimeiroSemestre(nome.getText().toString(),
                    semestre.getText().toString(), email.getText().toString());
            PrimaryUtil.insertOrUpdate(aluno);
            dismissPopUpAndRefreshPrimary();
        });

        Button btnExcluir = popupView.findViewById(R.id.bt_pop_excluir);
        btnExcluir.setOnClickListener(view -> dismissPopUpAndRefreshPrimary());
    }

    private void dismissPopUpAndRefreshPrimary(){
        popUp.dismiss();
        preencheListPrimary();
        adapterPrimary.notifyDataSetChanged();
    }


}