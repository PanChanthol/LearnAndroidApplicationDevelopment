package com.example.myapplication.compose.bottomsheet

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BottomSheetViewModel : ViewModel() {
    private val _selectedSize = mutableIntStateOf(1)
    val selectedSize: State<Int> = _selectedSize

    private val _selectedSugar = mutableIntStateOf(1)
    val selectedSugar: State<Int> = _selectedSugar

    private val _showBottomSheet = mutableStateOf(false)
    val showBottomSheet: State<Boolean> = _showBottomSheet

    private val _sugar = mutableStateOf<Model?>(null)
    val sugar: State<Model?> = _sugar

    private val _size = mutableStateOf<Model?>(null)
    val size: State<Model?> = _size

    val sizeList = listOf(
        Model(id = SizeCapModel.SMALL.code, label = "Small"),
        Model(id = SizeCapModel.MEDIUM.code, label = "Medium"),
        Model(id = SizeCapModel.lARGE.code, label = "Large"),
        Model(id = SizeCapModel.EXTRA_LARGE.code, label = "Extra Large")
    )

    val sugarList = listOf(
        Model(id = SugarModel.LEVEL_0.code, label = "No Sugar"),
        Model(id = SugarModel.LEVEL_25.code, label = "25%"),
        Model(id = SugarModel.LEVEL_50.code, label = "50%"),
        Model(id = SugarModel.LEVEL_75.code, label = "75%"),
        Model(id = SugarModel.LEVEL_100.code, label = "100%")
    )

    fun onSizeSelected(index: Int) {
        _selectedSize.intValue = index
    }

    fun onSugarSelected(index: Int) {
        _selectedSugar.intValue = index
    }

    fun setShowBottomSheet(show: Boolean) {
        _showBottomSheet.value = show
    }

    fun onConfirm() {
        _size.value = sizeList[_selectedSize.intValue]
        _sugar.value = sugarList[_selectedSugar.intValue]
        _showBottomSheet.value = false
    }
}
