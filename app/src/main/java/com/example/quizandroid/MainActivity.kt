package com.example.quizandroid

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun empezar(view: View)
    {

    }

    fun listarPreguntas(view: View)
    {
        intent = Intent(this, ActivityPreguntas::class.java)

        startActivity(intent)
    }

    fun showInfo(view: View)
    {

    }
}