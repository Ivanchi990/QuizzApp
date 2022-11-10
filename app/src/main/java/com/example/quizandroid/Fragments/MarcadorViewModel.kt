package com.example.quizandroid.Fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizandroid.SQLiteBD.MiBDOpenHelper

class MarcadorViewModel: ViewModel()
{
    private var marcador: MutableLiveData<Int>
    private var preguntaActual = 1
    private var totalPreguntas: Int = 0

    init
    {
        marcador = MutableLiveData<Int>()
    }

    fun setPreguntas(num: Int)
    {
        totalPreguntas = num
    }

    fun getPreguntas(): Int
    {
        return totalPreguntas
    }

    fun getMarcador(): MutableLiveData<Int>
    {
        if (marcador == null)
        {

        }
        return marcador
    }

    fun setPreguntaActual()
    {
        preguntaActual += 1
    }

    fun getPreguntaActual(): Int
    {
        return preguntaActual
    }
}