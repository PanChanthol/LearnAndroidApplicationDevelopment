package com.example.myapplication.compose.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTextField() {
    var valueName by rememberSaveable { mutableStateOf("") }
    var valueEmail by rememberSaveable { mutableStateOf("") }
    var valueMessage by rememberSaveable { mutableStateOf("") }
    var showFormContact by remember { mutableStateOf(false) }

    when (showFormContact) {
        true -> ContactForm(
            isFormContact = showFormContact,
            valueName = valueName,
            valueEmail = valueEmail,
            valueMessage = valueMessage,
            onValueName = { valueName = it },
            onValueEmail = { valueEmail = it },
            onValueMessage = { valueMessage = it },
            onDismiss = { showFormContact = false }
        )
        else -> {}
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("TextField")
                }
            )
        },
        bottomBar = {
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    showFormContact = !showFormContact
                }
            ) {
                Text("Show Form Contact")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
//            ContactForm(
//                isFormContact = showFormContact,
//                valueState = value,
//                onValueChange = { value = it }
//            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenTextFieldPreview() {
    MaterialTheme {
        MyApplicationTheme {
            ScreenTextField()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactForm(
    isFormContact: Boolean,
    valueName: String,
    valueEmail: String,
    valueMessage: String,
    onValueName: (String) -> Unit,
    onValueEmail: (String) -> Unit,
    onValueMessage: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val items = listOf("Java", "Kotlin", "Oracle Database", "Networking", "UX/UI")
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf(items[0]) }
    if (isFormContact) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            )
        ) {
            Column(
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.background)
                    .fillMaxSize(),

                ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    text = "Contact Form",
                    fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(end = 16.dp),
                        text = "First Name",
                        fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
                    )
                    TextField(
                        value = valueName,
                        onValueChange = onValueName,
                        placeholder = {
                            Text("Enter First Name")
                        },
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        maxLines = 1,
                        supportingText = {
                            Text("Required")
                        },
                        isError = valueName.length < 10,
                        visualTransformation = VisualTransformation.None,
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent, // hide the line indicator
                        ),
                    )
                    Text(
                        modifier = Modifier.padding(end = 16.dp),
                        text = "Email",
                        fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
                    )
                    TextField(
                        value = valueEmail,
                        onValueChange = onValueEmail,
                        placeholder = {
                            Text("Enter Email")
                        },
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        maxLines = 1,
                        supportingText = {
                            Text("Required")
                        },
                        isError = valueEmail.length < 10,
                        visualTransformation = VisualTransformation.None,
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent, // hide the line indicator
                        ),
                    )
                    Text(
                        modifier = Modifier.padding(end = 16.dp),
                        text = "Service",
                        fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
                    )
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = {
                            expanded = !expanded
                        }
                    ) {
                        TextField(
                            value = selectedItem,
                            onValueChange = {},
                            readOnly = true,
                            supportingText = {
                                Text("Required")
                            },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(
                                    expanded = expanded
                                )
                            },
                            shape = MaterialTheme.shapes.medium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .menuAnchor()
                        )
                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = {
                                expanded = false
                            },
                        ) {
                            items.forEach { item ->
                                DropdownMenuItem(
                                    text = {
                                        Text(item)
                                    },
                                    onClick = {
                                        selectedItem = item
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }
                    Text(
                        modifier = Modifier.padding(end = 16.dp),
                        text = "Message",
                        fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
                    )
                    TextField(
                        value = valueMessage,
                        onValueChange = onValueMessage,
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        visualTransformation = VisualTransformation.None,
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent, // hide the line indicator
                        ),
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Button(
                            modifier = Modifier.weight(1f),
                            onClick = onDismiss,
                        ) {
                            Text("Cancel")
                        }
                        Button(
                            modifier = Modifier.weight(1f),
                            onClick = onDismiss,
                        ) {
                            Text("Sent Message")
                        }
                    }
                }
            }
        }
    }
}
