//package com.example.doancoso3.test.api.data3
//
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.http.GET
//import retrofit2.http.POST
//import retrofit2.http.Query
//
//data class UserItem(
//    val age: String,
//    val city: String,
//    val id: Int,
//    val name: String
//)
//
//data class Item(
//    val id: Int,
//    val name: String,
//    val description: String,
//    val anh: String,
//)
//
//
//interface APIService1 {
//    @GET("get_items.php")
//    suspend fun getUsers(): List<Item>
//
//    @GET("get_item.php")
//    suspend fun getUserById(@Query("id") id: Int): List<Item>
//
//    @POST("add_items.php")
//    suspend fun addUser(
//        @Query("name") name: String,
//        @Query("description") description: String
//    ): List<Item>
//
//
//    @POST("update_items.php")
//    suspend fun updateUser(
//        @Query("id") id: Int,
//        @Query("name") name: String,
//        @Query("description") description: String
//    ): List<Item>
//
//    @POST("delete_items.php")
//    suspend fun deleteUser(
//        @Query("id") id: Int
//    ): List<Item>
//
//    companion object {
//        private var apiService1: APIService1? = null
//        fun getInstance(): APIService1 {
//            if (apiService1 == null) {
//                apiService1 = Retrofit.Builder()
//                    .baseUrl("https://apidacs3.000webhostapp.com/UserApi/")
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build().create(APIService1::class.java)
//            }
//            return apiService1!!
//        }
//    }
//}
