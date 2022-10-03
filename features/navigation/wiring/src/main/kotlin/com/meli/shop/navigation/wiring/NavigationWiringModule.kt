package com.meli.shop.navigation.wiring

import com.meli.shop.navigation.api.NavigationGraphRender
import com.meli.shop.navigation.impl.NavigationGraphRenderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class NavigationWiringModule {

    @Binds
    abstract fun bindRenderer(renderer: NavigationGraphRenderImpl): NavigationGraphRender
}
