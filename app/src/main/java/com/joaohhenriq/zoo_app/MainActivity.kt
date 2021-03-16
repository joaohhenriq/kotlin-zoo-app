package com.joaohhenriq.zoo_app

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_widget.*
import kotlinx.android.synthetic.main.animal_widget.view.*

class MainActivity : AppCompatActivity() {

    var animalList = ArrayList<AnimalModel>()
    var adapter: AnimalsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadAnimals()
    }

    private fun loadAnimals() {
        animalList.add(AnimalModel("Arara", "Arara from a zoo", R.drawable.arara, false))
        animalList.add(AnimalModel("Gireffe", "Gireffe from a zoo", R.drawable.giraffe, false))
        animalList.add(AnimalModel("Lion", "Lion from a zoo", R.drawable.lion, true))
        animalList.add(AnimalModel("Monkey", "Monkey from a zoo", R.drawable.monkey, true))
        animalList.add(AnimalModel("Zebra", "Zebra from a zoo", R.drawable.zebra, false))

        adapter = AnimalsAdapter(this, animalList)
        listViewItems.adapter = adapter
    }

    class AnimalsAdapter: BaseAdapter {
        var animalList = ArrayList<AnimalModel>()
        var context: Context? = null

        constructor(context: Context, animalList: ArrayList<AnimalModel>) : super() {
            this.animalList = animalList
            this.context = context
        }

        // most important
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal: AnimalModel = animalList[position]

            var inflator = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView: View

            myView = if (animal.isDangerous) {
                inflator.inflate(R.layout.dangerou_animal, null)
            } else {
                inflator.inflate(R.layout.animal_widget, null)
            }

            myView.textViewName.text = animal.name
            myView.textViewDescription.text = animal.description
            myView.imageView.setImageResource(animal.image)
            myView.imageView.setOnClickListener {
                val intent = Intent(context, AnimalInfo::class.java)
                intent.putExtra("name", animal.name)
                intent.putExtra("description", animal.description)
                intent.putExtra("image", animal.image)

                context!!.startActivity(intent)
            }
            return myView
        }

        // don't need this
        override fun getItem(position: Int): Any {
            return animalList[position]
        }

        // don't need this
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        // important
        override fun getCount(): Int {
           return animalList.size
        }

    }
}