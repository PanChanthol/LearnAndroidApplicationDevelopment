package com.example.myapplication.compose.alertdialog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenAlertDialog() {
    var openDialog by remember { mutableStateOf(false) }

    Scaffold(
        contentColor = MaterialTheme.colorScheme.onBackground,
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Dialog")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_more_vert),
                            contentDescription = null
                        )
                    }
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_share),
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        },
        bottomBar = {
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = { openDialog = true }
            ) {
                Text("Alert Dialog")
            }
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .wrapContentSize()
        ) {
            if (openDialog) {
                Box(
                    modifier = Modifier.wrapContentSize()
                ) {
                    AlertDialog(
                        modifier = Modifier,
                        icon = {
                            Icon(
                                modifier = Modifier.size(32.dp),
                                painter = painterResource(R.drawable.ic_warning),
                                contentDescription = null
                            )
                        },
                        title = {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Delete Account",
                                textAlign = TextAlign.Center
                            )
                        },
                        text = {
                            Text(
                                text = "An error has occurred while creating an error report.",
                                textAlign = TextAlign.Center
                            )
                        },
                        onDismissRequest = { openDialog = false },
                        confirmButton = {
                            TextButton(
                                onClick = { openDialog= false }
                            ) {
                                Text("OK")
                            }
                        },
                        dismissButton = {
                            TextButton(
                                onClick = {openDialog= false }
                            ) {
                                Text("NO")
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenAlertDialogPreview() {
    MyApplicationTheme {
        ScreenAlertDialog()
    }
}