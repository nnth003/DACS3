package com.example.doancoso3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.doancoso3.ui.navigation.NavHostAppDACS3
import com.example.doancoso3.ui.theme.DoAnCoSo3Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoAnCoSo3Theme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHostAppDACS3(navController)
//                    Navigation(navHostController = navController)
//                    Home()
//                    CourseScreen()
//                    val viewModel: CourseViewModel = viewModel()
//                    CourseDetail(viewModel = viewModel)
//                    CourseUpdate()

//                    val navController = rememberNavController()
//                    NavHost(navController, startDestination = "list_screen") {
////                        composable("input_screen") { InputScreen(navController) }
//                        composable("list_screen") { ListScreen(navController) }
//                        composable("detail_screen/{itemId}") { backStackEntry ->
//                            val itemId = backStackEntry.arguments?.getString("itemId")
//                            itemId?.let { DetailScreen(navController, it) }
//                        }
//                        composable("edit_screen/{itemId}") { backStackEntry ->
//                            val itemId = backStackEntry.arguments?.getString("itemId")
//                            itemId?.let { EditScreen(navController, it) }
//                        }
//                    }
//                    val viewModelDACS3: ViewModelDACS3 = viewModel()
//                    ProductListScreen(viewModelDACS3)
//                    SanPhamListScreen()
                }
            }

        }
    }
}




//
//fun addCourse(course: Course, onSuccess: () -> Unit) {
//    val db = Firebase.firestore
//    db.collection("Course")
//        .add(course)
//        .addOnSuccessListener { documentReference ->
//            course.courseID = documentReference.id
//            Log.d("Firestore", "DocumentSnapshot added with ID: ${documentReference.id}")
//            onSuccess()
//        }
//        .addOnFailureListener { e ->
//            Log.w("Firestore", "Error adding document", e)
//        }
//}
//
////fun getCourses(onCoursesLoaded: (List<Course>) -> Unit) {
////    val db = FirebaseFirestore.getInstance()
////    db.collection("Course")
////        .get()
////        .addOnSuccessListener { result ->
////            val courses = result.map { document ->
////                document.toObject(Course::class.java).apply {
////                    courseID = document.id
////                }
////            }
////            onCoursesLoaded(courses)
////        }
////        .addOnFailureListener { exception ->
////            Log.w("Firestore", "Error getting documents.", exception)
////        }
////}
//fun getCourses(onCoursesLoaded: (List<Course>) -> Unit) {
//    val db = FirebaseFirestore.getInstance()
//    db.collection("Course")
//        .get()
//        .addOnSuccessListener { result ->
//            for (document in result) {
//                Log.d(TAG, "${document.id} => ${document.data}")
//            }
//        }
//        .addOnFailureListener { exception ->
//            Log.w(TAG, "Error getting documents.", exception)
//        }
//}
//
//fun updateCourse(course: Course, onSuccess: () -> Unit) {
//    val db = FirebaseFirestore.getInstance()
//    db.collection("Course").document(course.courseID)
//        .set(course)
//        .addOnSuccessListener {
//            Log.d("Firestore", "DocumentSnapshot successfully updated!")
//            onSuccess()
//        }
//        .addOnFailureListener { e ->
//            Log.w("Firestore", "Error updating document", e)
//        }
//}
//
//fun deleteCourse(courseID: String, onSuccess: () -> Unit) {
//    val db = FirebaseFirestore.getInstance()
//    db.collection("Course").document(courseID)
//        .delete()
//        .addOnSuccessListener {
//            Log.d("Firestore", "DocumentSnapshot successfully deleted!")
//            onSuccess()
//        }
//        .addOnFailureListener { e ->
//            Log.w("Firestore", "Error deleting document", e)
//        }
//}

//@Composable
//fun FirebaseImage() {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//
//        AsyncImage(
//            model = "https://doancoso3-9cfb5.appspot.com/img/acer.jpg",
//            contentDescription = "Translated description of what the image contains"
//        )
//    }
//}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Main() {
    DoAnCoSo3Theme {
//        Home()
    }
}

