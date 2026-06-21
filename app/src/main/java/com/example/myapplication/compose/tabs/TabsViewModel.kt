package com.example.myapplication.compose.tabs

import androidx.lifecycle.ViewModel

class TabsViewModel : ViewModel() {
    val tabsList = listOf(
        TabsModel(id = 1, label = "All Chats"),
        TabsModel(id = 2, label = "Working"),
        TabsModel(id = 3, label = "Rean IT")
    )

    val gmailItems = listOf(
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
}
