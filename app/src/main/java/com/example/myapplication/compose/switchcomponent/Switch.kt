package com.example.myapplication.compose.switchcomponent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSwitch(viewModel: SwitchViewModel = viewModel()){
    val checked by viewModel.isChecked
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Switch")
                }
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text= "Dark Mood",
                    fontStyle = MaterialTheme.typography.titleLarge.fontStyle
                )

                Switch(
                    checked = checked,
                    onCheckedChange = {
                        viewModel.onCheckedChanged(it)
                    },
                    thumbContent = {
                        if(checked) {
                            Icon(
                                painter = painterResource(R.drawable.ic_check),
                                contentDescription = null
                            )
                        }
                        else {
                            Icon(
                                painter = painterResource(R.drawable.ic_close),
                                contentDescription = null
                            )
                        }
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colorScheme.primary,
                        checkedTrackColor = MaterialTheme.colorScheme.primary.copy(0.5f),
                        checkedIconColor = MaterialTheme.colorScheme.primaryContainer,
                        checkedBorderColor = MaterialTheme.colorScheme.primary,
                        uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                        uncheckedTrackColor = MaterialTheme.colorScheme.secondary.copy(0.5f),
                        uncheckedIconColor = MaterialTheme.colorScheme.onBackground,
                        uncheckedBorderColor = MaterialTheme.colorScheme.secondary,
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenSwitchPreview(){
    MaterialTheme{
        MyApplicationTheme {
            ScreenSwitch()
        }
    }
}
