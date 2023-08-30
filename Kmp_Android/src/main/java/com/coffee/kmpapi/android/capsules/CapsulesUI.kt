package com.coffee.kmpapi.android.capsules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.coffee.kmpapi.impl.capsule.model.CapModel
import com.coffee.kmpapi.impl.capsule.model.CapResponse
import java.util.Locale
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

    LazyColumn(modifier = Modifier
        .padding(horizontal = 5.dp)
        .padding(top = 10.dp)) {
        items(data) {
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .wrapContentHeight()
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp),
                shape = MaterialTheme.shapes.small

            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(text = it.serial, style = MaterialTheme.typography.titleLarge)
                    Text(
                        text = it.status.uppercase(locale = Locale.US),
                        style = MaterialTheme.typography.labelMedium
                    )
                    Spacer(modifier = Modifier.padding(top = 5.dp))
                    Text(
                        text = it.lastUpdate.orEmpty(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }


        }

    }

}


@Preview
@Composable
fun previewIt() {
// Create fake data for CapModel
    val capModel1 = CapModel(
        reuseCount = 5,
        waterLandings = 2,
        landLandings = 3,
        lastUpdate = "cmp=com.coffee.kmpapi.android/.MainActivity",
        launches = listOf("Launch1", "Launch2", "Launch3"),
        serial = "Serial123",
        status = "Active",
        type = "TypeA",
        id = "ID001"
    )

    val capModel2 = CapModel(
        reuseCount = 10,
        waterLandings = 4,
        landLandings = 6,
        lastUpdate = "cmp=com.coffee.kmpapi.android/.MainActivity",
        launches = listOf("Launch4", "Launch5"),
        serial = "Serial456",
        status = "Inactive",
        type = "TypeB",
        id = "ID002"
    )
    ShowCapList(data = listOf(capModel1, capModel2))
}

