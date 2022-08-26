package com.sortname.sorteio.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.sortname.sorteio.model.ListaPrimeiroSemestre;

@Database(entities = {ListaPrimeiroSemestre.class},version = 1, exportSchema = false)
public abstract class AppPrimaryDB extends RoomDatabase {
        public abstract PrimaryListDAO primaryListDAO();
}


