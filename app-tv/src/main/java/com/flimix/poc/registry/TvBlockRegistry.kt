package com.flimix.poc.registry

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.flimix.poc.blocks.tv.TvCarouselBlock
import com.flimix.poc.blocks.tv.TvHeroBlock
import com.flimix.poc.renderer.BlockRegistry
import com.flimix.poc.renderer.blockRegistry

@Composable
fun rememberTvBlockRegistry(): BlockRegistry {
    return remember {
        blockRegistry {
            register("hero") { block, _ -> TvHeroBlock(block) }
            register("carousel") { block, _ -> TvCarouselBlock(block) }
        }
    }
}
