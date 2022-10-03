package com.meli.shop.search.api

import com.meli.shop.common.navigation.AggregateFeatureEntry

interface SearchFeatureNavGraph : AggregateFeatureEntry {

    fun searchRoute(): String
}
