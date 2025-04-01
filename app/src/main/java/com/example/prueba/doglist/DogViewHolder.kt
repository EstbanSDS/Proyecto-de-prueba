package com.example.prueba.doglist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.databinding.ItemDogBinding
import com.squareup.picasso.Picasso

class DogViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemDogBinding.bind(view)

    // Este metodo es el que se va a llamar por cada item que venga en la data
    fun bind(image: String) {
        Picasso.get().load(image).into(binding.ivDog)
    }
}