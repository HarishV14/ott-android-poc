package com.flimix.poc.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.flimix.poc.renderer.RenderBlock
import com.flimix.poc.schema.PageResponse
import com.flimix.poc.ui.utils.toColor

@Composable
fun HomeScreen(pageResponse: PageResponse, modifier: Modifier = Modifier) {
    val bgColor = pageResponse.schema.layout?.canvas_bg.toColor(Color(0xFF171717))
    val canvasWidth = pageResponse.schema.layout?.canvas_content_width

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = bgColor
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(bgColor)
                .verticalScroll(rememberScrollState())
        ) {
            pageResponse.schema.blocks.forEach { block ->
                RenderBlock(block = block, canvasContentWidth = canvasWidth)
            }
        }
    }
}
