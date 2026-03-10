package com.flimix.poc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.flimix.poc.schema.MockApi
import com.flimix.poc.ui.screens.HomeScreen
import com.flimix.poc.ui.theme.FlimixandroidpocTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val pageResponse = MockApi.getHomePage()
        
        setContent {
            FlimixandroidpocTheme {
                HomeScreen(pageResponse = pageResponse)
            }
        }
    }
}
