package com.meli.shop.navigation.impl

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.meli.shop.common.navigation.AggregateFeatureEntry

@Composable
fun AppNavigationGraph(
    startDestination: String,
    destinations: Set<AggregateFeatureEntry>,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        destinations.forEach {
            it.registerNavigation(
                navGraphBuilder = this,
                navController = navController,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
