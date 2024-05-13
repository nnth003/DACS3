package com.example.myandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myandroidapp.ui.theme.MyAndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAndroidAppTheme(darkTheme = false) {
                CloudApp()
            }
        }
    }
}

@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun MyApp() {
    MyAndroidAppTheme(darkTheme = false) {
        MarsPhotosApp()
    }
}


