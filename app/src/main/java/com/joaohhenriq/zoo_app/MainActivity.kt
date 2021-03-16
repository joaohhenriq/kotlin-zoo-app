package com.joaohhenriq.zoo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var animalList = ArrayList<AnimalModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadAnimals()
    }

    fun loadAnimals() {
        animalList.add(AnimalModel("Arara", "Arara from a zoo", R.drawable.arara))
        animalList.add(AnimalModel("Gireffe", "Gireffe from a zoo", R.drawable.giraffe))
        animalList.add(AnimalModel("Lion", "Lion from a zoo", R.drawable.lion))
        animalList.add(AnimalModel("Monkey", "Monkey from a zoo", R.drawable.monkey))
        animalList.add(AnimalModel("Zebra", "Zebra from a zoo", R.drawable.zebra))
    }
}