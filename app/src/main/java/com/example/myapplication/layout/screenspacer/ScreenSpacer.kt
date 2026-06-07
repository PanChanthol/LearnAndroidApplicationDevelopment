package com.example.myapplication.layout.screenspacer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSpacer() {

    Scaffold(
        containerColor = Color.White,
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                },
                title = {
                    Text(
                        text = "Spacer Layout"
                    )
                },
                colors = topAppBarColors(
                    containerColor = Color(0xFF1976D2),
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {
                Spacer(modifier = Modifier.height(16.dp))

                CreditCard()

                Spacer(modifier = Modifier.height(12.dp))
            }

            items(transactions) { transaction ->
                TransactionCard(transaction)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun CreditCard() {

    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF11998E),
                        Color(0xFF38EF7D)
                    )
                )
            )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Credit Card",
                modifier = Modifier.padding(start = 20.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "VISA",
                modifier = Modifier.padding(end = 20.dp),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "$ 100 000",
                modifier = Modifier.padding(end = 20.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        Column(
            modifier = Modifier.padding(start = 20.dp)
        ) {

            Text(
                text = "Card Number",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "1234 5678 9012 3456",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun TransactionCard(transaction: TransactionModel) {

    Row(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFE8F5E9)),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier
                .padding(start = 12.dp)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(90.dp)
                    .clip(RoundedCornerShape(12.dp)),
                painter = painterResource(R.mipmap.ic_launcher_foreground),
                contentDescription = "",
                contentScale = ContentScale.FillHeight
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {

                Text(
                    text = transaction.id,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = transaction.description,
                    color = Color.DarkGray,
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = transaction.date,
                    color = Color.Gray,
                    fontSize = 13.sp
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            modifier = Modifier.padding(end = 16.dp),
            text = "- ${transaction.amount} USD",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Red
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenSpacerPreview() {

    MyApplicationTheme {
        ScreenSpacer()
    }
}

data class TransactionModel(
    val id: String,
    val amount: Double,
    val date: String,
    val description: String
)

val transactions = listOf(

    TransactionModel(
        "T001",
        100.0,
        "2026-02-07",
        "Food"
    ),

    TransactionModel(
        "T002",
        250.0,
        "2026-02-07",
        "Shopping"
    ),

    TransactionModel(
        "T003",
        75.0,
        "2026-02-08",
        "Transport"
    ),

    TransactionModel(
        "T004",
        300.0,
        "2026-02-08",
        "Electronics"
    ),

    TransactionModel(
        "T005",
        120.0,
        "2026-02-09",
        "Coffee"
    ),

    TransactionModel(
        "T006",
        90.0,
        "2026-02-09",
        "Movie"
    ),

    TransactionModel(
        "T007",
        500.0,
        "2026-02-10",
        "Laptop"
    ),

    TransactionModel(
        "T008",
        40.0,
        "2026-02-10",
        "Snacks"
    ),

    TransactionModel(
        "T009",
        60.0,
        "2026-02-11",
        "Fuel"
    ),

    TransactionModel(
        "T010",
        180.0,
        "2026-02-11",
        "Clothes"
    )
)