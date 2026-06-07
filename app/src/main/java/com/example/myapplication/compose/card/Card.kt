package com.example.myapplication.compose.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCard() {
    val foodList = foodList
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Card")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            foodList.forEach { item ->
                FoodCard(item = item)
            }
        }
    }
}

@Composable
fun FoodCard(item: FoodModel) {
    var countItem by remember { mutableStateOf(0) }
    Card(
        Modifier
            .padding(16.dp)
            .height(150.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Row(
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            Box(
                Modifier
                    .width(130.dp)
                    .fillMaxHeight()
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp)),
                    painter = painterResource(item.img),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                Modifier
                    .fillMaxHeight()
                    .padding(start = 8.dp)
                    .weight(1f)

            ) {
                Row(
                    Modifier
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = item.foodName
                    )

                    IconButton(
                        modifier = Modifier
                            .size(24.dp),
                        onClick = {}) {
                        Icon(
                            painterResource(R.drawable.ic_delete),
                            contentDescription = null
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(

                    text = item.foodPrice.toString()
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(

                    text = "Size: ${item.size}"
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
//                            Modifier.padding(start = 8.dp)
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Order:"
                    )

                    IconButton(
                        modifier = Modifier
                            .size(24.dp),
                        onClick = {
                            if (countItem > 0) {
                                countItem--
                            }
                        }) {
                        Icon(
                            painterResource(R.drawable.ic_minus),
                            contentDescription = null
                        )
                    }
                    Text(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        text = "$countItem"
                    )
                    IconButton(
                        modifier = Modifier
                            .size(24.dp),
                        onClick = {
                            countItem++
                        }
                    ) {
                        Icon(
                            painterResource(R.drawable.ic_plus),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenCardPreview() {
    MyApplicationTheme {
        ScreenCard()
    }
}

data class FoodModel(
    val foodID: String,
    val foodName: String,
    val foodPrice: Double,
    val size: String,
    @DrawableRes val img: Int
)

val foodList = listOf(

    FoodModel(
        foodID = "FD001",
        foodName = "Burger",
        foodPrice = 5.99,
        size = "Medium",
        img = R.drawable.img_burger
    ),

    FoodModel(
        foodID = "FD002",
        foodName = "Pizza",
        foodPrice = 8.50,
        size = "Large",
        img = R.drawable.img_pizza
    ),

    FoodModel(
        foodID = "FD003",
        foodName = "Fried Chicken",
        foodPrice = 6.75,
        size = "Medium",
        img = R.drawable.img_sandwich
    ),

    FoodModel(
        foodID = "FD004",
        foodName = "Hot Dog",
        foodPrice = 3.99,
        size = "Small",
        img = R.drawable.img_cake
    ),

    FoodModel(
        foodID = "FD005",
        foodName = "French Fries",
        foodPrice = 2.50,
        size = "Medium",
        img = R.drawable.img_sandwich
    ),

    FoodModel(
        foodID = "FD006",
        foodName = "Coca Cola",
        foodPrice = 1.99,
        size = "Large",
        img = R.drawable.img_breakfast
    ),

    FoodModel(
        foodID = "FD007",
        foodName = "Ice Cream",
        foodPrice = 2.99,
        size = "Small",
        img = R.drawable.img_ice_cream
    ),

    FoodModel(
        foodID = "FD008",
        foodName = "Sandwich",
        foodPrice = 4.25,
        size = "Medium",
        img = R.drawable.img_sandwich
    ),

    FoodModel(
        foodID = "FD009",
        foodName = "Spaghetti",
        foodPrice = 7.20,
        size = "Large",
        img = R.drawable.img_ice_cream
    ),

    FoodModel(
        foodID = "FD010",
        foodName = "Cake",
        foodPrice = 1.50,
        size = "Small",
        img = R.drawable.img_cake
    )
)