package com.example.myapplication.compose.tooltip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RichTooltip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenToolTipWithAction() {
    val tooltipState = rememberTooltipState()
    val position = TooltipDefaults.rememberTooltipPositionProvider()
    val coroutineScope = rememberCoroutineScope()
    val tooltipViewModel = TooltipViewModel()
    val accountInfo by tooltipViewModel.account.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        tooltipViewModel.getAccountInfo()
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("ToolTip")
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_back),
                        contentDescription = null
                    )
                },
                actions = {
                    Icon(
                        painter = painterResource(R.drawable.ic_more_vert),
                        contentDescription = null
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TooltipBox(
                positionProvider = position,
                tooltip = {
                    RichTooltip(
                        title = {
                            accountInfo?.title?.let { Text(it) }
                        },
                        text = {
                            Column(
                                modifier = Modifier,
                            ) {
                                Text(accountInfo?.name ?: "")
                                Text(accountInfo?.phoneNumber?:"")
                                Text(accountInfo?.email?:"")
                            }
                        },
                       action = {
                           TextButton(
                               onClick = {
                                   coroutineScope.launch {
                                       tooltipState.dismiss()
                                   }
                               }
                           ) {
                               Text("Close")
                           }
                       }
                    )
                },
                state = tooltipState
            ) {
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            tooltipState.show()
                        }
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_report),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenToolTipWithActionPreview() {
    MyApplicationTheme {
        MaterialTheme {
            ScreenToolTipWithAction()
        }
    }
}