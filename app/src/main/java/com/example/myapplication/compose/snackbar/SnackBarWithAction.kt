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
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSnackBarWithAction() {
    val context = LocalContext.current
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
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
                hostState = snackBarHostState
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
                    scope.launch {
                        snackBarHostState.showSnackbar("Snack bar")
                        delay(2000.milliseconds)
                    }
                }
            ) {
                Text("ShowSnackBar")
            }
            Button(
                onClick = {
                    scope.launch {
                        val result = snackBarHostState.showSnackbar(
                            message = "Snack bar",
                            actionLabel = "Undo",  // click to close
                            withDismissAction = true, // show icon X
                            duration = SnackbarDuration.Indefinite
                        )
                        when (result) {
                            SnackbarResult.ActionPerformed -> { // click to close
                                println("Action performed")
                            }
                            SnackbarResult.Dismissed->{  // show icon X
                                println("Dismissed")
                            }
                        }
                    }
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