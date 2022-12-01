package com.example.quizandroid.SQLiteBD

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.quizandroid.ActivityPreguntas

class MiBDOpenHelper(contex: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(contex, DATABASE_NAME, factory, DATABASE_VERSION) {

    val TAG = "SQLite"

    companion object
    {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "preguntas.db"
        //tabla preguntas
        val TABLA_PREGUNTAS = "preguntas"
        val COLUMNA_ID = "id_preg"
        val COLUMNA_TEXTO = "texto_preg"
        val COLUMNA_RES1 = "res_1"
        val COLUMNA_RES2 = "res_2"
        val COLUMNA_RES3 = "res_3"
        val COLUMNA_RES4 = "res_4"
        //tabla resultado
        val TABLA_RESULTADOMAX = "resultadoMax"
        val PUNTUACION_MAX = "puntuacionMax"
    }



    override fun onCreate(db: SQLiteDatabase?)
    {
        try
        {
            var crearTablaPreguntas = "CREATE TABLE $TABLA_PREGUNTAS ($COLUMNA_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMNA_TEXTO TEXT, $COLUMNA_RES1 TEXT, $COLUMNA_RES2 TEXT, $COLUMNA_RES3 TEXT, $COLUMNA_RES4 TEXT)"
            var crearTablaResultados = "CREATE TABLE $TABLA_RESULTADOMAX ($PUNTUACION_MAX INTEGER)"

            db!!.execSQL(crearTablaPreguntas)
            db!!.execSQL(crearTablaResultados)

            setMax(0)
        }
        catch (e: SQLiteException)
        {
            Log.e("$TAG (onCreate)", e.message.toString())
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
        try
        {
            val dropTablaPreguntas = "DROP TABLE IF EXISTS $TABLA_PREGUNTAS"
            val dropTablaResultados = "DROP TABLE IF EXISTS $TABLA_RESULTADOMAX"

            db!!.execSQL(dropTablaPreguntas)
            db!!.execSQL(dropTablaResultados)
            onCreate(db)
        }
        catch (e: SQLiteException)
        {
            Log.e("$TAG (onUpgrade)", e.message.toString())
        }
    }

    override fun onOpen(db: SQLiteDatabase?)
    {
        super.onOpen(db)
        Log.e("$TAG (onOpen)", "Base de datos abierta")
    }

    fun crearPregunta(textoPregunta: String, res1: String, res2: String, res3: String, res4: String)
    {
        val data = ContentValues()
        data.put(COLUMNA_TEXTO,textoPregunta)

        data.put(COLUMNA_RES1,res1)
        data.put(COLUMNA_RES2,res2)
        data.put(COLUMNA_RES3,res3)
        data.put(COLUMNA_RES4,res4)

        val db= this.writableDatabase
        db.insert(TABLA_PREGUNTAS,null,data)
        db.close()
    }

    fun obtenerPreguntas():Cursor
    {
        val db= this.readableDatabase
        var cursor = db.rawQuery("SELECT * FROM ${MiBDOpenHelper.TABLA_PREGUNTAS}", null)

        return cursor
    }

    fun obtenerPregunta(id: Int):Cursor
    {
        val db= this.readableDatabase
        var cursor = db.rawQuery("SELECT * FROM ${MiBDOpenHelper.TABLA_PREGUNTAS} WHERE $COLUMNA_ID= $id", null)

        cursor.moveToFirst()

        return cursor
    }

    fun getMax(): Int
    {
        val db= this.readableDatabase
        var cursor = db.rawQuery("SELECT * FROM ${MiBDOpenHelper.TABLA_RESULTADOMAX}", null)

        if(cursor.moveToFirst())
            return cursor.getInt(0)

        return 0
    }

    fun setMax(max: Int)
    {
        val db= this.writableDatabase

        db.execSQL("DELETE FROM $TABLA_RESULTADOMAX")

        val data = ContentValues()
        data.put(PUNTUACION_MAX,max)

        db.insert(TABLA_RESULTADOMAX,null,data)
        db.close()
    }
}