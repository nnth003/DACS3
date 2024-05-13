package com.example.myandroidapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myandroidapp.R
import com.example.myandroidapp.data.DataSource
import com.example.myandroidapp.ui.theme.MyAndroidAppTheme

val list = listOf(
    "Item 1",
    "Item 2",
    "Item 3",
    "Item 4",
    "Item 5",
//    "Item 1",
//    "Item 2",
//    "Item 3",
//    "Item 4",
//    "Item 5",
//    "Item 1",
//    "Item 2",
//    "Item 3",
//    "Item 4",
//    "Item 5",
//    "Item 1",
//    "Item 2",
//    "Item 3",
//    "Item 4",
//    "Item 5",
//    "Item 1",
//    "Item 2",
//    "Item 3",
//    "Item 4",
//    "Item 5",
//    "Item 1",
//    "Item 2",
//    "Item 3",
//    "Item 4",
//    "Item 5",
//    "Item 1",
//    "Item 2",
//    "Item 3",
//    "Item 4",
//    "Item 5",
//    "Item 1",
//    "Item 2",
//    "Item 3",
//    "Item 4",
//    "Item 5",
//    "Item 1",
//    "Item 2",
//    "Item 3",
//    "Item 4",
//    "Item 5",
//    "Item 1",
//    "Item 2",
//    "Item 3",
//    "Item 4",
//    "Item 5",
//    "Item 1",
//    "Item 2",
//    "Item 3",
//    "Item 4",
//    "Item 5",
//    "Item 1",
//    "Item 2",
//    "Item 3",
//    "Item 4",
//    "Item 5"
)

@Composable
fun t1(
    options: List<String>,
    onSelected: (String) -> Unit = {},
    onNextButtonClicked: (option:String) -> Unit,
    onPreviousButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedValue by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        options.forEach { item ->
            Row {
                RadioButton(
                    selected = selectedValue == item,
                    onClick = {
                        selectedValue = item
                        onSelected(item)
                    })
                Text(item)
            }

        }
        Button(
            onClick = {onNextButtonClicked(selectedValue)},
            modifier = Modifier.fillMaxWidth(1f)
        ) {
            Text(text = "Next")
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun A1() {
    MyAndroidAppTheme {
        t1(
            options = list,
            onNextButtonClicked = { /*TODO*/ },
            onPreviousButtonClicked = { /*TODO*/ })
    }
}
//        Text(
//            text = "What is Lorem Ipsum? 1"
//        )
//        Text(
//            text =
//            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
//                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
//                    "when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
//                    "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
//                    "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
//                    "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
//        )
//        LazyColumn {
//            items(list) { item -> Text(text = item) }
//        }