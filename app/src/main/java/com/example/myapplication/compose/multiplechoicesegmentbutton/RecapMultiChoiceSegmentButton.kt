package com.example.myapplication.compose.multiplechoicesegmentbutton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.compose.singlechoicesegmentbutton.transactionList
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenRecapMultiChoiceSegmentButton() {

    val selects = remember {
        mutableStateListOf(
            true,
            false,
            false,
            false,
            false
        )
    }

    val items = listOf(
        "All",
        "Transfer",
        "KHQR",
        "TopUp",
        "Payment"
    )

    val filteredTransactions = when {

        selects[0] -> transactionList

        else -> {
            transactionList.filter { transaction ->

                (selects[1] && transaction.transactionType.type == "Transfer") ||
                        (selects[2] && transaction.transactionType.type == "KHQR") ||
                        (selects[3] && transaction.transactionType.type == "TopUp") ||
                        (selects[4] && transaction.transactionType.type == "Payment")
            }
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("RecapMultiChoiceSegmentButton")
                }
            )
        }
    ) { padding ->

        Column(
            Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {

            LazyRow {
                item {

                    MultiChoiceSegmentedButtonRow(
                        Modifier
                            .padding(horizontal = 8.dp)
                            .fillMaxWidth()
                    ) {

                        items.forEachIndexed { index, item ->

                            SegmentedButton(
                                checked = selects[index],
                                onCheckedChange = {

                                    if (index == 0) {

                                        for (i in selects.indices) {
                                            selects[i] = false
                                        }

                                        selects[0] = true

                                    } else {

                                        selects[index] = !selects[index]

                                        if (selects[index]) {
                                            selects[0] = false
                                        }

                                        if (selects.drop(1).none { it }) {
                                            selects[0] = true
                                        }
                                    }
                                },
                                shape = RoundedCornerShape(
                                    topStart = if (index == 0) 8.dp else 0.dp,
                                    topEnd = if (index == items.size - 1) 8.dp else 0.dp,
                                    bottomStart = if (index == 0) 8.dp else 0.dp,
                                    bottomEnd = if (index == items.size - 1) 8.dp else 0.dp
                                ),
                                label = {
                                    Text(text = item)
                                }
                            )
                        }
                    }
                }
            }

            filteredTransactions.forEach { data ->

                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .height(56.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "${data.transactionId} - ${data.transactionType.type}"
                    )
                }

                HorizontalDivider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenRecapMultiChoiceSegmentButtonPreview() {
    MyApplicationTheme {
        ScreenRecapMultiChoiceSegmentButton()
    }
}