package com.example.quizandroid.DataQuestions

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class PreguntasAplication :Application()
{
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy{PreguntasBD.getDB(this, applicationScope)}
    val repository by lazy { PreguntasRepository(database.preguntasDAO()) }
}