package com.flimix.poc.ui.blocks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.flimix.poc.schema.Block
import com.flimix.poc.schema.CarouselProps
import com.flimix.poc.schema.ContentItem
import com.flimix.poc.schema.MockApi
import kotlinx.serialization.json.decodeFromJsonElement

import com.flimix.poc.ui.utils.toColor

@Composable
fun CarouselBlock(block: Block, canvasContentWidth: Int? = null) {
    val props = remember(block.props) {
        try {
            block.props?.let { MockApi.json.decodeFromJsonElement<CarouselProps>(it) } ?: CarouselProps()
        } catch (e: Exception) {
            CarouselProps()
        }
    }

    val horizontalPadding = if (canvasContentWidth != null && canvasContentWidth < 100) {
        // Calculate padding as percentage of screen width
        // In Compose, we can use fillMaxWidth and Arrangement.Center or specific padding
        // For carousel, we want the list to bleed but content to start at the margin.
        16.dp // Minimum padding
    } else {
        16.dp
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        // Header Row - Constrained to canvas width if provided
        // Header Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
                Text(
                    text = props.title ?: "",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                
                props.button?.let { btn ->
                    if (btn.enabled) {
                        Text(
                            text = btn.text ?: "View All",
                            color = Color.LightGray,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
        }
        
        // Carousel Items
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(props.items) { item ->
                CarouselCard(item = item, props = props)
            }
        }
    }
}

@Composable
fun CarouselCard(item: ContentItem, props: CarouselProps) {
    val width = when(props.item_size) {
        "small" -> 140.dp
        "large" -> 220.dp
        else -> 180.dp
    }
    
    val aspectRatio = when(props.item_shape) {
        "rectangle-landscape" -> 16f/9f
        "rectangle-portrait" -> 2f/3f
        "square" -> 1f
        else -> 16f/9f
    }
    
    val height = width / aspectRatio

    Column(modifier = Modifier.width(width)) {
        Box(
            modifier = Modifier
                .width(width)
                .height(height)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.DarkGray)
        ) {
            AsyncImage(
                model = item.poster ?: item.thumbnail ?: item.cover,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            
            // Progress Bar
            if (props.progress_bar?.enabled == true && item.progress != null) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .align(Alignment.BottomStart)
                        .background(Color.Gray.copy(alpha = 0.5f))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(item.progress / 100f)
                            .fillMaxHeight()
                            .background(props.progress_bar.color.toColor(Color.Red))
                    )
                }
            }
        }

        if (props.show_title) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.title ?: "",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                maxLines = 1,
                fontWeight = FontWeight.SemiBold
            )
        }
        
        if (props.show_subtitle && item.subtitle != null) {
            Text(
                text = item.subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                maxLines = 1,
                fontSize = 12.sp
            )
        } else if (props.show_genre && item.genres.isNotEmpty()) {
            Text(
                text = item.genres.first(),
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                maxLines = 1,
                fontSize = 12.sp
            )
        }
    }
}
