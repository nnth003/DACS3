package com.example.doancoso3.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import  androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.doancoso3.R
import com.example.doancoso3.ui.theme.DoAnCoSo3Theme


enum class NavHostScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    TrangChu(title = R.string.trangchu),
    DanhMuc(title = R.string.danhmuc)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavHostAppBar(
    currency: NavHostScreen,
    canNaigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currency.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNaigateBack) {
                IconButton(onClick = { navigateUp }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}

@Composable
fun NavHostApp(
//    navControler: NavHostController = rememberNavController(),
) {
//    val backStackEntry by navControler.currentBackStackEntryAsState()
//    val route = backStackEntry?.destination?.route
//    val routeWithParams = route?.substringBefore("/") ?: NavHostScreen.Start.name
//    val currencyScreen = NavHostScreen.valueOf(routeWithParams)
//
//    Scaffold(
//        topBar = {
//            NavHostAppBar(
//                currency = currencyScreen,
//                canNaigateBack = navControler.previousBackStackEntry != null,
//                navigateUp = { navControler.navigateUp() })
//        }
//    ) {inner ->
    val navControler = rememberNavController()
       NavHost(
           navController = navControler,
           startDestination = NavHostScreen.TrangChu.name,
//           modifier = Modifier.padding(inner)
           ){
            composable(route = NavHostScreen.TrangChu.name){
                ScaffoldHome(
                    onDanhMucButton = navControler,
                    route = NavHostScreen.DanhMuc.name
                )
            }
           composable(route = NavHostScreen.DanhMuc.name){
                ScaffoldList(

                )
            }
       }
    }
//}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun NavHostTest() {
    DoAnCoSo3Theme {
        NavHostApp()
    }
}