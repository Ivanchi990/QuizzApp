package com.example.quizandroid

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizandroid.SQLiteBD.MiBDOpenHelper
import com.example.quizandroid.SQLiteBD.SQLiteRecyclerViewAdapter


class ActivityPreguntas : AppCompatActivity()
{
    private lateinit var binding:

    private lateinit var preguntasDBHelper: MiBDOpenHelper
    private lateinit var db: SQLiteDatabase
    private lateinit var miSQLiteRecyclerViewAdapter: SQLiteRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivitySqliteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Iniciamos el recyclerview
        initRecyclerView()

        //establecemos el binding al boton de crear nota
        binding.buttonCrearNota.setOnClickListener
        {
            crearNota()
        }
    }

    fun initRecyclerView()
    {
        preguntasDBHelper = MiBDOpenHelper(this, null)

        val cursor = preguntasDBHelper.obtenerPreguntas()
        miSQLiteRecyclerViewAdapter = SQLiteRecyclerViewAdapter()
        miSQLiteRecyclerViewAdapter.SQLiteRecyclerViewAapter(this, cursor)

        binding.recyclerViewNotas.setHasFixedSize(true)
        binding.recyclerViewNotas.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewNotas.adapter = miSQLiteRecyclerViewAdapter
    }
}