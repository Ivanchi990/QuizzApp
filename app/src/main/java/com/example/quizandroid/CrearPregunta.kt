package com.example.quizandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.quizandroid.SQLiteBD.MiBDOpenHelper

class CrearPregunta : AppCompatActivity()
{
    private lateinit var pregunta: String
    private lateinit var res1: EditText
    private lateinit var res2: EditText
    private lateinit var res3: EditText
    private lateinit var res4: EditText

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_pregunta)

        pregunta = intent.getStringExtra("preg").toString()
    }

    fun volver(view: View)
    {
        res1 = findViewById<EditText>(R.id.getRes1)
        res2 = findViewById<EditText>(R.id.getRes2)
        res3 = findViewById<EditText>(R.id.getRes3)
        res4 = findViewById<EditText>(R.id.getRes4)

        if(res1.text.toString().equals("")
            || res2.text.toString().equals("") || res3.text.toString().equals("") || res4.text.toString().equals(""))
        {
            Toast.makeText(this, "Lo siento no puede haber campos vacios.", Toast.LENGTH_SHORT).show()
        }
        else
        {
            var preguntas = MiBDOpenHelper(this, null)

            preguntas.crearPregunta(pregunta, res1.text.toString(), res2.text.toString(), res3.text.toString(), res4.text.toString())

            intent = Intent(this, ActivityPreguntas::class.java)

            startActivity(intent)
        }
    }
}