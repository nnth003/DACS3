//package com.example.doancoso3.test.api.data4.main
//
//import com.google.gson.GsonBuilder
//import okhttp3.OkHttpClient
//import okhttp3.Protocol
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.http.DELETE
//import retrofit2.http.GET
//import retrofit2.http.POST
//import retrofit2.http.PUT
//import retrofit2.http.Query
//import java.util.concurrent.TimeUnit
//
//interface ApiService {
//    @GET("get_items.php")
//    suspend fun getItems(): List<Item>
//
//    @GET("get_item.php")
//    suspend fun getItem(@Query("id") id: Int): List<Item>
//
//    @POST("add_items.php")
//    suspend fun addItem(
//        @Query("name") name: String,
//        @Query("description") description: String
//    ): List<Item>
//
//
//    @POST("update_items.php")
//    suspend fun updateItem(
//        @Query("id") id: Int,
//        @Query("name") name: String,
//        @Query("description") description: String
//    ): List<Item>
//
//    @POST("delete_items.php")
//    suspend fun deleteItem(@Query("id") id: Int): List<Item>
//    companion object {
//        private var apiService4: ApiService? = null
//        fun getInstance(): ApiService {
//            if (apiService4 == null) {
////                val client = OkHttpClient.Builder()
////                    .protocols(listOf(Protocol.HTTP_1_1))
////                    .connectTimeout(30, TimeUnit.SECONDS)
////                    .readTimeout(30, TimeUnit.SECONDS)
////                    .build()
//                apiService4 = Retrofit.Builder()
//                    .baseUrl("https://apidacs3.000webhostapp.com/UserApi/")
//                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
////                    .client(client)
//                    .build().create(ApiService::class.java)
//            }
//            return apiService4!!
//        }
//    }
//}