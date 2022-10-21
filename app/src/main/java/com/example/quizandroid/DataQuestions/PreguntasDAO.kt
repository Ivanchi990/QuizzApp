package com.example.quizandroid.DataQuestions

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PreguntasDAO
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPregunta(pregunta: Pregunta)

    @Query("SELECT * FROM preguntas ORDER BY id  ASC")
    fun readAllData(): LiveData<List<Pregunta>>
}