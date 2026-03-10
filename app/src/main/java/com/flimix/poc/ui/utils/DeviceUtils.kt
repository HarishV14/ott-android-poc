package com.flimix.poc.ui.utils

import android.content.Context
import android.content.pm.PackageManager

fun isTvDevice(context: Context): Boolean {
    return context.packageManager.hasSystemFeature(
        PackageManager.FEATURE_LEANBACK
    )
}
