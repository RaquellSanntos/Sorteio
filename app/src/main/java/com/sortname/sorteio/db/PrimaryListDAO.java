package com.sortname.sorteio.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sortname.sorteio.model.ListaPrimeiroSemestre;

import java.util.List;

@Dao
public interface PrimaryListDAO {

    @Query("SELECT * FROM ListaPrimeiroSemestre")
    List<ListaPrimeiroSemestre> getAll();

    @Query("SELECT aluno.nome FROM ListaPrimeiroSemestre aluno")
    List<String> getAllNomes();

    @Query("SELECT * FROM ListaPrimeiroSemestre LIMIT 1")
    ListaPrimeiroSemestre getFirst();

    @Query("SELECT * FROM ListaPrimeiroSemestre WHERE id = :id")
    ListaPrimeiroSemestre findById(Integer id);

    @Query("SELECT * FROM ListaPrimeiroSemestre WHERE semestre LIKE :semestre")
    List<ListaPrimeiroSemestre> findBySemestre(String semestre);

    @Query("SELECT * FROM ListaPrimeiroSemestre WHERE nome LIKE :nome")
    List<ListaPrimeiroSemestre> findByNome(String nome);

    @Query("SELECT * FROM ListaPrimeiroSemestre WHERE email LIKE :email")
    List<ListaPrimeiroSemestre> findByEmail(String email);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(ListaPrimeiroSemestre ... alunos);

    @Delete
    void delete(ListaPrimeiroSemestre alunos);
}
