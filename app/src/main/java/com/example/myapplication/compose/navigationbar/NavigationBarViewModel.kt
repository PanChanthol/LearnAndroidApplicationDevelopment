package com.example.myapplication.compose.navigationbar

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class NavigationBarViewModel : ViewModel() {

    private val _selectedIndex = mutableIntStateOf(0)
    val selectedIndex: State<Int> = _selectedIndex

    val navigationBarItems = navigationBarItem

    fun onItemSelected(index: Int) {
        _selectedIndex.intValue = index
    }
}
