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
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTextField(viewModel: TextFieldViewModel = viewModel()) {
    val showFormContact by viewModel.showFormContact

    if (showFormContact) {
        ContactForm(
            viewModel = viewModel,
            onDismiss = { viewModel.setShowFormContact(false) }
        )
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
                    viewModel.setShowFormContact(true)
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
    viewModel: TextFieldViewModel,
    onDismiss: () -> Unit
) {
    val valueName by viewModel.valueName
    val valueEmail by viewModel.valueEmail
    val valueMessage by viewModel.valueMessage
    val expanded by viewModel.expanded
    val selectedItem by viewModel.selectedItem
    val items = viewModel.items

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
                    text = "Name",
                    fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
                )
                TextField(
                    value = valueName,
                    onValueChange = { viewModel.onValueNameChange(it) },
                    placeholder = {
                        Text("Enter Name")
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
                    onValueChange = { viewModel.onValueEmailChange(it) },
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
                        viewModel.setExpanded(it)
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
                            .menuAnchor(
                                type = ExposedDropdownMenuAnchorType.PrimaryNotEditable,
                                enabled = true
                            ),
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            viewModel.setExpanded(false)
                        },
                    ) {
                        items.forEach { item ->
                            DropdownMenuItem(
                                text = {
                                    Text(item)
                                },
                                onClick = {
                                    viewModel.setSelectedItem(item)
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
                    onValueChange = { viewModel.onValueMessageChange(it) },
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
