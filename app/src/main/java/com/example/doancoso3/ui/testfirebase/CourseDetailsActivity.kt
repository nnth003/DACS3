package com.example.doancoso3.ui.testfirebase

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doancoso3.ui.testfirebase.ui.theme.DoAnCoSo3Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseDetail(viewModel: CourseViewModel){
    val context = LocalContext.current
    val courseList = remember {viewModel.courseList}
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "GFG",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            )
        }
    ) { innerPadding ->
        Text(text = "Cap nhat du lieu", modifier = Modifier.padding(innerPadding))
        //mutableStateListOf
//        val courseList = remember {
//            mutableStateListOf<Course?>()
//        }
//        val db: FirebaseFirestore = FirebaseFirestore.getInstance()
////        val db = Firebase.firestore
//        db.collection("Course")
//            .get()
//            .addOnSuccessListener { queryDocumentSnapshots ->
//                if (!queryDocumentSnapshots.isEmpty) {
//                    val list = queryDocumentSnapshots.documents
//                    for (d in list) {
//                        val c: Course? = d.toObject(Course::class.java)
//                        c?.courseID = d.id
//                        Log.e("TAG", "Course id is: " + c!!.courseID)
//                        courseList.add(c)
//                    }
//                } else {
//                    Toast.makeText(
//                        context,
//                        "No data found in Database",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//
//            }
        viewModel.fetchCourses()
        firebaseUI(LocalContext.current, courseList.value)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun firebaseUI(context: Context, courseList: List<Course>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            itemsIndexed(courseList) { index, item ->
                Card(
                    onClick = {
//                        val i = Intent(context, UpdateCourse::class.java)
//                        i.putExtra("courseName", item?.courseName)
//                        i.putExtra("courseDuration", item?.courseDuration)
//                        i.putExtra("courseDescription", item?.courseDescription)
//                        i.putExtra("courseID", item?.courseID)
//                        context.startActivity(i)
                    },
                    modifier = Modifier.padding(8.dp),
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {
                        Spacer(modifier = Modifier.width(5.dp))
                        courseList[index]?.courseName?.let {
                            Text(
                                text = it,
                                modifier = Modifier.padding(4.dp),
                                color = Color.Green,
                                textAlign = TextAlign.Center,
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        courseList[index]?.courseDuration?.let {
                            Text(
                                text = it,
                                modifier = Modifier.padding(4.dp),
                                color = Color.Green,
                                textAlign = TextAlign.Center,
                                style = TextStyle(
                                    fontSize = 15.sp,
//                                        fontWeight = FontWeight.Bold
                                )
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        courseList[index]?.courseDescription?.let {
                            Text(
                                text = it,
                                modifier = Modifier.padding(4.dp),
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                style = TextStyle(
                                    fontSize = 15.sp,
//                                        fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DoAnCoSo3Theme {
//        CourseDetail()
    }
}