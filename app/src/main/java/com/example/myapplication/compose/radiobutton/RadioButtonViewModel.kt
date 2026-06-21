package com.example.myapplication.compose.radiobutton

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class RadioButtonViewModel : ViewModel() {
    private val _selectedSize = mutableIntStateOf(1)
    val selectedSize: State<Int> = _selectedSize

    private val _selectedSugar = mutableIntStateOf(1)
    val selectedSugar: State<Int> = _selectedSugar

    val sizes = listOf(
        Model(SizeCapModel.SMALL.code, "Small"),
        Model(SizeCapModel.MEDIUM.code, "Medium"),
        Model(SizeCapModel.lARGE.code, "Large"),
        Model(SizeCapModel.EXTRA_LARGE.code, "Extra Large")
    )

    val sugarLevels = listOf(
        Model(SugarModel.LEVEL_0.code, "No Sugar"),
        Model(SugarModel.LEVEL_25.code, "25%"),
        Model(SugarModel.LEVEL_50.code, "50%"),
        Model(SugarModel.LEVEL_75.code, "75%"),
        Model(SugarModel.LEVEL_100.code, "100%")
    )

    fun onSizeSelected(index: Int) {
        _selectedSize.intValue = index
    }

    fun onSugarSelected(index: Int) {
        _selectedSugar.intValue = index
    }
}

data class Model(
    val id: String, val label: String
)

enum class SizeCapModel(val code: String) {
    SMALL("1"), MEDIUM("2"), lARGE("3"), EXTRA_LARGE("4"),
}

enum class SugarModel(val code: String) {
    LEVEL_0("1"),
    LEVEL_25("2"),
    LEVEL_50("3"),
    LEVEL_75("4"),
    LEVEL_100("5"),
}
