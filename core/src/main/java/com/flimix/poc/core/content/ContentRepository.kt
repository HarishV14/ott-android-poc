package com.flimix.poc.core.content

interface ContentRepository {
    fun getContentDetail(contentId: Int): ContentDetail?
}

