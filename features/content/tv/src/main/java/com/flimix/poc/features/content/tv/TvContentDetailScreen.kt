package com.flimix.poc.features.content.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.tv.material3.Button
import androidx.tv.material3.ButtonDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.flimix.poc.core.content.MockContentRepository
import com.flimix.poc.renderer.navigation.LocalPageNavigator

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun TvContentDetailScreen(
    contentId: Int,
    modifier: Modifier = Modifier,
) {
    val navigator = LocalPageNavigator.current
    val detail = remember(contentId) { MockContentRepository.getContentDetail(contentId) } ?: return

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .background(Color(0xFF171717))
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 40.dp, vertical = 24.dp),
    ) {
        AsyncImage(
            model = detail.coverUrl,
            contentDescription = null,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(360.dp),
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = detail.title,
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )

        detail.description?.let { desc ->
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = desc,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White.copy(alpha = 0.85f),
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navigator.playContent(contentId) },
            colors = ButtonDefaults.colors(
                focusedContainerColor = Color.White,
                focusedContentColor = Color.Black
            )
        ) {
            Text(text = "Watch Now")
        }
    }
}

