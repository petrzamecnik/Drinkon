package com.example.drinkon.ui.drinks

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.drinkon.R

class DrinkDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_detail)

        // get drink info
        val bundle = intent.extras
        val drinkName = intent.getStringExtra("DRINK_NAME")
        val drinkInstructions = intent.getStringExtra("DRINK_INSTRUCTIONS")
        val drinkIngredients = bundle?.getStringArray("DRINK_INGREDIENTS")


        // update UI
        val textViewName: TextView = findViewById(R.id.textViewName)
        textViewName.text = drinkName

    }
}
