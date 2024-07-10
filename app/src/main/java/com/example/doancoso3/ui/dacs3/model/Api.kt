package com.example.doancoso3.ui.dacs3.model

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {
    @GET("auth.php")
    suspend fun auth(
        @Query("user") user: String,
        @Query("pass") pass: String,
    ): List<users>

    @POST("register.php")
    suspend fun register(
        @Query("user") user: String,
        @Query("email") email: String,
        @Query("pass") pass: String,
        @Query("ten") ten: String,
        @Query("sdt") sdt: String,
        @Query("diachi") diachi: String
    )

    @GET("get_danhmuc.php")
    suspend fun getDanhMuc(): List<danhmuc>

    @GET("get_sanpham.php")
    suspend fun getDanhSachSanPham(): List<sanpham>

    @GET("get_giohang.php")
    suspend fun getGioHang(
        @Query("id") id: Int
    ): List<giohang>

    @GET("get_tonggia.php")
    suspend fun getTongGia(
        @Query("id") id: Int
    ): List<tonggia>

    @POST("get_sanphamById.php")
    suspend fun getSanPhamByIdDanhMuc(
        @Query("id") id: Int,
    ): List<sanpham>

    @POST("get_sanphamByIdSanPham.php")
    suspend fun getSanPhamByIdSanPham(
        @Query("id") id: Int,
    ): List<sanpham>

    @POST("get_updatecart.php")
    suspend fun getUpadateCart(
        @Query("id") id: Int,
        @Query("iduser") iduser: Int,
        @Query("soluong") soluong: Int,
    ): List<giohang>

    // Chưa sửa
    @POST("updateUser.php")
    suspend fun updateUser(
        @Query("iduser") iduser: Int,
        @Query("user") user: String,
        @Query("email") email: String,
        @Query("pass") pass: String,
        @Query("ten") ten: String,
        @Query("sdt") sdt: String,
        @Query("diachi") diachi: String
    ): List<users>
    //
    @GET("get_donhang.php")
    suspend fun getdonhang(
        @Query("id") id: Int
    ): List<donhang>

    @GET("get_chitietdonhang.php")
    suspend fun getchitietdonhang(
        @Query("id") id: Int
    ): List<chitietdonhang>


    @POST("addtocart.php")
    suspend fun addToCart(
        @Query("iduser") iduser: Int,
        @Query("idsp") idsp: Int,
        @Query("tensanpham") tensanpham: String,
        @Query("anh") anh: String,
        @Query("gia") gia: Int,
        @Query("soluong") soluong: Int,
    ): List<giohang>

    @POST("deleteCart.php")
    suspend fun deleteCart(
        @Query("idsp") idsp: Int,
        @Query("iduser") iduser: Int,
    ): List<giohang>

    @POST("add_donhang.php")
    suspend fun add_donhang(
        @Query("iduser") iduser: Int,
        @Query("diachi") diachi: String,
        @Query("sdt") sdt: Int,
    )

    @GET("search.php")
    suspend fun searchProducts(
        @Query("searchTerm") searchTerm: String
    ): List<sanpham>

//    @GET("get_sanphamById.php")
//    suspend fun getSanPhamById(): List<sanpham>


    companion object {
        private var api: Api? = null

        private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        fun getInstance(): Api {
            if (api == null) {
                api = Retrofit.Builder()
                    .baseUrl("https://apidacs3.000webhostapp.com/UserApi/")
                    .addConverterFactory(
                        GsonConverterFactory.create(
                            GsonBuilder().setLenient().create()
                        )
                    )
                    .client(client)
                    .build().create(Api::class.java)
            }
            return api!!
        }
    }
}