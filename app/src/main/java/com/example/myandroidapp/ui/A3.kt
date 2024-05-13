package com.example.myandroidapp.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myandroidapp.R
import com.example.myandroidapp.ui.theme.MyAndroidAppTheme

val listA3 = listOf(
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
fun t3(
    options: List<String>,
    onSelected: (String) -> Unit = {},
    onNextButtonClicked: (String) -> Unit,
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
            onClick = { onNextButtonClicked(selectedValue) },
            modifier = Modifier.fillMaxWidth(1f)
        ) {
            Text(text = "Next")
        }
    }

}


data class Go(
    @StringRes val stringRes: Int,
    @DrawableRes val imageRes: Int
)

class DataA3() {
    fun load(): List<Go> {
        return listOf<Go>(
            Go(R.string.affirmation1, R.drawable.image1),
            Go(R.string.affirmation2, R.drawable.image2),
            Go(R.string.affirmation3, R.drawable.image3),
            Go(R.string.affirmation4, R.drawable.image4),
            Go(R.string.affirmation5, R.drawable.image5),
            Go(R.string.affirmation6, R.drawable.image6),
            Go(R.string.affirmation7, R.drawable.image7),
            Go(R.string.affirmation8, R.drawable.image9),
            Go(R.string.affirmation9, R.drawable.image10),
            Go(R.string.affirmation10, R.drawable.image8),
        )
    }
}

//@Composable
//fun DeviceApp() {
//    DeviceList(goList = DataA3().load(), onSelected = {})
//}

@Composable
fun DeviceList(
    goList: List<Go>,
    onSelected: (index: Int) -> Unit,
    modifier: Modifier = Modifier
) {
//    LazyColumn(modifier = modifier) {
//        items(goList) { go ->
//            Device(go = go, modifier = Modifier.padding(8.dp))
//        }
//    }
    var selectedValue by remember {
        mutableStateOf("")
    }
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = modifier) {
        items(goList.size) { index ->
            Student(
                go = goList[index],
                modifier = Modifier.padding(8.dp),
                onSelected = { onSelected(index) })
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Student(go: Go, modifier: Modifier = Modifier, onSelected: () -> Unit) {
    Card(modifier = modifier, onClick = onSelected) {
        Column {
            Image(
                painter = painterResource(go.imageRes),
                contentDescription = stringResource(go.stringRes),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(go.stringRes),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun A3() {
    MyAndroidAppTheme {
        t3(
            options = list,
            onNextButtonClicked = { /*TODO*/ },
            onPreviousButtonClicked = { /*TODO*/ })
    }
}
