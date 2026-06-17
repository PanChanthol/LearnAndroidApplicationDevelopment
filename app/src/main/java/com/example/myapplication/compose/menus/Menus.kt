package com.example.myapplication.compose.menus

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
fun ScreenMenus() {
    var expanded by remember { mutableStateOf(false) }
    var expandedItem by remember { mutableStateOf<String?>(null) }
    val items = items
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Menus")
                },
                navigationIcon = {
                    Icon(
                        painterResource(R.drawable.ic_arrow_back),
                        contentDescription = null
                    )
                },
                actions = {
                    Icon(
                        modifier = Modifier
                            .clickable(
                                onClick = {expanded = true}
                            ),
                        painter = painterResource(R.drawable.ic_more_vert),
                        contentDescription = null
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        items.forEach { item ->

                            DropdownMenuItem(
                                text = { Text(item.title) },
                                onClick = {
                                    expandedItem =
                                        if (expandedItem == item.title) null
                                        else item.title
                                },
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(item.icon),
                                        contentDescription = null
                                    )
                                }

                            )

                            if (expandedItem == item.title) {
                                item.children.forEach { child ->
                                    DropdownMenuItem(
                                        text = {
                                            Text("    ${child.title}")
                                        },
                                        onClick = { },
                                        leadingIcon = {
                                            Icon(
                                                painter = painterResource(child.icon),
                                                contentDescription = null
                                            )
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenMenusPreview() {
    MaterialTheme {
        MyApplicationTheme {
            ScreenMenus()
        }
    }
}

data class DropDownMenusItems(
    val title: String,
    @DrawableRes val icon: Int,
    val children: List<DropDownMenusItems> = emptyList()
)

val items = listOf(
    DropDownMenusItems("Home", R.drawable.ic_home),
    DropDownMenusItems(
        "Settings",
        R.drawable.ic_settings,
        children = listOf(
            DropDownMenusItems("Account", R.drawable.ic_account),
            DropDownMenusItems("Privacy", R.drawable.ic_report),
            DropDownMenusItems("Notification", R.drawable.ic_inbox)
        )
    ),
    DropDownMenusItems("Logout", R.drawable.ic_close)
)