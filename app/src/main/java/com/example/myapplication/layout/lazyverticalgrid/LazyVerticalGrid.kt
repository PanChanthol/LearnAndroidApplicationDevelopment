package com.example.myapplication.layout.lazyverticalgrid

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.layout.model.foodList
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenLazyVerticalGrid() {
    Scaffold(

        containerColor = Color.White,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lazy Vertical Grid"
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "",
                            tint = Color.Black
                        )

                    }
                },
                colors = topAppBarColors(
                    containerColor = Color.Gray,
                    titleContentColor = Color.Black,
                ),
                actions = {
                    Icon(
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = "",
                        tint = Color.Black
                    )
                }
            )
        }
    ) { padding ->
        LazyVerticalGrid(
            modifier = Modifier
                .padding(paddingValues = padding)
                .padding(top = 16.dp)
                .fillMaxSize(),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),

            ) {
            items(foodList.size) { index ->
                Column(
                    modifier = Modifier

                        .padding(horizontal = 8.dp)
                        .height(240.dp)
                        .background(
                            color = Color.Gray.copy(0.5f),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .border(
                            1.dp,
                            color = Color.Blue,
                            shape = RoundedCornerShape(16.dp)
                        ),
                ) {

                    Spacer(modifier = Modifier.height(8.dp))

                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(140.dp)
                                .clip(RoundedCornerShape(16.dp)),
                            painter = painterResource(foodList[index].image),
                            contentDescription = "",
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .weight(1f),
                            text = foodList[index].label,
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            FilledTonalButton(
                                onClick = {}
                            ) {
                                Text(
                                    text = "Add",
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center,
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 1
                                )
                            }
                            TextButton(
                                modifier = Modifier.weight(1f),
                                onClick = {}
                            ) {
                                Text(
                                    text = "Add",
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center,
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 1
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenLazyVerticalGridPreview() {
    MyApplicationTheme() {
        ScreenLazyVerticalGrid()
    }
}