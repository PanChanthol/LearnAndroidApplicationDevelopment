package com.example.myapplication.compose.timepicker

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.Calendar

class TimePickerWithDialogViewModel : ViewModel() {
    private val calendar = Calendar.getInstance()
    val initialHour = calendar.get(Calendar.HOUR_OF_DAY)
    val initialMinute = calendar.get(Calendar.MINUTE)

    private val _showDialogTime = mutableStateOf(false)
    val showDialogTime: State<Boolean> = _showDialogTime

    private val _showInputTime = mutableStateOf(false)
    val showInputTime: State<Boolean> = _showInputTime

    fun setShowDialogTime(show: Boolean) {
        _showDialogTime.value = show
    }

    fun setShowInputTime(show: Boolean) {
        _showInputTime.value = show
    }
}
