package com.sortname.sorteio.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
/*Visto como LivroRoom*/
@Entity
public class ListaPrimeiroSemestre {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "semestre")
    private String semestre;
    @ColumnInfo(name = "email")
    private String email;

    public ListaPrimeiroSemestre(){
    }

    @Ignore
    public ListaPrimeiroSemestre( String nome, String semestre, String email) {
        this.nome = nome;
        this.semestre = semestre;
        this.email = email;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSemestre() { return semestre; }
    public void setSemestre(String semestre) { this.semestre = semestre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }
}
