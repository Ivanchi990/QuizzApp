package com.example.quizandroid.DataQuestions

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Pregunta::class], version = 1, exportSchema = false)
abstract class PreguntasBD: RoomDatabase()
{
    abstract fun preguntasDAO(): PreguntasDAO

    companion object
    {
        @Volatile
        private var INSTANCE: PreguntasBD? = null

        fun getDB(context: Context): PreguntasBD
        {

        }
    }
}