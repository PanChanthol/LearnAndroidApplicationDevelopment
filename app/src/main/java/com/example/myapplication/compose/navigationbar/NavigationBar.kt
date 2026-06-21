package com.example.myapplication.compose.navigationbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenNavigationBar(viewModel: NavigationBarViewModel = viewModel()) {
    val itemsInNavigationBar = viewModel.navigationBarItems
    val selectedIndex by viewModel.selectedIndex

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("NavigationBar")
                },
                navigationIcon = {
                    Icon(
                        painterResource(R.drawable.ic_arrow_back),
                        contentDescription = null
                    )
                },
                actions = {
                    Icon(
                        painterResource(R.drawable.ic_share),
                        contentDescription = null
                    )
                    Icon(
                        painterResource(R.drawable.ic_more_vert),
                        contentDescription = null
                    )
                }
            )
        },
        bottomBar = {
            NavigationBar(
            ) {
                itemsInNavigationBar.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == selectedIndex,
                        onClick = {
                            viewModel.onItemSelected(index)
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
    ) { padding ->

        when (selectedIndex) {
            0 -> {
                Home(modifier = Modifier.padding(padding))
            }

            1 -> {
                Video(modifier = Modifier.padding(padding))
            }

            2 -> {
                Setting(modifier = Modifier.padding(padding))
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun ScreenNavigationBarPreview() {
    MaterialTheme {
        MyApplicationTheme {
            ScreenNavigationBar()
        }
    }
}

data class NavigationBarItemModel(
    val id: Int,
    @DrawableRes val icon: Int,
    val label: String
)

val navigationBarItem = listOf<NavigationBarItemModel>(
    NavigationBarItemModel(
        id = 1,
        icon = R.drawable.ic_home,
        label = "Home"
    ),
    NavigationBarItemModel(
        id = 1,
        icon = R.drawable.ic_videocam,
        label = "Video"
    ),
    NavigationBarItemModel(
        id = 1,
        icon = R.drawable.ic_settings,
        label = "Setting"
    ),
)

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
