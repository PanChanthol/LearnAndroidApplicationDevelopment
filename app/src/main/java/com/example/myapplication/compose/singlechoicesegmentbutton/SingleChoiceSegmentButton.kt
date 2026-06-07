package com.example.myapplication.compose.singlechoicesegmentbutton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSingleChoiceSegmentButton() {
    var selectIndex by remember { mutableIntStateOf(0) }
    val option = listOf("Day", "Week", "Mouth")
    val isOpenDialog = remember { mutableStateOf(false) }
    if (isOpenDialog.value) {

        AlertDialog(
            title = {
                Text(
                    text = "You want to exit"
                )
            },
            onDismissRequest = {
                println("Click dismiss request")
            },
            dismissButton = {
                TextButton(onClick = { isOpenDialog.value = false }) {
                    Text(
                        text = "No"
                    )
                }
            },

            confirmButton = {
                FilledTonalButton(onClick = { isOpenDialog.value = true }) {
                    Text(
                        text = "Yse"
                    )
                }

            },
        )
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Single Choice Segment Button")
                },
                navigationIcon = {
                    IconButton(onClick = { isOpenDialog.value = true }) {
                        Icon(
                            painterResource(R.drawable.ic_arrow_back),
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onBackground,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }

    ) { padding ->
        Column(
            Modifier.padding(padding)
        ) {
            SingleChoiceSegmentedButtonRow(
                Modifier.fillMaxWidth()
            ) {
                option.forEachIndexed { index, value ->
                    SegmentedButton(
                        selected = if (selectIndex == index) true else false,
                        onClick = {
                            selectIndex = index
                        },
                        label = {
                            Text(
                                text = value
                            )
                        },
                        shape = RoundedCornerShape(16.dp)
                    )
                }
            }
            when (selectIndex) {
                0 -> {
                    for (i in 1..31) {
                        Text("Day $i")
                    }
                }

                1 -> {
                    for (i in 1..4) {
                        Text("Week $i")
                    }
                }

                2 -> {
                    for (i in 1..12) {
                        Text("Month $i")
                    }
                    Icon(painterResource(R.drawable.ic_share),
                        contentDescription = null)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenSingleChoiceSegmentButtonPreview() {
    MyApplicationTheme {
        ScreenSingleChoiceSegmentButton()
    }
}
