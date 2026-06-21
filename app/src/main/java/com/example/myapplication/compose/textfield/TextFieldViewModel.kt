package com.example.myapplication.compose.textfield

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TextFieldViewModel : ViewModel() {
    private val _valueName = mutableStateOf("")
    val valueName: State<String> = _valueName

    private val _valueEmail = mutableStateOf("")
    val valueEmail: State<String> = _valueEmail

    private val _valueMessage = mutableStateOf("")
    val valueMessage: State<String> = _valueMessage

    private val _showFormContact = mutableStateOf(false)
    val showFormContact: State<Boolean> = _showFormContact

    private val _expanded = mutableStateOf(false)
    val expanded: State<Boolean> = _expanded

    private val _selectedItem = mutableStateOf("Java")
    val selectedItem: State<String> = _selectedItem

    val items = listOf("Java", "Kotlin", "Oracle Database", "Networking", "UX/UI")

    fun onValueNameChange(newValue: String) {
        _valueName.value = newValue
    }

    fun onValueEmailChange(newValue: String) {
        _valueEmail.value = newValue
    }

    fun onValueMessageChange(newValue: String) {
        _valueMessage.value = newValue
    }

    fun setShowFormContact(show: Boolean) {
        _showFormContact.value = show
    }

    fun setExpanded(expanded: Boolean) {
        _expanded.value = expanded
    }

    fun setSelectedItem(item: String) {
        _selectedItem.value = item
        _expanded.value = false
    }
}
