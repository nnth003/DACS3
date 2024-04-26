package com.example.myandroidapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myandroidapp.ui.theme.MyAndroidAppTheme


@Composable
fun GreetingText(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(painter = painterResource(id = R.drawable.ti_xung), contentDescription = "LOGO")
        Text(
            text = "Nguyễn Thanh Hải ",
            color = Color.Black,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Learning Android App",
            color = Color(0xFF16794a),
            fontSize = 15.sp,
        )
        Spacer(modifier.height(250.dp))
        Column {
            Row {
                Icon(
                    imageVector = Icons.Rounded.Phone,
                    contentDescription = "Phone",
                    tint = Color(0xFF16794a)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = "0123456789")
            }
            Row {
                Icon(
                    imageVector = Icons.Rounded.Share,
                    contentDescription = "Share",
                    tint = Color(0xFF16794a)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = "@NguyenThanhHai")
            }
            Row {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = "Email",
                    tint = Color(0xFF16794a)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = "haint.22itb@vku.udn.vn")
            }
            Row {

            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun App(){
    MyAndroidAppTheme {
        GreetingText()
    }
}