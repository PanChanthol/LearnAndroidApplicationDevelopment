package com.example.myapplication.compose.checkbox

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCheckBox(viewModel: CheckBoxViewModel = viewModel()) {
    val checkList = viewModel.checkList
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("CheckBox")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painterResource(R.drawable.ic_arrow_back),
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
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                }
            ) {
                Text("Add")
            }
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {
            val isAllChecked = viewModel.isAllChecked()
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isAllChecked,
                    onCheckedChange = { isChecked ->
                        viewModel.toggleAll(isChecked)
                    }
                )
                Text("Check All")
            }
            checkList.forEach { value ->
                Row(
                    Modifier
                        .height(64.dp)
                        .clickable(
                            onClick = {
                                viewModel.toggleCheck(value.id)
                            }
                        )
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    Checkbox(
                        checked = value.checked,
                        onCheckedChange = { isChecked ->
                            viewModel.setChecked(value.id, isChecked)
                        }
                    )
                    Text(
                        text = value.title,
                        textDecoration = if (value.checked) TextDecoration.LineThrough else null,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            SpacerAndDivider()
            }
        }
    }
}


@Composable
fun SpacerAndDivider() {
    HorizontalDivider()
}

@Composable
@Preview(showBackground = true)
fun ScreenCheckBoxPreview() {
    MyApplicationTheme {
        ScreenCheckBox()
    }
}
