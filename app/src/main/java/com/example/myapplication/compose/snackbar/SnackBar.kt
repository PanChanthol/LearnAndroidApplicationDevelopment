package com.example.myapplication.compose.snackbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSnackBar(viewModel: SnackBarViewModel = viewModel()) {
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
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show snack bar") },
                icon = { Icon(
                    painter = painterResource(R.drawable.ic_close),
                    contentDescription = null)
                 },
                onClick = {
                    viewModel.showSnackBar("Snack bar")
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenSnackBarPreview(){
    MaterialTheme{
        MyApplicationTheme {
            ScreenSnackBar()
        }
    }
}
