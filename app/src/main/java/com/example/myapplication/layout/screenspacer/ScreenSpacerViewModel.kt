package com.example.myapplication.layout.screenspacer

import androidx.lifecycle.ViewModel

class ScreenSpacerViewModel : ViewModel() {
    val transactionList = transactions
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
