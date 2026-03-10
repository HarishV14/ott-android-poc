package com.flimix.poc.blocks.tv.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.tv.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.flimix.poc.renderer.navigation.LocalPageNavigator
import com.flimix.poc.schema.CarouselProps
import com.flimix.poc.schema.ContentItem

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun TvPosterCard(item: ContentItem, props: CarouselProps) {
    var isFocused by remember { mutableStateOf(false) }
    val navigator = LocalPageNavigator.current
    val context = LocalContext.current
    val density = LocalDensity.current
    
    val width = when(props.item_size) {
        "small" -> 220.dp
        "large" -> 360.dp
        else -> 280.dp // medium
    }
    
    val aspectRatio = when(props.item_shape) {
        "rectangle-landscape" -> 16f/9f
        "rectangle-portrait" -> 2f/3f
        "square" -> 1f
        else -> 16f/9f
    }
    
    val height = width / aspectRatio
    val request =
        remember(item.poster, item.thumbnail, item.cover, width, height, density) {
            val pxWidth = with(density) { width.roundToPx() }
            val pxHeight = with(density) { height.roundToPx() }
            ImageRequest.Builder(context)
                .data(item.poster ?: item.thumbnail ?: item.cover)
                .size(pxWidth, pxHeight)
                .build()
        }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .width(width)
            .onFocusChanged { isFocused = it.isFocused }
            .clickable { navigator.openContent(item.id) }
            .focusable()
    ) {
        Box(
            modifier = Modifier
                .width(width)
                .height(height)
                .clip(RoundedCornerShape(12.dp))
                .background(if (isFocused) Color.White.copy(alpha = 0.2f) else Color.DarkGray)
        ) {
            AsyncImage(
                model = request,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            
            if (isFocused) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White.copy(alpha = 0.1f))
                )
            }
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        if (props.show_title) {
            Text(
                text = item.title ?: "",
                color = if (isFocused) Color.White else Color.Gray,
                fontSize = 20.sp,
                fontWeight = if (isFocused) FontWeight.Bold else FontWeight.Normal,
                maxLines = 1
            )
        }
    }
}
