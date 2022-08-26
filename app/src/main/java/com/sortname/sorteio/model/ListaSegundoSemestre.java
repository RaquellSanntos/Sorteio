package com.sortname.sorteio.model;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
/*Visto como LivroRealm*/

public class ListaSegundoSemestre {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "semestre")
    private String semestre;
    @ColumnInfo(name = "email")
    private String email;

    public ListaSegundoSemestre(){

    }

    public ListaSegundoSemestre(Integer id, String nome, String semestre, String email) {
        this.id = id;
        this.nome = nome;
        this.semestre = semestre;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
