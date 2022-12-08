package com.example.quizandroid.Fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.quizandroid.MainActivity
import com.example.quizandroid.R
import com.example.quizandroid.SQLiteBD.MiBDOpenHelper
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

        Handler(Looper.getMainLooper()).postDelayed({
            siguientePreg()
        }, 3000)

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

            comprobarRes()
        }
        else
        {
            binding?.textView2?.text = "Enhorabuena has fallado"

            binding?.fotoAcierto?.setImageResource(R.drawable.monotriste)
        }
    }


    fun siguientePreg()
    {
        if(marcadorViewModel.getAcertado() == false)
        {
            requireContext().let{
                it.startActivity(Intent(it, MainActivity::class.java))
            }
        }
        else
        {
            if((marcadorViewModel.getPreguntaActual()) == marcadorViewModel.getPreguntas())
            {
                marcadorViewModel.setAcertado(false)

                val transaction = fragmentManager?.beginTransaction()

                val fragmento1 = FragmentResultados()
                transaction?.replace(R.id.fragmentContainerView, fragmento1)
                transaction?.addToBackStack(null)
                transaction?.commit()
            }
            else
            {
                marcadorViewModel.setPreguntaActual()

                marcadorViewModel.setAcertado(false)

                val transaction = fragmentManager?.beginTransaction()

                val fragmento1 = FragmentPreguntas()
                transaction?.replace(R.id.fragmentContainerView, fragmento1)
                transaction?.addToBackStack(null)
                transaction?.commit()
            }
        }
    }


    fun comprobarRes()
    {
        val base = marcadorViewModel.getDatabase()

        val max = base?.obtenerPuntuacionMax()?.getInt(0)

        if(marcadorViewModel.getPreguntaActual() > max!!)
        {
            base.crearPuntuacionMax(max.toString())
        }
    }
}