package com.flimix.poc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.flimix.poc.core.page.MockPageRepository
import com.flimix.poc.features.page.tv.TvPageScreen
import com.flimix.poc.registry.rememberTvBlockRegistry
import com.flimix.poc.renderer.ProvideBlockRegistry
import com.flimix.poc.theme.FlimixTheme

class TvMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val pageResponse = MockPageRepository.getPage(slug = "home") ?: return

        setContent {
            FlimixTheme {
                val registry = rememberTvBlockRegistry()
                ProvideBlockRegistry(registry) {
                    TvPageScreen(pageResponse = pageResponse)
                }
            }
        }
    }
}
