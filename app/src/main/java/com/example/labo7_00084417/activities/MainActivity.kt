package com.example.labo7_00084417.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.labo7_00084417.R
import com.example.labo7_00084417.database.entities.GithubRepo

import com.example.labo7_00084417.viewmodels.GithubRepoViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel:GithubRepoViewModel
    lateinit var btnAction:Button
    var contador:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAction = findViewById(R.id.btn_accion)
        bind()
    }
    private fun bind(){
        viewModel = ViewModelProviders.of(this@MainActivity).get(GithubRepoViewModel::class.java)
        viewModel.getRepoList().observe(this, Observer {
            Log.d("Repos","--------------------------------------------")
            for( i in 0 until it.size){
                Log.d("Repos",it[i].name)

            }
        })
        btnAction.setOnClickListener {
            viewModel.insert(GithubRepo("Repositorio #$contador"))
            contador++
        }

    }
}
