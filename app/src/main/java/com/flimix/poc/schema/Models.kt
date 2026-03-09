package com.flimix.poc.schema

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class PageResponse(
    val title: String,
    val slug: String,
    val schema: PageSchema
)

@Serializable
data class PageSchema(
    val theme: String,
    val title: String,
    val blocks: List<Block>,
    val layout: Layout?
)

@Serializable
data class Block(
    val id: String,
    val type: String,
    val props: JsonObject? = null,
    val style: JsonObject? = null
)

@Serializable
data class Layout(
    val canvas_bg: String? = null,
    val canvas_content_width: Int? = null
)
