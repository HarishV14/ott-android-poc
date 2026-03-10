package com.flimix.poc.features.content.mobile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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

@Composable
fun ContentDetailScreen(
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
                .padding(horizontal = 16.dp, vertical = 16.dp),
    ) {
        AsyncImage(
            model = detail.coverUrl,
            contentDescription = null,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(220.dp),
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = detail.title,
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )

        detail.description?.let { desc ->
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = desc,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.8f),
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navigator.playContent(contentId) }) {
            Text(text = "Watch Now")
        }
    }
}

