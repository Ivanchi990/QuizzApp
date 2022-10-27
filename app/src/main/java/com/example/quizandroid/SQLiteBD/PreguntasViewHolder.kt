package com.example.quizandroid.SQLiteBD

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizandroid.R

class PreguntasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val pregunta_id = itemView.findViewById<TextView>(R.id.textoPreguntaId)
    val pregunta_texto = itemView.findViewById<TextView>(R.id.textoPregunta)
    val res1 = itemView.findViewById<TextView>(R.id.textoRespuesta1)
    val res2 = itemView.findViewById<TextView>(R.id.textoRespuesta2)
    val res3 = itemView.findViewById<TextView>(R.id.textoRespuesta3)
    val res4 = itemView.findViewById<TextView>(R.id.textoRespuesta4)

    fun render(id_pregunta: Int, texto_pregunta: String, texto_res1:String, texto_res2:String, texto_res3:String, texto_res4:String)
    {
        pregunta_id.text = id_pregunta.toString()
        pregunta_texto.text = texto_pregunta.toString()

        res1.text = texto_res1.toString()
        res2.text = texto_res2.toString()
        res3.text = texto_res3.toString()
        res4.text = texto_res4.toString()
    }
}