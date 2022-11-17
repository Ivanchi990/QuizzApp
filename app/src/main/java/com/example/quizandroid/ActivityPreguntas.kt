package com.example.quizandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizandroid.SQLiteBD.MiBDOpenHelper
import com.example.quizandroid.SQLiteBD.SQLiteRecyclerViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ActivityPreguntas : AppCompatActivity()
{
    private lateinit var preguntas: MiBDOpenHelper
    private lateinit var miSQLiteRecyclerViewAdapter: SQLiteRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preguntas)

        preguntas = MiBDOpenHelper(this, null)

        initRecyclerView()

        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener()
        {
            crearPregunta()
        }
    }

    fun initRecyclerView()
    {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclePreguntas)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val cursor = preguntas.obtenerPreguntas()

        miSQLiteRecyclerViewAdapter = SQLiteRecyclerViewAdapter(
            onClickListener = { pos -> dameID(pos) }
        )

        miSQLiteRecyclerViewAdapter.SQLiteRecyclerViewAapter(this,  cursor)

        recyclerView.adapter = miSQLiteRecyclerViewAdapter
    }

    fun crearPregunta()
    {
        intent = Intent(this, CrearTitulo::class.java)

        startActivity(intent)
    }

    fun dameID(pos: Int)
    {
        intent = Intent(this, MostrarPregunta::class.java).apply {
            putExtra("id", pos)
        }

        startActivity(intent)
    }
}