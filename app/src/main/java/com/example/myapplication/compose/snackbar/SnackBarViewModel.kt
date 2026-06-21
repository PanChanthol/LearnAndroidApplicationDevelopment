package com.example.myapplication.compose.snackbar

import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SnackBarViewModel : ViewModel() {
    val snackBarHostState = SnackbarHostState()

    fun showSnackBar(message: String) {
        viewModelScope.launch {
            snackBarHostState.showSnackbar(message)
        }
    }

    fun showSnackBarWithAction(
        message: String,
        actionLabel: String,
        onActionResult: (SnackbarResult) -> Unit
    ) {
        viewModelScope.launch {
            val result = snackBarHostState.showSnackbar(
                message = message,
                actionLabel = actionLabel,
                withDismissAction = true,
                duration = androidx.compose.material3.SnackbarDuration.Indefinite
            )
            onActionResult(result)
        }
    }
}
