package com.example.quizandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.quizandroid.SQLiteBD.MiBDOpenHelper

class MostrarPregunta : AppCompatActivity()
{
    private lateinit var texto: String

    private lateinit var textoPreg: TextView
    private lateinit var textoRes1: TextView
    private lateinit var textoRes2: TextView
    private lateinit var textoRes3: TextView
    private lateinit var textoRes4: TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_pregunta)

        textoPreg = findViewById(R.id.textoPreg)
        textoRes1 = findViewById(R.id.textoRes1)
        textoRes2 = findViewById(R.id.textoRes2)
        textoRes3 = findViewById(R.id.textoRes3)
        textoRes4 = findViewById(R.id.textoRes4)

        texto = intent.getStringExtra("id").toString()

        mostraPregunta()
    }

    fun mostraPregunta()
    {
        val preg = MiBDOpenHelper(this, null)

        val cursor = preg.obtenerPregunta(texto)

        textoPreg.text = cursor.getString(1)
        textoRes1.text = cursor.getString(2)
        textoRes2.text = cursor.getString(3)
        textoRes3.text = cursor.getString(4)
        textoRes4.text = cursor.getString(5)

        cursor.close()
    }


    fun back(view: View)
    {
        intent = Intent(this, ActivityPreguntas::class.java)

        startActivity(intent)
    }
}