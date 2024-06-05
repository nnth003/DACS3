package com.example.doancoso3.ui.data

import com.example.doancoso3.R

class Data() {
    fun loadAnhDanhMuc(): List<UrlAnh> {
        return listOf<UrlAnh>(
            UrlAnh("https://firebasestorage.googleapis.com/v0/b/doancoso3-9cfb5.appspot.com/o/img%2Flaptop_dm.jpg?alt=media&token=ee1f85b4-491f-4bed-88b8-1e378346c857"),
            UrlAnh("https://firebasestorage.googleapis.com/v0/b/doancoso3-9cfb5.appspot.com/o/img%2Fip15.jpg?alt=media&token=f91ab39e-d78f-4c7f-a5c3-e0c1df30ced9"),
//            UrlAnh(""),
//            UrlAnh(""),
//            UrlAnh(""),
//            UrlAnh(""),
//            UrlAnh(""),
//            UrlAnh(""),
//            UrlAnh(""),
        )
    }

    fun loadAnhDanhSach(): List<ProductList> {
        return listOf<ProductList>(
            ProductList(
                0,
                "Macbook",
                "https://firebasestorage.googleapis.com/v0/b/doancoso3-9cfb5.appspot.com/o/img%2Fmac.jpg?alt=media&token=e8b7e021-60f4-42f8-a62e-651009753b98",
                "20",
                "1"
            ),
            ProductList(
                1,
                "LapTop Danh Muc",
                "https://firebasestorage.googleapis.com/v0/b/doancoso3-9cfb5.appspot.com/o/img%2Flaptop_dm.jpg?alt=media&token=ee1f85b4-491f-4bed-88b8-1e378346c857",
                "30",
                "1"
            ),
//            UrlAnhDS("Ipad Air 5","https://firebasestorage.googleapis.com/v0/b/doancoso3-9cfb5.appspot.com/o/img%2Fipadair5.jpg?alt=media&token=ea2d2a31-b257-4233-9921-7fe465755405"),
//            UrlAnhDS("Iphone 14","https://firebasestorage.googleapis.com/v0/b/doancoso3-9cfb5.appspot.com/o/img%2Fip14.jpg?alt=media&token=19e957db-e8b4-431e-bcfd-aa82ad742df1"),
//            UrlAnhDS("Iphone 14","https://firebasestorage.googleapis.com/v0/b/doancoso3-9cfb5.appspot.com/o/img%2Fip14.jpg?alt=media&token=19e957db-e8b4-431e-bcfd-aa82ad742df1"),
//            UrlAnhDS("LapTop HP","https://firebasestorage.googleapis.com/v0/b/doancoso3-9cfb5.appspot.com/o/img%2Fhp.jpg?alt=media&token=18865060-8a57-421c-9a96-dfa191e5b142"),
//            UrlAnhDS("LapTop Dell","https://firebasestorage.googleapis.com/v0/b/doancoso3-9cfb5.appspot.com/o/img%2Fdell.jpg?alt=media&token=309f3be2-7b28-4540-8859-dd4ecd145fa8"),
//            UrlAnhDS("LapTop Asus 1","https://firebasestorage.googleapis.com/v0/b/doancoso3-9cfb5.appspot.com/o/img%2Fausus2.jpg?alt=media&token=49f7dfd8-6a37-4487-8bd8-8e07b9818109"),
//            UrlAnhDS("LapTop Asus 2","https://firebasestorage.googleapis.com/v0/b/doancoso3-9cfb5.appspot.com/o/img%2Fausus1.jpg?alt=media&token=c49d456d-8f65-461d-8fbc-ea51abe64243"),
//            UrlAnhDS("LapTop Asus 3","https://firebasestorage.googleapis.com/v0/b/doancoso3-9cfb5.appspot.com/o/img%2Fausus.jpg?alt=media&token=61d520a1-518a-457a-aa10-cc0f6498e553"),
//            UrlAnhDS("Laptop Acer","https://firebasestorage.googleapis.com/v0/b/doancoso3-9cfb5.appspot.com/o/img%2Facer.jpg?alt=media&token=7ef12993-b9d7-4df9-82c4-56a052be6a61"),
//            UrlAnhDS("Laptop Acer","https://firebasestorage.googleapis.com/v0/b/doancoso3-9cfb5.appspot.com/o/img%2Facer.jpg?alt=media&token=7ef12993-b9d7-4df9-82c4-56a052be6a61"),
////            UrlAnhDS(""),
        )
    }

    fun load(): List<DuLieu> {
        return listOf<DuLieu>(
            DuLieu(R.drawable.image1),
            DuLieu(R.drawable.image1),
        )
    }
}