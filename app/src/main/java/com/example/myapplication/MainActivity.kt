package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.myapplication.compose.textfield.ScreenTextField
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme(
            ) {
                ScreenTextField()
//                ScreenTabs()
//                ScreenSnackBarWithAction()
//                ScreenSnackBar()
//                ScreenBottomSheet()
//                ScreenCombineDrawerAndBar()
//                ScreenLoadingAndProgress()
//                ScreenFullDialog()
//                ScreenAlertDialog()
//                ScreenChips()
//                ScreenCheckBox()
//                ScreenHorizontalMultiBrowseCarousel()
//                ScreenCard()
//                HW100526()
//                ScreenIconButton()
//                RecapSingleChoiceSegmentButton()
            }

        }
    }
}



