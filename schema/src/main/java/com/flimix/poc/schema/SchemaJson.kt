package com.flimix.poc.schema

import kotlinx.serialization.json.Json

object SchemaJson {
    val json: Json =
        Json {
            ignoreUnknownKeys = true
            isLenient = true
        }
}

