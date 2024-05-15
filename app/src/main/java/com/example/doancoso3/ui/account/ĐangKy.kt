package com.example.doancoso3.ui.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

val name = mutableStateOf("")
val email = mutableStateOf("")
val password = mutableStateOf("")

@Composable
fun SignupScreen(
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
            BackButton(Icons.Default.ArrowBack, null) {
                navController?.navigateUp()
            }
            Spacer(modifier = Modifier.height(32.dp))
            TitleSection("Welcome", "Lets get started by creating your account with email")
        }
        SignupSection("Name", "Email address", "Password")
        ContinueButtonSection("Sing up", Icons.Default.ArrowForward, null)
        RedirectSection("Login")  {
//            navController?.navigate(Screen.LoginScreen.route)
        }
    }
}

@Composable
fun SignupSection(
    hintName: String,
    hintEmail: String,
    hintPassword: String
) {
    Column {
        SignupTextField(name.value, {name.value = it },"",hintName)
        Spacer(modifier = Modifier.height(12.dp))
        SignupTextField(email.value, { email.value = it }, "",hintEmail)
        Spacer(modifier = Modifier.height(12.dp))
        SignupTextField(password.value, { password.value = it } ,"",hintPassword)
    }
}

@Preview
@Composable
fun DangKy() {
    SignupScreen()
}