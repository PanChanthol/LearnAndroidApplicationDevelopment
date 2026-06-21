package com.example.myapplication.compose.radiobutton

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
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
fun ScreenRadioButton(viewModel: RadioButtonViewModel = viewModel()) {
    val selectedSize by viewModel.selectedSize
    val selectedSugar by viewModel.selectedSugar

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("RadioButton")
                },
                navigationIcon = {
                    Icon(
                        painterResource(R.drawable.ic_arrow_back), contentDescription = null
                    )
                },
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding( 16.dp)
        ) {
            Text(
                text = "Select Size",
                style = MaterialTheme.typography.titleLarge
            )
            viewModel.sizes.forEachIndexed {index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = {
                            viewModel.onSizeSelected(index)
                        }),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedSize == index,
                        onClick = {
                            viewModel.onSizeSelected(index)
                        })
                    Text(
                        text = item.label,
                    )
                }
            }

            HorizontalDivider()
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Select Sugar",
                style = MaterialTheme.typography.titleLarge
            )
            viewModel.sugarLevels.forEachIndexed {index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = {
                            viewModel.onSugarSelected(index)
                        }),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedSugar == index,
                        onClick = {
                            viewModel.onSugarSelected(index)
                        })
                    Text(
                        text = item.label,
                    )
                }
            }
            HorizontalDivider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenRadioButtonPreview() {
    MaterialTheme {
        MyApplicationTheme {
            ScreenRadioButton()
        }
    }
}
