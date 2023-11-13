package com.example.drinkon.ui.drinks

import androidx.lifecycle.ViewModel

class DrinksViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    data class Drink(
        val name: String,
        val ingredients: List<String>,
        val instructions: String
    )

    fun getBloodyMaryMock(): Drink {
        return Drink(
            name = "Bloody Mary",
            ingredients = listOf(
                "4.5 cl (3 parts) vodka",
                "9 cl (6 parts) Tomato juice",
                "1.5 cl (1 part) Lemon juice",
                "2 to 3 dashes of Worcestershire Sauce",
                "Tabasco sauce",
                "Celery salt",
                "Black pepper"
            ),
            instructions = "Stirring gently, pour all ingredients into highball glass. Garnish."
        )
    }

    fun getVodkaDrinksMock(): List<Drink> {
        return listOf(
            Drink(
                name = "Vodka Gimlet",
                ingredients = listOf(
                    "Two to four parts gin",
                    "One part sweetened lime juice"
                ),
                instructions = "Mix and serve. Garnish with a slice of lime"
            ),
            Drink(
                name = "Vodka Martini",
                ingredients = listOf(
                    "6 cl (6 parts) vodka",
                    "1 cl (1 parts) dry vermouth"
                ),
                instructions = "Straight: Pour all ingredients into mixing glass with ice cubes. Shake well. Strain in chilled martini cocktail glass. Squeeze oil from lemon peel onto the drink, or garnish with olive."
            )
        )
    }


}