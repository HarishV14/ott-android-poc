package com.flimix.poc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.flimix.poc.core.home.MockHomeRepository
import com.flimix.poc.designsystem.theme.FlimixandroidpocTheme
import com.flimix.poc.features.home.mobile.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val pageResponse = MockHomeRepository.getHomePage()
        
        setContent {
            FlimixandroidpocTheme {
                HomeScreen(pageResponse = pageResponse)
            }
        }
    }
}
