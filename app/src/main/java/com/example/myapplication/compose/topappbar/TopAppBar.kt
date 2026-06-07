package com.example.myapplication.compose.topappbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTopAppBar() {

    val isDialogOpen = remember { mutableStateOf(false) }
    if (isDialogOpen.value) {
        AlertDialog(
            title = {
                Text(
                    text = "Alert Dialog"
                )
            },
            onDismissRequest = {
                println("Click dismiss request")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        isDialogOpen.value = false
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                FilledTonalButton(
                    onClick = {
                        isDialogOpen.value = false
                    }
                ) {
                    Text("No")
                }
            }
        )
    }
    Scaffold(
        contentColor = MaterialTheme.colorScheme.onPrimary,
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Text("Screen Top App Bar")
                },
                navigationIcon = {
                    IconButton(
                        modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground.copy(0.1f)),
                        onClick = { isDialogOpen.value = true }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = ""
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { println("====> Share") }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_share),
                            contentDescription = ""
                        )
                    }
                    IconButton(
                        onClick = {
                            isDialogOpen.value = true
                        }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_more_vert),
                            contentDescription = ""
                        )
                    }
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onBackground,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ) {

        }
    }
}

@Composable
@Preview(showBackground = true, device = "id:pixel_9_pro", showSystemUi = false)
fun ScreenTopAppBarPreview() {
    MyApplicationTheme {
        ScreenTopAppBar()
    }
}