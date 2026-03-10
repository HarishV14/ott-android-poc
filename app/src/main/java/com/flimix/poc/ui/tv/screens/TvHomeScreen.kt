package com.flimix.poc.ui.tv.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.items
import com.flimix.poc.renderer.RenderBlock
import com.flimix.poc.schema.PageResponse
import com.flimix.poc.ui.utils.toColor

@Composable
fun TvHomeScreen(pageResponse: PageResponse) {
    val bgColor = pageResponse.schema.layout?.canvas_bg.toColor(Color(0xFF171717))

    TvLazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
    ) {
        items(pageResponse.schema.blocks) { block ->
            RenderBlock(
                block = block,
                isTv = true
            )
        }
    }
}
