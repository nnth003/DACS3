//package com.example.doancoso3.test.testfirebase
//
//import android.app.Activity
//import android.content.Context
//import android.os.Bundle
//import android.text.TextUtils
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Button
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.material3.TopAppBar
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.doancoso3.ui.testfirebase.ui.theme.DoAnCoSo3Theme
//import com.google.firebase.firestore.CollectionReference
//import com.google.firebase.firestore.FirebaseFirestore
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CourseUpdate(){
//    val context = LocalContext.current
//    val intent = (context as Activity).intent
//    val courseName = intent.getStringExtra("courseName") ?: ""
//    val courseDuration = intent.getStringExtra("courseDuration") ?: ""
//    val courseDescription = intent.getStringExtra("courseDescription") ?: ""
//    val courseID = intent.getStringExtra("courseID") ?: ""
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(
//                        text = "GFG",
//                        modifier = Modifier.fillMaxWidth(),
//                        textAlign = TextAlign.Center,
//                        color = Color.White
//                    )
//                }
//            )
//        }
//    ) { innerPadding ->
//        Text(
//            text = "Cap nhat du lieu",
//            modifier = Modifier.padding(innerPadding),
//        )
//        firebaseUI(
//            context = context,
//            name = courseName,
//            duration = courseDuration,
//            description = courseDescription,
//            courseID = courseID
//        )
//    }
//}
//@Composable
//private fun firebaseUI(
//    context: Context,
//    name: String?,
//    duration: String?,
//    description: String?,
//    courseID: String?
//) {
//    val courseID = remember {
//        mutableStateOf("")
//    }
//    val courseName = remember {
//        mutableStateOf("")
//    }
//    val courseDuration = remember {
//        mutableStateOf("")
//    }
//    val courseDescription = remember {
//        mutableStateOf("")
//    }
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight()
//            .background(Color.White),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        TextField(
//            value = courseName.value.toString(),
//            onValueChange = { courseName.value = it },
//            placeholder = { Text(text = "Enter your course name") },
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth(),
//            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
//            singleLine = true
//        )
//        Spacer(modifier = Modifier.height(10.dp))
//        TextField(
//            value = courseDuration.value.toString(),
//            onValueChange = { courseDuration.value = it },
//            placeholder = { Text(text = "Enter your course Duration") },
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth(),
//            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
//            singleLine = true
//        )
//        Spacer(modifier = Modifier.height(10.dp))
//        TextField(
//            value = courseDescription.value.toString(),
//            onValueChange = { courseDescription.value = it },
//            placeholder = { Text(text = "Enter your course Description") },
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth(),
//            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
//            singleLine = true
//        )
//        Spacer(modifier = Modifier.height(10.dp))
//        Button(
//            onClick = {
//                if (TextUtils.isEmpty(courseName.value.toString())) {
//                    Toast.makeText(context, "Please enter course name", Toast.LENGTH_SHORT)
//                        .show()
//                } else if (TextUtils.isEmpty(courseDuration.value.toString())) {
//                    Toast.makeText(context, "Please enter course duration", Toast.LENGTH_SHORT)
//                        .show()
//                } else if (TextUtils.isEmpty(courseDescription.value.toString())) {
//                    Toast.makeText(
//                        context,
//                        "Please enter course description",
//                        Toast.LENGTH_SHORT
//                    )
//                        .show()
//                } else {
//                    updateDataToFirebase(
//                        courseID.value,
//                        courseName.value,
//                        courseDuration.value,
//                        courseDescription.value,
//                        context
//                    )
//                }
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//        ) {
//            Text(text = "Update data", modifier = Modifier.padding(8.dp))
//        }
//        Spacer(modifier = Modifier.height(10.dp))
//
//    }
//}
//
//private fun updateDataToFirebase(
//    courseID: String,
//    name: String,
//    duration: String,
//    description: String,
//    context: Context
//) {
//    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
////        val dbCourse: CollectionReference = db.collection("Course")
//
//    val updateCourse = Course(courseID, name, duration, description)
//    db.collection("Course").document(courseID.toString()).set(updateCourse)
//        .addOnSuccessListener {
//            Toast.makeText(
//                context,
//                "Your Course has been update  to Firebase Firestore",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//        .addOnFailureListener { e ->
//            Toast.makeText(context, "Fail to update Course \n$e", Toast.LENGTH_SHORT).show()
//        }
//}
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview2() {
//    DoAnCoSo3Theme {
//    }
//}