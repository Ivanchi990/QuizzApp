package com.example.quizandroid.DataQuestions

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow

class PreguntasViewModel(private val repos: PreguntasRepository): ViewModel()
{
    private val readAllData: Flow<List<Pregunta>> = repos.todasPreguntas

    fun insertarPreg(pregunta: Pregunta) = viewModelScope.launch {
        repos.insertarPregunta(pregunta)
    }
}

class PreguntaViewModelFactory(private val repos: PreguntasRepository): ViewModelProvider.Factory
{
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PreguntasViewModel::class.java))
        {
            @Suppress("UNCHECKED_CAST")
            return PreguntasViewModel(repos) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}