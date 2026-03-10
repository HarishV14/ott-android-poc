package com.flimix.poc.blocks.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.tv.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import com.flimix.poc.schema.Block
import com.flimix.poc.schema.CarouselProps
import kotlinx.serialization.json.decodeFromJsonElement
import com.flimix.poc.schema.SchemaJson
import com.flimix.poc.renderer.util.toColor
import com.flimix.poc.blocks.tv.components.TvPosterCard

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun TvCarouselBlock(block: Block) {
    val props = remember(block.props) {
        try {
            block.props?.let { SchemaJson.json.decodeFromJsonElement<CarouselProps>(it) } ?: CarouselProps()
        } catch (e: Exception) {
            CarouselProps()
        }
    }

    val blockBg = block.style?.get("background_color")?.let { 
        it.toString().replace("\"", "").toColor() 
    } ?: Color.Transparent

    val verticalPadding = block.style?.get("padding_top")?.let { 16.dp } ?: 24.dp
    val gridGap = when(block.style?.get("grid_gap")?.toString()?.replace("\"", "")) {
        "sm" -> 8.dp
        "lg" -> 24.dp
        else -> 16.dp
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(blockBg)
            .padding(vertical = verticalPadding)
    ) {
        Text(
            text = props.title ?: "",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            modifier = Modifier.padding(start = 40.dp, bottom = 16.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 40.dp),
            horizontalArrangement = Arrangement.spacedBy(gridGap),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(props.items) { item ->
                TvPosterCard(item = item, props = props)
            }
        }
    }
}
