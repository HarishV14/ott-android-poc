package com.flimix.poc.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.tooling.preview.Preview
import com.flimix.poc.schema.MockApi
import com.flimix.poc.schema.PageResponse
import com.flimix.poc.ui.renderer.BlockRenderer
import com.flimix.poc.ui.theme.FlimixandroidpocTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val pageResponse = MockApi.getHomePage()
        setContent {
            FlimixandroidpocTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color(0xFF171717) // Matching canvas_bg
                ) { innerPadding ->
                    SduiPage(
                        pageResponse = pageResponse,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SduiPage(pageResponse: PageResponse, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF171717))
            .verticalScroll(rememberScrollState())
    ) {
        val canvasWidth = pageResponse.schema.layout?.canvas_content_width
        pageResponse.schema.blocks.forEach { block ->
            BlockRenderer(block = block, canvasContentWidth = canvasWidth)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SduiPagePreview() {
    FlimixandroidpocTheme {
        SduiPage(MockApi.getHomePage())
    }
}
