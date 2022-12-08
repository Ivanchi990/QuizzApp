package com.example.quizandroid.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.quizandroid.R
import com.example.quizandroid.SQLiteBD.MiBDOpenHelper
import com.example.quizandroid.databinding.ActivityEmpezarQuizzBinding
import com.example.quizandroid.databinding.FragmentPreguntasBinding

class FragmentPreguntas : Fragment()
{
    private val marcadorViewModel: MarcadorViewModel by activityViewModels()
    private lateinit var base: MiBDOpenHelper
    private var binding: FragmentPreguntasBinding? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                    savedInstanceState: Bundle?): View?
    {
        if(marcadorViewModel.getPreguntaActual() > marcadorViewModel.getMaxAcertado())
        {
            marcadorViewModel.setMaxAcertado()
        }

        base = marcadorViewModel.getDatabase()!!

        val frag = FragmentPreguntasBinding.inflate(inflater, container, false)
        binding = frag

        cargarTodo()

        binding?.comprobarRes?.setOnClickListener()
        {
            compronbarRespuesta()
        }

        return frag.root
    }

    fun cargarTodo()
    {
        val pregunta = base.obtenerPregunta(marcadorViewModel.getPreguntaActual())

        binding?.textoPreguntas?.text = pregunta.getString(1)

        binding?.res1?.text = pregunta.getString(2)
        binding?.res2?.text = pregunta.getString(3)
        binding?.res3?.text = pregunta.getString(4)
        binding?.res4?.text = pregunta.getString(5)
    }

    fun compronbarRespuesta()
    {
        if(binding?.radio?.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(this.context, "Tienes que seleccionar una opción",
                        Toast.LENGTH_SHORT).show()
        }
        else
        {
            if (base != null)
            {
                val soluciones = base.obtenerPregunta(marcadorViewModel.getPreguntaActual())

                val correcta = soluciones.getString(5)

                if((binding?.res1?.isChecked == true && binding!!.res1.text.equals(correcta))
                    || (binding?.res2?.isChecked == true  && binding!!.res2.text.equals(correcta))
                    || (binding?.res3?.isChecked == true && binding!!.res3.text.equals(correcta))
                    || (binding?.res4?.isChecked == true && binding!!.res4.text.equals(correcta)))
                {
                    marcadorViewModel.setAcertado(true)
                }

                val transaction= fragmentManager?.beginTransaction()
                val fragmento2 = FragmentSolucion()

                transaction?.replace(R.id.fragmentContainerView,fragmento2)
                transaction?.addToBackStack(null)
                transaction?.commit()
            }
        }
    }
}