package com.meli.shop.domains.search.impl.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RecentSearchEntity(
    @PrimaryKey
    val search: String
)
