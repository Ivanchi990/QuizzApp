package com.example.quizandroid.SQLiteBD

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizandroid.R

class PreguntasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    val pregunta_id = itemView.findViewById<TextView>(R.id.textoPreguntaId)
    val pregunta_texto = itemView.findViewById<TextView>(R.id.textoPregunta)

    fun render(id_pregunta: Int, texto_pregunta: String,
               onClickListener: (Int) -> Unit)
    {
        pregunta_id.text = id_pregunta.toString()
        pregunta_texto.text = texto_pregunta.toString()

        pregunta_texto.setOnClickListener {
            onClickListener(id_pregunta)
        }
    }
}