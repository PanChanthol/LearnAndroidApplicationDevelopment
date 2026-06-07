package com.example.myapplication.ecommerceapp.data

import androidx.annotation.DrawableRes
import com.example.myapplication.R

data class Banner(
    val id: Int,
    val tag: String,
    val title: String,
    val description: String,
    val buttonText: String
)

data class Category(
    val id: Int,
    val name: String,
    @DrawableRes val img: Int
)


data class FlashDeal(
    val id: Int,
    val name: String,
    val discountPercent: Int,
    val originalPrice: Double,
    val salePrice: Double,
    val imageRes: String
)

data class BestSellingProduct(
    val id: Int,
    val name: String,
    val rating: Double,
    val price: Double,
    val imageRes: String
)

val banners = listOf(
    Banner(
        id = 1,
        tag = "Summer Sale",
        title = "Up to 50% Off",
        description = "On selected fashion items",
        buttonText = "Shop Now"
    ),
    Banner(
        id = 2,
        tag = "New Arrival",
        title = "Fresh Styles Are Here",
        description = "Explore the latest trends this season",
        buttonText = "Explore Now"
    ),
    Banner(
        id = 3,
        tag = "Flash Deal",
        title = "Buy 2 Get 1 Free",
        description = "Limited time offer on all accessories",
        buttonText = "Grab Deal"
    )
)

val category = listOf(
    Category(id = 1, name = "Women", img = R.drawable.img_women),
    Category(id = 2, name = "Men", img = R.drawable.img_men, ),
    Category(id = 3, name = "Footwear", img = R.drawable.img_women ),
    Category(id = 4, name = "Bags", img = R.drawable.img_men),
    Category(id = 5, name = "Watches", img = R.drawable.img_women)
)
val flashDeals = listOf(
    FlashDeal(
        id = 1,
        name = "Smart Watch",
        discountPercent = 30,
        originalPrice = 99.99,
        salePrice = 69.99,
        imageRes = "img_smart_watch"
    ),
    FlashDeal(
        id = 2,
        name = "Men's Sneakers",
        discountPercent = 25,
        originalPrice = 79.99,
        salePrice = 59.99,
        imageRes = "img_mens_sneakers"
    ),
    FlashDeal(
        id = 3,
        name = "Hand Bag",
        discountPercent = 20,
        originalPrice = 49.99,
        salePrice = 39.99,
        imageRes = "img_hand_bag"
    )
)
val bestSelling = listOf(
    BestSellingProduct(
        id = 1,
        name = "Wireless Headphones",
        rating = 4.5,
        price = 49.99,
        imageRes = "img_headphones"
    ),
    BestSellingProduct(
        id = 2,
        name = "Men's Shirt",
        rating = 4.3,
        price = 29.99,
        imageRes = "img_mens_shirt"
    ),
    BestSellingProduct(
        id = 3,
        name = "Perfume",
        rating = 4.6,
        price = 24.99,
        imageRes = "img_perfume"
    ),
    BestSellingProduct(
        id = 4,
        name = "Backpack",
        rating = 4.4,
        price = 34.99,
        imageRes = "img_backpack"
    )
)
