package com.coffee.kmpapi.android.utils.ui

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.coffee.kmpapi.utils.KmpResponse

@Composable
fun <T> BoxScope.KmpResultSurface(
    networkStatus: KmpResponse<T>,
    onSuccess: @Composable (T) -> Unit
) {
    when (networkStatus) {
        is KmpResponse.Loading -> {
            CircularProgressIndicator(
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }

        is KmpResponse.Success -> {
            onSuccess(networkStatus.data)
        }

        is KmpResponse.Error -> {
            Text(
                text = networkStatus.exception.message.toString(),
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }
    }
}