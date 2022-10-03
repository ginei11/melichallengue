package com.meli.shop.productdetail.impl.presentation.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meli.shop.domains.productdetail.api.models.ProductDetailUIStates
import com.meli.shop.domains.productdetail.api.usecases.GetProductDetailUC
import com.meli.shop.productdetail.impl.ProductDetailFeatureNavGraphImpl.Companion.ARG_PRODUCT_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    getProductDetailUC: GetProductDetailUC,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val productId = savedStateHandle.get<String>(ARG_PRODUCT_ID).orEmpty()

    private val _state = MutableStateFlow<ProductDetailUIStates>(ProductDetailUIStates.Loading)
    val state: StateFlow<ProductDetailUIStates> = _state

    init {
        viewModelScope.launch {
            getProductDetailUC(productId).collect {
                _state.value = it
            }
        }
    }
}
