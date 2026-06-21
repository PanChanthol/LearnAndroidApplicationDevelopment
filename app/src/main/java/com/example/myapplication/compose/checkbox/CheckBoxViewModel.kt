package com.example.myapplication.compose.checkbox

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class CheckBoxViewModel : ViewModel() {
    private val _checkList = mutableStateListOf(
        CheckListModel(id = 1, title = "Learn Kotlin Basics"),
        CheckListModel(id = 2, title = "Practice Jetpack Compose"),
        CheckListModel(id = 3, title = "Create Login Screen"),
        CheckListModel(id = 4, title = "Build Banking Dashboard"),
        CheckListModel(id = 5, title = "Connect Oracle Database"),
        CheckListModel(id = 6, title = "Learn State Management"),
        CheckListModel(id = 7, title = "Design Transaction UI"),
        CheckListModel(id = 8, title = "Implement Navigation"),
        CheckListModel(id = 9, title = "Test Application"),
        CheckListModel(id = 10, title = "Deploy Final Project")
    )
    val checkList: List<CheckListModel> = _checkList

    fun toggleCheck(id: Int) {
        val index = _checkList.indexOfFirst { it.id == id }
        if (index != -1) {
            val item = _checkList[index]
            _checkList[index] = item.copy(checked = !item.checked)
        }
    }

    fun setChecked(id: Int, isChecked: Boolean) {
        val index = _checkList.indexOfFirst { it.id == id }
        if (index != -1) {
            val item = _checkList[index]
            _checkList[index] = item.copy(checked = isChecked)
        }
    }

    fun toggleAll(isChecked: Boolean) {
        for (i in _checkList.indices) {
            _checkList[i] = _checkList[i].copy(checked = isChecked)
        }
    }

    fun isAllChecked(): Boolean = _checkList.all { it.checked }
}

data class CheckListModel(
    val id: Int,
    val title: String,
    val checked: Boolean = false
)
