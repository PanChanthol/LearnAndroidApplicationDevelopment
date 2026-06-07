package com.example.myapplication.compose.multiplechoicesegmentbutton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
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
fun ScreenMultipleChoiceSegmentButton() {
    val selectedOption = remember { mutableStateListOf(false, false, false) }
    val option = listOf("Day", "Week", "Month")
    var isNewNotification by remember { mutableStateOf(false) }
    var countBadges by remember { mutableIntStateOf(0) }
    val isOpenDialog = remember { mutableStateOf(false) }
    if (isOpenDialog.value) {
        AlertDialog(
            title = {
                Text("You want to exit")
            },
            onDismissRequest = {
                println("Click dismiss request")
            },
            confirmButton = {
                FilledTonalButton(onClick = { isOpenDialog.value = true }) {
                    Text("ok")
                }
            },
            dismissButton = {
                TextButton(onClick = { isOpenDialog.value = false }) {
                    Text("No")
                }
            }
        )
    }
    Scaffold(
        Modifier
            .fillMaxWidth(),
        topBar = {
            MediumTopAppBar(
                title = {
                    Text("Multiple Choice Segment Button")
                },
                navigationIcon = {
                    IconButton(onClick = { isOpenDialog.value = true }) {
                        Icon(
                            painterResource(R.drawable.ic_arrow_back),
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    Row(
                        Modifier.padding(end = 16.dp)
                    ) {
                        IconButton(onClick = {}) {
                            BadgedBox(
                                badge = {
                                    if (isNewNotification) {
                                        Badge()
                                    }
                                }
                            ) {
                                Icon(
                                    painterResource(R.drawable.ic_share),
                                    contentDescription = null
                                )
                            }
                        }
                        IconButton(onClick = {}) {
                            BadgedBox(
                                badge = {
                                    if (countBadges > 0) {
                                        Badge(
                                            Modifier
                                                .wrapContentSize()
                                        ) {
                                            Text("$countBadges")
                                        }
                                    }
                                }
                            ) {
                                Icon(
                                    painterResource(R.drawable.ic_more_vert),
                                    contentDescription = null
                                )
                            }
                        }
                    }
                }
            )
        },
        bottomBar = {
            Row(
                Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        isNewNotification = !isNewNotification
                    },
                    Modifier.weight(1f)
                ) {
                    Text("Update Badges")
                }

                Button(
                    onClick = {
                        countBadges++
                    },
                    Modifier.weight(1f)
                ) {
                    Text("Update Badges number")
                }
            }
        }
    ) { padding ->
        Column(
            Modifier.padding(padding)
        ) {
            MultiChoiceSegmentedButtonRow(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                option.forEachIndexed { index, item ->
                    SegmentedButton(
                        checked = selectedOption[index],
                        shape = RoundedCornerShape(
                            topStart = if (index == 0) 16.dp else 0.dp,
                            topEnd = if (index == option.size - 1) 16.dp else 0.dp,
                            bottomStart = if (index == 0) 16.dp else 0.dp,
                            bottomEnd = if (index == option.size - 1) 16.dp else 0.dp
                        ),
                        onCheckedChange = { onCheck ->
                            println(selectedOption)
                            println(onCheck)
                            selectedOption[index] = onCheck
                            println(selectedOption)
                        },
                        label = {
                            Text(
                                text = item
                            )
                        },
                        icon = {
                            SegmentedButtonDefaults.Icon(
                                selectedOption[index]
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, device = "id:pixel_9_pro")
fun ScreenMultipleChoiceSegmentButtonPreview() {
    MyApplicationTheme {
        ScreenMultipleChoiceSegmentButton()
    }
}
