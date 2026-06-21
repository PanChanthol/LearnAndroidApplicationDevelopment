package com.example.myapplication.compose.singlechoicesegmentbutton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecapSingleChoiceSegmentButton(viewModel: SingleChoiceSegmentedButtonViewModel = viewModel()) {

    val selectedType by viewModel.selectedType
    val filteredTransactions by viewModel.filteredTransactions
    val transactionTypes = viewModel.transactionTypes

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.clearSelection()
                }
            ) {
                Text("Clear")
            }
        },
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Transaction Recap")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.teal_200)
                )
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(padding)
                .fillMaxSize()
        ) {

            SingleChoiceSegmentedButtonRow(
                modifier = Modifier.padding(16.dp)
            ) {

                transactionTypes.forEachIndexed { index, data ->

                    SegmentedButton(
                        selected = data == selectedType,

                        onClick = {
                            viewModel.onTypeSelected(data)
                        },

                        shape = RoundedCornerShape(
                            topStart = if (index == 0) 16.dp else 0.dp,
                            topEnd = if (index == transactionTypes.size - 1) 16.dp else 0.dp,
                            bottomStart = if (index == 0) 16.dp else 0.dp,
                            bottomEnd = if (index == transactionTypes.size - 1) 16.dp else 0.dp,
                        ),

                        label = {
                            Text(text = data.type)
                        }
                    )
                }
            }

            filteredTransactions.forEach { transaction ->

                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .height(56.dp),

                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "${transaction.transactionId} - ${transaction.transactionType.type}"
                    )
                }
                HorizontalDivider()
            }
        }
    }
}

enum class TransactionType(val id: String, val type: String) {
    All("TRX001", "All"),
    Transfer("TRX002", "Transfer"),
    KHQR("TRX003", "KHQR"),
    TopUp("TRX004", "TopUp"),
    Payment("TRX005", "Payment")
}

data class Transaction(
    val transactionId: String,
    val transactionType: TransactionType,
    val amount: Double,
    val currency: String,
    val sender: String,
    val receiver: String,
    val date: String,
    val status: String
)

