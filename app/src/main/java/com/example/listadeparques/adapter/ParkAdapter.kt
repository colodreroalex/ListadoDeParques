package com.example.listadeparques.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listadeparques.Park
import com.example.listadeparques.R


class ParkAdapter(private var parkList:List<Park>): RecyclerView.Adapter<ParkViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return ParkViewHolder(layoutInflater.inflate(R.layout.item_park, parent, false))
    }

    override fun getItemCount(): Int {
        return  parkList.size
    }

    override fun onBindViewHolder(holder: ParkViewHolder, position: Int) {
        val item = parkList[position]
        holder.render(item)
    }

    fun actualizarParques(listaparque: List<Park>) {
        this.parkList = listaparque
        notifyDataSetChanged()
    }

}