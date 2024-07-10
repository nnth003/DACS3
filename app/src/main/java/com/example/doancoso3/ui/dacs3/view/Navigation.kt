package com.example.doancoso3.ui.dacs3.view

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.doancoso3.ui.dacs3.model.ViewModelDA


sealed class RouteScreen(val route: String) {
    object Home : RouteScreen("home_screen")
    object ProductList : RouteScreen("list_screen")
    object ProductDetail : RouteScreen("detail_screen")
    object Cart : RouteScreen("cart_screen")
    object CheckOut : RouteScreen("checkout_screen")
    object Success : RouteScreen("success_screen")
    object Login : RouteScreen("login_screen")
    object Signup : RouteScreen("signup_screen")
    object Profile : RouteScreen("profile_screen")
    object Search : RouteScreen("search_screen")
    object EditProfile : RouteScreen("edit_profile_screen")
    object Order : RouteScreen("order_screen")
    object OrderDetail : RouteScreen("order_detail_screen")
}

@Composable
fun NavigationDA3(
    navHostController: NavHostController,
) {
    val context = LocalContext.current

    val viewModelDA: ViewModelDA = viewModel()

    NavHost(
        navController = navHostController,
        startDestination = RouteScreen.Login.route,
    ) {

        //TrangChu.kt
        composable(route = RouteScreen.Home.route) {
            Home(viewModel = viewModelDA, navHostController = navHostController)
//            viewModelDA.getSanPham()
//            viewModelDA.getDanhMuc()
        }

        //DanhSach.kt
        composable(
            route = "${RouteScreen.ProductList.route}/{i}",
            arguments = listOf(
                navArgument("i") {
                    type = NavType.IntType
                }
            )
        ) {
            val iddm = it.arguments?.getInt("i")
            if (iddm != null) {
                ProductList(navController = navHostController, viewModelDA = viewModelDA, id = iddm)
//                viewModelDA.getSanPhamByIdDanhMuc(iddm)
            }
        }

        composable(
            route = "${RouteScreen.ProductDetail.route}/{i}",
            arguments = listOf(
                navArgument("i") {
                    type = NavType.IntType
                }
            )
        ) {
            val id = it.arguments?.getInt("i")
            if (id != null) {
                ProductDetail(viewModelDA = viewModelDA, navController = navHostController, id = id)
//                viewModelDA.getSanPhamByIdSanPham(id)
            } else {
                Toast.makeText(context, "Error ID", Toast.LENGTH_SHORT).show()

            }

        }
        composable(
            route = "${RouteScreen.Cart.route}/{id}",
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) {
            val id = it.arguments?.getInt("id")
            if (id != null) {
                CartScreen(
                    navHostController = navHostController,
                    viewModelDA = viewModelDA,
                    iduser = id
                )
//            viewModelDA.getGioHang()
            } else {
                Toast.makeText(context, "Error ID User", Toast.LENGTH_SHORT).show()
            }
        }
        composable(route = RouteScreen.Profile.route) {
            Profile(viewModelDA = viewModelDA, navHostController = navHostController)
        }

        composable(
            route = "${RouteScreen.CheckOut.route}/{totalGia}",
            arguments = listOf(
                navArgument("totalGia") {
                    type = NavType.IntType
                }
            )
        ) {
            val total = it.arguments?.getInt("totalGia")
            if (total != null) {
                PaymentScreen(
                    viewModelDA = viewModelDA,
                    navController = navHostController,
                    total = total
                )
            }
        }
        composable(
            route = "${RouteScreen.Success.route}/{textName}/{textPhone}/{textLocal}/{totalPrice}",
            arguments = listOf(
                navArgument("textName") { type = NavType.StringType },
                navArgument("textPhone") { type = NavType.StringType },
                navArgument("textLocal") { type = NavType.StringType },
                navArgument("totalPrice") { type = NavType.IntType },
            )
        ) {
            val textName = it.arguments?.getString("textName")
            val textPhone = it.arguments?.getString("textPhone")
            val textLocal = it.arguments?.getString("textLocal")
            val totalPrice = it.arguments?.getInt("totalPrice")
            End(navHostController, textName, textPhone, textLocal, totalPrice)
        }
        composable(route = RouteScreen.Login.route) {
            LoginScreen(navHostController, viewModelDA)
        }
        composable(route = RouteScreen.Signup.route) {
            SignupScreen(navController = navHostController, viewModelDA = viewModelDA)
        }
        composable(route = RouteScreen.Search.route) {
            Search(viewModelDA = viewModelDA, navHostController = navHostController)
        }
        composable(route = RouteScreen.EditProfile.route) {
            EditProfile(viewModelDA = viewModelDA, navHostController = navHostController)
        }
        composable(
            route = "${RouteScreen.Order.route}/{iduser}",
            arguments = listOf(
                navArgument("iduser") { type = NavType.IntType }
            )
        ) {
            val id = it.arguments?.getInt("iduser")
            Order(navHostController = navHostController, viewModelDA = viewModelDA, id)
        }
        composable(
            route = "${RouteScreen.OrderDetail.route}/{iddonhang}/{trangthai}/{ngay}/{tonggia}",
            arguments = listOf(
                navArgument("iddonhang") { type = NavType.IntType },
                navArgument("trangthai") { type = NavType.StringType },
                navArgument("ngay") { type = NavType.StringType },
                navArgument("tonggia") { type = NavType.StringType }
            )
        ) {
            val iddonhang = it.arguments?.getInt("iddonhang")
            val trangthai = it.arguments?.getString("trangthai")
            val ngay = it.arguments?.getString("ngay")
            val tonggia = it.arguments?.getString("tonggia")
            OrderDetail(
                navHostController = navHostController,
                viewModelDA = viewModelDA,
                iddonhang = iddonhang,
                trangthai = trangthai,
                ngay = ngay,
                tonggia = tonggia
            )
        }
    }
}
//}