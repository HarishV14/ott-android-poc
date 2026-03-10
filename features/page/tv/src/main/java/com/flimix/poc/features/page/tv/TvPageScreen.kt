package com.flimix.poc.features.page.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.flimix.poc.renderer.BlockRenderer
import com.flimix.poc.renderer.util.toColor
import com.flimix.poc.schema.PageResponse

@Composable
fun TvPageScreen(pageResponse: PageResponse) {
    val bgColor = pageResponse.schema.layout?.canvas_bg.toColor(Color(0xFF171717))

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor),
    ) {
        items(pageResponse.schema.blocks) { block ->
            BlockRenderer(block = block)
        }
    }
}
