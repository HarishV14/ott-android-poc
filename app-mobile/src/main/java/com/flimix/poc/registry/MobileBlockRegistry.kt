package com.flimix.poc.registry

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.flimix.poc.blocks.mobile.CarouselBlock
import com.flimix.poc.blocks.mobile.HeroBlock
import com.flimix.poc.renderer.BlockRegistry
import com.flimix.poc.renderer.blockRegistry

@Composable
fun rememberMobileBlockRegistry(): BlockRegistry {
    return remember {
        blockRegistry {
            register("hero") { block, width -> HeroBlock(block, width) }
            register("carousel") { block, width -> CarouselBlock(block, width) }
        }
    }
}
