package com.example.doancoso3.test.account//package com.example.doancoso3.ui.account
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.Button
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import com.example.doancoso3.ui.navigation.ScreenDACS3
//
//@Composable
//fun LoginScreen(
//    navController: NavController? = null
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding(24.dp),
//        verticalArrangement = Arrangement.SpaceBetween
//    ) {
//        Column {
//            BackButton(Icons.Default.ArrowBack, null) {
//                navController?.navigateUp()
//            }
//            Spacer(modifier = Modifier.height(32.dp))
//            TitleSection("Welcome Back!", "Login to your account using email")
//        }
//        LoginSection("Email address", "Password")
//        Row (
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Center,
//            modifier = Modifier.fillMaxWidth(),
//        ){
//            Button(
//                onClick = { /*TODO*/ },
//                modifier = Modifier.width(200.dp)
//            ) {
//                Text(text = "Login")
//            }
//        }
//
////        ContinueButtonSection("Login", Icons.Default.ArrowForward, null)
//        OtherOptionSection()
//        RedirectSection("Sign up", true) {
//            navController?.navigate(ScreenDACS3.Signup.route)
//        }
//    }
//}
//
//@Composable
//fun LoginSection(
//    hintEmail: String,
//    hintPassword: String
//) {
//    Column {
//        val email = remember { mutableStateOf("") }
//        val password = remember { mutableStateOf("") }
//
//        LoginTextField(email.value, { email.value = it }, "",hintEmail)
//        Spacer(modifier = Modifier.height(12.dp))
//        LoginTextField(password.value, { password.value = it } ,"",hintPassword)
//    }
//}
//@Composable
//fun LoginTextField(
//    value: String,
//    onValueChange: (String) -> Unit,
//    hint: String,
//    hintTitle: String,
//) {
//    Column {
//        Text(
//            text = hintTitle,
//            modifier = Modifier.padding(start = 4.dp, bottom = 4.dp),
//            color = MaterialTheme.colorScheme.primary
//        )
//        TextField(
//            value = value,
//            onValueChange = onValueChange,
//            placeholder = {
//                Text(text = hint)
//            },
//            colors = TextFieldDefaults.colors(
////                backgroundColor = textWhite,
//                focusedIndicatorColor = MaterialTheme.colorScheme.primary
//            ),
//            modifier = Modifier.fillMaxWidth(),
//        )
//    }
//}
//@Composable
//fun OtherOptionSection() {
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.SpaceEvenly
//    ) {
////        OptionItem(R.drawable.google, null)
////        OptionItem(R.drawable.apple, null)
////        OptionItem(R.drawable.facebook, null)
//    }
//}
//
//@Composable
//fun OptionItem(
//    icon: Int,
//    iconDescription: String?
//) {
//    Box(
//        modifier = Modifier
//            .size(60.dp)
//            .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
//        contentAlignment = Alignment.Center
//    ) {
//        Image(
//            painter = painterResource(id = icon),
//            contentDescription = iconDescription,
//            modifier = Modifier.size(32.dp)
//        )
//    }
//}
//@Preview(
//    showSystemUi = true,
//    showBackground = true
//)
//@Composable
//fun LoginPreview() {
//    LoginScreen()
//}