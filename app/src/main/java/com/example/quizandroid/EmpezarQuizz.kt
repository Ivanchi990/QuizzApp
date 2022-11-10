package com.example.quizandroid

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
    private lateinit var binding: ActivityEmpezarQuizzBinding
    private val marcadorViewModel: MarcadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityEmpezarQuizzBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val base = MiBDOpenHelper(this, null)
        var cursor = base.obtenerPreguntas()

        marcadorViewModel.setPreguntas(cursor.count)

        val nameObserver = Observer<Int>{ valor ->
            binding.mostrarPuntos?.setText(valor.toString())
        }

        marcadorViewModel.getMarcador().observe(this, nameObserver)
    }
}