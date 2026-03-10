package com.flimix.poc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.flimix.poc.core.content.MockContentRepository
import com.flimix.poc.core.page.MockPageRepository
import com.flimix.poc.features.content.tv.TvContentDetailScreen
import com.flimix.poc.features.page.tv.TvPageScreen
import com.flimix.poc.features.player.PlayerScreen
import com.flimix.poc.registry.rememberTvBlockRegistry
import com.flimix.poc.renderer.ProvideBlockRegistry
import com.flimix.poc.renderer.navigation.PageNavigator
import com.flimix.poc.renderer.navigation.ProvidePageNavigator
import com.flimix.poc.theme.FlimixTheme

class TvMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FlimixTheme {
                val registry = rememberTvBlockRegistry()
                val navController = rememberNavController()
                val navigator =
                    object : PageNavigator {
                        override fun openContent(contentId: Int) {
                            navController.navigate("content/$contentId")
                        }

                        override fun playContent(contentId: Int) {
                            navController.navigate("player/$contentId")
                        }

                        override fun back() {
                            navController.popBackStack()
                        }
                    }

                ProvidePageNavigator(navigator) {
                    ProvideBlockRegistry(registry) {
                        NavHost(navController = navController, startDestination = "page/home") {
                            composable("page/home") {
                                val pageResponse =
                                    remember { MockPageRepository.getPage(slug = "home") } ?: return@composable
                                TvPageScreen(pageResponse = pageResponse)
                            }
                            composable("content/{contentId}") { entry ->
                                val contentId =
                                    entry.arguments?.getString("contentId")?.toIntOrNull() ?: return@composable
                                TvContentDetailScreen(contentId = contentId)
                            }
                            composable("player/{contentId}") { entry ->
                                val contentId =
                                    entry.arguments?.getString("contentId")?.toIntOrNull() ?: return@composable
                                val detail = MockContentRepository.getContentDetail(contentId) ?: return@composable
                                PlayerScreen(url = detail.playbackUrl)
                            }
                        }
                    }
                }
            }
        }
    }
}
