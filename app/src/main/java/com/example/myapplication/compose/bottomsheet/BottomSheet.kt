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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenBottomSheet() {
    val (selectedSize, onSizeSelected) = remember { mutableIntStateOf(1) }
    val (selectedSugar, onSugarSelected) = remember { mutableIntStateOf(1) }
    val (showBottomSheet, onShowBottomSheet) = remember { mutableStateOf(false) }
    val bottonSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val sizeList = sizeList
    val sugarList = sugarList
    var sugar by remember { mutableStateOf<Model?>(null) }
    var size by remember { mutableStateOf<Model?>(null) }
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
                        onShowBottomSheet(true)
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
            Text("Size : ${size?.label}")
            Text("Sugar : ${sugar?.label}")

            if (showBottomSheet) {
                ModalBottomSheet(
                    onShowBottomSheet = onShowBottomSheet,
                    sheetState = bottonSheetState,
                    onSizeSelected = onSizeSelected,
                    onSugarSelected = onSugarSelected,
                    selectedSize = selectedSize,
                    selectedSugar = selectedSugar,
                    sizeList = sizeList,
                    sugarList = sugarList,
                ){ sizeResult, sugarResult ->
                    size = sizeResult
                    sugar = sugarResult
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheet(
    onShowBottomSheet: (Boolean) -> Unit,
    sheetState: SheetState,
    onSizeSelected: (Int) -> Unit,
    onSugarSelected: (Int) -> Unit,
    selectedSize: Int,
    selectedSugar: Int,
    sizeList: List<Model>,
    sugarList: List<Model>,
    onConfirm: (size: Model, sugar: Model) -> Unit
) {
    fun onClick() {
        val sugar = sugarList[selectedSugar]
        val size = sizeList[selectedSize]
        onConfirm(size, sugar)
        onShowBottomSheet(false)
    }

    ModalBottomSheet(
        onDismissRequest = {
            onClick()
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
                            onSizeSelected(index)
                        }),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedSize == index,
                        onClick = {
                            onSizeSelected(index)
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
                            onSugarSelected(index)
                        }),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedSugar == index,
                        onClick = {
                            onSugarSelected(index)
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
                    onClick()
                    onShowBottomSheet(false)
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

val sizeList = listOf<Model>(
    Model(
        id = SizeCapModel.SMALL.code,
        label = "Small",
    ), Model(
        id = SizeCapModel.MEDIUM.code,
        label = "Medium",
    ), Model(
        id = SizeCapModel.lARGE.code,
        label = "Large",
    ), Model(
        id = SizeCapModel.EXTRA_LARGE.code,
        label = "Extra Large",
    )
)

enum class SizeCapModel(val code: String) {
    SMALL("1"), MEDIUM("2"), lARGE("3"), EXTRA_LARGE("4"),
}

val sugarList = listOf<Model>(
    Model(
        id = SugarModel.LEVEL_0.code,
        label = "No Sugar",
    ), Model(
        id = SugarModel.LEVEL_25.code,
        label = "25%",
    ), Model(
        id = SugarModel.LEVEL_50.code,
        label = "50%",
    ), Model(
        id = SugarModel.LEVEL_75.code,
        label = "75%",
    ),
    Model(
        id = SugarModel.LEVEL_100.code,
        label = "100%",
    )
)

enum class SugarModel(val code: String) {
    LEVEL_0("1"),
    LEVEL_25("2"),
    LEVEL_50("3"),
    LEVEL_75("4"),
    LEVEL_100("5"),
}