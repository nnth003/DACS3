//package com.example.doancoso3.test.testfirebase
//
//import android.content.Context
//import android.text.TextUtils
//import android.widget.Toast
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.Button
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.google.firebase.firestore.CollectionReference
//import com.google.firebase.firestore.FirebaseFirestore
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Home(){
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color.Green
//                ),
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
//        Text(modifier = Modifier.padding(innerPadding), text = "Them Du Lieu")
//        FirebaseUI(LocalContext.current)
//    }
//}
//
//@Composable
//fun FirebaseUI(context: Context) {
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
//            .fillMaxHeight()
//            .fillMaxWidth()
//            .background(Color.White),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        TextField(
//            value = courseName.value,
//            onValueChange = { courseName.value = it },
//            placeholder = { Text(text = "Enter your course name") },
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth(),
//            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
//            singleLine = true,
//        )
//        Spacer(modifier = Modifier.height(10.dp))
//        TextField(
//            value = courseDuration.value,
//            onValueChange = { courseDuration.value = it },
//            placeholder = { Text(text = "Enter your course duration") },
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth(),
//            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
//            singleLine = true
//        )
//        Spacer(modifier = Modifier.height(10.dp))
//        TextField(
//            value = courseDescription.value,
//            onValueChange = { courseDescription.value = it },
//            placeholder = { Text(text = "Enter your course description") },
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
//                    Toast.makeText(context, "Please enter course name", Toast.LENGTH_SHORT).show()
//                } else if (TextUtils.isEmpty(courseDuration.value.toString())) {
//                    Toast.makeText(context, "Please enter course duration", Toast.LENGTH_SHORT)
//                        .show()
//                } else if (TextUtils.isEmpty(courseDescription.value.toString())) {
//                    Toast.makeText(context, "Please enter course description", Toast.LENGTH_SHORT)
//                        .show()
//                } else {
//                    addDataToFirebase(
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
//            Text(text = "Add data", modifier = Modifier.padding(8.dp))
//        }
//    }
//}
//
//fun addDataToFirebase(
//    courseId: String,
//    courseName: String,
//    courseDuration: String,
//    courseDescription: String,
//    context: Context
//) {
//    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
//    val dbCourse: CollectionReference = db.collection("Course")
//
//    val course = Course(courseId, courseName, courseDuration, courseDescription)
//    dbCourse
//        .add(course).addOnSuccessListener {
//            Toast.makeText(
//                context,
//                "Your Course has been added to Firebase Firestore",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//        .addOnFailureListener{e ->
//            Toast.makeText(context, "Fil to add Course \n$e", Toast.LENGTH_SHORT).show()
//        }
//}