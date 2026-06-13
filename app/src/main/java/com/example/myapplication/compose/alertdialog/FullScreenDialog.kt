package com.example.myapplication.compose.alertdialog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenFullDialog() {
    var openDialog by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableIntStateOf(0) }
    var openFullDialog by remember {
        mutableStateOf(false)
    }
    when (selectedIndex) {
        1 -> {
            Dialog(
                openDialog = true,
                onDismiss = {
                    openDialog = false
                    selectedIndex = 0
                }
            )
        }

        2 -> {
            FullScreenDialog(
                fullDialog = true,
                onDismiss = {
                    openFullDialog = false
                    selectedIndex = 0
                }
            )
        }
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("FullScreenDialog")
                },
                navigationIcon = {
                    Icon(
                        painterResource(R.drawable.ic_arrow_back),
                        contentDescription = null
                    )
                },
                actions = {
                    Icon(
                        painterResource(R.drawable.ic_more_vert),
                        contentDescription = null
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        bottomBar = {
            Row(
                Modifier.fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        openFullDialog = true
                        selectedIndex =1}
                ) { Text("Alert Dialog") }
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        openFullDialog = true
                        selectedIndex =2
                    }
                ) { Text("Full Screen Dialog") }
            }
        }
    ) { padding ->
        Column(
            Modifier.padding(padding)
        ) {


        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenFullDialogPreview() {
    MyApplicationTheme {
        ScreenFullDialog()
    }
}

@Composable
fun FullScreenDialog(
     fullDialog: Boolean,
     onDismiss: () -> Unit
){
    if (fullDialog) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.surface),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Box(
                        modifier = Modifier
                            .padding(top = 60.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .height(580.dp)
                            .background(MaterialTheme.colorScheme.onBackground)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 60.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = "Success",
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFFE84040)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        "KHQR",
                                        color = MaterialTheme.colorScheme.background,
                                        fontSize = 10.sp
                                    )
                                }

                                Spacer(modifier = Modifier.width(12.dp))

                                Column {
                                    Text(
                                        "Transaction KHQR to",
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colorScheme.background,
                                    )
                                    Text(
                                        "KAMPONG CHAM SOLID WASTE",
                                        color = MaterialTheme.colorScheme.background,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        "30,000 ៛",
                                        color = Color(0xFFE84040),
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                            }
                            HorizontalDivider()
                            TransactionDetailRow("External Txn Ref", "e2ea32a2")
                            TransactionDetailRow("Date", "May 26, 2026 | 02:56 PM")
                            TransactionDetailRow("Paid From", "Soy Sotet")
                            TransactionDetailRow("Account No.", "098 354 338 (KHR)")
                            TransactionDetailRow(
                                "Debit Amount",
                                "-30,000 KHR",
                                valueColor = Color(0xFFE84040)
                            )
                            TransactionDetailRow("To Account", "KAMPONG CHAM SOLID WASTE")
                            TransactionDetailRow("Beneficiary Bank", "ABA Bank")
                            TransactionDetailRow("Reference No.", "61466394362")
                        }
                    }

                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.background),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Box(
                            modifier = Modifier
                                .size(105.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.secondary)
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .offset(y = (350).dp)
                        .clickable(onClick = onDismiss),
                    contentAlignment = Alignment.BottomCenter
                ){
                    Button(
                        onClick = onDismiss
                    ) {
                        Text("Close Dialog")
                    }
                }
            }
        }
    }
    }
}

@Composable
fun Dialog(
    openDialog: Boolean,
    onDismiss: () -> Unit
){
    if (openDialog) {
        Box(
            modifier = Modifier.wrapContentSize()
        ) {
            AlertDialog(
                modifier = Modifier,
                icon = {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(R.drawable.ic_warning),
                        contentDescription = null
                    )
                },
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Delete Account",
                        textAlign = TextAlign.Center
                    )
                },
                text = {
                    Text(
                        text = "An error has occurred while creating an error report.",
                        textAlign = TextAlign.Center
                    )
                },
                onDismissRequest = onDismiss,
                confirmButton = {
                    TextButton(
                        onClick = onDismiss
                    ) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = onDismiss
                    ) {
                        Text("NO")
                    }
                }
            )
        }
    }
}

@Composable
fun TransactionDetailRow(
    label: String,
    value: String,
    valueColor: Color = MaterialTheme.colorScheme.background
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            label, color = MaterialTheme.colorScheme.background,
            fontSize = 13.sp,
            modifier = Modifier.weight(1f)
        )
        Text(
            ": $value",
            color = valueColor,
            fontSize = 13.sp,
            modifier = Modifier.weight(1.2f)
        )
    }
}