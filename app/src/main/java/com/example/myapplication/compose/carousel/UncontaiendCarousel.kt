package com.example.myapplication.compose.carousel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.compose.card.foodList
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HorizontalUncontainedCarousel(){
    val foodList = foodList
    val carouselState = rememberCarouselState(
        initialItem = 0,
        itemCount = { 10 }
    )
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("HorizontalUncontainedCarousel")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        }
    ) {padding->
        Column(
            Modifier.padding(padding)
        ) {
            HorizontalUncontainedCarousel(
                state = carouselState,
                itemWidth = 120.dp,
                itemSpacing = 32.dp,
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) { index->
                val foodList = foodList[index]
                Image(
                    modifier = Modifier
                        .height(205.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    painter = painterResource(foodList.img),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HorizontalUncontainedCarouselPreview(){
    MyApplicationTheme {
        HorizontalUncontainedCarousel()
    }
}