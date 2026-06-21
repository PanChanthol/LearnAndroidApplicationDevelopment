package com.example.myapplication.compose.snackbar

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSnackBarWithAction(viewModel: SnackBarViewModel = viewModel()) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("SnackBar")
                }
            )
        },
        snackbarHost = {
            SnackbarHost(
                hostState = viewModel.snackBarHostState
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    viewModel.showSnackBar("Snack bar")
                }
            ) {
                Text("ShowSnackBar")
            }
            Button(
                onClick = {
                    viewModel.showSnackBarWithAction(
                        message = "Snack bar",
                        actionLabel = "Undo",
                        onActionResult = { result ->
                            when (result) {
                                SnackbarResult.ActionPerformed -> {
                                    println("Action performed")
                                }
                                SnackbarResult.Dismissed -> {
                                    println("Dismissed")
                                }
                            }
                        }
                    )
                }
            ) {
                Text("ShowSnackBarWithAction")
            }
            Button(
                onClick = {
                    Toast.makeText(context, "Toast Message", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text("ShowToastMessage")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenSnackBarWithActionPreview() {
    MaterialTheme {
        MyApplicationTheme {
            ScreenSnackBarWithAction()
        }
    }
}
