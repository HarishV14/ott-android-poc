package com.flimix.poc.blocks.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.tv.material3.Button
import androidx.tv.material3.ButtonDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.flimix.poc.schema.Block
import com.flimix.poc.schema.HeroProps
import com.flimix.poc.schema.SchemaJson
import kotlinx.serialization.json.decodeFromJsonElement
import com.flimix.poc.renderer.util.toColor
import com.flimix.poc.renderer.navigation.LocalPageNavigator

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun TvHeroBlock(block: Block) {
    val navigator = LocalPageNavigator.current
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
            .height(540.dp)
            .background(blockBg)
    ) {
        HorizontalPager(
            state = pagerState,
            beyondViewportPageCount = 0,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            val item = props.items[page]
            Box(modifier = Modifier.fillMaxSize()) {
                val context = LocalContext.current
                val imageUrl = item.cover ?: item.poster ?: item.thumbnail
                val imageRequest =
                    remember(imageUrl) {
                        ImageRequest.Builder(context)
                            .data(imageUrl)
                            // Avoid decoding full 4K bitmaps for every page while swiping.
                            .size(1280, 720)
                            .build()
                    }
                AsyncImage(
                    model = imageRequest,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    Color.Black.copy(alpha = 0.8f),
                                    Color.Black.copy(alpha = 0.4f),
                                    Color.Transparent
                                ),
                                startX = 0f
                            )
                        )
                )

                Column(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 40.dp)
                        .fillMaxWidth(0.5f)
                ) {
                    Text(
                        text = item.title ?: "",
                        fontSize = 48.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 56.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    val subtitle = item.subtitle
                    if (subtitle != null) {
                        Text(
                            text = subtitle,
                            fontSize = 20.sp,
                            color = Color.LightGray,
                            maxLines = 3
                        )
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    item.primary_cta?.let { cta ->
                        Button(
                            onClick = { navigator.playContent(item.id) },
                            colors = ButtonDefaults.colors(
                                containerColor = cta.background_color.toColor(Color.White),
                                contentColor = cta.text_color.toColor(Color.Black),
                                focusedContainerColor = Color.White,
                                focusedContentColor = Color.Black
                            ),
                            shape = ButtonDefaults.shape(shape = RoundedCornerShape(8.dp)),
                            modifier = Modifier
                                .height(56.dp)
                                .padding(end = 16.dp)
                        ) {
                            Text(
                                text = cta.label ?: "Watch Now",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }

        // Pager Indicators for TV
        if (props.items.size > 1) {
            Row(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 80.dp, bottom = 40.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                repeat(props.items.size) { index ->
                    val isSelected = pagerState.currentPage == index
                    Box(
                        modifier = Modifier
                            .size(if (isSelected) 12.dp else 8.dp)
                            .background(
                                color = if (isSelected) Color.White else Color.White.copy(alpha = 0.4f),
                                shape = RoundedCornerShape(50)
                            )
                    )
                }
            }
        }
    }
}
