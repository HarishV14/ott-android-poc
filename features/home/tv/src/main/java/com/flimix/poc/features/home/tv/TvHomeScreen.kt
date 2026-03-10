package com.flimix.poc.features.home.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.items
import com.flimix.poc.features.home.tv.blocks.TvCarouselBlock
import com.flimix.poc.features.home.tv.blocks.TvHeroBlock
import com.flimix.poc.renderer.BlockRenderer
import com.flimix.poc.renderer.blockRegistry
import com.flimix.poc.schema.PageResponse
import com.flimix.poc.designsystem.util.toColor

@Composable
fun TvHomeScreen(pageResponse: PageResponse) {
    val bgColor = pageResponse.schema.layout?.canvas_bg.toColor(Color(0xFF171717))
    val registry = blockRegistry {
        register("hero") { block, _ -> TvHeroBlock(block) }
        register("carousel") { block, _ -> TvCarouselBlock(block) }
    }

    TvLazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
    ) {
        items(pageResponse.schema.blocks) { block ->
            BlockRenderer(
                block = block,
                registry = registry,
            )
        }
    }
}
