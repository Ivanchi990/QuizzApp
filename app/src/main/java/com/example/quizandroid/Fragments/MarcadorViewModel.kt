package com.example.quizandroid.Fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizandroid.SQLiteBD.MiBDOpenHelper

class MarcadorViewModel: ViewModel()
{
    private var base: MiBDOpenHelper? = null
    private var preguntaActual = 1
    private var totalPreguntas: Int = 0
    private var acertado = false
    private var aciertos = 0
    private var marcador: MutableLiveData<Int>

    init
    {
        marcador = MutableLiveData<Int>()
    }

    fun setAcertado(estado: Boolean)
    {
        if(estado == true)
            aciertos += 1

        this.acertado = estado
    }

    fun getAcertado(): Boolean
    {
        return acertado
    }

    fun setDatabase(b: MiBDOpenHelper)
    {
        this.base = b
    }

    fun getDatabase():MiBDOpenHelper?
    {
        return base
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

    fun setMarcador()
    {
        val aux: Int = marcador.value ?: 0
        marcador.setValue(aux + 1)
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