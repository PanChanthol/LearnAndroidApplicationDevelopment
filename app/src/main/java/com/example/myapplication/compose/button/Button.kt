package com.example.myapplication.compose.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenButton() {
    var isChecked by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("Hello World!!!!") }
    var isHasNewNotification by remember { mutableStateOf(false) }
    var countBadges by remember { mutableIntStateOf(0) }
    val isDialogOpen = remember { mutableStateOf(false) }
    if (isDialogOpen.value) {
        AlertDialog(title = {
            Text(
                text = "You want to exit"
            )
        }, onDismissRequest = {
            println("Click dismiss request")
        }, confirmButton = {
            TextButton(
                onClick = {
                    isDialogOpen.value = false
                }) {
                Text("No")
            }
        }, dismissButton = {
            FilledTonalButton(
                onClick = {
                    isDialogOpen.value = false
                }) {
                Text("Yes")
            }
        })
    }
    Scaffold(
        modifier = Modifier
            .navigationBarsPadding(),
        topBar = {
            MediumTopAppBar(
                title = {
                    Text(
                        text = "Button"
                    )
                }, navigationIcon = {
                    IconButton(
                        modifier = Modifier.background(
                            color = MaterialTheme.colorScheme.onBackground.copy(
                                0.1f
                            )
                        ), onClick = { isDialogOpen.value = true }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = ""
                        )
                    }
                }, actions = {
                    IconButton(
                        modifier = Modifier,
                        onClick = { }) {
                        BadgedBox(
                            badge = {
                                if (countBadges > 0) {
                                    Badge(
                                        modifier = Modifier.wrapContentSize(),
                                    ) {
                                        Text(
                                            modifier = Modifier,
                                            text = "$countBadges"
                                        )
                                    }
                                }
                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_share),
                                contentDescription = ""
                            )
                        }
                    }
                    IconButton(onClick = {}) {
                        BadgedBox(
                            badge = {
                                if (isHasNewNotification) {
                                    Badge()
                                }
                            }) {
                            Icon(
                                painter = painterResource(R.drawable.ic_more_vert),
                                contentDescription = ""
                            )
                        }
                    }
                }, colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onBackground,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        bottomBar = {
            Row {
                FilledTonalButton(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        isHasNewNotification = !isHasNewNotification
                    }) {
                    Text(
                        text = "Update State"
                    )
                }
                FilledTonalButton(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        countBadges++
                    }) {
                    Text(
                        modifier = Modifier,
                        text = "Count"
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Button(

                onClick = {}) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_share),
                        contentDescription = null
                    )
                    Text(
                        text = "Button",
                        fontSize = 18.sp
                    )
                }
            }
            SpacerAndDivider()
            FilledTonalButton(onClick = {}) {
                Row{
                    Text(
                        text = "Filled Tonal Button",
                        fontSize = 18.sp
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_share),
                        contentDescription = null
                    )
                }
            }
            SpacerAndDivider()
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.teal_200)
                ),
                onClick = {
                    text = ""
                }) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_share),
                        contentDescription = null
                    )
                    Text(
                        text = "Remove Text",
                        fontSize = 18.sp
                    )
                }
            }
            SpacerAndDivider()
            FilledTonalButton(
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = colorResource(R.color.teal_700),
                    contentColor = colorResource(R.color.black)
                ),
                onClick = {
                text = "Hello World!!!!"
            }) {
                Row {
                    Text(
                        text = "Set Text",
                        fontSize = 18.sp
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_share),
                        contentDescription = null
                    )
                }
            }
            SpacerAndDivider()
            Text(
                text = text
            )
            SpacerAndDivider()
            FilledTonalIconToggleButton(
                checked = isChecked,
                onCheckedChange = { value ->
                    isChecked = value
                }
            ) {
                if (isChecked) {
                    Icon(
                        painter = painterResource(R.drawable.ic_check),
                        contentDescription = null
                    )
                } else {
                    Icon(
                        painter = painterResource(R.drawable.ic_unchecked),
                        contentDescription = null
                    )
                }
            }
            SpacerAndDivider()
            OutlinedButton(
                onClick = {}
            ) {
                Text("Out Line Button")
            }
            SpacerAndDivider()
            ElevatedButton(
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 15.dp,
                    pressedElevation = 30.dp
                ),
                onClick = {}
            ) {
                Text("Elevated Button")
            }
            SpacerAndDivider()
            TextButton(
                onClick = {}
            ) {
                Text(
                    text="Text Button",
                    fontSize = 24.sp
                )
            }
        }
    }
}

@Composable
fun SpacerAndDivider(){
    Spacer(Modifier.height(16.dp))
    HorizontalDivider()
    Spacer(Modifier.height(16.dp))
}

@Composable
@Preview(showBackground = true, device = "id:pixel_9_pro", showSystemUi = false)
fun ScreenButtonPreview() {
    MyApplicationTheme {
        ScreenButton()
    }
}