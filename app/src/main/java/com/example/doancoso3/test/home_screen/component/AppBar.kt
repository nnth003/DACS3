//package com.example.doancoso3.test.home_screen.component
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Call
//import androidx.compose.material.icons.filled.Notifications
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material.icons.filled.ShoppingCart
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.constraintlayout.compose.ConstraintLayout
//import androidx.navigation.NavController
//import com.example.doancoso3.R
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AppBar(
//    navController: NavController,
//    isVisible: Boolean,
//    searchCharSequence: (String) -> Unit,
//    onNotificationIconClick: () -> Unit,
//    onCartIconClick: () -> Unit
//) {
//    var typedText by remember {
//        mutableStateOf(TextFieldValue())
//    }
//    if (isVisible) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 15.dp, end = 15.dp, top = 30.dp, bottom = 30.dp),
//            horizontalArrangement = Arrangement.spacedBy(5.dp)
//        ) {
//            TextField(
//                value = typedText,
//                onValueChange = { newText ->
//                    typedText = newText
//                    searchCharSequence(newText.text)
//                },
//                singleLine = true,
//                placeholder = { Text(text = "Search product") },
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Default.Search,
//                        contentDescription = "Product Search Icon"
//                    )
//                },
//                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = Color.Transparent,
//                    unfocusedBorderColor = Color.Transparent,
//                    cursorColor = MaterialTheme.colorScheme.primary
//                ),
//
//
//                modifier = Modifier
//                    .background(
//                        color = MaterialTheme.colorScheme.primary,
//                        shape = RoundedCornerShape(20.dp)
//                    )
//                    .weight(1f),
//
//                )
//
//            Box(
//                modifier = Modifier
//                    .size(48.dp)
//                    .clip(CircleShape)
//                    .background(MaterialTheme.colorScheme.primary)
//                    .clickable {
//                        onCartIconClick()
//                    },
//                contentAlignment = Alignment.Center
//            ) {
//                Image(
//                    imageVector = Icons.Default.ShoppingCart,
//                    contentDescription = "Cart Icon"
//                )
//            }
////            ConstraintLayout() {
////                val (notification, notificationCounter) = createRefs()
////
////                Box(
////                    modifier = Modifier
////                        .size(48.dp)
////                        .clip(CircleShape)
////                        .background(MaterialTheme.colorScheme.primary)
////                        .constrainAs(notification) {}
////                        .clickable {
////                            onNotificationIconClick()
////                        },
////
////                    contentAlignment = Alignment.Center
////                ) {
////                    Image(
////                        imageVector = Icons.Default.Notifications,
////                        contentDescription = "Notification Icon"
////                    )
////
////                }
////                //notification count
////                Box(
////                    modifier = Modifier
////                        .size(20.dp)
////                        .background(color = Color.Red, shape = CircleShape)
////                        .padding(3.dp)
////                        .constrainAs(notificationCounter) {
////                            top.linkTo(notification.top)
////                            end.linkTo(notification.end)
////                        },
////                    contentAlignment = Alignment.Center
////                ) {
////                    Text(text = "3", fontSize = 11.sp, color = Color.White)
////                }
////
////            }
//
//
//        }
//    }
//
//
//}