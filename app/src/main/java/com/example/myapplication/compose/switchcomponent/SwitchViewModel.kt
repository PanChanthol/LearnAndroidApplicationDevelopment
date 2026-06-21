package com.example.myapplication.compose.switchcomponent

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SwitchViewModel : ViewModel() {
    private val _isChecked = mutableStateOf(false)
    val isChecked: State<Boolean> = _isChecked

    fun onCheckedChanged(newValue: Boolean) {
        _isChecked.value = newValue
    }
}
