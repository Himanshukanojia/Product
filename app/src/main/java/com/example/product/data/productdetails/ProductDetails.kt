package com.example.product.data.productdetails

data class ProductDetails(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val rating: Double,
    val discountPercentage : Double,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: String
)
