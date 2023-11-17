package com.example.drinkon.ui.drinks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.drinkon.R

class DrinksAdapter(
    private val drinks: List<DrinksViewModel.Drink>,
    private val listener: OnDrinkClickListener
) : RecyclerView.Adapter<DrinksAdapter.DrinkViewHolder>() {

    interface OnDrinkClickListener {
        fun onDrinkClick(drink: DrinksViewModel.Drink)
    }

    class DrinkViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameView: TextView = view.findViewById(R.id.name)
        private val ingredientsView: TextView = view.findViewById(R.id.ingredients)

        fun bind(drink: DrinksViewModel.Drink, listener: OnDrinkClickListener) {
            nameView.text = drink.name
            ingredientsView.text = drink.ingredients.joinToString("\n")

            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    listener.onDrinkClick(drink)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_drink, parent, false)
        return DrinkViewHolder(view)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        val drink = drinks[position]
        holder.bind(drink, listener)
    }

    override fun getItemCount() = drinks.size
}
