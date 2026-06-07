package com.example.myapplication.layout.model

data class AccountBankModel(
    val id: Int,
    val accountNo: String,
    val accountName: String,
    val balance: Double,
    val currency: String,
    val bankName: String
)

val accountBankList = listOf(
    AccountBankModel(
        id = 1,
        accountNo = "001234567",
        accountName = "John Doe",
        balance = 1500.50,
        currency = "USD",
        bankName = "ABA Bank"
    ),
    AccountBankModel(
        id = 2,
        accountNo = "001234568",
        accountName = "Alice Smith",
        balance = 2500.00,
        currency = "USD",
        bankName = "ACLEDA Bank"
    ),
    AccountBankModel(
        id = 3,
        accountNo = "001234569",
        accountName = "Michael Lee",
        balance = 3200.75,
        currency = "KHR",
        bankName = "Wing Bank"
    ),
    AccountBankModel(
        id = 4,
        accountNo = "001234570",
        accountName = "David Kim",
        balance = 980.25,
        currency = "USD",
        bankName = "Canadia Bank"
    ),
    AccountBankModel(
        id = 5,
        accountNo = "001234571",
        accountName = "Sophia Chen",
        balance = 5000.00,
        currency = "KHR",
        bankName = "Prince Bank"
    )
)