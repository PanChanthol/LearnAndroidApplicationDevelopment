package com.example.myapplication.compose.chips

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenRecapChips(){
    var filterSelected by remember { mutableStateOf(false) }
    var inputSelected by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Chips")
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
        }
    ) { padding->
        Column(
            Modifier.padding(padding)
        ) {
            Row(

            ) {
                // Assist Chip
                AssistChip(
                    onClick = { },
                    label = { Text("Assist") },
                    leadingIcon = {
                        Icon(
                            painterResource(R.drawable.ic_check),
                            contentDescription = null
                        )
                    }
                )

                // Filter Chip
                FilterChip(
                    selected = filterSelected,
                    onClick = {
                        filterSelected = !filterSelected
                    },
                    label = { Text("Filter") },
                    leadingIcon = if (filterSelected) {
                        {
                            Icon(
                                painterResource(R.drawable.ic_check),
                                contentDescription = null
                            )
                        }
                    } else null
                )

                // Input Chip
                InputChip(
                    selected = inputSelected,
                    onClick = {
                        inputSelected = !inputSelected
                    },
                    label = { Text("Android") },
                    avatar = {
                        Icon(
                            painterResource(R.drawable.ic_check),
                            contentDescription = null
                        )
                    }
                )

                // Suggestion Chip
                SuggestionChip(
                    onClick = { },
                    label = { Text("Kotlin") },
                    icon = {
                        Icon(
                            painterResource(R.drawable.ic_check),
                            contentDescription = null
                        )
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenRecapChipsPReview(){
    MyApplicationTheme {
        ScreenRecapChips()
    }
}