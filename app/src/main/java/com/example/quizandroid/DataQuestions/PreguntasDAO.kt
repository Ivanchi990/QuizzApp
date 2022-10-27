package com.example.quizandroid.DataQuestions

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface PreguntasDAO
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPregunta(pregunta: Pregunta)

    @Query("SELECT * FROM preguntas ORDER BY idPreg ASC;")
    fun readAllData(): Flow<List<Pregunta>>

    @Query("DELETE FROM preguntas;")
    suspend fun borrarTodo()

    @Query("DELETE FROM preguntas WHERE idPreg = idPreg;")
    suspend fun borrarNotasPorIdById(id_nota:Int)
}