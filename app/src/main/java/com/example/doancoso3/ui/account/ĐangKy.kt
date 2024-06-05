package com.example.doancoso3.ui.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.doancoso3.ui.navigation.ScreenDACS3

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
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),
        ){
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(200.dp)
            ) {
                Text(text = "Sign Up")
            }
        }
//        ContinueButtonSection("Sign up", Icons.Default.ArrowForward, null)
        RedirectSection("Login")  {
            navController?.navigate(ScreenDACS3.Login.route)
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

@Composable
fun SignupTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    hintTitle: String,
) {
    Column {
        Text(
            text = hintTitle,
            modifier = Modifier.padding(start = 4.dp, bottom = 4.dp),
            color = MaterialTheme.colorScheme.primary
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(text = hint)
            },
            colors = TextFieldDefaults.colors(
//                backgroundColor = textWhite,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
@Preview
@Composable
fun DangKy() {
    SignupScreen()
}