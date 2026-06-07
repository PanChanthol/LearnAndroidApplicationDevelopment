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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCheckBox() {
    var checkList by remember { mutableStateOf(checkList) }
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
            val isAllChecked = checkList.all { it.checked }
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isAllChecked,
                    onCheckedChange = { isChecked ->
                        checkList = checkList.map { item ->
                            item.copy(checked = isChecked)
                        }
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
                                checkList = checkList.map { item->
                                    if (item.id== value.id){
                                        item.copy(checked = !item.checked)
                                    }else{
                                        item
                                    }
                                }
                            }
                        )
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    Checkbox(
                        checked = value.checked,
                        onCheckedChange = { isChecked ->
                            checkList = checkList.map { item->
                                if (item.id== value.id){
                                    item.copy(checked = isChecked)
                                }else{
                                    item
                                }
                            }
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
//    Spacer(Modifier.height(8.dp))
    HorizontalDivider()
//    Spacer(Modifier.height(8.dp))
}

@Composable
@Preview(showBackground = true)
fun ScreenCheckBoxPreview() {
    MyApplicationTheme {
        ScreenCheckBox()
    }
}

data class CheckListModel(
    val id: Int,
    val title: String,
    var checked: Boolean = false
)

val checkList = listOf(
    CheckListModel(id = 1, title = "Learn Kotlin Basics"),
    CheckListModel(id = 2, title = "Practice Jetpack Compose"),
    CheckListModel(id = 3, title = "Create Login Screen"),
    CheckListModel(id = 4, title = "Build Banking Dashboard"),
    CheckListModel(id = 5, title = "Connect Oracle Database"),
    CheckListModel(id = 6, title = "Learn State Management"),
    CheckListModel(id = 7, title = "Design Transaction UI"),
    CheckListModel(id = 8, title = "Implement Navigation"),
    CheckListModel(id = 9, title = "Test Application"),
    CheckListModel(id = 10, title = "Deploy Final Project")
)
