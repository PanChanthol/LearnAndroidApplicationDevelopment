package com.example.myapplication.compose.timepicker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDialog
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerWithDialog() {
    var showDialogTime by remember { mutableStateOf(false) }
    var showInputTime by remember { mutableStateOf(false) }
    val calendar = Calendar.getInstance()
    val timePickerDialogState = rememberTimePickerState(
        initialHour = calendar.get(Calendar.HOUR_OF_DAY),
        initialMinute = calendar.get(Calendar.MINUTE),
        is24Hour = false
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Time Picker")
                }
            )
        },
        bottomBar = {
            NavigationBar(
            ) {
                NavigationBarItem(
                    label = {
                        Text("Show Time Dialog")
                    },
                    selected = true,
                    onClick = {
                        showDialogTime = true
                    },
                    icon = {
                        Icon(
                            painterResource(R.drawable.ic_time),
                            contentDescription = null
                        )
                    }
                )
                NavigationBarItem(
                    selected = true,
                    onClick = { showInputTime = true },
                    icon = {
                        Icon(
                            painterResource(R.drawable.ic_time),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text("Show Time Input")
                    },
                )
            }

        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Selected Time: ${timePickerDialogState.hour}:${timePickerDialogState.minute}")
            if (showDialogTime) {
                TimePickerDialog(
                    onDismissRequest = { showDialogTime = false },
                    title = {
                        Text("Select Time")
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                showDialogTime = false
                            }
                        ) {
                            Text("Confirm")
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = {
                                showDialogTime = false
                            }
                        ) {
                            Text("Cancel")
                        }
                    },

                    ) {
                    TimePicker(
                        state = timePickerDialogState
                    )
                }
            }
            if (showInputTime) {
                TimePickerDialog(
                    onDismissRequest = { showInputTime = false },
                    title = {
                        Text("Select Time")
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                showInputTime = false
                            }
                        ) {
                            Text("Confirm")
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = {
                                showInputTime = false
                            }
                        ) {
                            Text("Cancel")
                        }
                    },

                    ) {
                    TimeInput(
                        state = timePickerDialogState
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TimePickerWithDialogPreview() {
    MaterialTheme {
        MyApplicationTheme {
            TimePickerWithDialog()
        }
    }
}