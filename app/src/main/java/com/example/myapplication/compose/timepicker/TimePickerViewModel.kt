package com.example.myapplication.compose.timepicker

import androidx.lifecycle.ViewModel
import java.util.Calendar

class TimePickerViewModel : ViewModel() {
    private val calendar = Calendar.getInstance()
    val initialHour = calendar.get(Calendar.HOUR_OF_DAY)
    val initialMinute = calendar.get(Calendar.MINUTE)
}
