//package com.example.doancoso3.test.api.data
//
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//object RetrofitInstance {
//
//    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
//        level = HttpLoggingInterceptor.Level.BODY
//    }
//
//    private val client: OkHttpClient = OkHttpClient.Builder()
//        .addInterceptor(interceptor)
//        .build()
//
//    val api: com.example.doancoso3.test.api.data.Api = Retrofit.Builder()
//        .addConverterFactory(GsonConverterFactory.create())
//        .baseUrl(com.example.doancoso3.test.api.data.Api.BASE_URL)
//        .client(client)
//        .build()
//        .create(com.example.doancoso3.test.api.data.Api::class.java)
//
//}