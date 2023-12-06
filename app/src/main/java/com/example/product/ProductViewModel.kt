package com.example.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.product.data.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.product.remote.ProductInterface
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieInterface: ProductInterface) : ViewModel() {


    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    init {
        viewModelScope.launch {
            try {
                _products.value = ProductInterface.getProducts()
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

}