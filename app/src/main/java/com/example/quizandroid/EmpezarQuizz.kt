package com.example.quizandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.quizandroid.Fragments.MarcadorViewModel
import com.example.quizandroid.SQLiteBD.MiBDOpenHelper
import com.example.quizandroid.databinding.ActivityEmpezarQuizzBinding

class EmpezarQuizz : AppCompatActivity()
{
    private var binding: ActivityEmpezarQuizzBinding? = null
    private val marcadorViewModel: MarcadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityEmpezarQuizzBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        val base = MiBDOpenHelper(this, null)

        marcadorViewModel.setDatabase(base)

        var cursor = base.obtenerPreguntas()

        marcadorViewModel.setPreguntas(cursor.count)

        val nameObserver = Observer<String>{ valor ->
            binding!!.mostrarPuntos?.setText(valor.toString())
        }

        marcadorViewModel.getMarcador().observe(this, nameObserver)

        if(marcadorViewModel.getPreguntaActual() > marcadorViewModel.getPreguntas())
        {
            intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

        var max = base.obtenerPuntuacionMax()
        var puntuacionMaxima:Int = max.getInt(0)

        binding!!.mostrarPuntos.text = puntuacionMaxima.toString()

        binding?.fabHome?.setOnClickListener{
            intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
    }
}