package com.example.myapplication.compose.loadingandprogress

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadingViewModel : ViewModel() {
    private val _list = mutableStateListOf<String>()
    val list: List<String> = _list

    private val _clickOnButton = mutableIntStateOf(1)
    val clickOnButton: State<Int> = _clickOnButton

    private val _openDialog = mutableStateOf(false)
    val openDialog: State<Boolean> = _openDialog

    fun startLoading(type: Int, name: String) {
        _openDialog.value = true
        _clickOnButton.intValue = type
        viewModelScope.launch {
            delay(3000)
            _list.add("Hello $name")
            _openDialog.value = false
        }
    }
}
