package com.example.myapplication.ecommerceapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ecommerceapp.data.banners
import com.example.myapplication.ecommerceapp.data.category
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ECommerceApp() {
    val categories = category
    val banner = banners
    val pageState = rememberPagerState(pageCount = { banner.size })
    var text by remember { mutableStateOf("") }
    Scaffold(
        containerColor = Color.White,
        topBar = {
            Column {
                TopAppBar(
                    navigationIcon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_menu),
                            contentDescription = ""
                        )
                    },
                    title = {
                        Column(
                            modifier = Modifier.padding(horizontal = 8.dp)
                        ) {
                            Text(
                                text = "Hello, Chanthol",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "What are you looking for?",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    },
                    actions = {
                        Icon(
                            painter = painterResource(R.drawable.ic_share),
                            contentDescription = ""
                        )
                        Icon(
                            painter = painterResource(R.drawable.ic_more_vert),
                            contentDescription = ""
                        )
                    },
                    colors = topAppBarColors(
                        containerColor = Color.Gray,
                        navigationIconContentColor = Color.Black,
                        titleContentColor = Color.Black,
                        actionIconContentColor = Color.Black
                    )
                )
                TextField(
                    value = text,
                    onValueChange = { text = it },

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                        .clip(RoundedCornerShape(24.dp)),

                    placeholder = {
                        Text(
                            text = "Search for products...",
                            color = Color.Black
                        )
                    },

                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_search),
                            contentDescription = "Search",
                            tint = Color.Black
                        )
                    },

                    trailingIcon = {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = "Camera Search",
                                tint = Color.Black
                            )
                        }
                    },

                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Gray,
                        unfocusedContainerColor = Color.Gray,
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color.White
                    ),
                    singleLine = true
                )
            }
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                contentPadding = PaddingValues(16.dp),
                state = pageState
            ) { page ->
                val banner = banners[page]
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth(0.95f)
                        .background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
//                            modifier = Modifier.padding(vertical = 8.dp),
                            text = banner.tag,
                            fontSize = 18.sp,
                            color = Color.Yellow
                        )
                        Text(
                            modifier = Modifier.padding(vertical = 8.dp),
                            text = banner.title,
                            fontSize = 25.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            modifier = Modifier.padding(vertical = 8.dp),
                            text = banner.description,
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                        Button(
//                            modifier = Modifier.padding(vertical = 8.dp),
                            colors = buttonColors(
                                contentColor = Color.White,
                                containerColor = Color.Yellow.copy(0.2f)
                            ),
                            onClick = {}
                        ) {
                            Text(
                                text = banner.buttonText
                            )

                        }
                    }
                }
            }
            Column(
                verticalArrangement = Arrangement.Center
            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    categories.forEach { item ->
                        Column(
                            modifier = Modifier.width(80.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(62.dp)
                                    .background(
                                        color = Color.Gray,
                                        shape = RoundedCornerShape(16.dp)
                                    )
                            ) {
                                Image(
                                    modifier = Modifier.size(34.dp),
                                    painter = painterResource(item.img),
                                    contentDescription = null
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = item.name,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    device = "id:pixel_9_pro",
    showSystemUi = true
)
@Composable
fun ECommerceAppPreview() {

    MyApplicationTheme {
        ECommerceApp()
    }
}
