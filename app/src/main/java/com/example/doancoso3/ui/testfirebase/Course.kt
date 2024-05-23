package com.example.doancoso3.ui.testfirebase

data class Course (
    var courseID: String,
    val courseName: String,
    val courseDuration: String,
    val courseDescription: String,
){
    constructor() : this("", "", "", "")
}