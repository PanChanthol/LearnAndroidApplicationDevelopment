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
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTabs() {
    val tabsList = tabsList
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
                when (page) {
                    0 -> {
                        Home(
                            modifier = Modifier,
                            Text = "All Chats"
                        )
                    }

                    1 -> {
                        Home(
                            modifier = Modifier,
                            Text = "Working"
                        )
                    }

                    2 -> {
                        Home(
                            modifier = Modifier,
                            Text = "Rean IT"
                        )
                    }
                }
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
    Text: String,
) {
    val gmailItem = gmailItems

    Column(
        modifier = Modifier
            .then(modifier)
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = Text,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
        )

        gmailItem.forEachIndexed { index, item ->
            Card(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .height(110.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(
                    topStart = if (index == 0) 16.dp else 8.dp,
                    topEnd = if (index == 0) 16.dp else 8.dp,
                    bottomStart = if (index == gmailItem.size - 1) 16.dp else 8.dp,
                    bottomEnd = if (index == gmailItem.size - 1) 16.dp else 8.dp
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

val tabsList = listOf<TabsModel>(
    TabsModel(
        id = 1,
        label = "All Chats",
    ),
    TabsModel(
        id = 2,
        label = "Working",
    ),
    TabsModel(
        id = 3,
        label = "Rean IT",

        )

)

data class GmailItemModel(
    val id: Int,
    val fromName: String,
    val body: String,
    val description: String,
    val date: String, //Ex: 3:33 PM , May 31
)

val gmailItems = listOf<GmailItemModel>(
    GmailItemModel(
        id = 1,
        fromName = "Google",
        body = "Security Alert",
        description = "A new sign-in was detected on your account.",
        date = "8:15 AM"
    ),
    GmailItemModel(
        id = 2,
        fromName = "GitHub",
        body = "Pull Request Review",
        description = "Your pull request has received new comments.",
        date = "9:20 AM"
    ),
    GmailItemModel(
        id = 3,
        fromName = "LinkedIn",
        body = "New Job Opportunity",
        description = "A recruiter viewed your profile.",
        date = "10:05 AM"
    ),
    GmailItemModel(
        id = 4,
        fromName = "Android Weekly",
        body = "Compose Tips",
        description = "Latest Jetpack Compose articles and updates.",
        date = "11:40 AM"
    ),
    GmailItemModel(
        id = 5,
        fromName = "Stack Overflow",
        body = "Question Activity",
        description = "Someone answered your Kotlin question.",
        date = "12:10 PM"
    ),
    GmailItemModel(
        id = 6,
        fromName = "Amazon",
        body = "Order Shipped",
        description = "Your package is on its way.",
        date = "1:15 PM"
    ),
    GmailItemModel(
        id = 7,
        fromName = "Netflix",
        body = "New Release",
        description = "A new season of your favorite show is available.",
        date = "2:00 PM"
    ),
    GmailItemModel(
        id = 8,
        fromName = "Spotify",
        body = "Discover Weekly",
        description = "Fresh music recommendations for you.",
        date = "2:35 PM"
    ),
    GmailItemModel(
        id = 9,
        fromName = "Udemy",
        body = "Course Discount",
        description = "Special offer on Android development courses.",
        date = "3:10 PM"
    ),
    GmailItemModel(
        id = 10,
        fromName = "JetBrains",
        body = "IDE Update",
        description = "Android Studio plugin updates available.",
        date = "3:33 PM"
    ),
    GmailItemModel(
        id = 11,
        fromName = "Facebook",
        body = "New Friend Request",
        description = "You have a new friend request waiting.",
        date = "4:00 PM"
    ),
    GmailItemModel(
        id = 12,
        fromName = "Twitter",
        body = "Trending Topics",
        description = "Check out today's trending discussions.",
        date = "4:25 PM"
    ),
    GmailItemModel(
        id = 13,
        fromName = "Coursera",
        body = "Assignment Reminder",
        description = "Your course deadline is approaching.",
        date = "5:10 PM"
    ),
    GmailItemModel(
        id = 14,
        fromName = "Medium",
        body = "Daily Digest",
        description = "Top articles selected for you.",
        date = "5:45 PM"
    ),
    GmailItemModel(
        id = 15,
        fromName = "Microsoft",
        body = "Account Notification",
        description = "Password reset options have been updated.",
        date = "6:20 PM"
    ),
    GmailItemModel(
        id = 16,
        fromName = "Discord",
        body = "New Mention",
        description = "Someone mentioned you in a server.",
        date = "7:05 PM"
    ),
    GmailItemModel(
        id = 17,
        fromName = "Reddit",
        body = "Popular Post",
        description = "A post from your favorite community is trending.",
        date = "7:50 PM"
    ),
    GmailItemModel(
        id = 18,
        fromName = "Canva",
        body = "Design Shared",
        description = "A team member shared a new design with you.",
        date = "8:30 PM"
    ),
    GmailItemModel(
        id = 19,
        fromName = "Figma",
        body = "Project Update",
        description = "New comments were added to your design.",
        date = "9:15 PM"
    ),
    GmailItemModel(
        id = 20,
        fromName = "OpenAI",
        body = "Weekly AI News",
        description = "Recent developments in AI and machine learning.",
        date = "May 31"
    )
)