package com.example.myapplication.compose.card

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCard(viewModel: CardViewModel = viewModel()) {
    val foodList = viewModel.foodList
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
                FoodCard(
                    item = item,
                    onIncrement = { viewModel.updateCount(item.foodID, true) },
                    onDecrement = { viewModel.updateCount(item.foodID, false) },
                    onDelete = { viewModel.removeFood(item.foodID) }
                )
            }
        }
    }
}

@Composable
fun FoodCard(
    item: FoodCardModel,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onDelete: () -> Unit
) {
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
                        onClick = onDelete) {
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
                        onClick = onDecrement) {
                        Icon(
                            painterResource(R.drawable.ic_minus),
                            contentDescription = null
                        )
                    }
                    Text(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        text = "${item.count}"
                    )
                    IconButton(
                        modifier = Modifier
                            .size(24.dp),
                        onClick = onIncrement
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
