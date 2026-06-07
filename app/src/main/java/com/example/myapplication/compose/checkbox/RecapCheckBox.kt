package com.example.myapplication.compose.checkbox

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenRecapCheckBox(){
    val components = remember {
        mutableStateListOf(
            CheckBoxItem(
                id = "1",
                title = "Button",
                description = "Material3 Button Component",
                checked = false
            ),
            CheckBoxItem(
                id = "2",
                title = "Card",
                description = "Material3 Card Component",
                checked = false
            ),
            CheckBoxItem(
                id = "3",
                title = "Checkbox",
                description = "Material3 Checkbox Component",
                checked = false
            ),
            CheckBoxItem(
                id = "4",
                title = "Switch",
                description = "Material3 Switch Component",
                checked = false
            ),
            CheckBoxItem(
                id = "5",
                title = "Slider",
                description = "Material3 Slider Component",
                checked = false
            ),
            CheckBoxItem(
                id = "6",
                title = "TextField",
                description = "Material3 TextField Component",
                checked = false
            ),
            CheckBoxItem(
                id = "7",
                title = "Assist Chip",
                description = "Material3 Assist Chip",
                checked = false
            ),
            CheckBoxItem(
                id = "8",
                title = "Filter Chip",
                description = "Material3 Filter Chip",
                checked = false
            ),
            CheckBoxItem(
                id = "9",
                title = "Suggestion Chip",
                description = "Material3 Suggestion Chip",
                checked = false
            ),
            CheckBoxItem(
                id = "10",
                title = "Navigation Bar",
                description = "Material3 Navigation Bar",
                checked = false
            )
        )
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("RecapCheckBoxSingleChoice")
                },
                navigationIcon = {
                    Icon(
                        painterResource(R.drawable.ic_arrow_back),
                        contentDescription = null
                    )
                }
            )
        }
    ) { padding->
        Column(
            Modifier.padding(padding)
                .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
        ) {
            components.forEachIndexed { index, item ->

            Row(
                modifier = Modifier
                    .height(64.dp)
                    .clickable(onClick = {
                        components[index] = item.copy(checked = !item.checked)
                    })
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = item.checked,
                    onCheckedChange = { isChecked->
                        components[index] = item.copy(checked = isChecked)
                    }
                )
                Column(

                ) {
                Text(
                    text=item.title,
                    textDecoration =if (item.checked) TextDecoration.LineThrough else null
                )
                Text(
                    text=item.description,
                    fontSize = 12.sp
                )
                }
            }
            HorizontalDivider()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenRecapCheckBoxPreview(){
    MyApplicationTheme {
        ScreenRecapCheckBox()
    }
}

data class CheckBoxItem(
    val id: String,
    val title: String,
    val description: String,
    val checked: Boolean
)