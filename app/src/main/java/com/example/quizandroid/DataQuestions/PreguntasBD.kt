package com.example.quizandroid.DataQuestions

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Pregunta::class], version = 1, exportSchema = false)
abstract class PreguntasBD: RoomDatabase()
{
    abstract fun preguntasDAO(): PreguntasDAO

    companion object
    {
        @Volatile
        private var INSTANCE: PreguntasBD? = null

        fun getDB(context: Context, scope: CoroutineScope): PreguntasBD
        {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PreguntasBD::class.java,
                    ""
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(PreguntasBDCallback(scope))
                    .build()
                    INSTANCE = instance
                    instance
            }
        }
    }


    class PreguntasBDCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.preguntasDAO())
                }
            }
        }

        suspend fun populateDatabase(preguntasDAO: PreguntasDAO) {
            // Borramos el contenido
            preguntasDAO.borrarTodo()

            // Añadimos una nota
            var pregunta = Pregunta(preg = "¿Qué tal estas?", respuesta1 = "Bien", respuesta2 = "Regular", respuesta3 = "Genial", respuesta4 = "Como la mierda")
            preguntasDAO.addPregunta(pregunta)
        }
    }
}