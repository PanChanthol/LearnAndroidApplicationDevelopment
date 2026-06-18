package com.example.myapplication.compose.toolbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenToolBar(){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("ToolBar")
                }
            )
        },
        bottomBar = {
        }
    ) {padding->
        Column(
            modifier = Modifier.padding(padding)
        ) {

        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenToolBarPreview() {
    MaterialTheme {
        MyApplicationTheme {
            ScreenToolBar()
        }
    }
}