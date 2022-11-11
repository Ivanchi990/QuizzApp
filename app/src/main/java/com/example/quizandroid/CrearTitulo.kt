package com.example.quizandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CrearTitulo : AppCompatActivity()
{
    private lateinit var boton: Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_titulo)

        boton = findViewById(R.id.crearRes)
    }

    fun comprobarPregunta(view: View)
    {
        val texto = findViewById<EditText>(R.id.datoPregunta).text.toString()

        if(texto != "")
        {
            intent = Intent(this, CrearPregunta::class.java).apply {
                putExtra("preg", texto)
            }

            startActivity(intent)
        }
        else
        {
            Toast.makeText(this, "No puedes dejar ese campo vacio.", Toast.LENGTH_SHORT).show()
        }
    }
}