package com.example.demomvpretrofit.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demomvpretrofit.Adapters.PerroAdapter
import com.example.demomvpretrofit.Presenters.DogPresenter
import com.example.demomvpretrofit.R
import com.example.demomvpretrofit.ViewsListeners.DogsViewListener
import com.example.demomvpretrofit.databinding.FragmentDogsListBinding

class DogsListFragment : Fragment() , DogsViewListener {

    private lateinit var _binding: FragmentDogsListBinding
    private val binding get()= _binding!!
    lateinit var  presentador : DogPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presentador= DogPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentDogsListBinding.inflate(inflater)
        presentador.consumirListaPerros()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presentador.consumirListaPerros()
    }

    override fun onGetDogListSucces(lista: ArrayList<String>) {
        //Toast.makeText(activity, "Tamanio = ${lista.size}", Toast.LENGTH_SHORT).show()
        val adaptador= PerroAdapter(lista)
        binding.recyclerPerros.adapter=adaptador
        binding.recyclerPerros.layoutManager= LinearLayoutManager(activity)
    }

    override fun onGetListFail(mensaje: String) {
        Toast.makeText(activity, mensaje, Toast.LENGTH_SHORT).show()
    }

}