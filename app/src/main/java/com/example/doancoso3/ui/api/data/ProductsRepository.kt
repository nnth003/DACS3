package com.example.doancoso3.ui.api.data

import com.example.doancoso3.ui.api.data.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProductsList(): Flow<Result<List<Product>>>
}