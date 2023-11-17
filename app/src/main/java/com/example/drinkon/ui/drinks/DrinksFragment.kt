package com.example.drinkon.ui.drinks

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drinkon.R

class DrinksFragment : Fragment() {

    companion object {
        fun newInstance() = DrinksFragment()

    }

    private lateinit var viewModel: DrinksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_drinks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DrinksViewModel::class.java)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewDrinks)
        val drinks = viewModel.getVodkaDrinksMock() // Or your data source
        val adapter = DrinksAdapter(drinks, object : DrinksAdapter.OnDrinkClickListener {
            override fun onDrinkClick(drink: DrinksViewModel.Drink) {
                val intent = Intent(activity, DrinkDetailActivity::class.java)
                intent.putExtra("DRINK_NAME", drink.name)
                intent.putExtra("DRINK_INSTRUCTIONS", drink.instructions)

                val bundle = Bundle()
                bundle.putStringArray("DRINK_INGREDIENTS", drink.ingredients.toTypedArray())
                intent.putExtras(bundle)

                startActivity(intent)
            }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DrinksViewModel::class.java)

        val vodkaDrinks = viewModel.getVodkaDrinksMock()
//        val vodkaDrinks = viewModel.getBloodyMaryMock()

        vodkaDrinks.forEach { drink ->
            Log.d("DrinksFragment", "Drink: ${drink.name}, Ingredients: ${drink.ingredients.joinToString()}, Instructions: ${drink.instructions}")
        }

    }

}

private fun Intent.putExtra(s: String, ingredients: List<String>) {

}
