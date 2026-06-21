package com.example.myapplication.compose.singlechoicesegmentbutton

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SingleChoiceSegmentedButtonViewModel : ViewModel() {

    private val _selectedType = mutableStateOf<TransactionType?>(null)
    val selectedType: State<TransactionType?> = _selectedType

    val transactionTypes = listOf(
        TransactionType.Transfer,
        TransactionType.KHQR,
        TransactionType.TopUp,
        TransactionType.Payment
    )

    private val _transactions = transactionList
    
    val filteredTransactions = derivedStateOf {
        val currentType = _selectedType.value
        if (currentType == null) {
            _transactions
        } else {
            _transactions.filter { it.transactionType == currentType }
        }
    }

    fun onTypeSelected(type: TransactionType) {
        _selectedType.value = type
    }

    fun clearSelection() {
        _selectedType.value = null
    }
}
