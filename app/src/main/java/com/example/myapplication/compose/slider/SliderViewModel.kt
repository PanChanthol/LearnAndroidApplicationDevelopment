package com.example.myapplication.compose.slider

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableFloatStateOf
import androidx.lifecycle.ViewModel

class SliderViewModel : ViewModel() {
    private val _sliderPosition = mutableFloatStateOf(0.0f)
    val sliderPosition: State<Float> = _sliderPosition

    fun onSliderPositionChange(newValue: Float) {
        _sliderPosition.floatValue = newValue
    }
}
