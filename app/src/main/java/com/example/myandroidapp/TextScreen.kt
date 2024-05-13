package com.example.myandroidapp
//import androidx.annotation.StringRes
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.stringResource
//import androidx.navigation.NavHostController
//import androidx.navigation.NavType
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.currentBackStackEntryAsState
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.navArgument
//import com.example.myandroidapp.ui.DataA3
//import com.example.myandroidapp.ui.DeviceList
//import com.example.myandroidapp.ui.t4
//
//enum class TextScreen(@StringRes val title: Int) {
//    Start(title = R.string.app_name), A3(title = R.string.a3), A4(title = R.string.a4),
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TextAppBar(
//    currency: CloudScreen,
//    canNavigateBack: Boolean,
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
//            if (canNavigateBack) {
//                IconButton(onClick = navigateUp) {
//                    Icon(
//                        imageVector = Icons.Filled.ArrowBack,
//                        contentDescription = stringResource(R.string.back_button)
//                    )
//                }
//            }
//        }
//    )
//}
//
//@Composable
//fun TextApp(
//    navController: NavHostController = rememberNavController(),
//) {
//    val backStackEntry by navController.currentBackStackEntryAsState()
//
//    val route = backStackEntry?.destination?.route
//    val routeWithoutParams = route?.substringBefore("/") ?: CloudScreen.A3.name
//    val currencyScreen = CloudScreen.valueOf(routeWithoutParams)
//
////    val currencyScreen = TextScreen.valueOf(
////        backStackEntry?.destination?.route ?: TextScreen.A3.name
////    )
//
//    Scaffold(
//        topBar = {
//            TextAppBar(
//                currency = currencyScreen,
//                canNavigateBack = navController.previousBackStackEntry != null,
//                navigateUp = { navController.navigateUp() }
//            )
//        }
//    ) { inner ->
////        val navController = rememberNavController()
//        NavHost(
//            navController = navController,
//            startDestination = CloudScreen.A3.name,
//            modifier = Modifier.padding(inner)
//        ) {
//            composable(route = CloudScreen.A3.name) {
////                t3(
////                    onNextButtonClicked = { option -> navController.navigate("${TextScreen.A4.name}/${option}") },
////                    onPreviousButtonClicked = { },
////                    modifier = Modifier
////                        .fillMaxSize()
////                        .padding(
////                            inner
////                        ),
////                    options = list,
////                    onSelected = {}
////
////                )
//                DeviceList(
//                    goList = DataA3().load(),
//                    onSelected = { option -> navController.navigate("${CloudScreen.A4.name}/${option}")},
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(
//                            inner
//                        ),
//                )
//            }
//            composable(
//                route = "${CloudScreen.A4.name}/{op}", arguments = listOf(
//                    navArgument("op") {
//                        type = NavType.StringType
//                    },
//                )
//            ) {
//                val option = it.arguments?.getString("op")
//                t4(
//                    onNextButtonClicked = { },
//                    onPreviousButtonClicked = { navController.navigate(CloudScreen.A3.name) },
//                    option!!,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(
//                            inner
//                        )
//                )
//            }
//        }
//    }
//
//}