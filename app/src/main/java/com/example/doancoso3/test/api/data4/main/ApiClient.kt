//package com.example.doancoso3.ui.api.data4.Main
//
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//object ApiClient {
//    private const val BASE_URL = "https://apidacs3.000webhostapp.com/UserApi/"
//
//    val apiService: ApiService by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiService::class.java)
//    }
//}