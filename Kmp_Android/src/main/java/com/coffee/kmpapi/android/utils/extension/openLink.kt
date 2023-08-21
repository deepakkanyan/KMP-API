package com.coffee.kmpapi.android.utils.extension

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.openLink(url: String) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(url)
    }
    startActivity(intent)
}