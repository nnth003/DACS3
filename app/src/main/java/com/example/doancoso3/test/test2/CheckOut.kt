package com.example.doancoso3.test.test2//package com.example.doancoso3.ui.payment_ui
//
//import android.content.ContentValues.TAG
//import android.util.Log
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.AccountBox
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Alignment.Companion.CenterHorizontally
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.ImeAction
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.zIndex
//import androidx.navigation.NavHostController
//import com.example.doancoso3.R
//import com.example.doancoso3.ui.dacs3.viewmodel.ViewModelDACS3
//import com.example.doancoso3.ui.navigation.ScreenDACS3
//import com.example.doancoso3.ui.theme.DoAnCoSo3Theme
//
//val YellowLight = Color(0xDDF7D452)
//val GreenLight = Color(0xFF20b7b4)
//val Purple80 = Color(0xFFD0BCFF)
//val PurpleGrey80 = Color(0xFFCCC2DC)
//val Pink80 = Color(0xFFEFB8C8)
//
//val Purple40 = Color(0xFF6650a4)
//val PurpleGrey40 = Color(0xFF625b71)
//val Pink40 = Color(0xFF7D5260)
//
//@Composable
//fun PaymentScreen(viewModelDACS3: ViewModelDACS3, navController: NavHostController, total: Long) {
//    var textName by remember {
//        mutableStateOf("")
//    }
//    var textPhone by remember {
//        mutableStateOf("")
//    }
//    var textLocal by remember {
//        mutableStateOf("")
//    }
//    var textMessage by remember {
//        mutableStateOf("")
//    }
//    Column(
//        Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
//
//    ) {
//        TopArea {
//            TopBar(navController = navController)
//            HeaderCircles()
//            WalletAmount(total.toString())
//            AmountEnterCard(
//                textName,
//                textPhone,
//                textLocal,
//                textMessage,
//                onChangeName = { textName = it },
//                onChangePhone = { textPhone = it },
//                onChangeLocal = { textLocal = it },
//            ) { textMessage = it }
//        }
//        CustomizedButton(
//            text = "Xác nhận",
//            onClick = {
//                viewModelDACS3.setDataUser(textName, textPhone, textLocal, textMessage)
//                navController.navigate("${ScreenDACS3.Success.route}/${textName}/${textPhone}/${textLocal}/${textMessage}")
//                Log.d(TAG, "${ScreenDACS3.Success.route}/${textName}/${textPhone}/${textLocal}/${textMessage}")
//            }
//        )
//    }
//
//}
//
//@Composable
//fun TopBar(navController: NavHostController) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(60.dp)
//            .zIndex(1f),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Icon(
//            imageVector = Icons.Default.ArrowBack,
//            contentDescription = stringResource(R.string.back_button),
//            Modifier.clickable { navController.navigateUp() }
//        )
//    }
//}
//
//@Composable
//fun TopArea(content: @Composable () -> Unit) {
//
//    Column(
//        Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        content()
//    }
//}
//
//@Composable
//fun HeaderCircles() {
//    Canvas(modifier = Modifier
//        .fillMaxWidth()
//        .height(100.dp), onDraw = {
//        val canvasHeight = size.height
//        drawCircle(
//            color = YellowLight,
//            center = Offset(
//                x = 170f,
//                y = -50f
//            ),
//            radius = canvasHeight,
//        )
//        drawCircle(
//            color = Purple40,
//            center = Offset(
//                x = 0f,
//                y = 0f
//            ),
//            radius = canvasHeight
//        )
//    })
//}
//
//
//@Composable
//fun WalletAmount(text: String) {
//    Column(Modifier.padding(vertical = 16.dp)) {
//        Text(
//            text = "Tổng Tiền",
//            color = Color.Black,
//            fontWeight = FontWeight.SemiBold,
//            fontSize = 30.sp
//        )
//        Text(
//            text = text,
//            color = Purple40,
//            fontWeight = FontWeight.Bold,
//            fontSize = 33.sp
//        )
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AmountEnterCard(
//    textName: String,
//    textPhone: String,
//    textLocal: String,
//    textMessage: String,
//    onChangeName: (String) -> Unit,
//    onChangePhone: (String) -> Unit,
//    onChangeLocal: (String) -> Unit,
//    onChangeMessage: (String) -> Unit
//) {
//    Card(
//        shape = RoundedCornerShape(8.dp),
//        border = BorderStroke(
//            1.dp, Color.LightGray
//        ),
//        modifier = Modifier.fillMaxWidth(),
//        colors = CardDefaults.cardColors(
//            containerColor = Color.White
//        )
//    ) {
//        Column(
//            modifier = Modifier.padding(16.dp),
//
//            ) {
//            Text(text = "Nhập thông tin nhận hàng", fontSize = 22.sp, fontWeight = FontWeight.Bold)
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//
//            AmountTextField(
//                value = textName,
//                onValueChange = onChangeName,
//                placeholder = "Họ và Tên",
//                imeAction = ImeAction.Next,
//                keyboardType = KeyboardType.Text
//            )
//            AmountTextField(
//                value = textPhone,
//                onValueChange = onChangePhone,
//                placeholder = "Địa Chỉ",
//                imeAction = ImeAction.Next,
//                keyboardType = KeyboardType.Text
//            )
//            AmountTextField(
//                value = textLocal,
//                onValueChange = onChangeLocal,
//                placeholder = "Số Điện Thoại",
//                imeAction = ImeAction.Next,
//                keyboardType = KeyboardType.Number
//            )
//
//            Spacer(modifier = Modifier.height(30.dp))
////            Text(text = "Add some tips")
////            Spacer(modifier = Modifier.height(10.dp))
////            Row {
////                tipAmounts.forEach {
////                    TipButton(title = it, isToggled = selectedTips == it) { title, change ->
////                        selectedTips = if (change) {
////                            title
////                        } else {
////                            ""
////                        }
////                    }
////                    Spacer(modifier = Modifier.width(10.dp))
////                }
////
////
////            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//            TextField(
//                value = textMessage,
//                onValueChange = onChangeMessage,
//                colors = TextFieldDefaults.textFieldColors(
//                    containerColor = Color.White,
//                    focusedIndicatorColor = Color.LightGray,
//                    unfocusedLabelColor = Color.Transparent,
//                    disabledTextColor = Color.Transparent,
//                    disabledIndicatorColor = Color.Transparent,
//                    unfocusedIndicatorColor = Color.Transparent
//                ),
//                modifier = Modifier.align(CenterHorizontally),
//                placeholder = {
//                    Text(text = "Add Message")
//                }
//            )
//
//        }
//    }
//}
//
//@Composable
//fun TipButton(
//    title: String = "$10",
//    isToggled: Boolean = false
//) {
//    val color = if (isToggled) GreenLight else Color.Gray
//    Card(
//        shape = CircleShape,
//        border = BorderStroke(1.dp, color = color),
//    ) {
//        Text(
//            text = title,
//            modifier = Modifier
//                .padding(horizontal = 16.dp, vertical = 8.dp),
//            color = color
//        )
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AmountTextField(
//    value: String,
//    onValueChange: (String) -> Unit,
//    placeholder: String,
//    imeAction: ImeAction,
//    keyboardType: KeyboardType
//) {
//
//    TextField(
//        value = value,
//        onValueChange = onValueChange,
//        colors = TextFieldDefaults.colors(
//            focusedContainerColor = Color.White,
//            unfocusedContainerColor = Color.White,
//            disabledContainerColor = Color.White,
//            focusedIndicatorColor = Color.DarkGray,
//            unfocusedLabelColor = Color.Gray,
//        ),
//        placeholder = {
//            Text(text = placeholder, color = Color.Gray)
//        },
//        leadingIcon = {
//            Icon(
//                imageVector = Icons.Filled.AccountBox,
//                contentDescription = "Money"
//            )
//        },
//        keyboardOptions = KeyboardOptions(
//            imeAction = imeAction,
//            keyboardType = keyboardType
//        ),
//        modifier = Modifier.fillMaxWidth(),
//        textStyle = TextStyle(fontSize = 20.sp)
//    )
//}
//
//
//@Composable
//fun CustomizedButton(
//    modifier: Modifier = Modifier,
//    text: String,
//    onClick: () -> Unit
//) {
//    Column(
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//    ) {
//        Button(
//            onClick = onClick,
//            colors = ButtonDefaults.buttonColors(
//                containerColor = Purple40,
//            ), shape = RoundedCornerShape(4.dp),
//            modifier = Modifier.fillMaxWidth(),
//            contentPadding = PaddingValues(16.dp)
//        ) {
//            Text(text = text)
//        }
//    }
//
//}
//
//@Preview(
//    showSystemUi = true,
//    showBackground = true
//)
//@Composable
//fun Amount() {
//    DoAnCoSo3Theme {
////        PaymentScreen {
////        }
//    }
//}
//
//
//
//
