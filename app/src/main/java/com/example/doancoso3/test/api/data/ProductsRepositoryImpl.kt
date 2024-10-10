//package com.example.doancoso3.test.api.data
//
//import com.example.doancoso3.ui.api.data.model.Product
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//import okio.IOException
//import retrofit2.HttpException
//
//class ProductsRepositoryImpl(
//    private val api: com.example.doancoso3.test.api.data.Api
//): com.example.doancoso3.test.api.data.ProductsRepository {
//
//    override suspend fun getProductsList(): Flow<com.example.doancoso3.test.api.data.Result<List<Product>>> {
//        return flow {
//            val productsFromApi = try {
//                api.getProductsList()
//
//            } catch (e: IOException) {
//                e.printStackTrace()
////                emit(Result.Error(message = "Error loading products"))
//                return@flow
//            } catch (e: HttpException) {
//                e.printStackTrace()
////                emit(Result.Error(message = "Error loading products"))
//                return@flow
//            }  catch (e: Exception) {
//                e.printStackTrace()
////                emit(Result.Error(message = "Error loading products"))
//                return@flow
//            }
//
////            emit(Result.Success(productsFromApi.products))
//        }
//
//    }
//
//}