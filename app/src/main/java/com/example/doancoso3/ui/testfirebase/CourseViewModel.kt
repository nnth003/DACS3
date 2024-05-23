package com.example.doancoso3.ui.testfirebase

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class CourseViewModel : ViewModel() {
    private val _courseList = mutableStateOf<List<Course>>(emptyList())
    val courseList: State<List<Course>> = _courseList

    fun fetchCourses() {
        val db = FirebaseFirestore.getInstance()
        db.collection("Course")
            .get()
            .addOnSuccessListener { queryDocumentSnapshots ->
                if (!queryDocumentSnapshots.isEmpty) {
                    val list = queryDocumentSnapshots.documents
                    val courses = mutableListOf<Course>()
                    for (d in list) {
                        val c: Course? = d.toObject(Course::class.java)
                        c?.courseID = d.id
                        Log.e("TAG", "Course id is: " + c!!.courseID)
                        courses.add(c)
                    }
                    _courseList.value = courses
                } else {
                    // Handle case where no data found
                }
            }
    }
}
