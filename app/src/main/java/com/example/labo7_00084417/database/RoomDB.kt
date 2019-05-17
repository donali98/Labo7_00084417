package com.example.labo7_00084417.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.labo7_00084417.database.daos.GithubRepoDao
import com.example.labo7_00084417.database.entities.GithubRepo

@Database(entities = [GithubRepo::class], version = 1, exportSchema = false)
public abstract class RoomDB : RoomDatabase() {

    abstract fun repoDao():GithubRepoDao

    companion object {
        //cuando la instancia cambia, esta cambia tambien en todos los hilos que tenga la aplicacion
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getInstance(AppContext
                        : Context): RoomDB {
            val temp = INSTANCE
            if (temp != null) {
                return temp
            }
            //Hace que los hilos
            synchronized(this) {
                val instance = Room.databaseBuilder(AppContext, RoomDB::class.java, "RepoDB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }

    }
}
