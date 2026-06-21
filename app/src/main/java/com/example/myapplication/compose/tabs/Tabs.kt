package com.example.myapplication.compose.tabs

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTabs(viewModel: TabsViewModel = viewModel()) {
    val tabsList = viewModel.tabsList
    val pagerState = rememberPagerState(pageCount = { tabsList.size })
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Tabs")
                },
                navigationIcon = {
                    Icon(
                        painterResource(R.drawable.ic_arrow_back),
                        contentDescription = null
                    )
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            PrimaryTabRow(
                selectedTabIndex = pagerState.currentPage
            ) {
                tabsList.forEachIndexed { index, item ->

                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(
                                    page = index,
                                    animationSpec = tween(
                                        durationMillis = 1000,
                                        easing = FastOutSlowInEasing
                                    )
                                )
                            }
                        },
                        text = {
                            Text(item.label)
                        }
                    )
                }
            }
            HorizontalPager(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.Top,
                state = pagerState
            ) { page ->
                val label = tabsList.getOrNull(page)?.label ?: ""
                Home(
                    modifier = Modifier,
                    headerText = label,
                    gmailItems = viewModel.gmailItems
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenTabsPreview() {
    MaterialTheme {
        MyApplicationTheme {
            ScreenTabs()
        }
    }
}

@Composable
fun Home(
    modifier: Modifier,
    headerText: String,
    gmailItems: List<GmailItemModel>
) {
    Column(
        modifier = Modifier
            .then(modifier)
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = headerText,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
        )

        gmailItems.forEachIndexed { index, item ->
            Card(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .height(110.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(
                    topStart = if (index == 0) 16.dp else 8.dp,
                    topEnd = if (index == 0) 16.dp else 8.dp,
                    bottomStart = if (index == gmailItems.size - 1) 16.dp else 8.dp,
                    bottomEnd = if (index == gmailItems.size - 1) 16.dp else 8.dp
                )
            ) {

                Row(
                    modifier = Modifier
                        .padding(10.dp)
                ) {

                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(color = MaterialTheme.colorScheme.primary)
                    )

                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .weight(1f)
                            .fillMaxHeight()
                    ) {

                        Text(
                            text = item.fromName,
                            fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = item.body,
                            fontSize = MaterialTheme.typography.titleMedium.fontSize,
                            overflow = TextOverflow.Clip
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = item.description,
                            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                            overflow = TextOverflow.Clip,
                            maxLines = 1
                        )
                    }

                    Column(
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = item.date
                        )
                        Spacer(modifier = Modifier.weight(1f))

                        Icon(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

data class TabsModel(
    val id: Int,
    val label: String,
)

data class GmailItemModel(
    val id: Int,
    val fromName: String,
    val body: String,
    val description: String,
    val date: String,
)
