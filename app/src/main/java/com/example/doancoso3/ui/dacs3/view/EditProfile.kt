package com.example.doancoso3.ui.dacs3.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.doancoso3.ui.dacs3.model.ViewModelDA
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun EditProfile(
    navHostController: NavHostController,
    viewModelDA: ViewModelDA
) {
    val auth by viewModelDA.authCheck.collectAsState()

    val coroutineScope = rememberCoroutineScope()

    val name = remember { mutableStateOf(auth[0].user) }
    val fullname = remember { mutableStateOf(auth[0].ten) }
    val email = remember { mutableStateOf(auth[0].email) }
    val password = remember { mutableStateOf(auth[0].pass) }
    val phone = remember { mutableStateOf(auth[0].sdt) }
    val location = remember { mutableStateOf(auth[0].diachi) }
    val local = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            BackButton(Icons.Default.ArrowBack) {
                navHostController.navigateUp()
            }
            Spacer(modifier = Modifier.height(32.dp))
            TitleSection(
                "Xin Chào",
                "Hãy nhập thông tin tài khoản bạn muốn sửa"
            )
        }
        EditField(
            value = name.value,
            onValueChange = { name.value = it },
            hint = "",
            hintTitle = "User name",
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions()
        )
        EditField(
            email.value,
            { email.value = it },
            "",
            "Email",
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            ),
            keyboardActions = KeyboardActions()
        )
        EditField2(
            password.value,
            { password.value = it },
            "",
            "Password",
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions()
        )
        EditField(
            fullname.value,
            { fullname.value = it },
            "",
            "Full Name",
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions()
        )
        EditField(
            phone.value,
            { phone.value = it },
            "",
            "Phone number",
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Phone
            ),
            keyboardActions = KeyboardActions()
        )
        EditField(
            location.value,
            { location.value = it },
            "",
            "Location",
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions()
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        Toast.makeText(
                            local,
                            "Đang cập nhật thông tin. Vui lòng đợi",
                            Toast.LENGTH_SHORT
                        ).show()
                        viewModelDA.updateUser(
                            auth[0].iduser,
                            name.value,
                            email.value,
                            password.value,
                            fullname.value,
                            phone.value,
                            location.value
                        )
                        delay(4000)
                        Toast.makeText(
                            local,
                            "Sửa thông tin thành công",
                            Toast.LENGTH_SHORT
                        ).show()
                        navHostController.navigateUp()
                    }
                },
                modifier = Modifier.width(200.dp)
            ) {
                Text(text = "Sửa thông tin")
            }
        }
//        ContinueButtonSection("Sign up", Icons.Default.ArrowForward, null)
//        RedirectSection("Login") {
//            navController.navigate(ScreenDACS3.Login.route)
//        }
    }
}


@Composable
fun EditField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    hintTitle: String,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions
) {
    Column {

        TextField(
            label = {
                Text(
                    text = hintTitle,
//                    modifier = Modifier.padding(start = 4.dp, bottom = 4.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            },
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(text = hint)
            },
            colors = TextFieldDefaults.colors(
//                backgroundColor = textWhite,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(15.dp)),
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions
        )
    }
}
@Composable
fun EditField2(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    hintTitle: String,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
) {
    var passwordVisible by remember { mutableStateOf(false) }
    Column {
        TextField(
            label = {
                Text(
                    text = hintTitle,
                    color = MaterialTheme.colorScheme.primary
                )
            },
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(text = hint)
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(15.dp)),
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, description)
                }
            },
        )
    }
}