package com.example.myapplication.layout.screenlazyrow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.layout.model.foodList
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenLazyRow() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = (painterResource(id = R.drawable.ic_arrow_back)),
                            contentDescription = ""
                        )
                    }
                },
                colors = topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = MaterialTheme.colorScheme.background
                ),
                title = {
                    Text("Lazy Row Layout")
                }
            )
        }

    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues = padding)
                .fillMaxSize()
                .background(color = colorResource(R.color.teal_200)),

            ) {
            item {
                LazyRow {
                    items(foodList.size) { index ->
                        Box(
                            modifier = Modifier
                                .size(width = 120.dp, height = 130.dp)
                        ) {

                        Column(
                            modifier = Modifier
                                .padding(top=8.dp)
                                .clip(shape = RoundedCornerShape(6.dp))
                                .fillMaxSize()
                                .background(color = Color.Blue.copy(0.5f)),
//                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp),
                                painter = painterResource(foodList[index].image),
                                contentDescription = "",
                                contentScale = ContentScale.Crop
                            )

                            Text(
                                modifier = Modifier,
                                text =foodList[index].label ,
                                textAlign = TextAlign.Center,
                                color = Color.White,
                                fontSize = 16.sp
                            )
                        }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }

        }
    }
}



@Composable
@Preview(showBackground = true)
fun ScreenLazyRowPreview() {
    MyApplicationTheme {
        ScreenLazyRow()
    }
}