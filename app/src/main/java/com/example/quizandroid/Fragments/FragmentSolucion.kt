package com.example.quizandroid.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.quizandroid.R
import com.example.quizandroid.databinding.FragmentSolucionBinding

class FragmentSolucion : Fragment()
{
    private val marcadorViewModel: MarcadorViewModel by activityViewModels()
    private var binding: FragmentSolucionBinding? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                savedInstanceState: Bundle?): View?
    {

        val frag = FragmentSolucionBinding.inflate(inflater, container, false)
        binding = frag

        cargarSolucion()

        binding?.nextPreg?.setOnClickListener()
        {
            siguientePreg()
        }

        return frag.root
        return inflater.inflate(R.layout.fragment_solucion, container, false)
    }


    fun cargarSolucion()
    {
        if(marcadorViewModel.getAcertado())
        {
            marcadorViewModel.setMarcador()

            binding?.textView2?.text = "Enhorabuena has acertado"

            binding?.fotoAcierto?.setImageResource(R.drawable.monofeliz)
        }
        else
        {
            binding?.textView2?.text = "Enhorabuena has fallado"

            binding?.fotoAcierto?.setImageResource(R.drawable.monotriste)
        }
    }


    fun siguientePreg()
    {
        if(marcadorViewModel.getPreguntas() == marcadorViewModel.getPreguntaActual())
        {
            val transaction = fragmentManager?.beginTransaction()

            val fragmento1 = FragmentResultados()
            transaction?.replace(R.id.fragmentContainerView, fragmento1)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
        else
        {
            marcadorViewModel.setAcertado(false)

            val transaction = fragmentManager?.beginTransaction()

            val fragmento1 = FragmentPreguntas()
            transaction?.replace(R.id.fragmentContainerView, fragmento1)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
    }
}