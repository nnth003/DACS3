package com.example.doancoso3.ui.api.data3

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

data class UserItem(
    val age: String,
    val city: String,
    val id: String,
    val name: String
)

interface APIService1 {
    @GET("api_fetch_all.php")
    suspend fun getUsers(): List<UserItem>

    @GET("api_fetch_single.php?{id}")
    suspend fun getUserById(@Path("id") id: Long): UserItem

    @POST("api_create_user.php")
    suspend fun createUser(
        @Body user: UserItem
    ): Response<Unit>

    @PUT("api_update_user.php?{id}")
    suspend fun updateUser(
        @Path("id") id: Long,
        @Body user: UserItem
    ): Response<Unit>

    @DELETE("api_delete_user.php?{id}")
    suspend fun deleteUser(@Path("id") id: Long): Response<Unit>

    companion object {
        var apiService1: APIService1? = null
        fun getInstance(): APIService1 {
            if (apiService1 == null) {
                apiService1 = Retrofit.Builder()
                    .baseUrl("https://apidacs3.000webhostapp.com/UserApi/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(APIService1::class.java)
            }
            return apiService1!!
        }
    }
}
