package com.example.myapplication.homework

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HW100526() {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .size(32.dp),
                        painter = painterResource(R.drawable.ic_music),
                        contentDescription = "",
                        tint = Color.White
                    )
                },
                title = {
                    Text(
                        text = "Music",
                        color = Color.White,
                        fontSize = 24.sp
                    )
                },
                actions = {
                    Icon(
                        modifier = Modifier
                            .size(64.dp),
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "",
                        tint = Color.White
                    )
                    Icon(
                        modifier = Modifier
                            .size(64.dp),
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = "",
                        tint = Color.White
                    )
                    Icon(
                        modifier = Modifier
                            .size(64.dp),
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "",
                        tint = Color.White
                    )
                },
                colors = topAppBarColors(
                    containerColor = Color.Gray
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(paddingValues = padding)
        ) {
            LazyRow(
            ) {
                items(12) {
                    Row(
                        modifier = Modifier
                            .padding(12.dp)
                            .wrapContentSize()
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(color = Color.Gray)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(6.dp),
                            text = "Hello",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }
            }
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = "Speed dial",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .padding(12.dp)
                        .size(100.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(color = Color.Gray),

                    ) {}
                Box(
                    modifier = Modifier
                        .padding(12.dp)
                        .size(100.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(color = Color.Gray),

                    ) {}
                Box(
                    modifier = Modifier
                        .padding(12.dp)
                        .size(100.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(color = Color.Gray),

                    ) {}
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.padding(start = 12.dp),
                    text = "Quick picks",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                TextButton(
                    onClick = {},
                    modifier = Modifier.padding(end = 12.dp),
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = Color.White,
                        containerColor = Color.Gray
                    )
                ) {
                    Text("Play all")
                }
            }

            Spacer(modifier= Modifier.padding(8.dp))

            LazyHorizontalGrid(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxWidth()
                    .height(250.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                rows = GridCells.Fixed(3)
            ) {

                items(_root_ide_package_.com.example.myapplication.layout.model.foodList.size) { index ->
                    Row(
                        modifier = Modifier
                            .width(350.dp)
                            .background(
                                color = Color.Gray,
                                shape = RoundedCornerShape(12.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Image(
                            modifier = Modifier
                                .width(120.dp)
                                .clip(RoundedCornerShape(12.dp)),
                            painter = painterResource(_root_ide_package_.com.example.myapplication.layout.model.foodList[index].image),
                            contentDescription = "",
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxHeight()

                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .weight(1f),
                                text = _root_ide_package_.com.example.myapplication.layout.model.foodList[index].label,
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "*****"
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            painter = painterResource(R.drawable.ic_music),
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HW100526Preview() {
    MyApplicationTheme {
        HW100526()
    }
}