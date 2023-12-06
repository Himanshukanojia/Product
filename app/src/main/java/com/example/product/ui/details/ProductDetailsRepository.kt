package com.example.product.ui.details

import android.media.Session2Command
import android.net.http.UrlRequest
import com.example.product.data.productdetails.ProductDetails
import com.example.product.remote.ProductInterface
import com.example.product.utils.Constants

class ProductDetailsRepository (private val movieInterface: ProductInterface) {


    suspend fun getMovieDetails(id: String): Result<ProductDetails> {
        return try {
            val response = movieInterface.getProductDetails(id, Constants.BASE_URL)
            if (response.isSuccessful) {

                Result(UrlRequest.Status.SUCCESS, response.body(), null)

            } else {
                Result(Status.ERROR, null, null)
            }


        } catch (e: Exception) {
            Session2Command.Result(UrlRequest.Status.ERROR, null, null)
        }


    }

}