package com.example.doancoso3.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.doancoso3.R
import com.example.doancoso3.ui.theme.DoAnCoSo3Theme

data class Go(
    val ten: String,
    @DrawableRes val anh: Int,
    val gia: String
)

class DataGioHang() {
    fun load(): List<Go> {
        return listOf<Go>(
//            Go(R.string.hero1, R.string.description1, R.drawable.android_superhero1),
//            Go(R.string.hero2, R.string.description2, R.drawable.android_superhero2),
//            Go(R.string.hero3, R.string.description2, R.drawable.android_superhero3),
//            Go(R.string.hero4, R.string.description4, R.drawable.android_superhero4),
//            Go(R.string.hero5, R.string.description5, R.drawable.android_superhero5),
//            Go(R.string.hero6, R.string.description6, R.drawable.android_superhero6),
            Go("Macbook", R.drawable.architecture, "19.000.000đ"),
            Go("SamSung", R.drawable.architecture, "20.000.000đ"),
            Go("Dell", R.drawable.architecture, "10.000.000đ"),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GioHangApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onTertiary,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(stringResource(R.string.giohang))
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.onTertiary,
                contentColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .weight(1f)
                        .padding(2.dp)
                ) {
//                    Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                    Text(text = "Thanh Toán")
                }

            }
        }
    ) { innerPadding ->
        GioHangList(goList = DataGioHang().load(), modifier = Modifier.padding(innerPadding))
    }

}

@Composable
fun GioHangList(goList: List<Go>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(goList) { go ->
            CardGioHang(go = go, modifier = Modifier.padding(8.dp))
        }
    }

}

@Composable
fun CardGioHang(go: Go, modifier: Modifier = Modifier) {
    var quantity by remember { mutableStateOf(0) }

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier,
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))

            ) {
                Image(
                    painter = painterResource(go.anh),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )
            }
            Spacer(Modifier.width(20.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
//                    text = stringResource(go.ten),
                    text = go.ten,
                    style = MaterialTheme.typography.titleMedium,
//                    color = Color(0xFFFCE4EC)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = go.gia,
                    style = MaterialTheme.typography.bodyLarge,
//                    color = Color(0xFFFCE4EC)

                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Button(
                        onClick = { quantity-- },
                        modifier = Modifier
                            .width(50.dp)
                            .height(35.dp)
                    ) {
                        Text(text = "-")
                    }
                    BasicTextField(
                        value = if (quantity >= 0) {
                            quantity.toString()
                        } else {
                            quantity.toString(0)
                        },
                        onValueChange = { quantity = it.toIntOrNull() ?: 0 },
                        modifier = Modifier
                            .width(50.dp)
                            .align(Alignment.CenterVertically),
                        textStyle = TextStyle(textAlign = TextAlign.Center),
                        readOnly = true,
                    )
                    Button(
                        onClick = { quantity++ },
                        modifier = Modifier
                            .width(50.dp)
                            .height(35.dp)
                    ) {
                        Text(text = "+")
                    }
                }

            }
            Button(
                onClick = { /*TODO*/ },
//                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimaryContainer)
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "")
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun GioHang() {
    DoAnCoSo3Theme(darkTheme = false) {
        GioHangApp()
    }
}