package com.example.myapplication.compose.combinedrawerandbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.compose.navigationbar.NavigationBarItemModel
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCombineDrawerAndBar() {
    val itemInNavigationBar = navigationBarItem
    var selectedIndex by remember { mutableIntStateOf(0) }
    val drawerState = rememberDrawerState(DrawerValue.Open)
    val scope = rememberCoroutineScope()
    var label by remember { mutableStateOf("") }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(0.dp),
                windowInsets = WindowInsets.navigationBars
            ) {
                DrawerSheetContent { menuItem ->
                    label = menuItem.title
                    scope.launch {
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
                        Text(
                            text = when (selectedIndex) {
                                0 -> "Home"
                                1 -> "Video"
                                2 -> "Settings"
                                else -> "CombineDrawerAndBar"
                            }
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    if (drawerState.isClosed) {
                                        drawerState.open()
                                    } else {
                                        drawerState.close()
                                    }
                                }
                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_menu),
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar(
                ) {
                    itemInNavigationBar.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = index == selectedIndex,
                            onClick = {
                                selectedIndex = index
                            },
                            icon = {
                                Icon(
                                    painterResource(item.icon),
                                    contentDescription = null
                                )
                            },
                            label = {
                                Text(
                                    text = item.label
                                )
                            }
                        )
                    }
                }
            }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                when (selectedIndex) {
                    0 -> Home(Modifier)
                    1 -> Video(Modifier)
                    2 -> Setting(Modifier)
                }

                if (label.isNotEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Text(
                            text = "Last drawer action: $label",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier
                                .background(
                                    MaterialTheme.colorScheme.secondaryContainer,
                                    MaterialTheme.shapes.small
                                )
                                .padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_9_pro")
@Composable
fun ScreenCombineDrawerAndBarPreview() {
    MyApplicationTheme {
        ScreenCombineDrawerAndBar()
    }
}

@Composable
fun DrawerSheetContent(
    onClick: (NavDrawerItem) -> Unit
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .statusBarsPadding()
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(66.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Navigation Drawer",
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 20.sp
            )
        }
    }
        HorizontalDivider()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
        ) {
            navDrawerItems.forEach { item ->
                NavigationDrawerItem(
                    label = {
                        Text(item.title)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = null
                        )
                    },
                    selected = item.selected,
                    onClick = {
                        onClick(item)
                    }
                )
            }
        }
    }





@Composable
fun Home(modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
            .then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home")
    }
}

@Composable
fun Video(modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Video")
    }
}

@Composable
fun Setting(modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.onPrimary)
            .then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Setting")
    }
}

data class NavDrawerItem(
    val id: Int,
    val title: String,
    @DrawableRes val icon: Int,
    val selected: Boolean = false
)

val navigationBarItem = listOf<NavigationBarItemModel>(
    NavigationBarItemModel(
        id = 1,
        icon = R.drawable.ic_home,
        label = "Home"
    ),
    NavigationBarItemModel(
        id = 2,
        icon = R.drawable.ic_videocam,
        label = "Video"
    ),
    NavigationBarItemModel(
        id = 3,
        icon = R.drawable.ic_settings,
        label = "Setting"
    ),
)

val navDrawerItems = listOf(
    NavDrawerItem(
        id = 1,
        title = "Inbox",
        icon = R.drawable.ic_inbox,
        selected = false
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