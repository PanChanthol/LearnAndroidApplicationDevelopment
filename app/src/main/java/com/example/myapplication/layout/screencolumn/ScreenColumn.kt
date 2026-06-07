package com.example.myapplication.layout.screencolumn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun ScreenColumn(){
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
                    Text("Column Layout")
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
            Text(
                text="Hello 1"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text="Hello 2"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text="Hello 3"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text="Hello 4"
            )
        }
    }
}
@Composable
@Preview(showBackground = true)
fun ScreenColumnPreview(){
    MyApplicationTheme {
        ScreenColumn()
    }
}