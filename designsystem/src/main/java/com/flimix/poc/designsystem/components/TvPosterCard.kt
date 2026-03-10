package com.flimix.poc.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.flimix.poc.schema.CarouselProps
import com.flimix.poc.schema.ContentItem

@Composable
fun TvPosterCard(item: ContentItem, props: CarouselProps) {
    var isFocused by remember { mutableStateOf(false) }
    
    val width = when(props.item_size) {
        "small" -> 200.dp
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

    Column(
        modifier = Modifier
            .padding(8.dp)
            .width(width)
            .onFocusChanged { isFocused = it.isFocused }
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
                model = item.poster ?: item.thumbnail ?: item.cover,
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
