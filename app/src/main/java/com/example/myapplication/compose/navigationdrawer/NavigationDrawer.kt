package com.example.myapplication.compose.navigationdrawer

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenNavigationDrawer() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var label by remember { mutableStateOf("") }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = MaterialTheme.colorScheme.surface,
            ) {
                DrawerItem { menuItem ->
                    label = menuItem.title
                    scope.launch {
                        when (menuItem.id) {
                            1 -> {
                            drawerState.close()
                            }
                        }
                        drawerState.close()
                    }
                }
            }
        },
        gesturesEnabled = true
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text("Navigation Drawer")
                    },
                    navigationIcon = {
                        Icon(
                            modifier = Modifier.clickable(
                                onClick = {
                                    scope.launch {
                                        if (drawerState.isClosed) {
                                            drawerState.open()
                                        } else {
                                            drawerState.close()
                                        }
                                    }
                                }
                            ),
                            painter = painterResource(R.drawable.ic_menu),
                            contentDescription = null
                        )
                    },
                    actions = {
                        Icon(
                            painterResource(R.drawable.ic_share),
                            contentDescription = null
                        )
                        Icon(
                            painterResource(R.drawable.ic_account),
                            contentDescription = null
                        )
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = label,
                )
            }
        }
    }
}

@Composable
fun DrawerItem(onClick: (menuItems: NavDrawerItem) -> Unit) {
    val menuItems = navDrawerItems
    Column(
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.primary)
                .height(64.dp),
            contentAlignment = Alignment.Center

        ) {
            Text(
                text = "Navigation Drawer",
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        menuItems.forEach { item ->
            NavigationDrawerItem(
                label = {
                    Text(
                        text = item.title,
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = null
                    )
                },
                selected = item.selected,
                onClick = { onClick(item) }
            )
            HorizontalDivider()
        }
    }
}


@Composable
@Preview(showBackground = true)
fun ScreenNavigationDrawerPreview() {
    MaterialTheme {
        MyApplicationTheme {
            ScreenNavigationDrawer()
        }
    }
}

data class NavDrawerItem(
    val id: Int,
    val title: String,
    @DrawableRes val icon: Int,
    val selected: Boolean = false
)

val navDrawerItems = listOf(
    NavDrawerItem(
        id = 1,
        title = "Inbox",
        icon = R.drawable.ic_inbox,
        selected = true
    ),
    NavDrawerItem(
        id = 2,
        title = "Starred",
        icon = R.drawable.ic_star,
        selected = false
    ),
    NavDrawerItem(
        id = 3,
        title = "Snoozed",
        icon = R.drawable.ic_alarm,
        selected = false
    ),
    NavDrawerItem(
        id = 4,
        title = "Important",
        icon = R.drawable.ic_important,
        selected = false
    ),
    NavDrawerItem(
        id = 5,
        title = "Sent",
        icon = R.drawable.ic_send,
        selected = false
    ),
    NavDrawerItem(
        id = 6,
        title = "Scheduled",
        icon = R.drawable.ic_schedule_send,
        selected = false
    ),
    NavDrawerItem(
        id = 7,
        title = "Outbox",
        icon = R.drawable.ic_outbox,
        selected = false
    ),
    NavDrawerItem(
        id = 8,
        title = "Drafts",
        icon = R.drawable.ic_draft,
        selected = false
    ),
    NavDrawerItem(
        id = 9,
        title = "All Mail",
        icon = R.drawable.ic_all_inbox,
        selected = false
    ),
    NavDrawerItem(
        id = 10,
        title = "Spam",
        icon = R.drawable.ic_report,
        selected = false
    ),
    NavDrawerItem(
        id = 11,
        title = "Trash",
        icon = R.drawable.ic_delete,
        selected = false
    ),
    NavDrawerItem(
        id = 12,
        title = "Settings",
        icon = R.drawable.ic_settings,
        selected = false
    )
)