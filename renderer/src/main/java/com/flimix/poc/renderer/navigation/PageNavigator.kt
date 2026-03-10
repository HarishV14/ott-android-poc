package com.flimix.poc.renderer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

interface PageNavigator {
    fun openContent(contentId: Int)
    fun playContent(contentId: Int)
    fun back()
}

val LocalPageNavigator =
    staticCompositionLocalOf<PageNavigator> {
        error("PageNavigator not provided. Wrap your UI in ProvidePageNavigator(...).")
    }

@Composable
fun ProvidePageNavigator(
    navigator: PageNavigator,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalPageNavigator provides navigator, content = content)
}

