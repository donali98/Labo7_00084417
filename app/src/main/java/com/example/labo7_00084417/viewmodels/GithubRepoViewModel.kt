package com.example.labo7_00084417.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.labo7_00084417.database.RoomDB
import com.example.labo7_00084417.database.entities.GithubRepo
import com.example.labo7_00084417.database.repositories.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app:Application):AndroidViewModel(app) {
    private val repository:GithubRepoRepository

    init {
        val repoDAO = RoomDB.getInstance(app).repoDao()
        repository = GithubRepoRepository(repoDAO)
    }

    fun getRepoList():LiveData<List<GithubRepo>> = repository.getAll()

    fun insert(repo:GithubRepo) = viewModelScope.launch(Dispatchers.IO  ){
        repository.insert(repo)
    }

}