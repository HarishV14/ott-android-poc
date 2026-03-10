package com.flimix.poc.renderer

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.flimix.poc.schema.Block

typealias BlockComposable = @Composable (block: Block, canvasContentWidth: Int?) -> Unit

class BlockRegistry internal constructor(
    internal val renderers: Map<String, BlockComposable>,
)

class BlockRegistryBuilder {
    private val renderers = mutableMapOf<String, BlockComposable>()

    fun register(type: String, renderer: BlockComposable) {
        renderers[type] = renderer
    }

    fun build(): BlockRegistry = BlockRegistry(renderers.toMap())
}

fun blockRegistry(build: BlockRegistryBuilder.() -> Unit): BlockRegistry =
    BlockRegistryBuilder().apply(build).build()

val LocalBlockRegistry = staticCompositionLocalOf { blockRegistry { } }

@Composable
fun ProvideBlockRegistry(
    registry: BlockRegistry,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalBlockRegistry provides registry, content = content)
}

@Composable
fun BlockRenderer(
    block: Block,
    registry: BlockRegistry = LocalBlockRegistry.current,
    canvasContentWidth: Int? = null,
    modifier: Modifier = Modifier,
) {
    val renderer = registry.renderers[block.type]
    if (renderer != null) {
        renderer(block, canvasContentWidth)
    } else {
        Text(
            text = "Unknown block: ${block.type}",
            color = Color.Red,
            modifier = modifier.padding(16.dp),
        )
    }
}
