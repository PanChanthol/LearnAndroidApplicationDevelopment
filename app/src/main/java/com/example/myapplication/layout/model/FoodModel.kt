package com.example.myapplication.layout.model

import androidx.annotation.DrawableRes
import com.example.myapplication.R


data class FoodModel(
    val id: Int,
    @DrawableRes val image: Int,
    val label: String
)

val foodList = listOf(
    FoodModel(
        id = 1,
        image = R.drawable.img_breakfast,
        label = "Breakfast"
    ),
    FoodModel(
        id = 2,
        image = R.drawable.img_burger,
        label = "Burger"
    ),
    FoodModel(
        id = 3,
        image = R.drawable.img_pizza,
        label = "Pizza"
    ),
    FoodModel(
        id = 4,
        image = R.drawable.img_coffee,
        label = "Coffee"
    ),
    FoodModel(
        id = 5,
        image = R.drawable.img_cake,
        label = "Cake"
    ),
    FoodModel(
        id = 6,
        image = R.drawable.img_fried_rice,
        label = "Fried Rice"
    ),
    FoodModel(
        id = 7,
        image = R.drawable.img_noodle,
        label = "Noodle"
    ),
    FoodModel(
        id = 8,
        image = R.drawable.img_ice_cream,
        label = "Ice Cream"
    ),
    FoodModel(
        id = 9,
        image = R.drawable.img_sandwich,
        label = "Sandwich"
    ),
    FoodModel(
        id = 10,
        image = R.drawable.img_steak,
        label = "Steak"
    ),
    FoodModel(
        id = 11,
        image = R.drawable.img_ice_cream,
        label = "Ice Cream"
    ),
    FoodModel(
        id = 12,
        image = R.drawable.img_sandwich,
        label = "Sandwich"
    ),
    FoodModel(
        id = 13,
        image = R.drawable.img_steak,
        label = "Steak"
    )
)