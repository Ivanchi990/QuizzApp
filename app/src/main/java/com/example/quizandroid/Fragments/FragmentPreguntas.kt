package com.example.quizandroid.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.quizandroid.R
import com.example.quizandroid.databinding.ActivityEmpezarQuizzBinding
import com.example.quizandroid.databinding.FragmentPreguntasBinding

class FragmentPreguntas : Fragment()
{
    private val marcadorViewModel: MarcadorViewModel by activityViewModels()
    private lateinit var binding: FragmentPreguntasBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                    savedInstanceState: Bundle?): View?
    {
        val frag = FragmentPreguntasBinding.inflate(inflater, container, false)
        binding = frag

        binding.comprobarRes.setOnClickListener()
        {
            compronbarRespuesta()
        }

        return frag.root
    }

    fun compronbarRespuesta()
    {
        if(binding.radio.getCheckedRadioButtonId() == -1)
        {
            //binding.Toast.makeText(this, "Tienes que seleccionar una opción", Toast.LENGTH_SHORT).show
        }
    }
}