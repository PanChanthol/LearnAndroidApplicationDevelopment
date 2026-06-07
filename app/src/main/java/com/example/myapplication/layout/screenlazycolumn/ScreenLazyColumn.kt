package com.example.myapplication.layout.screenlazycolumn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenLazyColumn() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                        )
                    }
                }, colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.background
                ), title = {
                    Text("Lazy Column Layout")
                })
        }

    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues = padding)
                .fillMaxSize()
                .background(color = colorResource(R.color.teal_200)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //item
            item {
                for (account in bankAccounts) {
                    Row(
                        modifier = Modifier
                            .padding(6.dp)
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(
                                color = MaterialTheme.colorScheme.secondary,
                                shape = RoundedCornerShape(12.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Text(
                            modifier = Modifier.padding(start = 6.dp),
                            text = account.accountNo,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                        Text(
                            modifier = Modifier.padding(end = 6.dp),
                            text = account.balance.toString(),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }
            //items
            items(bankAccounts.size) { index ->
                val accountList = bankAccounts[index]
                Row(
                    modifier = Modifier
                        .padding(6.dp)
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                            shape = RoundedCornerShape(12.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(start = 6.dp),
                        text = accountList.accountNo,
                        color = MaterialTheme.colorScheme.onError
                    )
                    Text(
                        modifier = Modifier.padding(start = 6.dp),
                        text = accountList.balance.toString(),
                        color = MaterialTheme.colorScheme.onError
                    )
                }
            }
            //itemIndex
            itemsIndexed(
                items = bankAccounts,
                key = {_, item -> item.accountNo}
            ){ _, account ->
                Row(
                    modifier = Modifier
                        .padding(6.dp)
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 1f),
                            shape = RoundedCornerShape(12.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(start = 6.dp),
                        text = account.accountNo,
                        color = MaterialTheme.colorScheme.onError
                    )
                    Text(
                        modifier = Modifier.padding(end = 6.dp),
                        text = "${account.balance}",
                        color = MaterialTheme.colorScheme.onError
                    )
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun ScreenLazyColumnPreview() {
    MyApplicationTheme {
        ScreenLazyColumn()
    }
}

data class BankAccount8(
    val accountNo: String,
    val accountName: String,
    val balance: Double,
    val currency: String,   // USD / KHR
    val createDate: String  // format: yyyyMMdd
)

val bankAccounts = listOf(

    BankAccount8(
        accountNo = "100001",
        accountName = "Panchanthol",
        balance = 2500.0,
        currency = "USD",
        createDate = "20260101"
    ),

    BankAccount8(
        accountNo = "100002",
        accountName = "Sok Dara",
        balance = 1500000.0,
        currency = "KHR",
        createDate = "20260105"
    ),

    BankAccount8(
        accountNo = "100003",
        accountName = "Kimly",
        balance = 3200.5,
        currency = "USD",
        createDate = "20260110"
    ),

    BankAccount8(
        accountNo = "100004",
        accountName = "Ratha",
        balance = 780000.0,
        currency = "KHR",
        createDate = "20260112"
    ),

    BankAccount8(
        accountNo = "100005",
        accountName = "Sreypov",
        balance = 980.75,
        currency = "USD",
        createDate = "20260115"
    ),

    BankAccount8(
        accountNo = "100006",
        accountName = "Vannak",
        balance = 4500000.0,
        currency = "KHR",
        createDate = "20260118"
    ),

    BankAccount8(
        accountNo = "100007",
        accountName = "Dalin",
        balance = 12000.0,
        currency = "USD",
        createDate = "20260120"
    ),

    BankAccount8(
        accountNo = "100008",
        accountName = "Sokunthea",
        balance = 230000.0,
        currency = "KHR",
        createDate = "20260122"
    ),

    BankAccount8(
        accountNo = "100009",
        accountName = "Chantha",
        balance = 5400.0,
        currency = "USD",
        createDate = "20260125"
    ),

    BankAccount8(
        accountNo = "100010",
        accountName = "Bora",
        balance = 890000.0,
        currency = "KHR",
        createDate = "20260130"
    )

)