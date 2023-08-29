package com.coffee.kmpapi.android.capsules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.coffee.kmpapi.impl.capsule.model.CapModel
import com.coffee.kmpapi.impl.capsule.model.CapResponse
@Composable
fun CapsulesUI() {
    val viewModel: CapViewModel = viewModel()
    val cap = viewModel.capList.collectAsState().value

    Box(modifier = Modifier) {
        CapView(cap)
    }
}

@Composable
fun BoxScope.CapView(cap: CapResponse) {

    when (cap) {
        is CapResponse.Loading -> {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        is CapResponse.Success -> {
            ShowCapList(cap.data)
        }

        is CapResponse.Error -> {
            Text(
                text = cap.e.toString(),
                modifier = Modifier.align(Alignment.Center)
            )
        }

    }

}

@Composable
fun ShowCapList(data: List<CapModel>) {

    LazyColumn {
        items(data) {
            Text(text = it.status)
        }

    }

}

