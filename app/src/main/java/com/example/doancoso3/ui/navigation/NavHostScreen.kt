package com.example.doancoso3.ui.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import  androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.doancoso3.ui.CartScreen
import com.example.doancoso3.ui.EcommerceHomeScreen
import com.example.doancoso3.ui.ProductScreen
import com.example.doancoso3.ui.ScaffoldHome
import com.example.doancoso3.ui.account.LoginScreen
import com.example.doancoso3.ui.account.SignupScreen
import com.example.doancoso3.ui.data.ViewModelDACS3
import com.example.doancoso3.ui.payment_ui.PaymentScreen
import com.example.doancoso3.ui.payment_ui.SuccessScreen
import com.example.doancoso3.ui.theme.DoAnCoSo3Theme


//enum class NavHostScreen(@StringRes val title: Int) {
//    Start(title = R.string.app_name),
//    TrangChu(title = R.string.trangchu),
//    DanhMuc(title = R.string.danhmuc),
//    ChiTietSanPham(title = R.string.chitietsanpham),
//    GioHang(title = R.string.giohang),
//    TaiKhoan(title = R.string.taikhoan)
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun NavHostAppBar(
//    currency: NavHostScreen,
//    canNaigateBack: Boolean,
//    navigateUp: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    TopAppBar(
//        title = { Text(stringResource(currency.title)) },
//        colors = TopAppBarDefaults.mediumTopAppBarColors(
//            containerColor = MaterialTheme.colorScheme.primaryContainer
//        ),
//        modifier = modifier,
//        navigationIcon = {
//            if (canNaigateBack) {
//                IconButton(onClick = { navigateUp }) {
//                    Icon(
//                        imageVector = Icons.Default.ArrowBack,
//                        contentDescription = "Back"
//                    )
//                }
//            }
//        }
//    )
//}

@Composable
fun NavHostAppDACS3(
    navHostController: NavHostController
) {
//    val navControler = rememberNavController()
    val viewModelDACS3: ViewModelDACS3 = viewModel()
    val sanPhamList by viewModelDACS3.product.collectAsState()
    val context = LocalContext.current


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

    NavHost(
        navController = navHostController,
        startDestination = ScreenDACS3.ScaffoldHome.route,
//           modifier = Modifier.padding(inner)
    ) {

        //TrangChu.kt
        composable(route = ScreenDACS3.ScaffoldHome.route) {
            ScaffoldHome(navHostController = navHostController, viewModelDACS3 = viewModelDACS3)
        }

        //DanhSach.kt
        composable(route = ScreenDACS3.EcommerceHomeScreen.route) {
            EcommerceHomeScreen(
                navController = navHostController,
                viewModelDACS3 = viewModelDACS3,
//              id = id
            )
        }

        composable(
            route = "${ScreenDACS3.ProductScreen.route}/{i}",
            arguments = listOf(
                navArgument("i") {
                    type = NavType.IntType
                }
            )
        ) {
            val id = it.arguments?.getInt("i")
            if (id != null) {
                ProductScreen(
                    viewModelDACS3 = viewModelDACS3,
                    navController = navHostController,
                    id = id
                )
            } else {
                Toast.makeText(context, "Error ID", Toast.LENGTH_SHORT).show()

            }
        }
        composable(route = ScreenDACS3.CartScreen.route) {
            CartScreen(navHostController = navHostController, viewModelDACS3 = viewModelDACS3)
        }
//           composable(route = NavHostScreen.TaiKhoan.name){
//
//            }
        composable(
            route = "${ScreenDACS3.CheckOut.route}/{totalGia}",
            arguments = listOf(
                navArgument("totalGia") {
                    type = NavType.LongType
                }
            )
        ) {
            val total = it.arguments?.getLong("totalGia")
            if (total != null) {
                PaymentScreen(viewModelDACS3, navHostController, total)
            }
        }
        composable(
            route = "${ScreenDACS3.Success.route}/{textName}/{textPhone}/{textLocal}/{textMessage}",
            arguments = listOf(
                navArgument("textName"){type = NavType.StringType},
                navArgument("textPhone"){type = NavType.StringType},
                navArgument("textLocal"){type = NavType.StringType},
                navArgument("textMessage"){type = NavType.StringType},
            )
        ) {
            val textName = it.arguments?.getString("textName")
            val textPhone = it.arguments?.getString("textPhone")
            val textLocal = it.arguments?.getString("textLocal")
            val textMessage = it.arguments?.getString("textMessage")
            SuccessScreen(navHostController, textName, textPhone, textLocal, textMessage)
        }
        composable(route = ScreenDACS3.Login.route) {
            LoginScreen(navHostController)
        }
        composable(route = ScreenDACS3.Signup.route) {
            SignupScreen(navHostController)
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
//        NavHostAppDACS3()
    }
}