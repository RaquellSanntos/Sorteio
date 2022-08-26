package com.sortname.sorteio.db;

import android.content.Context;
import androidx.room.Room;
import com.sortname.sorteio.model.ListaPrimeiroSemestre;
import java.util.List;

public class PrimaryUtil {
  private static AppPrimaryDB primaryBD = null;
  public static void dataBaseInit(Context context){
    primaryBD = Room.databaseBuilder(context,AppPrimaryDB
                    .class, "primary-db")
            .allowMainThreadQueries().build();

    if (primaryBD.primaryListDAO().getFirst()==null){
      ListaPrimeiroSemestre aluno1 = new ListaPrimeiroSemestre("nome", "semestre",
              "emails@gmail.com");
      ListaPrimeiroSemestre aluno2 = new ListaPrimeiroSemestre("nome", "semestre",
              "emails@gmail.com");
      ListaPrimeiroSemestre aluno3 = new ListaPrimeiroSemestre("nome", "semestre",
              "emails@gmail.com");
      ListaPrimeiroSemestre aluno4 = new ListaPrimeiroSemestre("nome", "semestre",
              "emails@gmail.com");

      insertOrUpdate(aluno1, aluno2, aluno3, aluno4);
    }

  }
  public static void insertOrUpdate(ListaPrimeiroSemestre ... alunos){
    primaryBD.primaryListDAO().insertAll(alunos);
  }
  public static void delete( ListaPrimeiroSemestre... alunos){
    for(ListaPrimeiroSemestre aluno : alunos) {
      primaryBD.primaryListDAO().delete(aluno);
    }
  }
  public static List<ListaPrimeiroSemestre> getAll(){
    return primaryBD
            .primaryListDAO().getAll();
  }

  public static void dataBaseClose() {
    if (primaryBD != null) {
      primaryBD.close();
    }
  }
}
