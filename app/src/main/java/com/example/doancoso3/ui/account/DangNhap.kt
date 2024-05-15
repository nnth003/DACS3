package com.example.doancoso3.ui.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(
    navController: NavController? = null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
//            BackButton(R.drawable.ic_round_arrow_back, null) {
//                navController?.navigateUp()
//            }
            Spacer(modifier = Modifier.height(32.dp))
            TitleSection("Welcome\nBack", "Login to your account using email")
        }
        LoginSection("Email address", "Password")
        ContinueButtonSection("Login", Icons.Default.ArrowForward, null)
        OtherOptionSection()
        RedirectSection("Sign up", true) {
//            navController?.navigate(Screen.SignupScreen.route)
        }
    }
}

@Composable
fun LoginSection(
    hintEmail: String,
    hintPassword: String
) {
    Column {
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        SignupTextField(email.value, { email.value = it }, "",hintEmail)
        Spacer(modifier = Modifier.height(12.dp))
        SignupTextField(password.value, { password.value = it } ,"",hintPassword)
    }
}

@Composable
fun OtherOptionSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
//        OptionItem(R.drawable.google, null)
//        OptionItem(R.drawable.apple, null)
//        OptionItem(R.drawable.facebook, null)
    }
}

@Composable
fun OptionItem(
    icon: Int,
    iconDescription: String?
) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .border(2.dp, textWhite, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = iconDescription,
            modifier = Modifier.size(32.dp)
        )
    }
}
@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun LoginPreview() {
    LoginScreen()
}