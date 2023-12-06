package com.example.product.data

data class ProductsResponse(
    val Response: String,
    val products: List<Product>,
    val totalResults: String
)
