package com.example.product.remote

import com.example.product.data.Product
import com.example.product.data.ProductsResponse
import com.example.product.data.productdetails.ProductDetails
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductInterface {

    @GET("products")
    suspend fun getProducts(): List<Product>

    companion object {
        fun getProducts(): List<Product>? {
            return listOf(
                Product(
                    id = 1,
                    title = "Product 1",
                    description = "Description for Product 1",
                    price = 99.99,
                    discountPercentage = 10.0,
                    rating = 4.5,
                    stock = 50,
                    brand = "Brand A",
                    category = "Electronics",
                    thumbnail = "https://example.com/product1-thumbnail.jpg",
                    images = "https://example.com/product1-image1.jpg",
                // Add more products as needed
            ),)
        }
    }

    @GET("products")
    suspend fun getProductDetails(
        @Query("i") id: String,
        @Query("apiKey") apiKey: String
    ): Response<ProductDetails>
}