package com.example.quizandroid.DataQuestions

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "preguntas")
data class Pregunta
    (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "idPreg") val idPreg: Int =0,
    val preg: String,
    val respuesta1: String,
    val respuesta2: String,
    val respuesta3: String,
    val respuesta4: String
)