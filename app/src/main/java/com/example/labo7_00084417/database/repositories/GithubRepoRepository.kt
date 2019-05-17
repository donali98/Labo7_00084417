package com.example.labo7_00084417.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.labo7_00084417.database.daos.GithubRepoDao
import com.example.labo7_00084417.database.entities.GithubRepo

class GithubRepoRepository(private val repoDao: GithubRepoDao) {
    //obtener todos
    fun getAll(): LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    //Borrar
    fun nuke() = repoDao.nukeTable()



    //Extrae un hilo del scope para ejecutar una funcion
    @WorkerThread
    suspend fun insert(repo:GithubRepo) = repoDao.insert(repo)
}