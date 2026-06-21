package com.example.myapplication.compose.bottomsheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
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
fun ScreenBottomSheet(viewModel: BottomSheetViewModel = viewModel()) {
    val showBottomSheet by viewModel.showBottomSheet
    val sugar by viewModel.sugar
    val size by viewModel.size
    
    val bottonSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("BottomSheet")
                },
                navigationIcon = {
                    Icon(
                        painterResource(R.drawable.ic_arrow_back), contentDescription = null
                    )
                },
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
            ) {
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        viewModel.setShowBottomSheet(true)
                    }
                ) {
                    Text("Order")
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Size : ${size?.label ?: ""}")
            Text("Sugar : ${sugar?.label ?: ""}")

            if (showBottomSheet) {
                CustomModalBottomSheet(
                    viewModel = viewModel,
                    sheetState = bottonSheetState
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomModalBottomSheet(
    viewModel: BottomSheetViewModel,
    sheetState: SheetState
) {
    val selectedSize by viewModel.selectedSize
    val selectedSugar by viewModel.selectedSugar
    val sizeList = viewModel.sizeList
    val sugarList = viewModel.sugarList

    ModalBottomSheet(
        onDismissRequest = {
            viewModel.onConfirm()
        },
        sheetState = sheetState
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Select Size",
                style = MaterialTheme.typography.titleLarge
            )
            sizeList.forEachIndexed { index, item ->
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
            sugarList.forEachIndexed { index, item ->
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
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.onConfirm()
                }
            ) {
                Text("Confirm")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenBottomSheetPreview() {
    MaterialTheme {
        MyApplicationTheme {
            ScreenBottomSheet()
        }
    }
}

data class Model(
    val id: String, val label: String
)

enum class SizeCapModel(val code: String) {
    SMALL("1"), MEDIUM("2"), lARGE("3"), EXTRA_LARGE("4"),
}

enum class SugarModel(val code: String) {
    LEVEL_0("1"),
    LEVEL_25("2"),
    LEVEL_50("3"),
    LEVEL_75("4"),
    LEVEL_100("5"),
}
