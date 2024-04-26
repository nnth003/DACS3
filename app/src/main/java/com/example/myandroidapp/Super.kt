package com.example.myandroidapp

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myandroidapp.ui.theme.MyAndroidAppTheme

data class Hero(
    @StringRes val nameRes: Int,
    val descriptionRes: Int,
    @DrawableRes val imageRes: Int,
)

object HeroesRepository {
    val heroes = listOf(
        Hero(
            nameRes = R.string.hero1,
            descriptionRes = R.string.description1,
            imageRes = R.drawable.android_superhero1
        ),
        Hero(
            nameRes = R.string.hero2,
            descriptionRes = R.string.description2,
            imageRes = R.drawable.android_superhero2
        ),
        Hero(
            nameRes = R.string.hero3,
            descriptionRes = R.string.description3,
            imageRes = R.drawable.android_superhero3
        ),
        Hero(
            nameRes = R.string.hero4,
            descriptionRes = R.string.description4,
            imageRes = R.drawable.android_superhero4
        ),
        Hero(
            nameRes = R.string.hero5,
            descriptionRes = R.string.description5,
            imageRes = R.drawable.android_superhero5
        ),
        Hero(
            nameRes = R.string.hero6,
            descriptionRes = R.string.description6,
            imageRes = R.drawable.android_superhero6
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Super() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Superheroes",
                        style = MaterialTheme.typography.displayLarge
                    )
                },
            )
        }
    ) {it ->
        LazyColumn(contentPadding = it) {
            items(HeroesRepository.heroes.size) { item ->
                SuperCard(hero = HeroesRepository.heroes[item], modifier = Modifier.padding(8.dp))
            }
        }
    }


}

@Composable
fun SuperCard(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp, start = 16.dp, end = 16.dp),
//            .background(Color(0x6BD0BCFF))
        colors = CardDefaults.cardColors(
            containerColor = Color(0x6BD0BCFF)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(72.dp)
        ) {
            Column(
                modifier = Modifier
                    .width(260.dp)
                    .padding(end = 16.dp)
            ) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Image(
                painter = painterResource(hero.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(65.dp)
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AppSuper() {
    MyAndroidAppTheme() {
        Super()
    }
}

