package com.example.myapplication.compose.tooltip

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TooltipViewModel: ViewModel() {
    private val accountInfo = Model(
        title = "Account Info",
        name = "Pan Chanthol",
        phoneNumber = "086323602",
        email = "Panchanthol@gmail.com"
    )

    private val _account = MutableStateFlow<Model?>(null)
    val account = _account.asStateFlow()

    fun getAccountInfo(){
        viewModelScope.launch {
            _account.emit(accountInfo)
        }
    }
}