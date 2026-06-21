package com.example.myapplication.compose.loadingandprogress

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenLoadingAndProgress(viewModel: LoadingViewModel = viewModel()) {
    val list = viewModel.list
    val clickOnButton by viewModel.clickOnButton
    val openDialog by viewModel.openDialog

    if (openDialog){
        Dialog(
            onDismissRequest = { },
            properties = DialogProperties(
                dismissOnBackPress = false,
                usePlatformDefaultWidth = false
            )
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.onBackground.copy(0.4f)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    when(clickOnButton){
                        1 ->{
                            CircularProgressIndicator(
                                color = MaterialTheme.colorScheme.primary,
                                strokeWidth = 6.dp,
                                gapSize = 6.dp
                            )
                        }
                        2 ->{
                            LinearProgressIndicator(
                                color = MaterialTheme.colorScheme.primary,
                                strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
                                gapSize = 6.dp
                            )
                        }
                    }


                }
            }
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Loading And Progress")
                },
                navigationIcon = {
                    Icon(
                        painterResource(R.drawable.ic_arrow_back),
                        contentDescription = null
                    )
                },
                actions = {
                    Icon(
                        painterResource(R.drawable.ic_share),
                        contentDescription = null
                    )
                    Icon(
                        painterResource(R.drawable.ic_more_vert),
                        contentDescription = null
                    )
                }
            )
        },
        bottomBar= {
            NavigationBar() {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = {
                            viewModel.startLoading(1, "Seakhey")
                        }
                    ) {
                        Text("Circular")
                    }
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = {
                            viewModel.startLoading(2, "Sarath")
                        }
                    ) {
                        Text("Linear")
                    }
                }
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(list.size){ index->
                Text(
                    text = list[index]
                )
                HorizontalDivider()
            }

        }
    }
}

@Composable
@Preview(showBackground = true, device = "id:pixel_9_pro", showSystemUi = true)
fun ScreenLoadingAndProgressPreview() {
    MaterialTheme {
        MyApplicationTheme {
            ScreenLoadingAndProgress()
        }
    }
}
