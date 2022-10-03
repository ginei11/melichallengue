package com.meli.shop.domains.productdetail.api.models

import com.google.gson.annotations.SerializedName

data class AddressModel(
    @SerializedName("state") val stateName: AddressItem? = null,
    @SerializedName("city") val cityName: AddressItem? = null
)

data class AddressItem(
    @SerializedName("name") val name: String
)
