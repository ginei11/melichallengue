package com.meli.shop

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.meli.shop.navigation.api.NavigationGraphRender
import com.meli.shop.search.api.SearchFeatureNavGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationGraphRender: NavigationGraphRender

    @Inject
    lateinit var searchFeatureNavGraph: SearchFeatureNavGraph

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val route = searchFeatureNavGraph.searchRoute()
        navigationGraphRender.render(route)
    }
}
