package com.example.doancoso3.ui.api.test1

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("api_fetch_all.php")
    suspend fun getUsers(): Response<List<UserItem>>
}


private val gson: Gson = GsonBuilder()
    .setLenient()
    .create()

private val logging = HttpLoggingInterceptor().apply {
    setLevel(HttpLoggingInterceptor.Level.BODY)
}

private val client = OkHttpClient.Builder()
    .addInterceptor(logging)
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl("http://dacs3.rf.gd/UserApi/")
    .addConverterFactory(GsonConverterFactory.create(gson))
//        .client(client)
    .build()

val apiService = retrofit.create(ApiService::class.java)
