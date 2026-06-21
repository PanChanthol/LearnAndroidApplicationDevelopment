package com.example.myapplication.homework

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.text.NumberFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var selectedNavigation by remember { mutableIntStateOf(SelectedNavigation.SETTING.value) }
    val navigationItem = navigationItems
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground
            ) {
                navigationItem.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index +1 == selectedNavigation,
                        onClick = {
                            selectedNavigation = index + 1
                        },
                        icon = {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = item.title,
                                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.background,
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                        )
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            when (selectedNavigation) {
                SelectedNavigation.HOME.value -> {
                    Card()
                    QuickActions()
                    Services()
                }

                SelectedNavigation.FAVORITE.value -> {
                    FavoriteScreen()
                }

                SelectedNavigation.SETTING.value -> {
                    SettingScreen()
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, device = "id:pixel_9_pro")
fun HomeScreenPreview() {
    MaterialTheme {
        MyApplicationTheme {
            HomeScreen()
        }
    }
}

@Composable
fun Card() {
    val balance = 2450.0
    val accountNumber = "12345678901234"
    val formattedBalance = NumberFormat.getCurrencyInstance(Locale.US)
        .format(balance)
    val maskedAccount = "**** ${accountNumber.takeLast(4)}"
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Welcome, Pan Chanthol",
        fontSize = MaterialTheme.typography.titleLarge.fontSize,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(16.dp))
    Card(
        modifier = Modifier
            .height(128.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        onClick = { }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()

        ) {
            Text(
                text = "Total Balance",
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$formattedBalance",
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Saving Account $maskedAccount",
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun QuickActions() {
    data class QuickActionModel(
        @DrawableRes val icon: Int,
        val title: String
    )

    val quickActionsList = listOf(
        QuickActionModel(R.drawable.ic_send, "Transfer"),
        QuickActionModel(R.drawable.ic_scankhqr, "Scan"),
        QuickActionModel(R.drawable.ic_card, "Payment"),
        QuickActionModel(R.drawable.ic_mobile, "Top Up"),
    )
    Column(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Quick Actions",
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            quickActionsList.forEach { item ->
                Column(
                    modifier = Modifier.width(84.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .background(
                                color = MaterialTheme.colorScheme.surface,
                                shape = MaterialTheme.shapes.medium
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = item.title,
                        textAlign = TextAlign.Center,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

@Composable
fun Services() {
    data class ServiceModel(
        @DrawableRes val icon: Int,
        val title: String,
        val description: String

    )

    val serviceItems = listOf(
        ServiceModel(
            R.drawable.ic_financial___investment,
            "Transfer",
            "Transfer money to another account"
        ),
        ServiceModel(R.drawable.ic_transaction, "Transaction", "Check transaction history"),
        ServiceModel(R.drawable.ic_card, "Cards", "Manage your credit cards"),
    )
    Column(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Services",
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
        serviceItems.forEach { item ->
            Card(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .height(80.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.onSurface
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .weight(1f)
                    ) {
                        Text(
                            text = item.title,
                            fontSize = MaterialTheme.typography.titleMedium.fontSize,
                            fontWeight = FontWeight.Normal,
                        )
                        Text(
                            text = item.description,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onSurface.copy(0.3f)

                        )
                    }
                }
            }
        }
    }
}

@Composable
fun FavoriteScreen() {
    data class FavoriteModel(
        val title: String,
        val description: String
    )

    val favoriteList = listOf(
        FavoriteModel("Transfer to Dara", "ABA **** 3333"),
        FavoriteModel("Transfer to Sokha", "ACLEDA **** 4821"),
        FavoriteModel("Transfer to Vanna", "Wing Bank **** 7264"),
        FavoriteModel("Transfer to Chantha", "Canadia Bank **** 1958"),
        FavoriteModel("Transfer to Sreypov", "Prince Bank **** 6042"),
        FavoriteModel("Transfer to Piseth", "Sathapana Bank **** 8371"),
        FavoriteModel("Transfer to Borey", "Phillip Bank **** 5296"),
        FavoriteModel("Transfer to Rithy", "Maybank Cambodia **** 7413"),
        FavoriteModel("Transfer to Nita", "ABA **** 2184"),
        FavoriteModel("Transfer to Kunthea", "ACLEDA **** 9637"),
        FavoriteModel("Transfer to Lina", "Wing Bank **** 4059"),
        FavoriteModel("Transfer to Monika", "Canadia Bank **** 1762"),
        FavoriteModel("Transfer to Veasna", "Prince Bank **** 8514"),
        FavoriteModel("Transfer to Chenda", "Sathapana Bank **** 3907"),
        FavoriteModel("Transfer to Vibol", "Phillip Bank **** 6285"),
        FavoriteModel("Transfer to Sothea", "Maybank Cambodia **** 1473"),
        FavoriteModel("Transfer to Pheakdey", "ABA **** 5829"),
        FavoriteModel("Transfer to Davy", "ACLEDA **** 7316"),
        FavoriteModel("Transfer to Sophea", "Wing Bank **** 2948"),
        FavoriteModel("Transfer to Maly", "Canadia Bank **** 8641"),
        FavoriteModel("Transfer to Kosal", "Prince Bank **** 3157"),
        FavoriteModel("Transfer to Rina", "Sathapana Bank **** 7024"),
        FavoriteModel("Transfer to Mengly", "Phillip Bank **** 4583"),
        FavoriteModel("Transfer to Visal", "Maybank Cambodia **** 9365"),
        FavoriteModel("Transfer to Kanha", "ABA **** 2718"),
        FavoriteModel("Transfer to Theary", "ACLEDA **** 6492"),
        FavoriteModel("Transfer to Bunna", "Wing Bank **** 1835"),
        FavoriteModel("Transfer to Sophal", "Canadia Bank **** 5701"),
        FavoriteModel("Transfer to Raksmey", "Prince Bank **** 8246"),
        FavoriteModel("Transfer to Chhay", "Sathapana Bank **** 4179")
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Favorite",
        fontSize = MaterialTheme.typography.titleLarge.fontSize,
        fontWeight = FontWeight.Bold
    )
    favoriteList.forEach { item ->
        Card(
            modifier = Modifier
                .padding(top = 16.dp)
                .height(80.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            )
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_star_fill),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = item.title,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        fontWeight = FontWeight.Normal,
                    )
                    Text(
                        text = item.description,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onSurface.copy(0.3f)
                    )
                }
            }
        }
    }
}

@Composable
fun SettingScreen() {

    data class SettingModel(
        @DrawableRes val icon: Int,
        val title: String,
        val description: String
    )

    val settingList = listOf(
        SettingModel(R.drawable.ic_account, "Profile", "View and edit your profile"),
        SettingModel(R.drawable.ic_call, "Phone Number", "+855 XX XXX XXX"),
        SettingModel(R.drawable.ic_maill, "Email", "Panchanthol@gmail.com"),
        SettingModel(R.drawable.ic_lock, "Security", "PIN, password and biometric"),
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Setting",
        fontSize = MaterialTheme.typography.titleLarge.fontSize,
        fontWeight = FontWeight.Bold
    )
    Card(
        modifier = Modifier
            .padding(top = 16.dp)
            .height(110.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "PC",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "Pan Chanthol",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Junior Android Developer",
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onSurface.copy(0.3f)
                )
            }
        }
    }
    settingList.forEach { item ->
        Card(
            modifier = Modifier
                .padding(top = 16.dp)
                .height(80.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            )
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(item.icon),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = item.title,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = item.description,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onSurface.copy(0.3f)
                    )
                }
                Icon(
                   imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface.copy(0.3f)
                )
            }
        }
    }
}

data class NavigationBarItem(
    val title: String,
    @DrawableRes val icon: Int
)

val navigationItems = listOf(
    NavigationBarItem("Home", R.drawable.ic_home),
    NavigationBarItem("Favorite", R.drawable.ic_favorite),
    NavigationBarItem("Setting", R.drawable.ic_settings),
)

enum class SelectedNavigation(val value: Int) {
    HOME(1),
    FAVORITE(2),
    SETTING(3)
}