package com.meli.shop.navigation.impl

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.meli.shop.common.navigation.FeatureNavGraphs
import com.meli.shop.designsystem.theme.MeliTheme
import com.meli.shop.navigation.api.NavigationGraphRender
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class NavigationGraphRenderImpl @Inject constructor(
    private val activity: Activity,
    private val destinations: FeatureNavGraphs
) : NavigationGraphRender {
    override fun render(startDestination: String) {
        (activity as ComponentActivity).setContent {
            MeliTheme {
                AppNavigationGraph(startDestination = startDestination, destinations = destinations)
            }
        }
    }
}
