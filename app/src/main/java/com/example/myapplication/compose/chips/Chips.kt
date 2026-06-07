package com.example.myapplication.compose.chips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AssistChip
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenChips() {

    var selectedType by remember {
        mutableStateOf<String?>(null)
    }

    val filterTypeOfChips = if (selectedType == null) {
        chipsList
    } else {
        chipsList.filter {
            it.typeOfChips == selectedType
        }
    }

    Scaffold(
        contentColor = MaterialTheme.colorScheme.onBackground,
        containerColor = MaterialTheme.colorScheme.background,

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

    ) { padding ->

        Column(
            modifier = Modifier.padding(padding)
        ) {

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),

                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    FilterChip(
                        selected = selectedType == null,
                        onClick = {
                            selectedType = null
                        },
                        label = {
                            Text("All")
                        },
                        trailingIcon = {
                            Icon(
                                painterResource(R.drawable.ic_check),
                                contentDescription = null
                            )
                        }
                    )
                }
                item {
                    AssistChip(
                        onClick = {
                            selectedType = "Assist Chip"
                        },
                        label = {
                            Text("Assist")
                        },
                        leadingIcon = {
                            Icon(
                                painterResource(R.drawable.ic_plus),
                                contentDescription = null
                            )
                        },
//                        colors = AssistChipDefaults.assistChipColors(
//                            containerColor = MaterialTheme.colorScheme.onPrimary,
//                            labelColor = MaterialTheme.colorScheme.primaryContainer
//                        )
                    )
                }
                item {
                    FilterChip(
                        selected = selectedType == "Filter Chip",
                        onClick = {
                            selectedType = "Filter Chip"
                        },
                        label = {
                            Text("Filter")
                        }
                    )
                }
                item {
                    InputChip(
                        selected = selectedType == "Input Chip",
                        onClick = {
                            selectedType = "Input Chip"
                        },
                        label = {
                            Text("Input")
                        }
                    )
                }
                item {
                    SuggestionChip(
                        onClick = {
                            selectedType = "Suggestion Chip"
                        },
                        label = {
                            Text("Suggestion")
                        }
                    )
                }

            }

            LazyColumn {

                items(filterTypeOfChips) { item ->

                    Row(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .height(64.dp)
                            .fillMaxWidth(),

                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "${item.name} - ${item.typeOfChips}"
                        )
                    }

                    HorizontalDivider()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenChipsPreview() {
    MyApplicationTheme {
        ScreenChips()
    }
}

data class ChipsModel(val name: String, val typeOfChips: String)

val chipsList =
    listOf(
        ChipsModel(name = "Settings", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Call", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Message", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Navigate", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Share", typeOfChips = "Assist Chip"),
        ChipsModel(name = "All", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Unread", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Starred", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Attachments", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Recent", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Android", typeOfChips = "Input Chip"),
        ChipsModel(name = "Kotlin", typeOfChips = "Input Chip"),
        ChipsModel(name = "Compose", typeOfChips = "Input Chip"),
        ChipsModel(name = "Material3", typeOfChips = "Input Chip"),
        ChipsModel(name = "Dark Mode", typeOfChips = "Input Chip"),
        ChipsModel(name = "Add to Calendar", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Set Reminder", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Open Map", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Reply", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Save Draft", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Settings", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Call", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Message", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Navigate", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Share", typeOfChips = "Assist Chip"),
        ChipsModel(name = "All", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Unread", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Starred", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Attachments", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Recent", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Android", typeOfChips = "Input Chip"),
        ChipsModel(name = "Kotlin", typeOfChips = "Input Chip"),
        ChipsModel(name = "Compose", typeOfChips = "Input Chip"),
        ChipsModel(name = "Material3", typeOfChips = "Input Chip"),
        ChipsModel(name = "Dark Mode", typeOfChips = "Input Chip"),
        ChipsModel(name = "Add to Calendar", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Set Reminder", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Open Map", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Reply", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Save Draft", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Settings", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Call", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Message", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Navigate", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Share", typeOfChips = "Assist Chip"),
        ChipsModel(name = "All", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Unread", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Starred", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Attachments", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Recent", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Android", typeOfChips = "Input Chip"),
        ChipsModel(name = "Kotlin", typeOfChips = "Input Chip"),
        ChipsModel(name = "Compose", typeOfChips = "Input Chip"),
        ChipsModel(name = "Material3", typeOfChips = "Input Chip"),
        ChipsModel(name = "Dark Mode", typeOfChips = "Input Chip"),
        ChipsModel(name = "Add to Calendar", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Set Reminder", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Open Map", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Reply", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Save Draft", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Settings", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Call", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Message", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Navigate", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Share", typeOfChips = "Assist Chip"),
        ChipsModel(name = "All", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Unread", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Starred", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Attachments", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Recent", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Android", typeOfChips = "Input Chip"),
        ChipsModel(name = "Kotlin", typeOfChips = "Input Chip"),
        ChipsModel(name = "Compose", typeOfChips = "Input Chip"),
        ChipsModel(name = "Material3", typeOfChips = "Input Chip"),
        ChipsModel(name = "Dark Mode", typeOfChips = "Input Chip"),
        ChipsModel(name = "Add to Calendar", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Set Reminder", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Open Map", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Reply", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Save Draft", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Settings", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Call", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Message", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Navigate", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Share", typeOfChips = "Assist Chip"),
        ChipsModel(name = "All", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Unread", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Starred", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Attachments", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Recent", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Android", typeOfChips = "Input Chip"),
        ChipsModel(name = "Kotlin", typeOfChips = "Input Chip"),
        ChipsModel(name = "Compose", typeOfChips = "Input Chip"),
        ChipsModel(name = "Material3", typeOfChips = "Input Chip"),
        ChipsModel(name = "Dark Mode", typeOfChips = "Input Chip"),
        ChipsModel(name = "Add to Calendar", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Set Reminder", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Open Map", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Reply", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Save Draft", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Settings", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Call", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Message", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Navigate", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Share", typeOfChips = "Assist Chip"),
        ChipsModel(name = "All", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Unread", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Starred", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Attachments", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Recent", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Android", typeOfChips = "Input Chip"),
        ChipsModel(name = "Kotlin", typeOfChips = "Input Chip"),
        ChipsModel(name = "Compose", typeOfChips = "Input Chip"),
        ChipsModel(name = "Material3", typeOfChips = "Input Chip"),
        ChipsModel(name = "Dark Mode", typeOfChips = "Input Chip"),
        ChipsModel(name = "Add to Calendar", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Set Reminder", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Open Map", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Reply", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Save Draft", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Settings", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Call", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Message", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Navigate", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Share", typeOfChips = "Assist Chip"),
        ChipsModel(name = "All", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Unread", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Starred", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Attachments", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Recent", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Android", typeOfChips = "Input Chip"),
        ChipsModel(name = "Kotlin", typeOfChips = "Input Chip"),
        ChipsModel(name = "Compose", typeOfChips = "Input Chip"),
        ChipsModel(name = "Material3", typeOfChips = "Input Chip"),
        ChipsModel(name = "Dark Mode", typeOfChips = "Input Chip"),
        ChipsModel(name = "Add to Calendar", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Set Reminder", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Open Map", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Reply", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Save Draft", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Settings", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Call", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Message", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Navigate", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Share", typeOfChips = "Assist Chip"),
        ChipsModel(name = "All", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Unread", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Starred", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Attachments", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Recent", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Android", typeOfChips = "Input Chip"),
        ChipsModel(name = "Kotlin", typeOfChips = "Input Chip"),
        ChipsModel(name = "Compose", typeOfChips = "Input Chip"),
        ChipsModel(name = "Material3", typeOfChips = "Input Chip"),
        ChipsModel(name = "Dark Mode", typeOfChips = "Input Chip"),
        ChipsModel(name = "Add to Calendar", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Set Reminder", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Open Map", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Reply", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Save Draft", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Settings", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Call", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Message", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Navigate", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Share", typeOfChips = "Assist Chip"),
        ChipsModel(name = "All", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Unread", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Starred", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Attachments", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Recent", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Android", typeOfChips = "Input Chip"),
        ChipsModel(name = "Kotlin", typeOfChips = "Input Chip"),
        ChipsModel(name = "Compose", typeOfChips = "Input Chip"),
        ChipsModel(name = "Material3", typeOfChips = "Input Chip"),
        ChipsModel(name = "Dark Mode", typeOfChips = "Input Chip"),
        ChipsModel(name = "Add to Calendar", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Set Reminder", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Open Map", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Reply", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Save Draft", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Settings", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Call", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Message", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Navigate", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Share", typeOfChips = "Assist Chip"),
        ChipsModel(name = "All", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Unread", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Starred", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Attachments", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Recent", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Android", typeOfChips = "Input Chip"),
        ChipsModel(name = "Kotlin", typeOfChips = "Input Chip"),
        ChipsModel(name = "Compose", typeOfChips = "Input Chip"),
        ChipsModel(name = "Material3", typeOfChips = "Input Chip"),
        ChipsModel(name = "Dark Mode", typeOfChips = "Input Chip"),
        ChipsModel(name = "Add to Calendar", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Set Reminder", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Open Map", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Reply", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Save Draft", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Settings", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Call", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Message", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Navigate", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Share", typeOfChips = "Assist Chip"),
        ChipsModel(name = "All", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Unread", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Starred", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Attachments", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Recent", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Android", typeOfChips = "Input Chip"),
        ChipsModel(name = "Kotlin", typeOfChips = "Input Chip"),
        ChipsModel(name = "Compose", typeOfChips = "Input Chip"),
        ChipsModel(name = "Material3", typeOfChips = "Input Chip"),
        ChipsModel(name = "Dark Mode", typeOfChips = "Input Chip"),
        ChipsModel(name = "Add to Calendar", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Set Reminder", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Open Map", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Reply", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Save Draft", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Settings", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Call", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Message", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Navigate", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Share", typeOfChips = "Assist Chip"),
        ChipsModel(name = "All", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Unread", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Starred", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Attachments", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Recent", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Android", typeOfChips = "Input Chip"),
        ChipsModel(name = "Kotlin", typeOfChips = "Input Chip"),
        ChipsModel(name = "Compose", typeOfChips = "Input Chip"),
        ChipsModel(name = "Material3", typeOfChips = "Input Chip"),
        ChipsModel(name = "Dark Mode", typeOfChips = "Input Chip"),
        ChipsModel(name = "Add to Calendar", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Set Reminder", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Open Map", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Reply", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Save Draft", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Settings", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Call", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Message", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Navigate", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Share", typeOfChips = "Assist Chip"),
        ChipsModel(name = "All", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Unread", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Starred", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Attachments", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Recent", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Android", typeOfChips = "Input Chip"),
        ChipsModel(name = "Kotlin", typeOfChips = "Input Chip"),
        ChipsModel(name = "Compose", typeOfChips = "Input Chip"),
        ChipsModel(name = "Material3", typeOfChips = "Input Chip"),
        ChipsModel(name = "Dark Mode", typeOfChips = "Input Chip"),
        ChipsModel(name = "Add to Calendar", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Set Reminder", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Open Map", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Reply", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Save Draft", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Settings", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Call", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Message", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Navigate", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Share", typeOfChips = "Assist Chip"),
        ChipsModel(name = "All", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Unread", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Starred", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Attachments", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Recent", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Android", typeOfChips = "Input Chip"),
        ChipsModel(name = "Kotlin", typeOfChips = "Input Chip"),
        ChipsModel(name = "Compose", typeOfChips = "Input Chip"),
        ChipsModel(name = "Material3", typeOfChips = "Input Chip"),
        ChipsModel(name = "Dark Mode", typeOfChips = "Input Chip"),
        ChipsModel(name = "Add to Calendar", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Set Reminder", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Open Map", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Reply", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Save Draft", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Settings", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Call", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Message", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Navigate", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Share", typeOfChips = "Assist Chip"),
        ChipsModel(name = "All", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Unread", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Starred", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Attachments", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Recent", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Android", typeOfChips = "Input Chip"),
        ChipsModel(name = "Kotlin", typeOfChips = "Input Chip"),
        ChipsModel(name = "Compose", typeOfChips = "Input Chip"),
        ChipsModel(name = "Material3", typeOfChips = "Input Chip"),
        ChipsModel(name = "Dark Mode", typeOfChips = "Input Chip"),
        ChipsModel(name = "Add to Calendar", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Set Reminder", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Open Map", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Reply", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Save Draft", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Settings", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Call", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Message", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Navigate", typeOfChips = "Assist Chip"),
        ChipsModel(name = "Share", typeOfChips = "Assist Chip"),
        ChipsModel(name = "All", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Unread", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Starred", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Attachments", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Recent", typeOfChips = "Filter Chip"),
        ChipsModel(name = "Android", typeOfChips = "Input Chip"),
        ChipsModel(name = "Kotlin", typeOfChips = "Input Chip"),
        ChipsModel(name = "Compose", typeOfChips = "Input Chip"),
        ChipsModel(name = "Material3", typeOfChips = "Input Chip"),
        ChipsModel(name = "Dark Mode", typeOfChips = "Input Chip"),
        ChipsModel(name = "Add to Calendar", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Set Reminder", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Open Map", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Reply", typeOfChips = "Suggestion Chip"),
        ChipsModel(name = "Save Draft", typeOfChips = "Suggestion Chip"),
    )