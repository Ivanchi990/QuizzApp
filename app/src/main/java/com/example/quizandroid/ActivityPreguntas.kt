package com.example.quizandroid

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizandroid.SQLiteBD.MiBDOpenHelper
import com.example.quizandroid.SQLiteBD.SQLiteRecyclerViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ActivityPreguntas : AppCompatActivity()
{
    private lateinit var preguntas: MiBDOpenHelper
    private lateinit var db: SQLiteDatabase
    private lateinit var miSQLiteRecyclerViewAdapter: SQLiteRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preguntas)

        initRecyclerView()

        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener()
        {
            crearPregunta()
        }
    }

    fun initRecyclerView()
    {
        preguntas = MiBDOpenHelper(this, null)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclePreguntas)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val cursor = preguntas.obtenerPreguntas()

        miSQLiteRecyclerViewAdapter = SQLiteRecyclerViewAdapter()
        miSQLiteRecyclerViewAdapter.SQLiteRecyclerViewAapter(this,  cursor)

        recyclerView.adapter = miSQLiteRecyclerViewAdapter
    }

    fun crearPregunta()
    {

    }
}