val transactionList = listOf(
    Transaction(
        "TXN1001",
        TransactionType.Transfer,
        150.00,
        "USD",
        "Pan Chanthol",
        "Sok Dara",
        "2026-05-24 10:30 AM",
        "Success"
    ),
    Transaction(
        "TXN1002",
        TransactionType.KHQR,
        40000.0,
        "KHR",
        "Pan Chanthol",
        "Lucky Supermarket",
        "2026-05-24 11:00 AM",
        "Success"
    ),
    Transaction(
        "TXN1003",
        TransactionType.TopUp,
        5.00,
        "USD",
        "ABA Bank",
        "Smart",
        "2026-05-24 12:15 PM",
        "Pending"
    ),
    Transaction(
        "TXN1004",
        TransactionType.Payment,
        12.50,
        "USD",
        "Pan Chanthol",
        "Food Panda",
        "2026-05-24 01:45 PM",
        "Success"
    ),
    Transaction(
        "TXN1005",
        TransactionType.Transfer,
        250.00,
        "USD",
        "Chan Vibol",
        "Kimly",
        "2026-05-24 02:10 PM",
        "Success"
    ),
    Transaction(
        "TXN1006",
        TransactionType.KHQR,
        75000.0,
        "KHR",
        "Pan Chanthol",
        "Brown Coffee",
        "2026-05-24 03:00 PM",
        "Success"
    ),
    Transaction(
        "TXN1007",
        TransactionType.TopUp,
        10.00,
        "USD",
        "ACLEDA Bank",
        "Cellcard",
        "2026-05-24 03:30 PM",
        "Failed"
    ),
    Transaction(
        "TXN1008",
        TransactionType.Payment,
        35.99,
        "USD",
        "Pan Chanthol",
        "AEON Mall",
        "2026-05-24 04:20 PM",
        "Success"
    ),
    Transaction(
        "TXN1009",
        TransactionType.Transfer,
        120000.0,
        "KHR",
        "Srey Pov",
        "Nita",
        "2026-05-24 05:15 PM",
        "Pending"
    ),
    Transaction(
        "TXN1010",
        TransactionType.KHQR,
        8.50,
        "USD",
        "Pan Chanthol",
        "Starbucks",
        "2026-05-24 06:00 PM",
        "Success"
    ),
    Transaction(
        "TXN1011",
        TransactionType.Transfer,
        20.00,
        "USD",
        "Dara",
        "Vanna",
        "2026-05-24 06:10 PM",
        "Success"
    ),
    Transaction(
        "TXN1012",
        TransactionType.Payment,
        3.50,
        "USD",
        "Chanthol",
        "7-Eleven",
        "2026-05-24 06:15 PM",
        "Success"
    ),
    Transaction(
        "TXN1013",
        TransactionType.TopUp,
        15.00,
        "USD",
        "ABA Bank",
        "Metfone",
        "2026-05-24 06:20 PM",
        "Success"
    ),
    Transaction(
        "TXN1014",
        TransactionType.KHQR,
        12000.0,
        "KHR",
        "Chan Vibol",
        "Mini Mart",
        "2026-05-24 06:25 PM",
        "Success"
    ),
    Transaction(
        "TXN1015",
        TransactionType.Transfer,
        300.00,
        "USD",
        "Sok Dara",
        "Pan Chanthol",
        "2026-05-24 06:30 PM",
        "Success"
    ),

    Transaction(
        "TXN1016",
        TransactionType.Payment,
        7.25,
        "USD",
        "Vanna",
        "Amazon Cafe",
        "2026-05-24 06:35 PM",
        "Success"
    ),
    Transaction(
        "TXN1017",
        TransactionType.KHQR,
        25000.0,
        "KHR",
        "Pan Chanthol",
        "Lucky Express",
        "2026-05-24 06:40 PM",
        "Success"
    ),
    Transaction(
        "TXN1018",
        TransactionType.TopUp,
        2.00,
        "USD",
        "Smart",
        "Phone Balance",
        "2026-05-24 06:45 PM",
        "Success"
    ),
    Transaction(
        "TXN1019",
        TransactionType.Transfer,
        500.00,
        "USD",
        "Srey Pov",
        "Dara",
        "2026-05-24 06:50 PM",
        "Pending"
    ),
    Transaction(
        "TXN1020",
        TransactionType.Payment,
        18.75,
        "USD",
        "Pan Chanthol",
        "Pizza Company",
        "2026-05-24 06:55 PM",
        "Success"
    ),

    Transaction(
        "TXN1021",
        TransactionType.KHQR,
        9000.0,
        "KHR",
        "Chan Vibol",
        "Coffee Time",
        "2026-05-24 07:00 PM",
        "Success"
    ),
    Transaction(
        "TXN1022",
        TransactionType.Transfer,
        60.00,
        "USD",
        "Dara",
        "Sok Dara",
        "2026-05-24 07:05 PM",
        "Success"
    ),
    Transaction(
        "TXN1023",
        TransactionType.Payment,
        4.00,
        "USD",
        "Vanna",
        "Mini Mart",
        "2026-05-24 07:10 PM",
        "Failed"
    ),
    Transaction(
        "TXN1024",
        TransactionType.TopUp,
        25.00,
        "USD",
        "ACLEDA Bank",
        "Cellcard",
        "2026-05-24 07:15 PM",
        "Success"
    ),
    Transaction(
        "TXN1025",
        TransactionType.KHQR,
        55000.0,
        "KHR",
        "Pan Chanthol",
        "AEON MaxValu",
        "2026-05-24 07:20 PM",
        "Success"
    ),

    Transaction(
        "TXN1026",
        TransactionType.Transfer,
        110.00,
        "USD",
        "Sok Dara",
        "Chan Vibol",
        "2026-05-24 07:25 PM",
        "Success"
    ),
    Transaction(
        "TXN1027",
        TransactionType.Payment,
        9.99,
        "USD",
        "Pan Chanthol",
        "Netflix",
        "2026-05-24 07:30 PM",
        "Success"
    ),
    Transaction(
        "TXN1028",
        TransactionType.KHQR,
        30000.0,
        "KHR",
        "Vanna",
        "Brown Coffee",
        "2026-05-24 07:35 PM",
        "Success"
    ),
    Transaction(
        "TXN1029",
        TransactionType.TopUp,
        30.00,
        "USD",
        "Smart",
        "Internet Data",
        "2026-05-24 07:40 PM",
        "Success"
    ),
    Transaction(
        "TXN1030",
        TransactionType.Transfer,
        75.00,
        "USD",
        "Dara",
        "Srey Pov",
        "2026-05-24 07:45 PM",
        "Pending"
    ),

    Transaction(
        "TXN1031",
        TransactionType.Payment,
        22.00,
        "USD",
        "Chanthol",
        "AEON Mall Food Court",
        "2026-05-24 07:50 PM",
        "Success"
    ),
    Transaction(
        "TXN1032",
        TransactionType.KHQR,
        15000.0,
        "KHR",
        "Sok Dara",
        "Lucky Supermarket",
        "2026-05-24 07:55 PM",
        "Success"
    ),
    Transaction(
        "TXN1033",
        TransactionType.Transfer,
        45.00,
        "USD",
        "Vibol",
        "Pan Chanthol",
        "2026-05-24 08:00 PM",
        "Success"
    ),
    Transaction(
        "TXN1034",
        TransactionType.Payment,
        6.50,
        "USD",
        "Dara",
        "Coffee Shop",
        "2026-05-24 08:05 PM",
        "Success"
    ),
    Transaction(
        "TXN1035",
        TransactionType.TopUp,
        12.00,
        "USD",
        "ABA Bank",
        "Metfone",
        "2026-05-24 08:10 PM",
        "Success"
    )
)


@Preview(showBackground = true, device = "id:pixel_9_pro")
@Composable
fun RecapSingleChoiceSegmentButtonPreview() {

    MyApplicationTheme {
        RecapSingleChoiceSegmentButton()
    }
}
