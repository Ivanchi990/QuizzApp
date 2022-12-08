package com.example.quizandroid

import android.content.Intent
import android.net.Uri
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import com.example.quizandroid.Fragments.MarcadorViewModel
import com.example.quizandroid.SQLiteBD.MiBDOpenHelper

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun empezar(view: View)
    {
        val base = MiBDOpenHelper(this, null)

        val cursor = base.obtenerPreguntas()

        if(cursor.count == 0)
        {
            Toast.makeText(this, "No puedes jugar sin antes crear preguntas.", Toast.LENGTH_SHORT).show()
        }
        else
        {
            intent = Intent(this, EmpezarQuizz::class.java)

            startActivity(intent)
        }
    }

    fun listarPreguntas(view: View)
    {
        intent = Intent(this, ActivityPreguntas::class.java)

        startActivity(intent)
    }

    fun showInfo(view: View)
    {
        var url = "https://aulavirtual33.educa.madrid.org/ies.goya.madrid/"

        var uri = Uri.parse(url)
        intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}