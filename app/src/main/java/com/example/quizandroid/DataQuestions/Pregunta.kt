package com.example.quizandroid.DataQuestions

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "preguntas")
data class Pregunta
    (
    @PrimaryKey(autoGenerate = true)
    val idPreg: Int,
    val preg: String,
    val respuestas: Array<String>
)