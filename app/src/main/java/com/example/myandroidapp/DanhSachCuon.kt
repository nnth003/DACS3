package com.example.myandroidapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myandroidapp.ui.theme.MyAndroidAppTheme

data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResource: Int,
)

class Datasource() {
    fun loadAffirmation(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2),
            Affirmation(R.string.affirmation3, R.drawable.image3),
            Affirmation(R.string.affirmation4, R.drawable.image4),
            Affirmation(R.string.affirmation5, R.drawable.image5),
            Affirmation(R.string.affirmation6, R.drawable.image6),
            Affirmation(R.string.affirmation7, R.drawable.image7),
            Affirmation(R.string.affirmation8, R.drawable.image8),
            Affirmation(R.string.affirmation9, R.drawable.image9),
            Affirmation(R.string.affirmation10, R.drawable.image10)
        )
    }
}

@Composable
fun AffirmationApp() {
    AffirmationList(affirmationList = Datasource().loadAffirmation())
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = modifier) {
        items(affirmationList) { affirmation ->
            AffirmationCard(affirmation = affirmation, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier) {
    Card(modifier = modifier) {
        Column {
            Box {
                Image(
                    painter = painterResource(affirmation.imageResource),
                    contentDescription = stringResource(affirmation.stringResourceId),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Box(
                modifier = Modifier.height(150.dp)
            ) {
                Text(
                    text = LocalContext.current.getString(affirmation.stringResourceId),
                    modifier = Modifier
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    style = MaterialTheme.typography.headlineSmall,
//                    maxLines = 4,
//                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Aff(){
    MyAndroidAppTheme {
//        AffirmationApp()
    }
}