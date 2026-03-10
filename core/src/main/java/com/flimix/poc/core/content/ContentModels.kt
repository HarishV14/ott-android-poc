package com.flimix.poc.core.content

data class ContentDetail(
    val id: Int,
    val title: String,
    val coverUrl: String?,
    val description: String?,
    val playbackUrl: String,
)

