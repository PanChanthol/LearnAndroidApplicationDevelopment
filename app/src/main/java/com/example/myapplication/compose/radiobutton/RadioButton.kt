package com.example.myapplication.compose.radiobutton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenRadioButton(){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("RadioButton")
                },
                navigationIcon = {
                    Icon(
                        painterResource(R.drawable.ic_arrow_back),
                        contentDescription = null
                    )
                },
            )
        }
    ) { padding->
        Column(
            modifier = Modifier.padding(padding)
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenRadioButtonPreview(){
    MaterialTheme{
        MyApplicationTheme {
            ScreenRadioButton()
        }
    }
}
