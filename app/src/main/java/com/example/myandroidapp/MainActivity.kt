package com.example.myandroidapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myandroidapp.ui.theme.GameScreen
import com.example.myandroidapp.ui.theme.MyAndroidAppTheme

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "OnCreate Called")
        setContent {
            MyAndroidAppTheme {
//                GreetingText()
//                AffirmationApp()
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
//                    DogApp()
//                GameScreen()
                    CupcakeApp()
                }
//                DessertClickerApp(desserts = DatasourceUnit4.dessertList)
            }
        }
    }
//    override fun onStart() {
//        super.onStart()
//        Log.d(TAG, "onStart Called")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d(TAG, "onResume Called")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.d(TAG, "onRestart Called")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d(TAG, "onPause Called")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d(TAG, "onStop Called")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d(TAG, "onDestroy Called")
//    }
}
//
//@Preview(
//    showBackground = true,
//    showSystemUi = true
//)
//@Composable
//fun MyApp() {
//    MyAndroidAppTheme(darkTheme = false) {
//        GreetingText()
//        AffirmationApp()
//        DogApp()
//        GameScreen()
//            MyCityApp()
//    }
//}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MyAppDark() {
    MyAndroidAppTheme(darkTheme = false) {
//        GreetingText()
//        AffirmationApp()
//        DogApp()
        CupcakeApp()
    }
}