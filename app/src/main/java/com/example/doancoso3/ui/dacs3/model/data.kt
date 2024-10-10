package com.example.doancoso3.ui.dacs3.model

data class users(
    val iduser: Int,
    val user: String,
    val pass: String,
    val email: String,
    val ten: String,
    val sdt: String,
    val diachi: String,
)

data class danhmuc(
    val IDDM: Int,
    val TenDanhMuc: String,
    val anh: String
)

data class sanpham(
    val ID: Int,
    val TenSanPham: String,
    val Gia: Int,
    val GiaBanDau: Int,
    val SoLuong: Int,
    val IDDanhMuc: Int,
    val image: String,
    val mota: String,
    val soluotdanhgia: Int,
    val thongtinsp: String
)

data class sanphamById(
    val ID: Int,
    val TenSanPham: String,
    val Gia: Int,
    val GiaBanDau: Int,
    val SoLuong: Int,
    val IDDanhMuc: Int,
    val image: String,
    val soluotdanhgia: Int,
    val thongtinsp: String
)

data class donhang(
    val ID: Int,
    val iduser: Int,
    val diachi: String,
    val sdt: Int,
    val trangthai: String,
    val tonggia: Int,
    val ngay: String
)

data class chitietdonhang(
    val ID: Int,
    val iddonhang: Int,
    val idsp: Int,
    val tensanpham: String,
    val gia: Int,
    val soluong: Int,
    val anh: String
)

data class giohang(
    val id: Int,
    val iduser: Int,
    val idsanpham: Int,
    val tensanpham: String,
    val anh: String,
    val gia: Int,
    val soluong: Int
)

data class binhluan(
    val idbl: Int,
    val idUser: Int,
    val idSanPham: Int,
    val ngay: String,
    val soSao: String,
    val noiDung: String
)

data class tonggia(
    val tongtien: Int
)
data class auth(
    val user: String,
    val pass: String
)

