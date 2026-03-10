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

@Serializable
data class HeroProps(
    val items: List<ContentItem> = emptyList(),
    val variant: String? = null,
    val aspect_ratio: String? = null,
    val custom_height: String? = null,
    val autoplay: Boolean = false,
    val scroll_speed: Int = 5000,
    val show_arrows: Boolean = true
)

@Serializable
data class CarouselProps(
    val title: String? = null,
    val items: List<ContentItem> = emptyList(),
    val item_shape: String = "rectangle-landscape",
    val item_size: String = "medium",
    val show_title: Boolean = true,
    val show_subtitle: Boolean = false,
    val show_genre: Boolean = false,
    val show_rating: Boolean = false,
    val button: CarouselButton? = null,
    val progress_bar: ProgressBar? = null
)

@Serializable
data class ContentItem(
    val id: Int,
    val title: String? = null,
    val subtitle: String? = null,
    val type: String? = null,
    val poster: String? = null,
    val cover: String? = null,
    val thumbnail: String? = null,
    val genres: List<String> = emptyList(),
    val details: ContentDetails? = null,
    val primary_cta: CTA? = null,
    val progress: Int? = null,
    val show_meta: Boolean = false
)

@Serializable
data class ContentDetails(
    val duration: String? = null,
    val release_year: Int? = null,
    val language: String? = null
)

@Serializable
data class CTA(
    val label: String? = null,
    val link: String? = null,
    val variant: String? = null,
    val background_color: String? = null,
    val text_color: String? = null,
    val icon: String? = null
)

@Serializable
data class CarouselButton(
    val text: String? = null,
    val enabled: Boolean = false,
    val link: String? = null
)

@Serializable
data class ProgressBar(
    val enabled: Boolean = false,
    val color: String? = null
)
