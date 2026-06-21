package com.example.myapplication.compose.navigationdrawer

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class NavigationDrawerViewModel : ViewModel() {

    private val _label = mutableStateOf("")
    val label: State<String> = _label

    private val _menuItems = mutableStateOf(navDrawerItems)
    val menuItems: State<List<NavDrawerItem>> = _menuItems

    fun onMenuItemClick(item: NavDrawerItem) {
        _label.value = item.title
        _menuItems.value = _menuItems.value.map {
            it.copy(selected = it.id == item.id)
        }
    }
}
