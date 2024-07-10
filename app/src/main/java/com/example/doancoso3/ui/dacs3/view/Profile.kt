package com.example.doancoso3.ui.dacs3.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.doancoso3.R
import com.example.doancoso3.ui.dacs3.model.ViewModelDA
import com.example.doancoso3.ui.dacs3.model.auth
import com.example.doancoso3.ui.theme.DoAnCoSo3Theme


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun Profile(
    viewModelDA: ViewModelDA,
    navHostController: NavHostController,
) {
    val auth_id by viewModelDA.authCheck.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.taikhoan))
                },
                navigationIcon = {
                    IconButton(onClick = { navHostController.navigate(RouteScreen.Home.route) }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
            )
        },
        bottomBar = {
            Button(
                onClick = {
                    viewModelDA.logout()
                    navHostController.navigate(RouteScreen.Login.route)
                },
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(4.dp)
            ) {
                Text(text = "Đăng Xuất")
            }
        },
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8),
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(
                            modifier = Modifier.padding(vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(60.dp)
                            )
                            Column(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = auth_id[0].ten,
                                    style = MaterialTheme.typography.titleLarge
                                )
                            }
                        }
                        Column(modifier = Modifier.padding(vertical = 5.dp)) {
                            ImageText(
                                icon = Icons.Default.LocationOn,
                                name = auth_id[0].diachi,
                                onClick = {}
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            ImageText(
                                icon = Icons.Default.Call,
                                name = auth_id[0].sdt.toString(),
                                onClick = { }
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            ImageText(
                                icon = Icons.Default.MailOutline,
                                name = auth_id[0].email,
                                onClick = { }
                            )
                        }

                    }
                }
                Divider()
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    shape = RoundedCornerShape(8),
                ) {
                    Column(modifier = Modifier.padding(5.dp)) {
//                    Text(
//                        modifier = Modifier
//                            .padding(10.dp),
//                        text = "NTH2",
//                        style = MaterialTheme.typography.titleMedium,
//                    )
                        MoreOptionsComp(
                            icon = Icons.Default.Edit,
                            name = "Sửa thông tin",
                            onClick = {
                                navHostController.navigate(RouteScreen.EditProfile.route)
                            }
                        )
                        MoreOptionsComp(
                            icon = Icons.Default.List,
                            name = "Danh sách đơn hàng",
                            onClick = {
                                navHostController.navigate("${RouteScreen.Order.route}/${auth_id[0].iduser}")
                            }
                        )
                    }
                }
            }
        }

    }
}

@Composable
fun ImageText(
    icon: ImageVector,
    name: String,
    onClick: () -> Unit
) {
    Row {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .size(20.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = name,
            style = MaterialTheme.typography.labelLarge,
        )
    }

}

@Composable
fun MoreOptionsComp(
    icon: ImageVector,
    name: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(imageVector = icon, contentDescription = null)
        Column(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .weight(1f)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.labelLarge
            )
        }
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun DanhMuc() {
    DoAnCoSo3Theme() {
//        Profile()
    }

}