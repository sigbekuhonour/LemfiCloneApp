package com.example.lemficloneapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lemficloneapp.ui.theme.LemfiCloneAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemfiCloneAppTheme {
                Navigation()
            }
        }
    }
}



