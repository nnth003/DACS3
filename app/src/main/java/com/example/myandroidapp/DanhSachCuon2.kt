package com.example.myandroidapp

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myandroidapp.ui.theme.MyAndroidAppTheme

data class Dog(
    @DrawableRes val image: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies: Int
)

val dogs = listOf(
    Dog(R.drawable.image1, R.string.dog_name_1, 2, R.string.dog_description_1),
    Dog(R.drawable.image2, R.string.dog_name_2, 2, R.string.dog_description_2),
    Dog(R.drawable.image3, R.string.dog_name_3, 2, R.string.dog_description_3),
    Dog(R.drawable.image4, R.string.dog_name_4, 2, R.string.dog_description_4),
    Dog(R.drawable.image5, R.string.dog_name_5, 2, R.string.dog_description_5),
    Dog(R.drawable.image6, R.string.dog_name_6, 2, R.string.dog_description_6),
    Dog(R.drawable.image7, R.string.dog_name_7, 2, R.string.dog_description_7),
    Dog(R.drawable.image8, R.string.dog_name_8, 2, R.string.dog_description_8),
    Dog(R.drawable.image9, R.string.dog_name_9, 2, R.string.dog_description_9),
)

@Composable
fun DogApp() {
    Scaffold(
        topBar = { DogAppTopBar() }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(dogs.size) {
                DogItem(
                    dog = dogs[it],
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }

}


@Composable
fun DogItem(
    dog: Dog,
    modifier: Modifier = Modifier
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer

    )
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
                .background(color = color)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            )
            {
                DogIcon(dog.image)
                DogInformation(dogName = dog.name, dogAge = dog.age)
                Spacer(modifier = Modifier.weight(1f))
                DogItemButton(expended = expanded, onClick = { expanded = !expanded })
            }
            if (expanded) {
                DogHobby(
                    dogHobby = dog.hobbies, modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        bottom = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium),
                    )
                )
            }
        }
    }
}


@Composable
fun DogItemButton(
    expended: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(
            imageVector = if (expended) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogAppTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small)),
                    painter = painterResource(R.drawable.ic_woof_logo),
                    contentDescription = null,
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun DogIcon(
    @DrawableRes dogIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = dogIcon),
        contentDescription = null,
    )
}

@Composable
fun DogInformation(
    @StringRes dogName: Int,
    dogAge: Int,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(dogName),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(
                top = dimensionResource(R.dimen.padding_small)
            )
        )
        Text(
            text = stringResource(id = R.string.years_old, dogAge),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun DogHobby(
    @StringRes dogHobby: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = stringResource(R.string.about), style = MaterialTheme.typography.labelSmall)
        Text(text = stringResource(dogHobby), style = MaterialTheme.typography.bodyLarge)
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Dog(){
    MyAndroidAppTheme {
//        DogApp()
    }
}

