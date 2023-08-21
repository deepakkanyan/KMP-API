package com.coffee.kmpapi.android.utils.ui.views


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.coffee.kmpapi.android.utils.extension.openLink


@Composable
fun KmpLinkIcon(imageVector: ImageVector, url: String?) {
    url?.let {
        val context = LocalContext.current
        Icon(imageVector = imageVector,
            contentDescription = url,
            modifier = Modifier.padding(10.dp).clickable {
                context.openLink(url)
            }
        )
    }
}