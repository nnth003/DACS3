package com.example.myandroidapp.ui.UiLearrn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myandroidapp.ui.theme.MyAndroidAppTheme

@Composable
fun t2(

    onNextButtonClicked: () -> Unit,
    onPreviousButtonClicked: () -> Unit,
    option: String,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
//            text = "Why do we use it? 2"
            text = option
        )
        Text(
            text = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)."
        )
        Button(onClick = onPreviousButtonClicked, modifier = Modifier.fillMaxWidth(1f)) {
            Text(text = "Previous")
        }
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun A2() {
    MyAndroidAppTheme {
//        t2(onNextButtonClicked = {  }, onPreviousButtonClicked = { /*TODO*/ })
    }
}