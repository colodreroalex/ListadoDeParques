package com.example.listadeparques.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.listadeparques.Park
import android.view.View
import com.bumptech.glide.Glide
import com.example.listadeparques.databinding.ItemParkBinding

class ParkViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val binding = ItemParkBinding.bind(view)

    fun render(parkModel: Park){
        binding.ParkName.text = parkModel.namePark
        binding.ParkDescription.text = parkModel.description

        Glide.with(binding.ParkPhoto.context).load(parkModel.photo).into(binding.ParkPhoto)
    }
}