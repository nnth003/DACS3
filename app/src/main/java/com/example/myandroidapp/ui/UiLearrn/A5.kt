package com.example.myandroidapp.ui.UiLearrn

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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

data class TruongTHPT(
    @DrawableRes val anh: Int,
    @StringRes val tenTruong: Int,
    @StringRes val tenQuan: Int,
    @StringRes val moTa: Int,

)

class TruongData() {
    fun load(): List<TruongTHPT> {
        return listOf<TruongTHPT>(
            TruongTHPT(R.drawable.image1, R.string.truong1, R.string.quan1, R.string.mota1),
            TruongTHPT(R.drawable.image2, R.string.truong2, R.string.quan2, R.string.mota2),
            TruongTHPT(R.drawable.image3, R.string.truong3, R.string.quan3, R.string.mota3),
            TruongTHPT(R.drawable.image4, R.string.truong4, R.string.quan4, R.string.mota4),
            TruongTHPT(R.drawable.image5, R.string.truong5, R.string.quan5, R.string.mota5),
            TruongTHPT(R.drawable.image6, R.string.truong6, R.string.quan6, R.string.mota6),
            TruongTHPT(R.drawable.image7, R.string.truong7, R.string.quan7, R.string.mota7),
            TruongTHPT(R.drawable.image8, R.string.truong8, R.string.quan3, R.string.mota3),
            TruongTHPT(R.drawable.image9, R.string.truong9, R.string.quan4, R.string.mota4),
            TruongTHPT(R.drawable.image10, R.string.truong10, R.string.quan6, R.string.mota1),

        )
    }
}

@Composable
fun TruongList(
    truongList: List<TruongTHPT>,
    onSelected: (index: Int) -> Unit,
    modifier: Modifier = Modifier,
    onDelete: (anh: Int) -> Unit
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
        items(truongList.size) { index ->
            CardTruong(
                truong = truongList[index],
                modifier = Modifier.padding(8.dp),
                onSelected = { onSelected(index) }
            ) { anh -> onDelete(anh) }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardTruong(truong: TruongTHPT, modifier: Modifier = Modifier, onSelected: () -> Unit, onDelete: (anh: Int) -> Unit) {
    Card(modifier = modifier, onClick = onSelected) {
        Column {
            Image(
                painter = painterResource(truong.anh),
                contentDescription = stringResource(truong.moTa),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(truong.tenTruong),
                modifier = Modifier.padding(2.dp),
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                text = LocalContext.current.getString(truong.tenQuan),
                modifier = Modifier.padding(2.dp),
                style = MaterialTheme.typography.displaySmall
            )
            Button(onClick = {
            onDelete(truong.anh)
        }) {
            Text(text = "Delete")
        }

        }
    }
}




@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun A5() {
    MyAndroidAppTheme {
//        TruongList(truongList = TruongData().load(), onSelected = {})
    }
}
