package com.example.listadeparques

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadeparques.databinding.ActivityMainBinding
import androidx.recyclerview.widget.GridLayoutManager
import com.example.listadeparques.adapter.ParkAdapter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val decoration = DividerItemDecoration(this, GridLayoutManager.VERTICAL)
        val manager = LinearLayoutManager(this)
        val adapter = ParkAdapter(ParkProvider.parkList)

        binding.recycler.layoutManager = manager //LinearLayoutManager(this)
        binding.recycler.adapter = adapter
        binding.recycler.addItemDecoration(decoration)



        //Filtrado por nombre de parque - Crear funcion en ParkAdapter
        binding.idFiltro.addTextChangedListener {filtro ->
            val filtroParque = ParkProvider.parkList.filter { park ->
                park.namePark.lowercase().contains(filtro.toString())  }
            adapter.actualizarParques(filtroParque)
        }



    }
}