package com.flimix.poc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import com.flimix.poc.schema.MockApi
import com.flimix.poc.ui.screens.HomeScreen
import com.flimix.poc.ui.theme.FlimixandroidpocTheme
import com.flimix.poc.ui.tv.screens.TvHomeScreen
import com.flimix.poc.ui.utils.isTvDevice

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val pageResponse = MockApi.getHomePage()
        
        setContent {
            val context = LocalContext.current
            val isTv = isTvDevice(context)
            
            FlimixandroidpocTheme {
                if (isTv) {
                    TvHomeScreen(pageResponse = pageResponse)
                } else {
                    HomeScreen(pageResponse = pageResponse)
                }
            }
        }
    }
}
