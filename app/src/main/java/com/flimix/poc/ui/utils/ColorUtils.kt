package com.flimix.poc.ui.utils

import androidx.compose.ui.graphics.Color

fun String?.toColor(default: Color = Color.Transparent): Color {
    if (this == null) return default
    return try {
        if (startsWith("#")) {
            val colorString = when (length) {
                4 -> "#" + this[1] + this[1] + this[2] + this[2] + this[3] + this[3] // #RGB -> #RRGGBB
                9 -> "#" + substring(7, 9) + substring(1, 7) // #RRGGBBAA -> #AARRGGBB
                else -> this
            }
            Color(android.graphics.Color.parseColor(colorString.uppercase()))
        } else if (startsWith("rgba")) {
            // Very basic RGBA parsing: rgba(255, 255, 255, 0)
            val values = replace("rgba(", "").replace(")", "").split(",")
            if (values.size == 4) {
                Color(
                    red = values[0].trim().toInt() / 255f,
                    green = values[1].trim().toInt() / 255f,
                    blue = values[2].trim().toInt() / 255f,
                    alpha = values[3].trim().toFloat()
                )
            } else default
        } else {
            default
        }
    } catch (e: Exception) {
        default
    }
}
