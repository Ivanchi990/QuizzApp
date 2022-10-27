package com.example.quizandroid.DataQuestions

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class PreguntasRepository(private val preguntasDAO: PreguntasDAO)
{
    val todasPreguntas: Flow<List<Pregunta>> = preguntasDAO.readAllData()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertarPregunta(pregunta: Pregunta)
    {
        preguntasDAO.addPregunta(pregunta)
    }
}