package com.example.doancoso3.ui.dacs3.view

import android.icu.text.NumberFormat
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.doancoso3.ui.theme.DoAnCoSo3Theme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun End(
    navHostController: NavHostController,
    textName: String?,
    textPhone: String?,
    textLocal: String?,
    totalPrice: Int?,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(26.dp)
        ) {

            com.example.doancoso3.ui.payment_ui.HeaderCircles()
            Spacer(modifier = Modifier.height(16.dp))
            SuccessCard(textName, textPhone, textLocal, totalPrice)

        }
        com.example.doancoso3.ui.payment_ui.CustomizedButton(
            modifier = Modifier.align(Alignment.BottomCenter),
            text = "Back to Home",
            onClick = { navHostController.navigate(RouteScreen.Home.route) }
        )

    }
}

@Composable
fun SuccessCard(
    textName: String?,
    textPhone: String?,
    textLocal: String?,
//    textMessage: String?,
    totalPrice: Int?
) {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)

    Box(
        Modifier
            .fillMaxWidth()
    ) {

        Card(
            shape = CircleShape, modifier = Modifier
                .align(Alignment.TopCenter)
                .zIndex(25f),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "",
                tint = com.example.doancoso3.ui.payment_ui.GreenLight,
                modifier = Modifier
                    .padding(16.dp)
                    .size(50.dp)

            )
        }
        Column(Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(60.dp))
            Card(
                modifier = Modifier
                    .zIndex(20f)
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                Color.LightGray,
                                Color.Transparent
                            )
                        )
                    ),
                shape = RoundedCornerShape(8.dp),

                ) {

                Column(
                    Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (textName != null && textPhone != null && textLocal != null) {
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.height(26.dp))
                            Text(
                                text = "Sent!",
                                color = com.example.doancoso3.ui.payment_ui.GreenLight
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Transfer Done",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                            Spacer(modifier = Modifier.height(16.dp))


                            Info(
                                leftText = "Sent to ",
                                rightText = textName,
                                showRightSubtitle = true,
//                                rightSubtitle = "91293293"
                            )


                            Info(leftText = "Phone", rightText = textPhone)
                            Info(
                                leftText = "Date/Time",
                                rightText = getCurrentDate(),
                                showRightSubtitle = true,
                                rightSubtitle = "12:00 AM"
                            )
                            Info(
                                leftText = "Locale",
                                rightText = textLocal,
                                showRightSubtitle = true,
//                            rightSubtitle = "xxx 8239 - $10"
                            )

                        }
                        Canvas(modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp), onDraw = {

                            drawLine(
                                color = Color.Gray,
                                start = Offset(0f, size.height / 2),
                                end = Offset(size.width, size.height / 2),
                                pathEffect = pathEffect
                            )
                            drawCircle(
                                color = Color(
                                    0xffffffff
                                ),
                                radius = 50f,
                                center = Offset(x = 0f, y = size.height / 2)
                            )
                            drawCircle(
                                color = Color(
                                    0xffffffff
                                ),
                                radius = 50f,
                                center = Offset(x = size.width, y = size.height / 2)
                            )
                        })

//                        Text(text = textMessage)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = fomat(amount = totalPrice), color = GreenLight, fontSize = 30.sp)
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }

    }
}


@Composable
fun Info(
    leftText: String,
    rightText: String,
    rightSubtitle: String = "",
    showRightSubtitle: Boolean = false
) {
    Row {
        Text(
            text = leftText,
            modifier = Modifier.fillMaxWidth(0.5f),
            color = Color.Gray,
            fontSize = 20.sp


        )
        Column(
            modifier = Modifier.fillMaxWidth(1f)
        ) {
            Text(
                text = rightText,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            if (showRightSubtitle)
                Text(
                    text = rightSubtitle,
                    color = Color.Gray,
                    fontSize = 15.sp


                )
        }

    }
    Spacer(modifier = Modifier.height(12.dp))

}
@Composable
fun fomat(amount: Int?): String {
    return NumberFormat.getNumberInstance(Locale("vi", "VN")).format(amount) + " VNĐ"
}
fun getCurrentDate(): String {
    val dateFormat = SimpleDateFormat("dd-MM-yyyy")
    val date = Date()
    return dateFormat.format(date)
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun Test() {
    DoAnCoSo3Theme {
        val nav = rememberNavController()
        End(
            navHostController = nav,
            textName = "NTH",
            textPhone = "0395520809",
            textLocal = "Da Nang",
            totalPrice = 123456789
        )
    }
}