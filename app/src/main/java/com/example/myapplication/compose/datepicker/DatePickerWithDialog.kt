package com.example.myapplication.compose.datepicker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DateRangePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenDatePickerWithDialog() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    var showDatePicker by rememberSaveable { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val dateRangePickerState = rememberDateRangePickerState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Date Picker")
                }
            )
        },
        bottomBar = {
            Row {
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        selectedIndex = 1
                        showDatePicker = true
                    }
                ) {
                    Text("Date Picker")
                }

                Button(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        selectedIndex = 2
                        showDatePicker = true
                    }
                ) {
                    Text("Date Range Picker")
                }
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier.padding(padding)
        ) {

            when (selectedIndex) {
                1 -> {
                    DatePickerDialog(
                        showDatePicker = showDatePicker,
                        onDismiss = {
                            showDatePicker = false
                        },
                        state = datePickerState
                    )
                }

                2 -> {
                    DateRangePickerDialog(
                        showDatePicker = showDatePicker,
                        onDismiss = {
                            showDatePicker = true
                        },
                        state = dateRangePickerState,
                        onConfirm = {
                            showDatePicker = false
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialog(
    showDatePicker: Boolean,
    onDismiss: () -> Unit,
    state: DatePickerState
) {
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = onDismiss,
            confirmButton = {
                TextButton(
                    onClick = onDismiss
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onDismiss
                ) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp)),
                state = state,
                showModeToggle = false,

                colors = DatePickerDefaults.colors(
                    containerColor = Color.White,
                    selectedDayContainerColor = Color.Blue,
                    selectedDayContentColor = Color.White,
                    todayContentColor = Color.Red,
                    todayDateBorderColor = Color.Red
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateRangePickerDialog(
    showDatePicker: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    state: DateRangePickerState
) {
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = onDismiss,
            confirmButton = {
                TextButton(
                    onClick = onConfirm
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onDismiss
                ) {
                    Text("Cancel")
                }
            }
        ) {
            DateRangePicker(
                showModeToggle = false,
                state = state,
                modifier = Modifier
                    .fillMaxWidth()
//                    .padding(16.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenDatePickerWithDialogPreview() {
    MyApplicationTheme {
        ScreenDatePickerWithDialog()
    }
}