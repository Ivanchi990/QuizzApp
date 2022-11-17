package com.example.quizandroid.SQLiteBD

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizandroid.R

class SQLiteRecyclerViewAdapter(
    private val onClickListener: (Int) -> Unit
): RecyclerView.Adapter<PreguntasViewHolder>()
{
    private lateinit var context: Context
    private lateinit var cursor: Cursor

    fun SQLiteRecyclerViewAapter(context: Context, cursor: Cursor)
    {
        this.context = context
        this.cursor = cursor
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreguntasViewHolder
    {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PreguntasViewHolder(layoutInflater.inflate(R.layout.item_pregunta, parent, false))
    }

    //Renederizamos cada elemento de la lista
    override fun onBindViewHolder(holder: PreguntasViewHolder, position: Int)
    {
        cursor.moveToPosition(position)
        holder.render(cursor.getInt(0),cursor.getString(1), onClickListener)
    }

    //Obtenemos el tamaño de la lista
    override fun getItemCount(): Int
    {
        return cursor.count
    }
}