package com.meli.shop.domains.productdetail.api.models

import com.google.gson.annotations.SerializedName

data class AttributeModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("value_id") val valueId: String?,
    @SerializedName("value_name") val valueName: String?,
    @SerializedName("attribute_group_id") val attributeGroupId: String?,
    @SerializedName("attribute_group_name") val attributeGroupName: String?
)
