package com.example.labo7_00084417.database.daos

import android.media.MediaPlayer
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.labo7_00084417.database.entities.GithubRepo


@Dao
interface GithubRepoDao {

    @Query("SELECT * FROM repos")
    fun getAllRepos(): LiveData<List<GithubRepo>>

    @Query("DELETE FROM repos")
    fun nukeTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo: GithubRepo)
}
