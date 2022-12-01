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
    var aciertos = 0
    private var marcador: MutableLiveData<String>
    private var maxPuntuacion = 0

    init
    {
        marcador = MutableLiveData<String>()

        marcador.setValue("-Puntuación actual: $aciertos -Puntuación máxima: $maxPuntuacion")
    }

    fun setAcertado(estado: Boolean)
    {
        if(estado)
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

    fun getMaxAcertado():Int
    {
        return base!!.getMax()
    }

    fun setMaxAcertado2(num: Int)
    {
        base!!.setMax(num)
        maxPuntuacion = num
    }

    fun setMaxAcertado()
    {
        base!!.setMax(maxPuntuacion + 1)
    }


    fun getPreguntas(): Int
    {
        return totalPreguntas
    }

    fun getMarcador(): MutableLiveData<String>
    {
        if (marcador == null)
        {
        }
        return marcador
    }

    fun setMarcador()
    {
        marcador.setValue("-Puntuación actual: $aciertos -Puntuación máxima: $maxPuntuacion")
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