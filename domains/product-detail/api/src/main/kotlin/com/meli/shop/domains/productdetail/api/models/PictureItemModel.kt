package com.meli.shop.domains.productdetail.api.models

import com.google.gson.annotations.SerializedName

data class PictureItemModel(
    @SerializedName("id") val id: String,
    @SerializedName("url") val url: String,
)
