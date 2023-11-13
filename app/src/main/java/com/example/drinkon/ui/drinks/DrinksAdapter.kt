package com.example.drinkon.ui.drinks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.drinkon.R

class DrinksAdapter(private val drinks: List<DrinksViewModel.Drink>) : RecyclerView.Adapter<DrinksAdapter.DrinkViewHolder>() {

    class DrinkViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameView: TextView = view.findViewById(R.id.name)
        private val ingredientsView: TextView = view.findViewById(R.id.ingredients)
        private val instructionsView: TextView = view.findViewById(R.id.instructions)

        fun bind(drink: DrinksViewModel.Drink) {
            nameView.text = drink.name
            ingredientsView.text = drink.ingredients.joinToString("\n")
            instructionsView.text = drink.instructions
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_drink, parent, false)
        return DrinkViewHolder(view)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.bind(drinks[position])
    }

    override fun getItemCount() = drinks.size
}
