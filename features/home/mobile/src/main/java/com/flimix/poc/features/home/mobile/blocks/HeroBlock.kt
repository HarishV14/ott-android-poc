package com.flimix.poc.features.home.mobile.blocks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.flimix.poc.schema.Block
import com.flimix.poc.schema.HeroProps
import kotlinx.serialization.json.decodeFromJsonElement
import com.flimix.poc.designsystem.util.toColor
import com.flimix.poc.schema.SchemaJson

@Composable
fun HeroBlock(block: Block, canvasContentWidth: Int? = null) {
    val props = remember(block.props) {
        try {
            block.props?.let { SchemaJson.json.decodeFromJsonElement<HeroProps>(it) } ?: HeroProps()
        } catch (e: Exception) {
            HeroProps()
        }
    }

    if (props.items.isEmpty()) return

    val pagerState = rememberPagerState(pageCount = { props.items.size })
    val blockBg = block.style?.get("background_color")?.let { 
        it.toString().replace("\"", "").toColor() 
    } ?: Color.Transparent

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(660.dp)
            .background(blockBg)
    ) {
        // ... (rest of the Box content)
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            val item = props.items[page]
            Box(modifier = Modifier.fillMaxSize()) {
                // Background Image
                AsyncImage(
                    model = item.cover ?: item.poster ?: item.thumbnail,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Subdued Overlay Gradient
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black.copy(alpha = 0.5f),
                                    Color.Black.copy(alpha = 0.9f)
                                ),
                                startY = 400f
                            )
                        )
                )

                // Content Overlay
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 48.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(horizontal = 24.dp)
                            .fillMaxWidth()
                    ) {
                        // Title
                    Text(
                        text = item.title ?: "",
                        style = MaterialTheme.typography.displaySmall,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Metadata Row: Year • Genre • Language
                    if (item.show_meta) {
                        val metaParts = mutableListOf<String>()
                        item.details?.release_year?.let { metaParts.add(it.toString()) }
                        if (item.genres.isNotEmpty()) metaParts.add(item.genres.joinToString(", "))
                        item.details?.language?.let { metaParts.add(it) }

                        if (metaParts.isNotEmpty()) {
                            Text(
                                text = metaParts.joinToString("  •  "),
                                color = Color.LightGray,
                                style = MaterialTheme.typography.bodyMedium,
                                fontSize = 14.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Subtitle
                    val subtitle = item.subtitle
                    if (subtitle != null) {
                        Text(
                            text = subtitle,
                            color = Color.White.copy(alpha = 0.8f),
                            style = MaterialTheme.typography.bodyLarge,
                            maxLines = 3,
                            modifier = Modifier.fillMaxWidth(0.9f)
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // CTAs
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        item.primary_cta?.let { cta ->
                            Button(
                                onClick = { /* Handle Click */ },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = cta.background_color.toColor(Color.White),
                                    contentColor = cta.text_color.toColor(Color.Black)
                                ),
                                shape = RoundedCornerShape(4.dp),
                                modifier = Modifier.height(48.dp)
                            ) {
                                Text(
                                    text = cta.label ?: "Watch Now",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    // Pager Indicator
        if (props.items.size > 1) {
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(props.items.size) { index ->
                    val isSelected = pagerState.currentPage == index
                    val color = if (isSelected) Color.White else Color.White.copy(alpha = 0.5f)
                    val size = if (isSelected) 10.dp else 6.dp
                    
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .size(size)
                            .background(color, RoundedCornerShape(50))
                    )
                }
            }
        }
    }
}
