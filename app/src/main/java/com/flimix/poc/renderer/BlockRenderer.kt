package com.flimix.poc.renderer

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.flimix.poc.schema.Block
import com.flimix.poc.ui.blocks.CarouselBlock
import com.flimix.poc.ui.blocks.HeroBlock

@Composable
fun RenderBlock(block: Block, canvasContentWidth: Int? = null) {
    when (block.type) {
        "hero" -> HeroBlock(block, canvasContentWidth)
        "carousel" -> CarouselBlock(block, canvasContentWidth)
        else -> Text(
            text = "Unknown block: ${block.type}",
            color = Color.Red,
            modifier = Modifier.padding(16.dp)
        )
    }
}
