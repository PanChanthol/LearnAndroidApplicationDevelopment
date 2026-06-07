package com.example.myapplication.layout.screenbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenBox(){
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) { Icon(
                        painter = painterResource(R.drawable.ic_arrow_back),
                        contentDescription = "Back",
                    ) }
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.background
                ),
                title = {
                    Text("Box Layout")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.background
            ){
             Text(
                 modifier = Modifier
                     .fillMaxWidth(),
                 textAlign = TextAlign.Center,
                 text = "Bottom Bar",
             )
            }
        }
    ) {padding ->
        Column(
            modifier= Modifier
                .padding(paddingValues = padding)
                .fillMaxSize()
                .background(color= colorResource(R.color.teal_200)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Box(
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.error,
                    shape= CircleShape
                    )
                    .size(128.dp),
                contentAlignment = Alignment.Center,
            ){
                Box(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .size(56.dp)
                    .background(color = MaterialTheme.colorScheme.secondary)
                ){}
                Box(
                    modifier = Modifier
                        .padding(start = 32.dp)
                        .background(color = MaterialTheme.colorScheme.onBackground)
                        .size(56.dp)
                ){}
                Box(
                    modifier = Modifier
                        .padding(end = 42.dp)
                        .background(color = MaterialTheme.colorScheme.primary)
                        .size(56.dp)
                ){}
            }

        }
    }
}
@Composable
@Preview(showBackground = true)
fun ScreenBoxPreview(){
    MyApplicationTheme {
        ScreenBox()
    }
}