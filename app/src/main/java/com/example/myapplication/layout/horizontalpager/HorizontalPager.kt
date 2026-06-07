package com.example.myapplication.layout.horizontalpager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.layout.model.accountBankList
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHorizontalPager() {
    val accounts = accountBankList
    val pagerState = rememberPagerState(pageCount = { accounts.size })
    Scaffold(
        containerColor = Color.White,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Horizontal Pager"
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        ) {
            HorizontalPager(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.Top,
                state = pagerState,
                contentPadding = PaddingValues(16.dp)
            ) { page ->
                val account = accounts[page]
                Box(
                    modifier = Modifier
                        .height(240.dp)
                        .fillMaxWidth(0.95f)
                        .background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(16.dp)
                        ),
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize()
                    ) {
                        Row(
                            modifier = Modifier

                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = account.accountName,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = account.accountNo,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }//row1
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "Balance",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = account.balance.toString(),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = account.currency,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }//row2
                    }//column2
                }//box

            }//horizontalpager
        }//column1
    }//scaffold
}

@Composable
@Preview(showBackground = true)
fun ScreenHorizontalPagerPreview() {
    MyApplicationTheme() {
        ScreenHorizontalPager()
    }
}