package com.joaohhenriq.zoo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_info.*

class AnimalInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)

        val bundle: Bundle = intent.extras!!

        val name = bundle.getString("name")
        val description = bundle.getString("description")
        val image = bundle.getInt("image")

        imageViewAnimal.setImageResource(image)
        textViewName.text = name
        textViewDescription.text = description
    }
}