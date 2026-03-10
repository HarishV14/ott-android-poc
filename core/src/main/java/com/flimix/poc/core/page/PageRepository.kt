package com.flimix.poc.core.page

import com.flimix.poc.schema.PageResponse

interface PageRepository {
    fun getPage(slug: String): PageResponse?
}

