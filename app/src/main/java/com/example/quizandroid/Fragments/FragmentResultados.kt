package com.example.quizandroid.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizandroid.CrearPregunta
import com.example.quizandroid.R
import com.example.quizandroid.databinding.FragmentPreguntasBinding
import com.example.quizandroid.databinding.FragmentResultadosBinding

class FragmentResultados : Fragment()
{
    private var binding: FragmentResultadosBinding? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        val frag = FragmentResultadosBinding.inflate(inflater, container, false)
        binding = frag

        cargarFin()

        return frag.root
    }


    fun cargarFin()
    {

    }
}