package com.example.doancoso3.ui.dacs3.view.account

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.doancoso3.ui.dacs3.view.BackButton
import com.example.doancoso3.ui.dacs3.view.TitleSection
import com.example.doancoso3.ui.dacs3.viewmodel.ViewModelDA
import com.example.doancoso3.ui.dacs3.view.navigation.RouteScreen
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


@Composable
fun LoginScreen(
    navController: NavHostController? = null,
    viewModelDA: ViewModelDA
) {

    val auth by viewModelDA.authCheck.collectAsState()
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val local = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val loading = remember { mutableStateOf(false) }
    val colorText = listOf(Color.Transparent, Magenta, Color.LightGray)

    var passwordVisible by remember { mutableStateOf(false) }

    val brush = remember {
        Brush.linearGradient(
            colors = colorText
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            BackButton(Icons.Default.Close) {
                navController?.navigate(RouteScreen.Home.route)
            }
            Spacer(modifier = Modifier.height(32.dp))
            TitleSection("Xin Chào!", "Vui lòng đăng nhập")
        }
        Column {
            Column {
                TextField(
                    label = {
                        Text(
                            text = "Email Address",
//                            modifier = Modifier.padding(start = 4.dp, bottom = 4.dp),
                            color = MaterialTheme.colorScheme.primary
                        )
                    },
                    value = email.value,
                    onValueChange = { email.value = it },
                    placeholder = {
                        Text(text = "")
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
//                backgroundColor = textWhite,
                        focusedIndicatorColor = MaterialTheme.colorScheme.primary
                    ),
//                    textStyle = TextStyle(brush = brush),
                    modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(20.dp)),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Text
                    ),
                )
            }
            Spacer(modifier = Modifier.height(22.dp))
            Column {

                TextField(
                    label = {
                        Text(
                            text = "Password",
//                            modifier = Modifier.padding(start = 4.dp, bottom = 4.dp),
                            color = MaterialTheme.colorScheme.primary
                        )
                    },
                    value = password.value,
                    onValueChange = { password.value = it },
                    placeholder = {
                        Text(text = "")
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
//                backgroundColor = textWhite,
                        focusedIndicatorColor = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(20.dp)),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Password
                    ),
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
                        keyboardActions = KeyboardActions(
                            onDone = {
                                coroutineScope.launch {
                                    viewModelDA.auth_check(email.value, password.value)
                                    Toast.makeText(
                                        local,
                                        "Đang xử lý, vui lòng chờ",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    loading.value = true
                                    delay(5000)

                                    Log.e("LOGIN", "Email: ${email.value}/Pass: ${password.value}")
                                    if (auth.isNotEmpty() && auth[0].user == email.value && auth[0].pass == password.value) {
                                        viewModelDA.login()
                                        navController?.navigate(RouteScreen.Home.route)
                                    } else {
                                        Toast.makeText(
                                            local,
                                            "Lỗi đăng nhập, vui lòng thử lại",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                    loading.value = false
                                }
                            }
                        )
                        )
                    }
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                viewModelDA.auth_check(email.value, password.value)
                                Toast.makeText(
                                    local,
                                    "Đang xử lý, vui lòng chờ",
                                    Toast.LENGTH_SHORT
                                ).show()
                                loading.value = true
                                delay(5000)

                                Log.e("LOGIN", "Email: ${email.value}/Pass: ${password.value}")
                                if (auth.isNotEmpty() && auth[0].user == email.value && auth[0].pass == password.value) {
                                    viewModelDA.login()
                                    navController?.navigate(RouteScreen.Home.route)
                                } else {
                                    Toast.makeText(
                                        local,
                                        "Lỗi đăng nhập, vui lòng thử lại",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                                loading.value = false
                            }

                        },
                        modifier = Modifier.width(200.dp)
                    ) {
                        Text(text = "Login")
                    }

                }
                Button(
                    onClick = { navController?.navigate(RouteScreen.Signup.route) },
                    modifier = Modifier.width(200.dp)
                ) {
                    Text(text = "Register")
                }
            }


//        ContinueButtonSection("Login", Icons.Default.ArrowForward, null)
            OtherOptionSection(viewModelDA)
//        RedirectSection("Sign up", true) {
//            navController?.navigate(RouteScreen.Signup.route)
//        }
        }
    }


    @Composable
    fun OtherOptionSection(viewModelDA: ViewModelDA) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
//        OptionItem(R.drawable.google, null, viewModelDA)
//        OptionItem(R.drawable.apple, null)
//        OptionItem(R.drawable.facebook, null)
        }
    }

    @Composable
    fun OptionItem(
        icon: Int,
        iconDescription: String?,
        viewModelDA: ViewModelDA
    ) {
        val local = LocalContext.current
        val launcher = rememberFirebaseAuthLauncher(
            onAuthComplete = { result ->
                viewModelDA.user = result.user
            },
            onAuthError = {
                viewModelDA.user = null
            },
        )
        Box(
            modifier = Modifier
                .size(60.dp)
                .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = iconDescription,
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
//                viewModelDA.signInWithGoogle(R.string.app_name,local,launcher)
                    }
            )
        }
    }

    @Preview(
        showSystemUi = true,
        showBackground = true
    )
    @Composable
    fun LoginPreview() {
//    LoginScreen()
    }

    @Composable
    fun rememberFirebaseAuthLauncher(
        onAuthComplete: (AuthResult) -> Unit,
        onAuthError: (ApiException) -> Unit,
    ): ManagedActivityResultLauncher<Intent, ActivityResult> {
        val scope = rememberCoroutineScope()
        return rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                val credential = GoogleAuthProvider.getCredential(account.idToken!!, null)
                scope.launch {
                    val authResult = Firebase.auth.signInWithCredential(credential).await()
                    onAuthComplete(authResult)
                }
            } catch (e: ApiException) {
                onAuthError(e)
            }
        }
    }