package com.example.myapplication.compose.card

import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.R

class CardViewModel : ViewModel() {
    private val _foodList = mutableStateListOf(
        FoodCardModel("FD001", "Burger", 5.99, "Medium", R.drawable.img_burger),
        FoodCardModel("FD002", "Pizza", 8.50, "Large", R.drawable.img_pizza),
        FoodCardModel("FD003", "Fried Chicken", 6.75, "Medium", R.drawable.img_sandwich),
        FoodCardModel("FD004", "Hot Dog", 3.99, "Small", R.drawable.img_cake),
        FoodCardModel("FD005", "French Fries", 2.50, "Medium", R.drawable.img_sandwich),
        FoodCardModel("FD006", "Coca Cola", 1.99, "Large", R.drawable.img_breakfast),
        FoodCardModel("FD007", "Ice Cream", 2.99, "Small", R.drawable.img_ice_cream),
        FoodCardModel("FD008", "Sandwich", 4.25, "Medium", R.drawable.img_sandwich),
        FoodCardModel("FD009", "Spaghetti", 7.20, "Large", R.drawable.img_ice_cream),
        FoodCardModel("FD010", "Cake", 1.50, "Small", R.drawable.img_cake)
    )
    val foodList: List<FoodCardModel> = _foodList

    fun updateCount(foodID: String, increment: Boolean) {
        val index = _foodList.indexOfFirst { it.foodID == foodID }
        if (index != -1) {
            val item = _foodList[index]
            val newCount = if (increment) item.count + 1 else if (item.count > 0) item.count - 1 else 0
            _foodList[index] = item.copy(count = newCount)
        }
    }

    fun removeFood(foodID: String) {
        _foodList.removeIf { it.foodID == foodID }
    }
}

data class FoodCardModel(
    val foodID: String,
    val foodName: String,
    val foodPrice: Double,
    val size: String,
    @DrawableRes val img: Int,
    val count: Int = 0
)
