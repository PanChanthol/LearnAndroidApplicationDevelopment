package com.example.myapplication.ecommerceapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.ecommerceapp.data.banners
import com.example.myapplication.ecommerceapp.data.category

class ECommerceViewModel : ViewModel() {
    private val _searchText = mutableStateOf("")
    val searchText: State<String> = _searchText

    val categoriesList = category
    val bannersList = banners

    fun onSearchTextChange(newText: String) {
        _searchText.value = newText
    }
}
