package com.example.myandroidapp.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myandroidapp.ui.theme.MyAndroidAppTheme
import kotlin.math.floor

@Composable
fun t6(
    onDelete: (anh: Int) -> Unit,

    option: String,
    modifier: Modifier = Modifier
) {
    val optionIndex = option.toIntOrNull() ?: 0
    val listTruong = TruongData().load()
    val colors = listOf(Color.Red, Color.Blue, Color.Gray)
    var change by remember {
        mutableStateOf(colors[0])
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(change)
    ) {
        Text(
            text = stringResource(id = listTruong[optionIndex].tenTruong)

        )
        println(listTruong[optionIndex].tenTruong)
        Text(
            text = stringResource(id = listTruong[optionIndex].tenQuan)
        )
        Text(
            text = stringResource(id = listTruong[optionIndex].moTa)
        )
        Button(onClick = {
            change = colors[floor(Math.random() * colors.size).toInt()]
        }) {
            Text(text = "Change Color")
        }
        val context = LocalContext.current
        Button(onClick = {
            Toast.makeText(
                context,
                "Đây là bài thi giữa kỳ 2",
                Toast.LENGTH_LONG
            ).show()
        }) {
           Text(text = "About")
        }
//
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun A6() {
    MyAndroidAppTheme {
//        t2(onNextButtonClicked = {  }, onPreviousButtonClicked = { /*TODO*/ })
    }
}